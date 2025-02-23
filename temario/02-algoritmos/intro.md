# Algoritmos > Repaso e introducción

## Por qué

[🤔](🤔.md)

Hemos de comprender lo que estamos diseñando, dado que es crucial para lograr soluciones efectivas: eficaces vs eficientes.

Debe existir alguna manera de medir la efectividad de los algoritmos. A lo mejor no en términos de tiempo real (sería imposible dada la cantidad de escenarios que se pueden abordar), sino en cómo su tiempo de ejecución o espacio requerido varía en función del tamaño de la entrada.


## Qué

Los algoritmos son procedimientos o fórmulas para resolver problemas. Pueden ser tan simples como un procedimiento de suma o tan complejos como el algoritmo que subyace a un motor de búsqueda en Internet. Los algoritmos se definen por su claridad, precisión y la finitud de sus pasos. (Visto en [Programación 1](https://github.com/mmasias/23-24-prg1/blob/main/temario/001-Algoritmos.md))

## Para qué

- **Predecir** el rendimiento de los algoritmos en diferentes condiciones.
- **Elegir** el algoritmo más eficiente y adecuado para una tarea específica, optimizando recursos.
- **Diseñar y desarrollar** soluciones de software escalables que puedan manejar un crecimiento en el volumen de datos sin degradar significativamente el rendimiento.

## Cómo

|Análisis del problema|Diseño de la solución|Evaluación de la eficiencia|
|-|-|-|
|Identificar claramente los datos de entrada y la salida esperada|Descomponer el problema en subproblemas más pequeños|Analizar el tiempo de ejecución esperado|
|Determinar las restricciones y casos especiales|Identificar patrones y estructuras de datos apropiadas|Considerar el uso de memoria|
|Considerar el volumen de datos a manejar|Considerar diferentes enfoques (iterativo vs recursivo, etc.)|Identificar posibles cuellos de botella|

### Ej.: una búsqueda

```java
static final int NO_ENCONTRADO = -1;

public int busquedaLineal(int[] array, int objetivo) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == objetivo)
          return i;
    }
    return NO_ENCONTRADO;
}

public int busquedaBinaria(int[] arrayOrdenado, int objetivo) {
    int inicio = 0;
    int fin = arrayOrdenado.length - 1;
    
    while (inicio <= fin) {
        int medio = (inicio + fin) / 2;
        if (arrayOrdenado[medio] == objetivo)
            return medio;
        if (arrayOrdenado[medio] < objetivo)
            inicio = medio + 1;
        else
            fin = medio - 1;
    }
    return NO_ENCONTRADO;
}
```

|Tamaño<br>*n*|Operaciones<br><small>en array desordenado</small>|Operaciones<br><small>en array ordenado|Tiempo*<br><small>en desordenado|Tiempo*<br><small>en ordenado|¡La diferencia!|
|-:|-:|-:|-|-|-|
|1|1|0|0.000001 s|0 s|=|
|10|10|3.32|0.00001 s|0.00000332 s|3x más rápido|
|100|100|6.64|0.0001 s|0.00000664 s|15x más rápido|
|1,000|1,000|9.97|0.001 s|0.00000997 s|100x más rápido|
|10,000|10,000|13.29|0.01 s|0.0000133 s|752x más rápido|

> *Asumiendo 1 microsegundo (0.000001 segundos) por operación*

Lo interesante aquí es notar que:

1. Para arrays pequeños (n=1) no hay diferencia significativa.
1. La diferencia se vuelve más dramática conforme crece n.
1. Para n=10,000, la búsqueda binaria es 752 veces más rápida.
1. Los números de O(log n) son log₂(n), ya que en cada paso dividimos por 2.

En el contexto de los algoritmos, la evaluación de la eficiencia se hace utilizando la notación Big O

### Notación Big O

Es una notación matemática que describe el **comportamiento límite superior de una función cuando el argumento tiende hacia un valor particular o infinito**.

En el contexto de los algoritmos, se utiliza para describir su complejidad temporal o espacial, es decir, cómo cambia el tiempo de ejecución o el espacio de memoria requerido con el tamaño de la entrada.

|Tamaño<br>n|O(n)|O(log n)|O(n) tiempo*|O(log n) tiempo*|¡La diferencia!|
|-:|-:|-:|-|-|-|
|1|1|0|0.000001 s|0 s|=|
|10|10|3.32|0.00001 s|0.00000332 s|3x más rápido|
|100|100|6.64|0.0001 s|0.00000664 s|15x más rápido|
|1,000|1,000|9.97|0.001 s|0.00000997 s|100x más rápido|
|10,000|10,000|13.29|0.01 s|0.0000133 s|752x más rápido|

> *Asumiendo 1 microsegundo (0.000001 segundos) por operación*
