# Hashing

## ¿Por qué?

|||
|-|-|
En el ámbito de la computación y el manejo de datos, es fundamental poder acceder y gestionar la información de manera rápida y eficiente. A medida que las bases de datos y los volúmenes de información crecen, los métodos tradicionales de búsqueda secuencial se vuelven ineficaces. Aquí es donde entra en juego el hashing, que permite una rápida indexación y recuperación de datos, transformando la manera en que los sistemas manejan grandes conjuntos de datos.|En muchos contextos, especialmente en la educación y la administración de datos, es crucial garantizar que la información no haya sido alterada desde su creación o durante su transmisión. La integridad de los datos es fundamental para mantener la confianza en los sistemas de información, y es particularmente crítica en sectores donde la manipulación de datos puede tener serias implicaciones legales, académicas o financieras.

## ¿Qué?

|||
|-|-|
El **hashing** es una técnica utilizada para convertir un rango grande de valores de claves en un rango más pequeño de índices de un arreglo. Se hace mediante una función de hash, que es una función que toma un elemento (la clave) y le asigna un índice en un arreglo o tabla, donde se almacena el valor correspondiente. Esta tabla se conoce como una **tabla hash**.|Una **función hash criptográfica** es un tipo especial de función hash diseñada para ser una vía de sentido único — fácil de calcular en una dirección, pero extremadamente difícil de invertir o de encontrar dos entradas que produzcan la misma salida (resistencia a colisiones). Estas funciones producen un "resumen" o "hash" fijo y relativamente pequeño de un conjunto de datos de cualquier tamaño.

## ¿Para qué?

|||
|-|-|
**Acceso rápido a datos**: Permite recuperar datos en tiempo constante \(O(1)\), en el caso ideal.|**Criptografía**: Las funciones de hash criptográficas son fundamentales para la seguridad de los datos, usadas en autenticación, firma digital, y más.
**Manejo eficiente de colisiones**: Las colisiones ocurren cuando diferentes claves obtienen el mismo índice de hash. El manejo adecuado de colisiones es crucial para mantener la eficiencia del hashing.|**Verificar la integridad de los datos**: Comparando los hashes calculados de los datos en puntos de tiempo diferentes, se puede detectar cualquier alteración.
**Implementación de estructuras de datos**: Es la base para estructuras como diccionarios y conjuntos, usados extensivamente en programación.|**Auditoría y cumplimiento**: Facilitan la verificación de que los datos no han sido modificados sin autorización, cumpliendo con normativas legales y políticas internas.
**Prevención de duplicados**: Facilita la verificación rápida de la existencia de un elemento.|**Seguridad en la transmisión de datos**: Aseguran que los datos enviados a través de redes inseguras no hayan sido manipulados durante el tránsito.

## ¿Cómo?

- Implementaciones de la validación de integridad con funciones hash
  - [Contraseña](src/v003/)
  - [Una persona](src/v001/)
  - [Datos modificados](src/v002/)
  - [Acta de calificaciones](src/v004/)
