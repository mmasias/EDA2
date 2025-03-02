# crearArbol

> [crearArbol](https://github.com/mmasias/NutrIber/blob/d6a1b1c738fc4c536740ae636dd389f83a0e6998/fuentes.DEBUG/mFuncionesGenerales.bas#L755C1-L904C8) / [📖](/src/casosDeUso/recursividad/CrearArbol.bas)


## ¿Por qué?

En el contexto de la visualización de datos jerárquicos, la representación gráfica de estructuras anidadas constituye un desafío fundamental para los sistemas informáticos. La necesidad de mostrar relaciones padre-hijo de manera intuitiva y manipulable por el usuario requiere un enfoque algorítmico que refleje fielmente la naturaleza recursiva de los datos subyacentes. Los controles de tipo árbol (TreeView) presentes en interfaces gráficas de usuario representan una solución visual a este problema, pero su construcción programática demanda algoritmos que puedan recorrer y representar adecuadamente cada nivel de la jerarquía.

Particularmente en entornos con restricciones de recursos como los sistemas operativos de principios de los 2000 (Windows XP), se requería un enfoque eficiente que permitiera visualizar estructuras complejas sin comprometer el rendimiento general de la aplicación. La implementación de algoritmos recursivos para la construcción de estas visualizaciones emerge como una solución natural, permitiendo un mapeo directo entre la estructura de datos y su representación visual.

## ¿Qué?

El procedimiento `CrearArbol` constituye un ejemplo de recursividad directa aplicada a la visualización de datos. A diferencia de la [recursividad indirecta observada en el algoritmo `CalculaNutrientes`](calcularNutrientes.md), este procedimiento se invoca a sí mismo explícitamente durante su ejecución, creando una cadena de llamadas que refleja la profundidad de la estructura jerárquica.

Las características estructurales más destacables de este algoritmo incluyen:

- **Recursividad directa explícita**: El procedimiento se llama a sí mismo dentro de su propia definición, siguiendo la estructura jerárquica de los datos.
- **Estructura de casos paralela**: Implementa el mismo patrón de casos (E - Encuesta, D - Dieta, M - Menú, R - Receta, A - Alimento) que su contraparte de cálculo, manteniendo coherencia en el modelo de datos.
- **Paso de contexto mediante parámetros**: La información del estado actual y la ubicación en la jerarquía se transmite a través de los parámetros, especialmente mediante la construcción incremental del parámetro `miRama`.
- **Caso base implícito**: Aunque no se declara explícitamente, el algoritmo alcanza sus casos base cuando procesa nodos de tipo "A" (alimentos), que no generan llamadas recursivas adicionales.

El comportamiento del algoritmo se ajusta a la estructura clásica de una travesía en profundidad (DFS - Depth-First Search) de un árbol n-ario, donde cada nodo puede tener un número variable de hijos dependiendo de su tipo y contenido.

## ¿Para qué?

La implementación recursiva de `CrearArbol` satisface múltiples objetivos fundamentales en el diseño de interfaces de usuario para sistemas de información jerárquicos:

- **Visualización isomórfica**: Permite una correspondencia uno-a-uno entre la estructura de datos y su representación visual, facilitando la comprensión intuitiva por parte del usuario.
- **Exploración interactiva de datos**: La construcción del TreeView con propiedades como `.Expanded` controladas según el tipo de elemento permite a los usuarios explorar selectivamente la jerarquía sin sobrecarga visual.
- **Retroalimentación visual contextual**: El uso de diferentes colores, estilos de fuente y íconos para distintos tipos de elementos (`.Image = UCase(miTipoElemento)`, `.ForeColor = VerColor(miTipoElemento)`, `.Bold = True`) proporciona pistas visuales que enriquecen la experiencia del usuario.
- **Correlación entre cálculo y visualización**: Al compartir la misma estructura algorítmica con la función de cálculo, se garantiza la coherencia entre los valores nutricionales calculados y la representación visual de los elementos que contribuyen a dichos valores.

Esta dualidad entre cálculo y visualización ilustra un principio fundamental en el diseño de software: cuando la representación visual refleja fielmente el modelo de datos, la interfaz de usuario se vuelve más intuitiva y los resultados más comprensibles para el usuario final.

## ¿Cómo?

Desde la perspectiva de análisis de algoritmos, el procedimiento `CrearArbol` presenta características particulares:

1. Complejidad temporal
    - En un árbol tradicional, sería O(n) donde cada nodo se procesa una vez.
    - Sin embargo, en este sistema, elementos pueden aparecer múltiples veces en diferentes contextos jerárquicos.
    - Si existe alta reutilización (por ejemplo, la misma receta en múltiples menús), el algoritmo procesa el mismo elemento varias veces.
    - Cada procesamiento incluye consultas a base de datos, cuyo rendimiento depende del tamaño de las tablas.
    - En el peor caso teórico con máxima reutilización, la complejidad podría alcanzar O(n²).

1. Complejidad espacial
    - Debemos considerar que el número de nodos en el TreeView (m) puede ser significativamente mayor que el número de elementos únicos (n).
    - El espacio del TreeView es O(m), donde m puede aproximarse a n² en casos de alta reutilización.
    - La pila de llamadas recursivas almacena variables locales sustanciales, incluyendo objetos Recordset en cada nivel.
    - El parámetro miRama crece con cada nivel de recursión, aumentando la memoria consumida.
    - En el peor caso, la profundidad de recursión podría aproximarse a m.

1. Puntos de interés implementativo
   - El uso de concatenación de cadenas para construir identificadores únicos de nodos: `miRama & miElemento & miTipoElemento`
   - El manejo de casos especiales, como el cálculo de factores para recetas: `miFactor = miCantidad / miSuma`
   - La inclusión de metadatos en las propiedades `.Tag` de los nodos para facilitar operaciones posteriores: `.Tag = miElemento & "|" & miCantidad`

1. Dependencia de bases de datos
    - El algoritmo realiza múltiples consultas a la base de datos durante su ejecución, lo que podría representar un cuello de botella en términos de rendimiento, especialmente en sistemas con recursos limitados como Windows XP.
