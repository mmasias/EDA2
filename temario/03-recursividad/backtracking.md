# Backtracking

## ¿Por qué?

El backtracking emerge como una necesidad fundamental cuando se enfrentan problemas de búsqueda combinatoria o exploración de espacios de soluciones. Su desarrollo se justifica por varias razones esenciales:

|Problemas de optimización combinatoria|Espacios de búsqueda complejos|Restricciones interdependientes|Soluciones secuenciales|Insuficiencia de métodos iterativos|
|-|-|-|-|-|
|Multitud de problemas prácticos requieren encontrar una configuración óptima entre un conjunto exponencial de posibilidades, donde es inviable explorar todas las combinaciones mediante fuerza bruta.|Se presentan situaciones donde el espacio de búsqueda es tan vasto que se necesita un método sistemático para explorarlo de manera eficiente, evitando caminos que no conducen a soluciones válidas.|Muchos problemas presentan restricciones donde cada decisión afecta a las posibilidades futuras, requiriéndose un mecanismo que permita "deshacer" decisiones cuando se detecta que no llevarán a una solución válida.|Se requiere un método para problemas donde las soluciones se construyen elemento por elemento, y donde no todas las secuencias parciales pueden extenderse a soluciones completas.|Los enfoques puramente iterativos resultan inadecuados para problemas donde las decisiones tomadas en un paso pueden necesitar ser reconsideradas posteriormente.|
|En el problema del viajante (TSP), para solo 20 ciudades existen más de 2.4×10¹⁸ rutas posibles. Mediante backtracking puede reducirse drásticamente este espacio al podar caminos parciales que ya superan la distancia mínima encontrada hasta el momento.|Al resolver un Sudoku 9×9 parcialmente completado, existen aproximadamente 6.67×10²¹ posibles configuraciones, pero mediante backtracking se exploran solamente aquellas que cumplen las restricciones en cada paso, reduciendo el espacio de búsqueda a menudo a menos de mil combinaciones para puzzles típicos.|En el problema de las N-Reinas, colocar una reina en cierta posición automáticamente invalida múltiples posiciones para las reinas restantes. Si más adelante se descubre que no existe solución válida con esa configuración parcial, es necesario retroceder y probar otra ubicación para la reina anterior.|Al generar todas las posibles palabras de un idioma con ciertas restricciones (por ejemplo, palabras de 5 letras que deben contener la letra 'a'), muchas secuencias parciales pueden descartarse tempranamente. Si comenzamos con las letras "qi", sabemos que en español casi ninguna palabra comienza así, por lo que podemos retroceder inmediatamente sin explorar todas las posibilidades que comienzan con "qi".|Al resolver un laberinto, un algoritmo iterativo como la búsqueda en anchura encontrará la salida más cercana, pero si queremos encontrar todos los caminos posibles o el camino que recolecte la mayor cantidad de "tesoros" dentro del laberinto, necesitaremos backtracking para explorar sistemáticamente todas las rutas prometedoras.|

El backtracking surge así como una respuesta natural a la necesidad de explorar sistemáticamente espacios de soluciones complejos, aprovechando la capacidad de la recursividad para mantener estado y retroceder cuando sea necesario.

## ¿Qué?

El backtracking es una técnica algorítmica que utiliza la recursividad para construir soluciones incrementalmente, abandonando caminos que se determina no conducirán a una solución válida.

### Definición formal

El backtracking es una estrategia algorítmica para encontrar soluciones a problemas computacionales, particularmente aquellos que requieren satisfacer restricciones, mediante la construcción incremental de candidatos a solución y el abandono de candidatos parciales ("backtrack" o retroceso) tan pronto como se determina que no pueden extenderse a una solución válida.

### Elementos fundamentales

- **Estado parcial**: Representación de una solución parcial o incompleta al problema.
- **Restricciones**: Condiciones que deben cumplirse para que una solución sea válida.
- **Verificación de validez**: Mecanismo para determinar si un estado parcial puede extenderse a una solución válida.
- **Mecanismo de retroceso**: Proceso de abandonar un camino de exploración cuando se determina que no conducirá a una solución válida.

### Estructura general

Todo algoritmo de backtracking sigue una estructura recursiva con estos componentes:

1. **Verificación de caso base**: Determinar si se ha alcanzado una solución completa.
2. **Generación de candidatos**: Identificar las posibles extensiones del estado actual.
3. **Verificación de restricciones**: Comprobar si una extensión particular viola alguna restricción.
4. **Recursión con estado modificado**: Avanzar recursivamente con la extensión seleccionada.
5. **Retroceso**: Deshacer modificaciones y probar otras alternativas cuando una rama no lleva a solución.

### Diferencia con otras técnicas recursivas

El backtracking se distingue de la recursividad simple por:

|Característica|Recursividad simple|Backtracking|
|-|-|-|
|Enfoque|Divide el problema en casos más pequeños|Construye soluciones incrementalmente y prueba alternativas|
|Ramificación|Generalmente fija|Dinámica, se reduce mediante poda|
|Exploración|Completa todo el árbol recursivo|Abandona ramas tan pronto como se detectan como inviables|
|Uso de estado|Generalmente no mantiene estado entre llamadas|Mantiene y actualiza estado para rastrear soluciones parciales|
|Caso típico|Cálculos matemáticos como factorial o Fibonacci|Problemas de restricciones como N-Reinas o coloración de grafos|

## ¿Para qué?

El backtracking se utiliza para resolver una amplia gama de problemas en informática y matemáticas:

### Problemas de satisfacción de restricciones

- **Problemas de asignación**: Asignar recursos limitados a tareas cumpliendo ciertas restricciones.
- **Coloración de grafos**: Asignar colores a vértices de un grafo de modo que vértices adyacentes tengan colores diferentes.
- **Problemas de satisfacibilidad lógica (SAT)**: Determinar si existe una asignación de valores que haga verdadera una fórmula booleana.

### Juegos y puzzles

- **Sudoku**: Completar una cuadrícula 9×9 con dígitos de manera que cada columna, fila y subcuadrícula contenga los dígitos del 1 al 9.
- **Problema de las N-Reinas**: Colocar N reinas en un tablero de ajedrez N×N sin que se amenacen entre sí.
- **Resolución de laberintos**: Encontrar un camino desde la entrada hasta la salida de un laberinto.
- **Crucigramas**: Rellenar una cuadrícula con palabras que cumplan restricciones horizontales y verticales.

### Problemas de optimización

- **Problema del viajante (TSP)**: Encontrar la ruta más corta que visite cada ciudad exactamente una vez.
- **Problema de la mochila**: Seleccionar ítems con diferentes pesos y valores para maximizar el valor sin exceder una capacidad de peso.
- **Partición de conjuntos**: Dividir un conjunto en subconjuntos que cumplan ciertas propiedades.

### Aplicaciones en inteligencia artificial

- **Planificación automática**: Generar secuencias de acciones para alcanzar objetivos.
- **Sistemas expertos**: Implementar motores de inferencia para razonamiento basado en reglas.
- **Aprendizaje automático**: Poda de árboles de decisión y selección de características.

### Compiladores y procesamiento de lenguajes

- **Análisis sintáctico**: Parsing de gramáticas de contexto libre en compiladores.
- **Generación de expresiones regulares**: Construcción de patrones que coincidan con conjuntos de cadenas.
- **Unificación en lenguajes lógicos**: Implementación de mecanismos de resolución en Prolog.

## ¿Cómo?

La implementación de algoritmos de backtracking sigue una estructura general que se adapta a cada problema específico. A continuación se presenta cómo diseñar e implementar soluciones utilizando esta técnica:

### Estructura general de un algoritmo de backtracking

```java
public void backtrack(Estado estado) {
    if (esSolucionCompleta(estado)) {
        procesarSolucion(estado);
        return;
    }
    
    for (Candidato candidato : generarCandidatos(estado)) {
        if (esValido(estado, candidato)) {
            aplicarCandidato(estado, candidato);
            backtrack(estado);
            deshacerCandidato(estado, candidato);  // Backtracking
        }
    }
}
```

### Caso de estudio: Problema de las N-Reinas

El problema consiste en colocar N reinas en un tablero de ajedrez N×N de manera que ninguna reina pueda atacar a otra (es decir, sin que haya dos reinas en la misma fila, columna o diagonal).

#### Representación del estado

```java
public class NReinasEstado {
    private int n;                // Tamaño del tablero
    private int[] tablero;        // tablero[i] = columna donde se coloca la reina en la fila i
    private int reinasColocadas;  // Número de reinas colocadas hasta ahora
    
    public NReinasEstado(int n) {
        this.n = n;
        this.tablero = new int[n];
        Arrays.fill(tablero, -1); // -1 indica que no hay reina en esa fila
        this.reinasColocadas = 0;
    }
    
    // Métodos getter/setter y clonación omitidos por brevedad
}
```

#### Implementación del algoritmo

> [Queens.java *vVerbose*](/src/casosDeUso/recursividad/Queens.java) / [Queens.java *vSilent*](/src/casosDeUso/recursividad/QueensMuted.java)

### Optimizaciones comunes

1. **Ordenamiento de candidatos**: Explorar primero los candidatos más prometedores.

```java
List<Candidato> candidatos = generarCandidatos(estado);
candidatos.sort((c1, c2) -> estimarPotencial(c1) - estimarPotencial(c2));
```

2. **Detección temprana de inconsistencias**: Verificar restricciones lo antes posible.

```java
// Verificar restricciones antes de la recursión
if (!cumpleRestriccionesGlobales(estado)) {
    return; // Podar este camino inmediatamente
}
```

3. **Memoización**: Almacenar resultados de subproblemas ya resueltos.

```java
Map<Estado, Resultado> memorizacion = new HashMap<>();

public Resultado backtrackConMemo(Estado estado) {
    if (memorizacion.containsKey(estado)) {
        return memorizacion.get(estado);
    }
    
    // Lógica normal de backtracking
    Resultado resultado = calcularResultado(estado);
    
    memorizacion.put(estado, resultado);
    return resultado;
}
```

4. **Heurísticas de poda**: Eliminar ramas que no pueden conducir a una solución óptima.

```java
// Si el costo actual más la estimación del costo restante excede el mejor costo encontrado,
// podemos podar esta rama
if (costoActual + estimarCostoRestante(estado) >= mejorCostoEncontrado) {
    return;
}
```

### Consideraciones de implementación

- **Representación eficiente del estado**: Elegir estructuras de datos que permitan verificar restricciones rápidamente.
- **Gestión de memoria**: Cuidado con la profundidad de la recursión y el tamaño de la pila.
- **Balance entre poda y sobrecarga**: Las verificaciones demasiado complejas pueden ralentizar el algoritmo.
- **Depuración**: Implementar mecanismos para visualizar el árbol de búsqueda durante la ejecución.
