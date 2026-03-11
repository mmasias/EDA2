<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [Estructuración](/temario/002-recursividad/02-estructuracion/README.md) / [**Implementación**](/temario/002-recursividad/03-implementacion/README.md) / [Aplicación](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Inicio](README.md) / [00](00-topologia.md) / [**01**](01-metodo-iterativo.md) / [02](02-recursion-sin-caso-base.md) / [03](03-un-caso-base.md) / [04](04-multiples-casos-base.md) / [05](05-multiples-llamadas-condicional.md) / [06](06-multiples-llamadas-ambas.md) / [07](07-interrupcion-recursiva.md) / [08](08-el-estado.md) / [09](09-hacer-y-deshacer.md) / [10](10-el-arbol-de-decisiones.md) / [11](11-una-solucion.md) / [12](12-todas-las-soluciones.md) / [13](13-poda.md) / [14](14-cierre.md)

</div>

# 01. Método iterativo (sin recursión)

## ¿Por qué?

Antes de implementar recursividad en código, es necesario reconocer cuándo un problema no la requiere.

Un error común es intentar forzar una solución recursiva cuando un bucle simple resuelve el problema de forma más natural y eficiente.

## ¿Qué?

Un método iterativo es aquel que utiliza bucles (`for`, `while`) para repetir un bloque de código.

A diferencia de la recursión:

- No se llama a sí mismo
- El estado se guarda en variables locales
- La condición de parada controla cuándo termina

## ¿Para qué?

- **Anclar lo que NO es recursivo**: Tener un punto de comparación claro
- **Entender el contraste**: Diferenciar entre iteración y recursión
- **Reconocer problemas iterativos**: Identificar cuándo un bucle es más natural

## ¿Cómo?

### Implementación

#### Suma de n primeros números (iterativo)

```java
class SumaIterativa {

    static int sumarNPrimeros(int n) {
        int suma = 0;

        for (int i = 1; i <= n; i++) {
            suma = suma + i;
        }

        return suma;
    }

    public static void main(String[] args) {
        System.out.println(sumarNPrimeros(5));
        System.out.println(sumarNPrimeros(10));
    }
}
```

#### Traza de ejecución

Para `sumarNPrimeros(5)`:

<div align=center>

|Iteración|i|suma antes|suma después|
|-:|-:|-:|-:|
|1|1|0|1|
|2|2|1|3|
|3|3|3|6|
|4|4|6|10|
|5|5|10|15|

</div>

### Análisis

#### ¿Por qué esto NO es recursivo?

<div align=center>

|Criterio|¿Se cumple?|
|-|:-:|
|¿El método se llama a sí mismo?|No|
|¿Hay caso base?|No|
|¿La estructura se contiene a sí misma?|No|
|¿Hay autosimilitud a diferentes escalas?|No|

</div>

#### Vocabulario clave

- **Iteración**: Repetición de un bloque de código usando un bucle (`for`, `while`)
- **Variable de acumulación**: `suma` guarda el estado entre iteraciones
- **Condición de parada**: `i <= n` controla cuándo termina el bucle

#### ¿Cuándo usar iteración vs recursión?

<div align=center>

|Iteración|Recursión|
|-|-|
Recorrer arrays/listas|Estructuras anidadas (árboles, directorios)
Contar con acumulador|Definiciones autorreferentes (factorial, Fibonacci)
Procesos con número fijo de repeticiones|Problemas que se pueden dividir en subproblemas iguales

</div>

## Reflexión final

Este método es **iterativo**, no recursivo:

- No se llama a sí mismo
- Usa un bucle `for` con una variable de control
- El estado se guarda en una variable local (`suma`)

En el siguiente paso se aborda la implementación recursiva de este problema.

> [Siguiente: Recursión sin caso base](02-recursion-sin-caso-base.md)
