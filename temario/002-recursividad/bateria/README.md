# Esquema

- Un esquema tabular, una tabla
- Dos columnas:
  - La primera columna, la entrada de datos: cuando me llaman con un dato, cuando me llaman con otro dato.
  - La segunda columna, el resultado: a tal entrada, tal salida.
- Las filas
  - Filas para el caso base
  - Pares de filas para el/los caso(s) recursivo(s)

## Cómo rellenamos la tabla

### La(s) fila(s) del caso base

- Encontramos lo más sencillo: el caso base. ¿En qué caso no hay que hacer ningún cálculo (o sea, no hay proceso recursivo)?
  - En el cálculo de factorial: caso base, 0. Lo pongo en la primera fila, primera columna: 0. En la segunda columna, 1.
  - Para ver si un elemento es miembro de una lista: Si el elemento que me piden es el primero de la lista, el elemento es miebro de la lista: en la primera columna, la lista con aquel primer elemento. En la segunda columna, true.
  - Suma de elementos de una lista: Lista vacía: devuelvo cero. 

> Hay que encontrar exactamente el caso base: ni más restrictivo, ni más permisivo. ¿Cómo? ¡Con la práctica! De a pocos la experiencia demostrará que, sistemáticamente los casos base suelen ser cero para números, suelen ser listas vacías o excepcionalmente listas con un único elemento, etc...

### Las filas de los casos recursivos

#### Me alejo del caso base

Elijo un valor "al azar":

- No debe estar pegado al valor del caso base (como mínimo 2 o 3 pasos alejado del caso base)
  - Factorial: Elijo el 5. Pongo 5 en la primera columna, 120 en la segunda columna.

#### Desciendo un orden

En una fila justo encima, 

- El 5 lo hago tender un grado cero: 4. Entonces, pongo (sobre el 5), 4 en la primera coluna y 24 en la segunda columna

> La experiencia demostrará que "tender a" en números habitualmente es restar un número. Con listas es quitar un elemento.

#### Observo en aspa

Llegados a este punto tenemos:

<div align=center>

||n|f(n)|
|-|-|-|
CB|0|1
||-|-
CR n-1|4|**24**
CR n|**5**|**120**

</div>

5 tiene que dar 120. Y 4 tiene que dar 24. ¿Cómo puedo llegar al 120 ayudándome del 5 y del 24?

5 x 24 = 120

Lo que significa que factorial, recursivamente, es n * f(n-1)

## Una batería de problemas

- [x] [Factorial](factorial.md)
- [x] [Suma de n primeros numeros](sumaNPrimeros.md)
- [x] [Multiplicar dos numeros](multiplicacionSumas.md)
- [x] [Potencias 2^n](potencias.md)
- [x] [Sumar los dígitos de un número](sumarDigitos.md)
- [x] [Contar](contar.md)
- [x] [Contar en reversa](reversa.md)
- [x] [Invertir una cadena](invertirCadena.md)
- [x] [Contar apariciones de una letra](contarApariciones.md)
- [x] [Suma de números de una lista](sumaNumerosLista.md)
- [x] [Filtrar lista (Mayores que X)](filtrarLista.md)
- [x] [Encontrar un elemento](encontrarElemento.md)
- [x] [Máximo de una lista](maximo.md)
- [x] [Lista ordenada](listaOrdenada.md)

## 2Think

- Producto de pares hasta n
- Contar las cifras de un número
- Elevar n al cuadrado
- En una palabra/frase, eliminar todas las apariciones de una letra
- En una palabra/frase, reemplazar una letra por otra
- Validar su una palabra es un palíndromo
- En una lista, duplicar sus elementos ([1,2,3] convertirla en [1,1,2,2,3,3])
- En una lista, sumar elementos en posiciones pares.
- Conversor a binario
