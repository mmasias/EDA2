# Una función recursiva

> [calculaNutrientes](https://github.com/mmasias/NutrIber/blob/d6a1b1c738fc4c536740ae636dd389f83a0e6998/fuentes.DEBUG/mFuncionesGenerales.bas#L169)

## Estructura

La función `CalculaNutrientes` se utiliza para calcular la composición nutricional en diferentes tipos de elementos como menús, recetas y alimentos. La función es recursiva, permitiendo el cálculo en estructuras compuestas anidadas a través de varios niveles:

```vbnet
Function CalculaNutrientes(miElemento As Long, _
                           miTipoElemento As TipoElemento, _
                  Optional Cantidad As Double, _
                  Optional miFactor As Double = -1) As Double()

```

- miElemento: id del elemento
- miTipoElemento : miEncuesta / miDieta / miMenu / miReceta / miAlimento

La función utiliza la recursividad para descomponer estructuras complejas en componentes más simples. Por ejemplo, un menú se descompone en recetas y/o alimentos, donde cada receta puede a su vez contener más alimentos. Este enfoque es típico en problemas de descomposición de estructuras o de división y conquista.

## Análisis de complejidad

### Complejidad temporal

La función presenta una complejidad temporal que puede ser modelada como \(O(k^5)\), donde \(k\) es el número promedio de sub-elementos por cada elemento y 5 representa la profundidad de la recursión (Encuesta, Día, Ingesta, Receta, Alimento):

- **Recursión exponencial**: Cada nivel puede invocar múltiples instancias del siguiente nivel, resultando en un crecimiento exponencial del número de llamadas recursivas.
- **Operaciones por llamada**: Dentro de cada llamada, se realizan operaciones sobre un array de 35 elementos, lo que añade un factor lineal sobre la base exponencial.

### Complejidad espacial

El uso de espacio es dominado por:

- **Pila de llamadas**: Cada llamada recursiva añade una nueva capa en la pila de llamadas.
- **Estructuras de datos temporales**: Arrays y objetos utilizados en cada llamada.

## Reflexiones sobre la recursividad

En este caso, la recursividad facilita el manejo de estructuras de datos complejas y anidadas, pero también introduce desafíos significativos en términos de eficiencia y manejo de memoria, especialmente en contextos de bases de datos donde cada llamada puede involucrar operaciones I/O costosas.

## xMejorar

1. Optimización de las consultas SQL: Reducir el número de consultas por llamada, utilizar técnicas como el cargado de datos previo (pre-fetching) o la implementación de cachés para resultados intermedios.
2. Alternativas a la recursividad: Convertir la recursión en iteración donde sea posible, o utilizar estructuras de datos que naturalmente optimicen las operaciones recursivas, como árboles balanceados o tablas hash.
3. Caching de resultados: Almacenar resultados de cálculos frecuentes puede reducir significativamente la cantidad de procesamiento necesario.
