# Suma recursiva de elementos en un array

## ¿Por qué?

La suma de elementos en un array es una operación fundamental en programación. Tradicionalmente, esta tarea se realiza mediante un bucle que recorre cada elemento y acumula su valor. Sin embargo, este enfoque iterativo presenta ciertas limitaciones:

1. La solución iterativa limita la comprensión de patrones de descomposición de problemas.
1. Se pierde la oportunidad de modelar el problema como una composición de subproblemas idénticos.
1. Para fines educativos, se requiere un ejemplo introductorio que demuestre claramente la aplicación del paradigma recursivo.

Aunque la suma de elementos es trivial con bucles, su implementación recursiva sirve como un excelente punto de entrada para comprender la técnica cabeza-cola (head-tail), pilar fundamental de muchos algoritmos recursivos más complejos.

## ¿Qué?

La suma recursiva de elementos consiste en calcular la suma total de todos los valores contenidos en un array de números utilizando el principio de recursión. El problema se aborda descomponiendo el array en:

1. **Cabeza (head)**: El primer elemento del array.
1. **Cola (tail)**: Un nuevo array conteniendo todos los elementos después del primero.

La solución recursiva define la suma del array completo como la suma de la cabeza más la suma recursiva de la cola. Esta definición se aplica sucesivamente hasta alcanzar el caso base.

## ¿Para qué?

La implementación recursiva de la suma de elementos proporciona:

1. Un ejemplo introductorio claro de la técnica cabeza-cola, fundamental para algoritmos recursivos más avanzados.
1. Una demostración tangible de cómo descomponer problemas en subproblemas más simples.
1. Una base conceptual para comprender la pila de llamadas y su relación con la recursión.
1. Una oportunidad para analizar las ventajas y desventajas de enfoques recursivos versus iterativos.
1. Un fundamento práctico para discutir optimizaciones como la recursión de cola.

## ¿Cómo?

### Análisis del [algoritmo](/src/casosDeUso/recursividad/SumaRecursiva.java)

#### Identificación del caso base y casos recursivos

- **Caso base**: Un array vacío, cuya suma es 0.
- **Caso recursivo**: Sumar el primer elemento (cabeza) con la suma recursiva del resto del array (cola).

#### Convergencia

El array se reduce en un elemento en cada llamada recursiva, garantizando que eventualmente se alcance el caso base (array vacío).

#### Funcionamiento de la pila de llamadas

<table>
<tr>
<td valign=top>

Para el array `[5, 2, 4, 8]`, la pila de llamadas evoluciona así:

1. `sumar([5, 2, 4, 8])` → cabeza=5, cola=[2, 4, 8]
1. `sumar([2, 4, 8])` → cabeza=2, cola=[4, 8]  
1. `sumar([4, 8])` → cabeza=4, cola=[8]
1. `sumar([8])` → cabeza=8, cola=[]
1. `sumar([])` → retorna 0 (caso base)
1. Retroceso: 0+8=8, 8+4=12, 12+2=14, 14+5=19
</td>
<td>

<div align=center>

![](/images/modelosUML/sumaNumerosArray.svg)

</div>
</td>
</tr>
</table>

### Consideraciones de eficiencia

Esta implementación recursiva presenta algunas limitaciones:

1. **Eficiencia espacial**: Cada llamada recursiva crea una nueva copia del array (la cola), lo que resulta en un uso de memoria O(n²) donde n es la longitud del array.
1. **Eficiencia temporal**: La creación constante de subarrays añade una complejidad temporal de O(n²), comparada con O(n) de la versión iterativa.
1. **Límite de recursión**: Para arrays muy grandes, existe el riesgo de desbordamiento de la pila de llamadas.

### Versión iterativa equivalente

```java
public static int sumarIterativo(int[] numeros) {
    int suma = 0;
    for (int numero : numeros) {
        suma = suma + numero;
    }
    return suma;
}
```
