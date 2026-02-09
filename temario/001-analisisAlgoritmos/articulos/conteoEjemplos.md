# Conteo: ejemplos

## O(2ⁿ) - Duplicación al añadir un elemento

### Problema de las n decisiones binarias

***n*** interruptores. Cada uno puede estar en ON u OFF.

- 1 interruptor: 2 estados posibles
- 2 interruptores: 4 estados posibles (ON-ON, ON-OFF, OFF-ON, OFF-OFF)
- 3 interruptores: 8 estados posibles
- 4 interruptores: 16 estados posibles

Añadir un interruptor duplica el número de configuraciones posibles. Recorrer todos los estados requiere 2ⁿ operaciones.

### Torre de Hanoi

Mover n discos entre tres torres siguiendo las reglas del juego:

- 1 disco: 1 movimiento
- 2 discos: 3 movimientos
- 3 discos: 7 movimientos
- 4 discos: 15 movimientos

Fórmula: 2ⁿ - 1. Cada disco adicional más que duplica los movimientos necesarios.

## O(n²) - Crecimiento cuadrático

### Copiar matriz cuadrada n×n

Una matriz de lado n contiene n² elementos.

- Matriz 2×2: 4 elementos a copiar
- Matriz 4×4: 16 elementos a copiar (×4)
- Matriz 8×8: 64 elementos a copiar (×4)

Duplicar el lado cuadruplica el número de operaciones.

### Estrechar manos en un grupo

En un grupo de n personas, cada una estrecha la mano a todas las demás una vez.

- 2 personas: 1 apretón
- 3 personas: 3 apretones
- 4 personas: 6 apretones
- 5 personas: 10 apretones

Total: n(n-1)/2 ≈ n²/2

### Comparar todos los pares de elementos

Tienes n elementos y necesitas comparar cada uno con todos los demás.

- 10 elementos: ~50 comparaciones
- 20 elementos: ~200 comparaciones (×4)
- 40 elementos: ~800 comparaciones (×4)

## O(n³) - Crecimiento cúbico

### Copiar cubo 3D de lado n

Un cubo de lado n contiene n³ celdas.

- Cubo 2×2×2: 8 celdas a copiar
- Cubo 4×4×4: 64 celdas a copiar (×8)
- Cubo 8×8×8: 512 celdas a copiar (×8)

Duplicar el lado multiplica por 8 el número de operaciones.

### Rellenar un edificio cúbico

Construyes un edificio de n pisos, con n habitaciones por piso, y n muebles por habitación.

- Edificio 3×3×3: 27 muebles a colocar
- Edificio 6×6×6: 216 muebles a colocar (×8)

### Comparar todos los tripletes

Examinar todas las combinaciones posibles de 3 elementos entre n disponibles.

- 5 elementos: 10 tripletes
- 10 elementos: 120 tripletes (×12)
- 20 elementos: 1140 tripletes (×9.5)

Relación aproximada: C(n,3) = n(n-1)(n-2)/6 ≈ n³/6