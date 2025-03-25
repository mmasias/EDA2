# Análisis conceptual

## ¿Por qué?

La programación tradicional basada en iteraciones presenta limitaciones significativas cuando se enfrentan problemas con estructuras de datos complejas o anidadas. En estos escenarios, se requiere descomponer problemas en subproblemas idénticos pero más pequeños, algo difícil de modelar con bucles simples. Adicionalmente, ciertos dominios como recorridos de árboles, retrocesos (backtracking) y problemas de *división y conquista* resultan artificialmente complejos cuando se implementan de manera iterativa.

Las soluciones iterativas para problemas inherentemente recursivos suelen requerir la implementación de estructuras de datos auxiliares como pilas explícitas, aumentando la complejidad del código y dificultando su mantenimiento. Además, la naturaleza de algunos algoritmos clásicos (como la Torre de Hanoi) hace que su comprensión conceptual sea significativamente más compleja sin el paradigma recursivo.

## ¿Qué?

La recursión es un paradigma de resolución de problemas donde una función se invoca a sí misma para resolver versiones más pequeñas del mismo problema. Fundamentalmente, una función recursiva debe incluir:

1. Un caso base que proporciona el resultado directo para la instancia más simple del problema, sin llamadas recursivas adicionales.
1. Uno o más casos recursivos donde la función se llama a sí misma con parámetros modificados que avanzan (*¿retroceden?*) hacia el caso base.
1. Un mecanismo que garantiza que los argumentos de cada llamada recursiva se aproximan al caso base.

## ¿Para qué?

La comprensión y dominio de los algoritmos recursivos permite:

1. **Simplificar la solución conceptual** - La recursión facilita expresar soluciones elegantes para problemas complejos, haciendo que el código refleje directamente la naturaleza del problema.
1. **Implementar algoritmos eficientemente** - Ciertos problemas (como recorridos de árboles y retrocesos) se resuelven de manera más natural y eficiente mediante recursión.
1. **Dominar técnicas fundamentales de programación** - La recursión constituye un paradigma esencial en ciencias de la computación y forma parte del conjunto de habilidades básicas de cualquier programador.
1. **Prepararse para entrevistas técnicas** - Los algoritmos recursivos aparecen frecuentemente en entrevistas de codificación para evaluar el pensamiento algorítmico.
1. **Comprender el funcionamiento interno del lenguaje** - La implementación de recursión profundiza la comprensión de la pila de llamadas, gestión de memoria y optimizaciones del compilador.

## ¿Cómo?

Para implementar soluciones recursivas efectivas, se debe seguir una metodología estructurada:

1. **Identificar el caso base** - Determinar las condiciones más simples donde el problema puede resolverse directamente sin recursión adicional.
1. **Formular el caso recursivo** - Definir cómo descomponer el problema original en instancias más pequeñas del mismo problema.
1. **Garantizar la convergencia** - Asegurar que cada llamada recursiva se acerca al caso base, evitando así recursión infinita.
1. **Aplicar la técnica cabeza-cola (head-tail)** cuando sea apropiado:
   - Dividir la estructura de datos en su primer elemento (cabeza) y el resto (cola)
   - Procesar la cabeza directamente
   - Aplicar recursión a la cola
   - Combinar los resultados adecuadamente
1. **Utilizar la técnica de "salto de fe" (leap of faith)** - Asumir que la llamada recursiva funciona correctamente para casos más pequeños al implementar el caso recursivo.
1. **Evaluar la eficiencia** - Considerar si la solución recursiva es apropiada o si una implementación iterativa sería más eficiente en términos de tiempo de ejecución y uso de memoria.
1. **Prevenir desbordamientos de pila** - Ser consciente de las limitaciones de profundidad recursiva y considerar técnicas como la recursión de cola o implementaciones iterativas para problemas con entradas grandes.

## Implementaciones prácticas

Los siguientes algoritmos recursivos clásicos se implementarán en Java en apartados independientes:

1. **[Suma de números en un array](implementaciones/sumaNumerosArray.md)** - Implementación del algoritmo que suma los elementos de un array utilizando la técnica cabeza-cola.
1. **[Inversión de cadenas de texto](implementaciones/inversionCadenas.md)** - Algoritmo recursivo para invertir una cadena de caracteres.
    - [*2Think*](implementaciones/ascensoVsDescenso.md)
1. **[Detección de palíndromos](implementaciones/palindromos.md)** - Verificación recursiva de si una cadena es palíndromo.
1. **[Torre de Hanoi](implementaciones/torreDeHanoi.md)** - Solución recursiva al clásico problema de la Torre de Hanoi.
1. **[Algoritmo de relleno por inundación (flood fill)](implementaciones/floodFill.md)** - Implementación del algoritmo utilizado en aplicaciones gráficas para rellenar áreas.
1. **Función de Ackermann** - Ejemplo de función matemática altamente recursiva.
