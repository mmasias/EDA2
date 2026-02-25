<div align=right>

<sub>[Inicio](README.md) / [**00**](00-topologia.md) / [01](01-metodo-iterativo.md) / [02](02-recursion-sin-caso-base.md) / [03](03-un-caso-base.md) / [04](04-multiples-casos-base.md) / [05](05-multiples-llamadas-condicional.md) / [06](06-multiples-llamadas-ambas.md) / [07](07-interrupcion-recursiva.md)</sub>

</div>

# Topología de una función recursiva

## ¿Por qué?

Antes de implementar funciones recursivas completas, es necesario entender **qué efecto tiene cada pieza según dónde se coloca**.

Una función recursiva tiene pocas piezas: la llamada recursiva, el caso base, las operaciones locales. Pero el comportamiento cambia radicalmente según su disposición. Mover una línea de sitio puede convertir una cuenta atrás en una cuenta hacia arriba, o un programa funcional en un stack overflow.

Sin esta experimentación previa, la estructura `if (casoBase) return; ... return f(n-1)` se memoriza como receta sin entender **por qué** cada pieza está donde está.

## ¿Qué?

Una exploración progresiva del *layout* de los componentes de una función recursiva, observando qué cambia con cada movimiento.

## ¿Para qué?

- **Entender que la posición importa**: El mismo código en distinto orden produce comportamiento distinto
- **Descubrir la pila por experimentación**: Ver que lo que está *después* de la llamada recursiva se ejecuta al *volver*
- **Construir intuición antes de formalizar**: Cuando llegue la implementación formal, ya se habrá experimentado todo

## ¿Cómo?

### Fase 1 — Solo la llamada

```java
class Topologia {

    static void f(int n) {
        f(n - 1);
    }

    public static void main(String[] args) {
        f(5);
    }
}
```

```
Exception in thread "main" java.lang.StackOverflowError
```

No hay salida visible. No hay caso base. No hay nada que observar salvo la muerte del programa.

> **Pregunta**: ¿Qué ha pasado? ¿Por qué no vemos nada?

### Fase 2 — Print antes de la llamada

```java
class Topologia {

    static void f(int n) {
        System.out.println(n);
        f(n - 1);
    }

    public static void main(String[] args) {
        f(5);
    }
}
```

```
5
4
3
2
1
0
-1
-2
...
Exception in thread "main" java.lang.StackOverflowError
```

Ahora vemos algo: una cuenta atrás infinita. El `println` se ejecuta **antes** de cada llamada, así que vemos cada valor de `n` a medida que la pila crece.

Sigue muriendo, pero al menos ahora se ve *cómo* muere.

### Fase 3 — Print después de la llamada

```java
class Topologia {

    static void f(int n) {
        f(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        f(5);
    }
}
```

```
Exception in thread "main" java.lang.StackOverflowError
```

No imprime **nada**. El `println` está ahí, pero nunca se ejecuta.

> **Pregunta**: ¿Por qué? Si la línea existe en el código...

**Respuesta**: Lo que está *después* de la llamada recursiva solo se ejecuta cuando la llamada **vuelve**. Si la llamada nunca vuelve (porque no hay caso base), lo de abajo no existe.

### Fase 4 — Caso base + print antes

```java
class Topologia {

    static void f(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        f(n - 1);
    }

    public static void main(String[] args) {
        f(5);
    }
}
```

```
5
4
3
2
1
```

Cuenta atrás limpia. El caso base detiene la pila. El `println` se ejecuta antes de cada llamada, así que imprime en orden descendente.

### Fase 5 — Caso base + print después

```java
class Topologia {

    static void f(int n) {
        if (n == 0) {
            return;
        }
        f(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        f(5);
    }
}
```

```
1
2
3
4
5
```

**Cuenta hacia arriba.** Nadie pidió sumar. Nadie dijo "invierte el orden". El mismo `println`, la misma llamada, el mismo caso base. Solo cambió la posición.

> **Pregunta**: ¿Cómo es posible que cuente hacia arriba si `n` siempre decrece?

**Respuesta**: El `println` se ejecuta **al volver**. La primera llamada que *vuelve* es `f(1)` (la más profunda antes del caso base). La última en volver es `f(5)` (la primera que se hizo).

La pila desapila en orden inverso. Esto no es magia: es LIFO.

### Fase 6 — Print antes Y después

```java
class Topologia {

    static void f(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        f(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        f(5);
    }
}
```

```
5
4
3
2
1
1
2
3
4
5
```

La combinación de las dos fases anteriores. La primera mitad es la fase 4 (descenso). La segunda mitad es la fase 5 (ascenso). La llamada recursiva actúa como **espejo**: todo lo que está antes se ejecuta al bajar, todo lo que está después se ejecuta al subir.

### Fase 7 — Operación antes vs después

Si en vez de imprimir, **acumulamos**:

<div align=center>

<table>
<tr><th>Operación antes (descendiendo)</th><th>Operación después (ascendiendo)</th></tr>
<tr><td>

```java
static int f(int n) {
    if (n == 0) {
        return 0;
    }
    return n + f(n - 1);
}
```

</td><td>

```java
static int f(int n, int acumulador) {
    if (n == 0) {
        return acumulador;
    }
    return f(n - 1, acumulador + n);
}
```

</td></tr>
<tr><td>

El `n +` se ejecuta **al volver**. La suma se resuelve de dentro hacia fuera: `1 + 0 = 1`, luego `2 + 1 = 3`, luego `3 + 3 = 6`...

</td><td>

El `acumulador + n` se ejecuta **al bajar**. La suma se resuelve de fuera hacia dentro: `0 + 5 = 5`, luego `5 + 4 = 9`, luego `9 + 3 = 12`...

</td></tr>
<tr><td>

Resultado: **15**. Construido al desapilar.

</td><td>

Resultado: **15**. Construido al apilar.

</td></tr>
</table>

</div>

Mismo resultado, diferente momento de construcción. La primera versión necesita que toda la pila se llene antes de empezar a calcular. La segunda calcula mientras baja.

> **Observación**: No hay que elegir una como "mejor". Lo relevante es entender que **dónde** se coloca la operación determina **cuándo** se ejecuta.

### Fase 8 — Hago y deshago

La fase 6 mostró que lo de antes se ejecuta al bajar y lo de después al subir. ¿Y si le damos **intención** a esa simetría?

```java
class Topologia {

    static void f(int n, String camino) {
        if (n == 0) {
            System.out.println("Llegué: " + camino);
            return;
        }

        camino = camino + n + " ";
        System.out.println("  Elijo " + n + " -> " + camino);

        f(n - 1, camino);

        camino = camino.substring(0, camino.length() - 2);
        System.out.println("  Deshago " + n + " -> " + camino);
    }

    public static void main(String[] args) {
        f(3, "");
    }
}
```

```
  Elijo 3 -> 3
  Elijo 2 -> 3 2
  Elijo 1 -> 3 2 1
Llegué: 3 2 1
  Deshago 1 -> 3 2
  Deshago 2 -> 3
  Deshago 3 ->
```

Es la fase 6 con significado: la función **construye un camino bajando** y **lo desmonta subiendo**. Antes de la llamada, *elige*. Después de la llamada, *se retracta*.

> **Pregunta**: ¿Para qué querría alguien deshacer lo que hizo?

Aquí solo hay un camino posible. Pero si hubiera varios caminos y no todos sirvieran, necesitaríamos *probar uno*, y si no funciona, *deshacerlo* para probar otro.

Eso, por ahora, queda flotando.

## Mapa

Entonces:

<div align=center>

|Posición|Se ejecuta|Efecto observado|
|-|-|-|
|Antes de la llamada|Al **descender** (apilar)|Se ve primero lo de arriba|
|Después de la llamada|Al **ascender** (desapilar)|Se ve primero lo de abajo|
|Antes y después|Al bajar y al subir|Simetría: la llamada actúa como espejo|
|Antes y después con intención|Elegir al bajar, deshacer al subir|Construcción y retractación de camino|
|Sin caso base|Nunca vuelve|Lo de después no se ejecuta; stack overflow|
|Con caso base|La pila tiene fondo|Todo se ejecuta en su momento|

</div>

Con este mapa en mente, implementar funciones recursivas deja de ser seguir una receta: es colocar piezas sabiendo qué efecto tiene cada posición.

---

[Siguiente: Implementación →](README.md)