# Patrones de procesamiento recursivo: descenso vs ascenso

## ¿Por qué?

Las implementaciones recursivas no son homogéneas en su estructura. Aunque todas siguen el principio de descomposición en problemas más pequeños, existe una diferencia fundamental en cuándo y cómo se procesan los resultados. Esta distinción, a menudo pasada por alto, tiene implicaciones significativas en la eficiencia, optimización y aplicabilidad de los algoritmos recursivos.

La falta de comprensión de esta diferencia puede llevar a implementaciones ineficientes o difíciles de mantener. Además, ciertos problemas requieren inherentemente uno u otro enfoque, por lo que conocer ambos patrones resulta esencial para seleccionar la estrategia recursiva adecuada.

## ¿Qué?

Existen dos patrones principales de procesamiento en algoritmos recursivos:

|Procesamiento en descenso (head-first o descendente)|Procesamiento en ascenso (tail-first o ascendente)|
|-|-|
|`operación(cabeza, recursión(cola))`|`operación(recursión(cola), cabeza)`|
|La operación principal se realiza antes de conocer el resultado completo de la llamada recursiva. El procesamiento ocurre principalmente durante la fase de "descenso" de la recursión.|La operación principal se realiza después de obtener el resultado completo de la llamada recursiva. El procesamiento ocurre principalmente durante la fase de "ascenso" o retorno de la recursión.|

## ¿Para qué?

Comprender estos patrones permite:

1. **Seleccionar el enfoque óptimo**: Algunos problemas se adaptan naturalmente a uno u otro patrón.
1. **Optimizar algoritmos**: Identificar oportunidades para técnicas como recursión de cola o memoización.
1. **Predecir el comportamiento**: Anticipar cómo crecerá la pila de llamadas y cómo se combinarán los resultados.
1. **Transformar algoritmos**: Convertir entre implementaciones iterativas y recursivas con mayor facilidad.
1. **Depurar eficazmente**: Comprender mejor el flujo de ejecución para localizar errores en implementaciones recursivas.

## ¿Cómo?

<div align=center>

<table>
<tr><th>Procesamiento en descenso</th><th>Procesamiento en ascenso</th></tr>
<tr><td>

[Suma recursiva](sumaNumerosArray.md)
</td><td>

[Inversión de cadenas](inversionCadenas.md)
</td></tr>
<tr>
    <td>Flujo de ejecución con [2, 4, 8]</td>
    <td>Flujo de ejecución con "CAT":</td>
</tr>
<tr><td valign=top>

```
sumar([2, 4, 8])
       ├─ cabeza = 2
       └─ 2 + sumar([4, 8])
                 ├─ cabeza = 4
                 ├─ 4 + sumar([8])
                 |         ├─ cabeza = 8
                 |         ├─ 8 + sumar([])
                 |         |         ├─ retorna 0
                 |         |         └─ 8 + 0 = 8
                 |         └─ 4 + 8 = 12
                 └─ 2 + 12 = 14
```

</td><td valign=top>

```
invertir("CAT")
├─ cabeza = 'C'
└─ invertir("AT") + 'C'
              ├─ cabeza = 'A'
              ├─ invertir("T") + 'A'
              |          ├─ retorna "T" (caso base)
              |          └─ "T" + 'A' = "TA"
              └─ "TA" + 'C' = "TAC"
```
</td></tr>
<tr><td><i>Temprano</i></td><td><i>Tardío</i></td></tr>
</table>

</div>

### Diferencias clave

1. **Momento de procesamiento**:
   - Descenso: La operación comienza antes de completar la recursión
   - Ascenso: La operación solo puede realizarse después de completar la recursión
1. **Orden de ejecución**:
   - Descenso: Primero procesa, luego recursa
   - Ascenso: Primero recursa, luego procesa
1. **Optimización**:
   - Descenso: Puede transformarse en recursión de cola con un acumulador
   - Ascenso: Generalmente requiere la pila completa para el procesamiento de retorno
1. **Aplicaciones típicas**:
   - Descenso: Cálculos acumulativos (sumas, productos, conteos)
   - Ascenso: Transformaciones que requieren resultados completos de subproblemas (inversiones, ordenamientos, árboles)

## Conexión con recorridos de árboles

Los patrones de procesamiento recursivo en estructuras lineales (arrays, cadenas) tienen una correspondencia directa con los recorridos clásicos en estructuras de árboles. Esta conexión no es casual, sino que refleja un principio fundamental sobre el momento de procesamiento en algoritmos recursivos.

### Taxonomía unificada del procesamiento recursivo

Podemos categorizar los patrones recursivos según el momento en que se realiza el procesamiento principal:

1. **Procesamiento temprano**: Se procesa antes de todas las llamadas recursivas
1. **Procesamiento intermedio**: Se procesa entre llamadas recursivas
1. **Procesamiento tardío**: Se procesa después de todas las llamadas recursivas

### Correspondencias con estructuras lineales y jerárquicas

|Momento|Estructuras lineales|Estructuras arbóreas|Ejemplo|
|-|-|-|-|
|**Temprano**|Procesamiento en descenso|Recorrido en preorden|`cabeza + sumar(cola)`|
|**Intermedio**|Procesamiento híbrido|Recorrido en inorden|`invertir(izquierda) + raíz + invertir(derecha)`|
|**Tardío**|Procesamiento en ascenso|Recorrido en postorden|`invertir(cola) + cabeza`|

### Ilustración gráfica de la correspondencia

Para visualizar esta conexión, consideremos cómo se transformaría una estructura lineal como `[A,B,C,D]` en una estructura de árbol degenerada:

```
      A
     /
    B
   /
  C
 /
D
```

|Preorden / *Temprano*|Postorden / *Tardío*|
|-|-|
|*procesar nodo actual → recorrer izquierda → recorrer derecha*|*recorrer izquierda → recorrer derecha → procesar nodo actual*|
|Empezamos en A: procesamos A, luego bajamos a B|Empezamos en A, pero no lo procesamos aún; primero bajamos a B|
|En B: procesamos B, luego bajamos a C|En B, no lo procesamos aún; primero bajamos a C|
|En C: procesamos C, luego bajamos a D|En C, no lo procesamos aún; primero bajamos a D|
|En D: procesamos D (no hay más hijos)|En D: procesamos D (no hay más hijos)|
|Resultado final: `A,B,C,D`|Retrocedemos a C: ahora procesamos C|
||Retrocedemos a B: ahora procesamos B|
||Retrocedemos a A: finalmente procesamos A|
||Resultado final: `D,C,B,A`|

Esta generalización nos permite aplicar conceptos y optimizaciones de manera unificada independientemente de la estructura de datos.

### Implicaciones para optimización

La clasificación según el momento de procesamiento tiene consecuencias directas en las estrategias de optimización aplicables:

1. **Procesamiento temprano**: Favorable para recursión de cola y acumuladores
2. **Procesamiento tardío**: Requiere mantener la pila de llamadas, beneficiado por memoización
3. **Procesamiento intermedio**: A menudo requiere combinación de técnicas
