# Recursividad vs. Iteración

## ¿Por qué?

La comparación entre recursividad e iteración surge de una necesidad fundamental en el desarrollo de software: encontrar la forma más efectiva de resolver problemas repetitivos o divisibles. Este análisis comparativo es necesario por diversas razones:

- **Claridad conceptual**: Es imprescindible desmitificar la supuesta superioridad inherente de cualquiera de los dos enfoques, aclarando que ninguno posee capacidades especiales que el otro no pueda replicar.
- **Limitaciones prácticas**: A pesar de su elegancia conceptual, la recursividad presenta restricciones técnicas como el desbordamiento de pila (stack overflow) que pueden hacer inviable su uso en ciertos contextos.
- **Eficiencia computacional**: Se requiere evaluar el rendimiento de ambos enfoques en términos de tiempo de ejecución y consumo de memoria, factores críticos en el desarrollo de software eficiente.
- **Competencia técnica integral**: El conocimiento profundo de ambos paradigmas permite al programador seleccionar la herramienta más adecuada según las características específicas del problema a resolver.
- **Transformación entre paradigmas**: Se necesita comprender los mecanismos mediante los cuales cualquier algoritmo recursivo puede transformarse en uno iterativo y viceversa, ampliando así el repertorio de técnicas de resolución de problemas.

La comparación entre estos dos enfoques no se realiza para determinar cuál es universalmente superior, sino para entender en qué contextos cada uno ofrece ventajas significativas.

## ¿Qué?

La recursividad y la iteración representan dos paradigmas fundamentales para implementar procesos repetitivos en programación:

<div align=center>

|Iteración|Recursividad|
|-|-|
|La iteración utiliza estructuras de control como bucles (while, for) para repetir un conjunto de instrucciones hasta que se cumpla una condición.|La recursividad es un enfoque donde una función se llama a sí misma para resolver versiones más pequeñas del mismo problema hasta alcanzar un caso base.|
|**Inicialización**: Establecimiento de valores iniciales|**Caso base**: Condición que detiene las llamadas recursivas
|**Condición de continuación**: Determina si el bucle continúa|**Caso recursivo**: Parte donde la función se invoca a sí misma
|**Actualización**: Modifica el estado para avanzar hacia la terminación|**Progresión hacia el caso base**: Cada llamada debe acercarse al caso base
|**Cuerpo del bucle**: Instrucciones que se ejecutan repetidamente|

</div>

### Equivalencia teórica

Existe una equivalencia fundamental entre ambos enfoques:

<div align=center>

|Todo algoritmo iterativo puede convertirse en recursivo|Todo algoritmo recursivo puede implementarse iterativamente|
|-|-|
|Transformando el bucle en llamadas recursivas.|Utilizando un bucle y una estructura de pila explícita.|

</div>

Esta equivalencia significa que la elección entre recursividad e iteración no afecta lo que se puede computar, sino cómo se computa.

### Comparación de características

<div align=center>

|Característica|Recursividad|Iteración|
|-|-|-|
|Uso de memoria|Utiliza la pila de llamadas|Generalmente más eficiente en memoria |
|Claridad conceptual|A menudo más cercana a la definición matemática|Puede ser más intuitiva para operaciones secuenciales |
|Riesgo de errores|Desbordamiento de pila si la recursión es profunda|Bucles infinitos si la condición de salida está mal definida |
|Rendimiento|Puede implicar sobrecarga por múltiples llamadas a funciones|Generalmente más eficiente para problemas simples |
|Mantenimiento|A veces más elegante y concisa|A menudo más directa y fácil de depurar |

</div>

## ¿Para qué?

La comparación entre recursividad e iteración sirve para diversos propósitos prácticos en el desarrollo de software:

### Selección del enfoque adecuado

- **Optimización de rendimiento**: Permite elegir el enfoque más eficiente según las características del problema y las restricciones del sistema.
- **Gestión de recursos**: Facilita la toma de decisiones sobre el uso de memoria y tiempo de procesamiento.
- **Adecuación al dominio**: Ayuda a seleccionar el enfoque que mejor se adapta a la naturaleza del problema.

### Mejora de algoritmos existentes

- **Refactorización**: Ofrece técnicas para transformar código recursivo ineficiente en iterativo, o viceversa cuando sea beneficioso.
- **Eliminación de limitaciones**: Permite superar restricciones como el desbordamiento de pila en algoritmos recursivos profundos.
- **Mejora de legibilidad**: Posibilita reescribir código utilizando el paradigma que resulte más claro para un problema específico.

### Aplicaciones específicas

- **Estructuras jerárquicas**: Para recorrer árboles, grafos y otras estructuras anidadas, donde la recursividad a menudo resulta natural.
- **Algoritmos de dividir y conquistar**: En operaciones como ordenamiento (QuickSort, MergeSort) donde la recursividad puede ser conceptualmente más clara.
- **Cálculos matemáticos**: Para implementar funciones matemáticas definidas recursivamente (factorial, Fibonacci, etc.).
- **Backtracking**: En problemas como recorrido de laberintos o búsqueda de soluciones donde es necesario explorar múltiples caminos.

### Desarrollo de pensamiento algorítmico

- **Perspectivas complementarias**: Fomenta diferentes formas de pensar sobre la solución a un problema.
- **Percepción algorítmica**: A veces, pensar recursivamente puede revelar soluciones más eficientes que luego pueden implementarse iterativamente.
- **Comprensión profunda**: Entender ambos enfoques proporciona una visión más completa de las estructuras de control en programación.

## ¿Cómo?

A continuación, se presenta cómo implementar y comparar soluciones recursivas e iterativas para problemas comunes, así como técnicas para convertir entre ambos enfoques:

### Implementación de factorial

#### Enfoque recursivo

```java
public static int factorialRecursivo(int n) {
    if (n == 1) {
        return 1;
    }
    else {
        return n * factorialRecursivo(n - 1);
    }
}
```

#### Enfoque iterativo

```java
public static int factorialIterativo(int n) {
    int resultado = 1;
    for (int i = 1; i <= n; i++) {
        resultado = resultado * i;
    }
    return resultado;
}
```

### Implementación de Fibonacci

<div align=center>

![](/images/fibonacci.svg)

</div>

#### Enfoque recursivo

```java
public static int fibonacciRecursivo(int n) {
    if (n == 1 || n == 2) {
        return 1;
    }
    else {
        return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
    }
}
```

#### Enfoque iterativo

```java
public static int fibonacciIterativo(int n) {
    if (n <= 2) return 1;
    
    int a = 1, b = 1;
    for (int i = 3; i <= n; i++) {
        int temp = a + b;
        a = b;
        b = temp;
    }
    return b;
}
```

### Convertir un algoritmo recursivo a iterativo

Para convertir un algoritmo recursivo a iterativo, deben seguirse estos pasos:

1. **Crear una pila explícita**: Implementar una estructura de pila para simular la pila de llamadas.
2. **Identificar el estado**: Determinar qué información debe guardarse en cada "marco" de la pila.
3. **Inicializar**: Colocar el estado inicial en la pila.
4. **Implementar un bucle**: Procesar elementos de la pila hasta que esté vacía.
5. **Simular llamadas recursivas**: En lugar de llamadas recursivas, agregar nuevos estados a la pila.
6. **Simular retornos**: Cuando se alcance un caso base, procesar el resultado y continuar con el siguiente elemento.

#### Ejemplo: factorial iterativo utilizando una pila

```java
public static int factorialConPila(int n) {
    
    Stack<Integer> pila = new Stack<>();
    Stack<Integer> resultados = new Stack<>();
    
    pila.push(n);
    
    while (!pila.isEmpty()) {
        int actual = pila.pop();
        
        if (actual == 1) {
            resultados.push(1);
        } else {
            resultados.push(actual);
            pila.push(actual - 1);
        }
    }
    
    int resultado = 1;
    while (!resultados.isEmpty()) {
        resultado = resultados * resultados.pop();
    }
    
    return resultado;
}
```

<div align=center>

|Paso|Operación|pila|resultados|Acción realizada|
|-|-|-|-|-|
|1|Inicialización|[5]|[]|Se agrega 5 a `pila`|
|2|Procesar 5|[]|[5]|Se saca 5 de `pila`, se mete 4|
|3|Procesar 4|[4]|[5]|Se saca 4 de `pila`, se mete 3|
|4|Procesar 3|[3]|[5, 4]|Se saca 3 de `pila`, se mete 2|
|5|Procesar 2|[2]|[5, 4, 3]|Se saca 2 de `pila`, se mete 1|
|6|Procesar 1|[1]|[5, 4, 3, 2]|Se saca 1 de `pila`, caso base|
|7|Caso base|[]|[5, 4, 3, 2, 1]|Se saca 1 de `pila`, se mete 1 en `resultados`|
|8|Multiplicar resultados|||Multiplicar: 5 * 4 * 3 * 2 * 1|

</div>

### Convertir un algoritmo iterativo a recursivo

Para convertir un algoritmo iterativo a recursivo:

1. **Identificar variables de estado**: Determinar qué variables controlan el estado del bucle.
2. **Convertir en parámetros**: Transformar estas variables en parámetros de la función recursiva.
3. **Definir caso base**: Establecer cuándo debe terminar la recursión (equivalente a la condición de salida del bucle).
4. **Implementar caso recursivo**: Hacer que la función se llame a sí misma con valores actualizados.

#### Ejemplo: suma de enteros iterativa a recursiva

```java
public static int sumaIterativa(int n) {
    int suma = 0;
    for (int i = 1; i <= n; i++) {
        suma = suma + i;
    }
    return suma;
}

public static int sumaRecursiva(int n) {
    if (n == 1) {
        return 1;
    }
    else {
        return n + sumaRecursiva(n - 1);
    }
}
```

### Caso de estudio: El cálculo de exponentes

Implemente el cálculo de base^exponente (**a mano**, es decir, sin la clase `Math`).

```java
public class CalculoPotencia {

    public static long exponente(int base, int exponente) {
        long resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado = resultado * base;
        }
        return resultado;
    }
}
```

> 🚬
>
> El cálculo de exponentes (a^n) puede realizarse de forma recursiva utilizando la regla:
> - `Si n es par: a^n = (a^(n/2))^2`
> - `Si n es impar: a^n = a * (a^(n/2))^2`

```java
public static long exponenteOptimizado(int base, int exponente) {
    if (exponente == 0) {
        return 1;
    } else if (exponente == 1) {
        return base;
    } else if (exponente % 2 == 0) {
        long resultado = exponenteOptimizado(base, exponente / 2);
        return resultado * resultado;
    }
    else {
        long resultado = exponenteOptimizado(base, exponente / 2);
        return base * resultado * resultado;
    }
}
```

<div align=center>

|Iterativo|Recursivo|
|-|-|
|**Paso 1:** Inicializar resultado = 1|**Llamada 1:** exponenteOptimizado(3, 9)|
|**Paso 2:** resultado = 1 × 3 = 3|Como 9 es impar, calcular exponenteOptimizado(3, 4)|
|**Paso 3:** resultado = 3 × 3 = 9|**Llamada 2:** exponenteOptimizado(3, 4)|
|**Paso 4:** resultado = 9 × 3 = 27|Como 4 es par, calcular exponenteOptimizado(3, 2)|
|**Paso 5:** resultado = 27 × 3 = 81|**Llamada 3:** exponenteOptimizado(3, 2)|
|**Paso 6:** resultado = 81 × 3 = 243|Como 2 es par, calcular exponenteOptimizado(3, 1)|
|**Paso 7:** resultado = 243 × 3 = 729|**Llamada 4:** exponenteOptimizado(3, 1)|
|**Paso 8:** resultado = 729 × 3 = 2187|Caso base: devuelve 3|
|**Paso 9:** resultado = 2187 × 3 = 6561|Regresa a llamada 3: resultado = 3 * 3 = 9|
|**Paso 10:** resultado = 6561 × 3 = 19683|Regresa a llamada 2: resultado = 9 * 9 = 81|
||Regresa a llamada 1: resultado = 3 × 81 * 81 = 3 × 6561 = 19683|
|**Operaciones:**||
|· 9 multiplicaciones|· 5 multiplicaciones|

</div>

Y si tuvieramos que calcular 3^1000 con el método iterativo tendriamos que calcular 1000 multiplicaciones, mientras que con el método recursivo usamos 23.
