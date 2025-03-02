# Una función recursiva

> [calculaNutrientes](https://github.com/mmasias/NutrIber/blob/d6a1b1c738fc4c536740ae636dd389f83a0e6998/fuentes.DEBUG/mFuncionesGenerales.bas#L169) / [📖](/src/casosDeUso/recursividad/CalculaNutrientes.bas)

## ¿Por qué?

En el diseño de sistemas informáticos para nutrición y dietética se presenta un problema fundamental de representación jerárquica: los elementos dietéticos forman una estructura inherentemente recursiva. Un plato o menú está compuesto por alimentos o recetas, que a su vez pueden contener otros alimentos o subrecetas. Esta estructura anidada constituye un caso práctico donde la recursividad no es solo una opción de implementación, sino una necesidad derivada de la naturaleza misma del problema.

La complejidad del cálculo nutricional no radica únicamente en las operaciones matemáticas, sino en el manejo de esta estructura de datos jerárquica que requiere un enfoque recursivo para su procesamiento eficiente. El análisis de esta complejidad es crucial para entender las limitaciones y optimizaciones posibles en aplicaciones de alto rendimiento que deben procesar grandes volúmenes de datos nutricionales.

## ¿Qué?

El código presentado implementa una función denominada `CalculaNutrientes()` que evidencia un caso de recursividad indirecta o mutua. Esta implementación no utiliza la clásica estructura recursiva donde una función se llama a sí misma directamente, sino que presenta un patrón más sofisticado donde la recursión se manifiesta a través de las relaciones entre los diferentes tipos de elementos dietéticos.

En términos de estructura algorítmica, se observa:

- **Recursividad indirecta**: La función se llama a sí misma pero solo para ciertos casos y siempre con un tipo de elemento diferente, garantizando la terminación del algoritmo.
- **Estructura de árbol n-ario**: Conceptualmente, el sistema modela un árbol donde cada nodo puede tener múltiples hijos (una dieta contiene varios menús, un menú contiene varias recetas, etc.).
- **Propagación bottom-up**: Los valores nutricionales se calculan desde las hojas del árbol (alimentos básicos) hacia arriba (dietas completas).

La complejidad espacial del algoritmo es proporcional a la profundidad máxima de la jerarquía dietética multiplicada por el número de componentes nutricionales (35 en este caso), debido a la necesidad de mantener en memoria los resultados parciales durante la recursión.

## ¿Para qué?

El enfoque recursivo implementado en este código permite:

1. **Modelar relaciones complejas**: Representar fielmente la estructura jerárquica de elementos dietéticos, permitiendo cualquier nivel de anidación (por ejemplo, una receta puede contener otra receta como ingrediente).
1. **Facilitar el mantenimiento**: Aunque el código contiene complejidades, la estructura recursiva facilita la extensión del sistema para incorporar nuevos tipos de elementos (como evidencian los comentarios sobre la adición de "Encuestas" y "Enterales").
1. **Optimizar cálculos**: La recursividad permite reducir la redundancia de cálculos en estructuras complejas, evitando recalcular valores ya procesados.
1. **Adaptarse a diferentes contextos de uso**: El mismo algoritmo puede utilizarse para calcular valores nutricionales desde un simple alimento hasta una dieta completa para un período extendido.

El entendimiento de estos patrones recursivos trasciende la aplicación específica de nutrición, siendo aplicable a numerosos dominios donde se trabaja con estructuras jerárquicas o composiciones anidadas.

## ¿Cómo?

El análisis de la complejidad algorítmica de esta implementación revela aspectos interesantes:

### Complejidad temporal

Analizando con mayor precisión, la complejidad temporal de este algoritmo es más cercana a O(n²), donde n representa el número total de elementos en la estructura jerárquica completa. Esto ocurre porque:

- Para cada nivel de la jerarquía (dieta, menú, receta), el algoritmo debe recorrer todos los elementos hijos
- En el peor caso, si cada elemento puede contener referencias a casi todos los demás elementos, esto resulta en un comportamiento cuadrático
- El factor constante de 35 componentes nutricionales no afecta la notación O grande, pero sí el rendimiento práctico

   También podría expresarse como O(n * h), donde h es la altura máxima del árbol jerárquico, si la estructura está balanceada y tiene pocas referencias cruzadas. Sin embargo, en el peor caso teórico de una estructura altamente interconectada, el comportamiento cuadrático prevalece.

### Puntos de mejora identificados

- El algoritmo realiza múltiples consultas a la base de datos, lo que podría optimizarse mediante técnicas de caching.
- La gestión de casos especiales (valores -1 para trazas, -2 para ausencias) añade complejidad condicional al código.
- Algunos comentarios sugieren cambios en la lógica de procesamiento (`'arrSumaMenu(i) = arrSumaMenu(i) + arrElementosMenu(i)` reemplazado por `arrSumaMenu(i) = SumaComponentes(arrSumaMenu(i), arrElementosMenu(i))`), indicando posibles refinamientos en la precisión de los cálculos.

### Seguridad de terminación

A pesar de su naturaleza recursiva, el algoritmo garantiza terminación porque:

- Existe una jerarquía clara de tipos de elementos (500 > 400 > 300 > 200 > 100)
- Cada llamada recursiva siempre avanza hacia un tipo de elemento de nivel inferior
- Los casos base (elementos tipo 100/alimento o 700/enteral) no generan llamadas recursivas adicionales

### Gestión de errores

El código incluye tratamiento especial para valores negativos y ausencias, pero carece de manejo explícito de excepciones, lo que podría ser problemático en entornos de producción.

### Justificación histórica

En 2003, las restricciones de hardware eran significativamente diferentes a las actuales. Windows XP típicamente funcionaba en máquinas con procesadores de un solo núcleo (Pentium 4 o similares), con memoria RAM limitada (256MB-1GB era común) y discos duros mecánicos relativamente lentos.

Estas limitaciones de hardware explicarían algunas de las decisiones de implementación visibles en el código:

1. La estructura recursiva indirecta es eficiente para ese entorno porque:
   - Minimiza la duplicación de código
   - Permite que el programa funcione con conjuntos de datos que podrían ser demasiado grandes para caber completamente en la memoria disponible
2. Las múltiples consultas a la base de datos (en lugar de cargar todo en memoria) eran necesarias dado el limitado espacio RAM.
3. El uso de Visual Basic con su modelo de Recordset para acceso a datos era típico para aplicaciones de Windows en esa época, antes que tecnologías como LINQ o ORMs modernos se volvieran comunes.
