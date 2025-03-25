# Relleno por inundación (*Flood Fill*)

## ¿Por qué?

El relleno por inundación es un algoritmo fundamental en el procesamiento de imágenes y gráficos por computadora utilizado para determinar el área conectada a un punto dado. Este problema presenta un escenario donde la recursión resulta naturalmente aplicable debido a la naturaleza de propagación del algoritmo.

Los enfoques tradicionales para recorrer matrices bidimensionales suelen utilizar bucles anidados, pero estos resultan insuficientes cuando se requiere detectar y procesar áreas contiguas con características similares. El relleno por inundación necesita explorar áreas conectadas en múltiples direcciones, siguiendo un patrón de ramificación que coincide perfectamente con las propiedades estructurales de la recursión.

Este algoritmo representa, además, un caso de uso donde la recursión opera sobre estructuras de datos multidimensionales, ampliando el concepto más allá de las estructuras lineales o jerárquicas vistas en ejemplos anteriores.

## ¿Qué?

El algoritmo de relleno por inundación consiste en cambiar el color (o valor) de un área conectada en una imagen o matriz bidimensional. Comenzando desde un punto inicial, el algoritmo examina los píxeles o celdas adyacentes y, si tienen el mismo color original, cambia su valor al nuevo color especificado. Este proceso se propaga en cuatro direcciones cardinales (arriba, abajo, izquierda, derecha) hasta que toda el área conectada ha sido rellenada.

El problema puede definirse formalmente como:

- Dada una matriz bidimensional, un punto de inicio (x,y), un color original y un color nuevo
- Reemplazar el color de todos los elementos conectados al punto inicial que tengan el color original
- Dos elementos se consideran conectados si son adyacentes horizontalmente o verticalmente

La solución recursiva examina cada píxel adyacente y, si cumple con las condiciones, cambia su color y aplica recursivamente el mismo proceso a sus vecinos.

## ¿Para qué?

La implementación recursiva del algoritmo de relleno por inundación proporciona:

1. **Aplicación práctica en gráficos**: Implementa la herramienta "balde de pintura" presente en prácticamente todos los programas de edición de imágenes.
1. **Modelo para propagación espacial**: Establece un patrón para algoritmos que requieren propagar efectos o cambios a través de áreas conectadas.
1. **Demostración de recursión multidireccional**: Ilustra cómo la recursión puede ramificarse en múltiples direcciones simultáneamente, formando un patrón de árbol.
1. **Base para algoritmos de detección de componentes conectados**: Fundamenta técnicas para identificar regiones, detectar objetos o analizar estructuras en imágenes y datos espaciales.
1. **Aplicación en juegos y simulaciones**: Permite implementar mecánicas como descubrimiento de mapas, propagación de efectos o detección de territorios en juegos.
1. **Preparación para algoritmos de búsqueda en grafos**: Introduce conceptos relacionados con recorridos en profundidad (DFS) que se aplican en estructuras de datos más complejas.
1. **Caso de estudio para analizar límites de recursión**: Proporciona un ejemplo donde la recursión puede alcanzar límites prácticos en términos de profundidad de pila para imágenes grandes.

## ¿Cómo?

> [RellenoInundacion.java](/src/casosDeUso/recursividad/RellenoInundacion.java)
>
> *Incluye versiones recursivas e iterativas del algoritmo*

### Análisis del algoritmo

<div align=center>

|Casos base|Casos recursivos|
|-|-|
|Si la coordenada está fuera de los límites de la imagen.|Propagar el relleno a los cuatro píxeles adyacentes|
|Si el píxel en la coordenada actual no tiene el color original.|· Arriba (x, y-1)|
|Si el color original y el nuevo son iguales.|· Abajo (x, y+1)|
||· Izquierda (x-1, y)|
||· Derecha (x+1, y)|

</div>

#### Convergencia

El algoritmo converge porque en cada llamada recursiva:

1. No se modifica ningún píxel más de una vez (una vez cambiado, ya no coincide con el color original).
2. El número de píxeles con el color original es finito.
3. Eventualmente, todos los píxeles conectados con el color original serán procesados.

#### Funcionamiento detallado con un ejemplo reducido

Consideremos una matriz más pequeña para ilustrar el proceso paso a paso:

```
.....
.###.
.#.#.
.###.
.....
```

Si iniciamos el relleno en la coordenada (2,2) (el centro):

1. `rellenar(2,2,'o','.') → imagen[2][2] = 'o'`

   ```
   .....
   .###.
   .#o#.
   .###.
   .....
   ```

1. Llamadas recursivas desde (2,2):
   - `rellenar(2,3,'o','.')` → Base case: el píxel no es '.'
   - `rellenar(2,1,'o','.')` → Base case: el píxel no es '.'
   - `rellenar(3,2,'o','.')` → Base case: el píxel no es '.'
   - `rellenar(1,2,'o','.')` → Base case: el píxel no es '.'

1. No hay más propagación, el algoritmo termina con un solo píxel cambiado.

Para un caso más complejo, si iniciamos en (0,0) (esquina superior izquierda), la propagación recorrería todo el exterior.

### Consideraciones de eficiencia

La implementación recursiva del relleno por inundación presenta:

1. **Complejidad temporal**: O(n×m) en el peor caso, donde n y m son las dimensiones de la matriz, ya que cada celda se visita como máximo una vez.
1. **Complejidad espacial**: O(n×m) para la pila de llamadas recursivas en el peor caso, cuando el área a rellenar tiene una forma que maximiza la profundidad de la recursión.
1. **Limitaciones prácticas**: Para imágenes grandes, este algoritmo puede causar desbordamiento de pila debido a demasiadas llamadas recursivas anidadas.

### Implementación iterativa equivalente

Para evitar el desbordamiento de pila en imágenes grandes, se puede implementar una versión iterativa usando una pila o cola explícita

## A partir de aquí

> [*Ejemplo*](https://www.youtube.com/@PixelArtSierra)

Jugar con ideas usando [imagenes](http://www.sierrawallpaper.com/games/kq1agi/) y [ASCII](https://www.asciiart.eu/image-to-ascii)

<div align=center>

|![image](https://github.com/user-attachments/assets/8ee57bcd-9020-4ff6-8496-86b16ea4d7a1)|![image](https://github.com/user-attachments/assets/6229e4df-3a02-464d-ae04-1868824d0517)|
|-|-|

</div>
