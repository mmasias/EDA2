# Operaciones funcionales sobre colecciones inmutables

## ¿Por qué?

La programación tradicional con colecciones en Java se basa en modificar el estado interno de estas estructuras mediante métodos como `add()`, `remove()` o `set()`. Este enfoque mutable, aunque familiar, genera dificultades en entornos de programación paralela donde múltiples hilos pueden intentar modificar las mismas colecciones simultáneamente.

Las colecciones mutables requieren sincronización explícita para evitar inconsistencias, lo que a menudo resulta en código complejo propenso a errores como condiciones de carrera, deadlocks, o inconsistencias en los datos. Además, la depuración de estos problemas se vuelve particularmente desafiante debido a su naturaleza no determinista.

A nivel conceptual, la mutabilidad de las colecciones también dificulta el razonamiento sobre el comportamiento del programa, especialmente cuando se comparten referencias a estas colecciones entre diferentes componentes del sistema. Un cambio en una colección puede tener efectos secundarios inesperados en partes distantes del código, complicando el mantenimiento y la evolución del software.

## ¿Qué?

Las operaciones funcionales sobre colecciones inmutables representan un paradigma alternativo donde las colecciones, una vez creadas, no se modifican. En lugar de alterar una colección existente, cada operación genera una nueva colección que refleja el cambio deseado, manteniendo la colección original intacta.

Java, desde su versión 8, introduce la API de Stream como mecanismo principal para trabajar con colecciones de manera funcional. Un Stream representa una secuencia de elementos que soporta diversas operaciones agregadas de forma secuencial o paralela. Estas operaciones se clasifican en:

- **Operaciones intermedias**: Como mapeo, filtrado o aplanamiento, que transforman un stream en otro.
- **Operaciones terminales**: Como reducción o recolección, que procesan el stream para producir un resultado final.

Este enfoque permite expresar transformaciones complejas de datos como composiciones de operaciones más simples, siguiendo los principios de la programación funcional: transparencia referencial, ausencia de efectos secundarios y uso de funciones como ciudadanos de primera clase.

## ¿Para qué?

La adopción de operaciones funcionales sobre colecciones inmutables soluciona directamente los problemas mencionados anteriormente:

Al trabajar con colecciones que no cambian después de su creación, se elimina la posibilidad de condiciones de carrera relacionadas con modificaciones concurrentes. Esto simplifica drásticamente el desarrollo de sistemas paralelos, permitiendo aprovechar eficientemente la capacidad de procesamiento de arquitecturas multicore sin la sobrecarga de mecanismos de sincronización complejos.

El estilo declarativo de las operaciones funcionales expresa claramente la intención del programador, centrándose en el "qué" debe hacerse en lugar del "cómo" hacerlo. Esto resulta en código más legible, mantenible y menos propenso a errores, facilitando la comprensión de transformaciones complejas de datos.

La composición de operaciones permite construir pipelines de procesamiento que pueden aplicarse de forma eficiente tanto secuencial como paralelamente, simplemente cambiando la naturaleza del stream utilizado, lo que proporciona una escalabilidad natural conforme aumentan los recursos computacionales disponibles.

## ¿Cómo?

La API de Stream de Java ofrece un conjunto rico de operaciones para trabajar con colecciones de manera funcional. A continuación, se explorarán las principales operaciones con ejemplos detallados.

|||||
|-|-|-|-|
|Básicas  |Mapeo de colecciones (***map***)                   |Transforma cada elemento de una colección aplicando una función definida|[Ejemplo](/src/casosDeUso/inmutabilidad/e010/)
|         |Mapeo y aplanamiento de colecciones (***flatMap***)|Permite transformar cada elemento en múltiples elementos y aplanar el resultado|[Ejemplo](/src/casosDeUso/inmutabilidad/e020/)
|         |Filtrado de colecciones (***filter***)             |Selecciona elementos que cumplen con un predicado específico|[Ejemplo](/src/casosDeUso/inmutabilidad/e030/)
|         |Reducción de colecciones (***reduce***)            |Combina los elementos de una colección para producir un único resultado|[Ejemplo](/src/casosDeUso/inmutabilidad/e040/)
|Derivadas|Combinando operaciones: Pipelines de transformación|Las operaciones pueden encadenarse para formar pipelines de transformación completos|[Ejemplo](/src/casosDeUso/inmutabilidad/e050/)
|         |Streams numéricos especializados                   |Variantes especializadas para valores primitivos numéricos|[Ejemplo](/src/casosDeUso/inmutabilidad/e060/)
|         |Recolección de resultados                          |Diversas formas de recolectar resultados|[Ejemplo](/src/casosDeUso/inmutabilidad/e070/)

## 2Think: *del paradigma imperativo ("cómo hacer") al declarativo ("qué queremos lograr")*

<div align=center>

|||
|-|-|
*La evolución desde los tradicionales bucles for hasta la elegancia de los streams representa más que una actualización sintáctica: constituye un cambio fundamental en la filosofía de programación.*|*La inmutabilidad, inicialmente percibida como una restricción que limita las modificaciones directas sobre estructuras de datos, se revela como una liberación conceptual que habilita patrones de pensamiento más sofisticados.*

</div>

La introducción de streams en Java 8 no fue solo añadir un API más: fue un cambio de mentalidad. Cuando empezamos con el concepto de inmutabilidad, queríamos evitar los efectos secundarios peligrosos de modificar colecciones compartidas. Pero lo que encontramos fue un modelo completo de programación que ofrece:

- Código más legible: En lugar de bucles anidados y variables intermedias, un pipeline de operaciones que se lee como una *receta de cocina*.
- Más seguro: La inmutabilidad garantizada elimina toda una clase de bugs relacionados con concurrencia y estados compartidos.
- Naturalmente encadenable: Cada operación devuelve un stream, creando una cadena fluida que se asemeja más al pensamiento humano.

Lo elegante de Java Streams es cómo integra tres principios poderosos:

- Inmutabilidad (seguridad)
- Fluent API (expresividad)
- Operaciones especializadas (eficiencia)

Lo que comenzó como una preocupación técnica de seguridad (no modificar datos) se transformó en una forma más natural y expresiva de programar: en lugar de decirle a la computadora exactamente cómo manipular cada elemento uno por uno, ahora describimos transformaciones de alto nivel sobre colecciones enteras.

La inmutabilidad no es solo una restricción técnica - es una puerta hacia un estilo de programación más claro, seguro y poderoso.
