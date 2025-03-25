# La Torre de Hanoi

## ¿Por qué?

La Torre de Hanoi es un problema clásico en ciencias de la computación que representa un escenario ideal para la aplicación de recursión. Este rompecabezas requiere mover una pila de discos desde una torre origen a una torre destino, respetando restricciones específicas, lo que genera un patrón de solución naturalmente recursivo.

A diferencia de los problemas anteriores que operan sobre estructuras de datos lineales, la Torre de Hanoi implica operaciones secuenciales interdependientes donde cada movimiento depende del estado actual de las torres. La naturaleza de este problema hace que enfoques iterativos resulten significativamente más complejos conceptualmente, mientras que la definición recursiva captura elegantemente la esencia del proceso de solución.

Adicionalmente, este problema demuestra un caso donde el crecimiento exponencial del número de pasos (2^n - 1 para n discos) revela limitaciones prácticas importantes de ciertos algoritmos recursivos, proporcionando un escenario ideal para analizar la complejidad algorítmica.

## ¿Qué?

La Torre de Hanoi es un rompecabezas que consiste en tres torres (o postes) y un número n de discos de diferentes tamaños que pueden deslizarse sobre cualquier torre. El rompecabezas comienza con todos los discos ordenados por tamaño decreciente en una torre, formando una estructura cónica.

El objetivo del rompecabezas es mover toda la pila de discos a otra torre, respetando las siguientes reglas:

1. Solo puede moverse un disco a la vez.
1. Cada movimiento consiste en tomar el disco superior de una torre y colocarlo en la parte superior de otra.
1. Ningún disco puede colocarse sobre otro de menor tamaño.

## ¿Para qué?

La implementación recursiva de la Torre de Hanoi proporciona:

1. **Demostración de recursión múltiple**: Presenta un caso donde cada invocación recursiva genera múltiples llamadas recursivas adicionales, formando una estructura de árbol.
1. **Modelo para problemas de estados**: Establece un patrón para abordar problemas que requieren transformar un estado inicial en un estado final a través de una secuencia de transformaciones válidas.
1. **Visualización de la explosión combinatoria**: Ilustra cómo el número de operaciones crece exponencialmente con el tamaño de la entrada, demostrando limitaciones prácticas de ciertos algoritmos.
1. **Aplicación de subproblemas superpuestos**: Muestra cómo un problema complejo puede descomponerse en instancias más pequeñas del mismo problema que se resuelven siguiendo el mismo patrón.
1. **Base para análisis de complejidad**: Proporciona un caso de estudio ideal para comprender el análisis de complejidad temporal O(2^n) y sus implicaciones prácticas.
1. **Fundamento para backtracking**: Establece principios aplicables a algoritmos más complejos de backtracking y búsqueda de soluciones.
1. **Demostración de estructura recursiva en árbol**: Revela cómo las llamadas recursivas forman naturalmente una estructura arbórea, diferente de las estructuras lineales de los algoritmos anteriores.

## ¿Cómo?

[La solución recursiva](/src/casosDeUso/recursividad/Hanoi.java) se basa en la observación de que para mover n discos:

1. Se mueven n-1 discos desde la torre origen a la torre auxiliar.
1. Se mueve el disco n (el más grande) de la torre origen a la torre destino.
1. Se mueven n-1 discos desde la torre auxiliar a la torre destino.

### Análisis del algoritmo

#### Identificación del caso base y casos recursivos

- **Caso base**: Cuando hay un solo disco para mover, simplemente se mueve directamente de la torre origen a la torre destino.
- **Caso recursivo**: Para n discos, se realizan tres pasos:
  1. Mover n-1 discos de origen a auxiliar, usando destino como auxiliar temporal.
  1. Mover el disco n de origen a destino.
  1. Mover n-1 discos de auxiliar a destino, usando origen como auxiliar temporal.

#### Convergencia

El número de discos a mover disminuye en 1 en cada llamada recursiva, garantizando que eventualmente se alcanza el caso base (1 disco).

#### Estructura recursiva en árbol

A diferencia de los algoritmos anteriores, la Torre de Hanoi presenta un árbol binario de llamadas recursivas, donde cada subproblema genera dos llamadas adicionales, a excepción del caso base.

#### Funcionamiento para 4 discos

`resolver(numeroDiscos, torreOrigen, torreDestino, torreAuxiliar)`

```
resolver(4, A, C, B)
├─ resolver(3, A, B, C)
│   ├─ resolver(2, A, C, B)
│   │   ├─ resolver(1, A, B, C) → Mover disco 1 de A a B
│   │   ├─ Mover disco 2 de A a C
│   │   └─ resolver(1, B, C, A) → Mover disco 1 de B a C
│   ├─ Mover disco 3 de A a B
│   └─ resolver(2, C, B, A)
│       ├─ resolver(1, C, A, B) → Mover disco 1 de C a A
│       ├─ Mover disco 2 de C a B
│       └─ resolver(1, A, B, C) → Mover disco 1 de A a B
├─ Mover disco 4 de A a C
└─ resolver(3, B, C, A)
    ├─ resolver(2, B, A, C)
    │   ├─ resolver(1, B, C, A) → Mover disco 1 de B a C
    │   ├─ Mover disco 2 de B a A
    │   └─ resolver(1, C, A, B) → Mover disco 1 de C a A
    ├─ Mover disco 3 de B a C
    └─ resolver(2, A, C, B)
        ├─ resolver(1, A, B, C) → Mover disco 1 de A a B
        ├─ Mover disco 2 de A a C
        └─ resolver(1, B, C, A) → Mover disco 1 de B a C
```

### Consideraciones de eficiencia

La implementación recursiva de la Torre de Hanoi presenta:

1. **Complejidad temporal**: O(2^n), donde n es el número de discos. Esto implica un crecimiento exponencial: cada disco adicional duplica el número de movimientos necesarios.
2. **Complejidad espacial**: O(n) para la pila de llamadas recursivas, con una profundidad máxima de n.
3. **Limitaciones prácticas**: Para n = 64 discos, el algoritmo requeriría 2^64 - 1 movimientos, lo que tomaría más de 580 mil millones de años completar a razón de un movimiento por segundo.
