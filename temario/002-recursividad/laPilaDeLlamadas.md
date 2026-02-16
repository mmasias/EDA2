# La pila de llamadas, a.k.a. *call stack*

## ¿Por qué?

Hemos visto que `factorial(5)` funciona llamándose a sí mismo con `factorial(4)`, que se llama con `factorial(3)`, y así sucesivamente. Pero surgen preguntas fundamentales:

- ¿Cómo "recuerda" cada llamada su valor particular de `n`?
- ¿Cómo sabe cada llamada dónde debe volver cuando termina?
- ¿Por qué `factorial(3)` no "pierde" su valor de `n=3` mientras se ejecuta `factorial(2)`?
- Si escribimos `factorial(1000000)`, ¿qué impide que funcione?

Para responder estas preguntas necesitamos entender el mecanismo que hace posible la recursión: **la pila de llamadas** (call stack).

## ¿Qué?

La pila de llamadas es una estructura de datos que el sistema utiliza para gestionar la ejecución de funciones.

**Cada vez que se llama a una función** (recursiva o no), se crea un **marco** (frame) que se coloca en la pila. Este marco contiene:

- **Dirección de retorno**: A dónde volver cuando la función termine
- **Argumentos**: Los valores pasados a la función
- **Variables locales**: Toda variable declarada dentro de la función

**Cuando la función termina**, su marco se elimina de la pila y la ejecución vuelve al punto desde donde se llamó.

**Si una función se llama a sí misma repetidamente sin retornar**, la pila crece hasta que se produce un **desbordamiento de pila** (stack overflow).

## ¿Para qué?

Entender la pila de llamadas permite:

- **Comprender por qué la recursión funciona**: Cada llamada recursiva mantiene su propio contexto independiente
- **Depurar código recursivo**: Poder "trazar" mentalmente qué está en la pila en cada momento
- **Prevenir errores**: Entender qué causa un stack overflow y cómo evitarlo
- **Identificar limitaciones**: Saber que la recursión profunda consume memoria proporcional a la profundidad
- **Diseñar soluciones apropiadas**: Elegir recursión cuando la profundidad sea manejable, iteración cuando no

## ¿Cómo?

### Visualización con funciones no recursivas

La pila funciona con cualquier llamada a función, no solo con recursión:

<div align=center>

<table>
<tr>
<td valign=top>

```java
public class Example {
    public static void a() {
        String spam = "Ant";
        System.out.println("spam is " + spam);
        b();
        System.out.println("spam is " + spam);
    }
    
    public static void b() {
        String spam = "Bobcat";
        System.out.println("spam is " + spam);
        c();
        System.out.println("spam is " + spam);
    }
    
    public static void c() {
        String spam = "Coyote";
        System.out.println("spam is " + spam);
    }
    
    public static void main(String[] args) {
        a();
    }
}
```
</td>
<td valign=top>

```
spam is Ant
spam is Bobcat
spam is Coyote
spam is Bobcat
spam is Ant
```
</td>
</tr>
</table>

|![](/images/callStack.webp)
|:-:
|El estado de la pila de llamadas mientras se ejecuta el programa `Example.java`

</div>

Cada función tiene su propia variable `spam` con valor diferente. Las variables no se "mezclan" porque cada una está en su propio marco. Los marcos se apilan y desapilan en orden LIFO (Last In, First Out).

### Aplicación a recursión: cuentaAtrasAdelante

```java
public static void cuentaAtrasAdelante(int number) {
    System.out.println(number);

    if (number == 0) {
        System.out.println("Llegamos al caso base.");
        return;
    }
    else {
        cuentaAtrasAdelante(number - 1);
        System.out.println(number + " volviendo");
    }
}
```

<details>
<summary>Traza completa de cuentaAtrasAdelante(3)</summary>

<div align=center>

|Fase de descenso|Caso base|Fase de ascenso|
|:-:|:-:|:-:|
|3|||
|2|||
|1|||
|0|||
||Llegamos al caso base.||
|||1 volviendo|
|||2 volviendo|
|||3 volviendo|

</div>

**Estado de la pila en cada momento:**
```
Llamada inicial:
[main] → cuentaAtrasAdelante(3)

Después de imprimir 3:
[main] → cuentaAtrasAdelante(3)
            ↓ llama a
         cuentaAtrasAdelante(2)

Después de imprimir 2:
[main] → cuentaAtrasAdelante(3)
            ↓
         cuentaAtrasAdelante(2)
            ↓ llama a
         cuentaAtrasAdelante(1)

Después de imprimir 1:
[main] → cuentaAtrasAdelante(3)
            ↓
         cuentaAtrasAdelante(2)
            ↓
         cuentaAtrasAdelante(1)
            ↓ llama a
         cuentaAtrasAdelante(0)

Caso base alcanzado, imprime "Llegamos al caso base":
[main] → cuentaAtrasAdelante(3)
            ↓
         cuentaAtrasAdelante(2)
            ↓
         cuentaAtrasAdelante(1)
            ↓
         cuentaAtrasAdelante(0) ← TERMINA, se elimina de la pila

Vuelve a cuentaAtrasAdelante(1), imprime "1 volviendo":
[main] → cuentaAtrasAdelante(3)
            ↓
         cuentaAtrasAdelante(2)
            ↓
         cuentaAtrasAdelante(1) ← TERMINA, se elimina

Vuelve a cuentaAtrasAdelante(2), imprime "2 volviendo":
[main] → cuentaAtrasAdelante(3)
            ↓
         cuentaAtrasAdelante(2) ← TERMINA, se elimina

Vuelve a cuentaAtrasAdelante(3), imprime "3 volviendo":
[main] → cuentaAtrasAdelante(3) ← TERMINA
```

</details>

### El desbordamiento de pila (stack overflow)

Si una función recursiva nunca alcanza su caso base, la pila crece indefinidamente:

<div align=center>

<table>
<tr>
<td valign=top>

```java
public class Shortest {
    public static void shortest() {
        shortest();
    }
    
    public static void main(String[] args) {
        shortest();
    }
}
```
</td>
<td valign=top>

```
Exception in thread "main" java.lang.StackOverflowError
    at Shortest.shortest(Shortest.java:3)
    at Shortest.shortest(Shortest.java:3)
    at Shortest.shortest(Shortest.java:3)
    at Shortest.shortest(Shortest.java:3)
    at Shortest.shortest(Shortest.java:3)
    ...
```
</td>
</tr>
</table>

|![](/images/callStackOverflow.webp)
|:-:
|Un desbordamiento de pila ocurre cuando la pila se vuelve demasiado alta<br>y demasiados marcos ocupan la memoria.

</div>

### Aplicación a factorial

Traza de `factorial(3)` con conciencia de la pila:
```java
public static int factorial(int n) {
    if (n == 0) {
        return 1;
    } else {
        return n * factorial(n - 1);
    }
}
```

**Ejecución paso a paso:**
```
1. factorial(3) se llama
   ↓ n=3, no es caso base
   ↓ necesita calcular 3 * factorial(2)
   ↓ pero primero debe obtener factorial(2)

2. factorial(2) se llama
   ↓ n=2, no es caso base
   ↓ necesita calcular 2 * factorial(1)
   ↓ pero primero debe obtener factorial(1)

3. factorial(1) se llama
   ↓ n=1, no es caso base
   ↓ necesita calcular 1 * factorial(0)
   ↓ pero primero debe obtener factorial(0)

4. factorial(0) se llama
   ↓ n=0, ES CASO BASE
   ↓ retorna 1 inmediatamente

5. Vuelve a factorial(1)
   ↓ ahora puede calcular 1 * 1 = 1
   ↓ retorna 1

6. Vuelve a factorial(2)
   ↓ ahora puede calcular 2 * 1 = 2
   ↓ retorna 2

7. Vuelve a factorial(3)
   ↓ ahora puede calcular 3 * 2 = 6
   ↓ retorna 6
```

## Pasos para implementar recursión correctamente

Con el conocimiento de la pila de llamadas:

1. **Identificar el caso base**: Definir cuándo la recursión debe detenerse (cuando la pila puede empezar a desapilarse)
2. **Definir el caso recursivo**: Formular cómo el problema se reduce (qué nuevo marco se apilará)
3. **Garantizar el progreso**: Cada llamada debe acercarse al caso base (la pila no puede crecer indefinidamente)
4. **Unificar las soluciones**: Determinar cómo combinar resultados cuando la pila se desapila

## *#2Think*

1. ¿Qué imprimirá `misterio(3)` y en qué orden?

```java
   public static void misterio(int n) {
       if (n > 0) {
           System.out.print(n + " ");
           misterio(n - 1);
           System.out.print(n + " ");
       }
   }
```

1. ¿Por qué este código produce stack overflow?

```java
   public static int mal(int n) {
       if (n == 0) return 0;
       return mal(n);
   }
```

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>