<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[**Inducción**](/temario/002-recursividad/01-induccion/prePatrones.md) / [Estructuración](/temario/002-recursividad/02-estructuracion/README.md) / [Implementación](/temario/002-recursividad/03-implementacion/README.md) / [Aplicación](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[prePatrones](prePatrones.md) / [Patrones](README.md) / [**postPatrones**](postPatrones.md)

</div>

# Clasificación

<div align=center>

|Categoría|Casos|
|-|-|
|**Secuencial**|Un niño crece, La erosión profundiza surcos|
|**Recurrente**|Los terremotos ocurren, Las crisis económicas regresan, Las migrañas reaparecen|
|**Iterativo**|El corazón late, Las estaciones cambian, Los semáforos ciclan|
|**Recursivo**|Un río se ramifica, Una oración se anida|

</div>

## ¿Por qué?

### Secuencial

- *Niño crece*: Progresión unidireccional, fases cualitativamente distintas, no hay repetición
- *Erosión surcos*: Proceso que progresa acumulativamente, cada estado causado por el anterior

### Recurrente

- *Terremotos, crisis, migrañas*: Reaparecen eventualmente, intervalos impredecibles, sin consecutividad garantizada

### Iterativo

- *Corazón, estaciones, semáforos*: Repetición consecutiva, periodicidad fija/regular, cada ciclo independiente del anterior

### Recursivo

- *Río, oración*: Estructura autocontenida, autosimilitud a diferentes escalas, definición autorreferente

## Debatible

- **La erosión** ¿es secuencial puro o tiene elementos recurrentes? Cada ciclo de lluvia erosiona más, pero no es iterativo (cada evento depende causalmente del estado anterior). Es secuencial con memoria acumulativa.

## *#2Think*

|||
|-|-|
Como tantas otras veces en la carrera y en la vida, no existe una "respuesta única perfecta" sino que hace falta que apliquemos el razonamiento ***explícito y formal*** sobre qué dimensiones pesan más en cada clasificación.|El valor no está en memorizar "X es iterativo, Y es recursivo", sino en **poder justificar** la clasificación usando los criterios que hemos revisado. Dos personas pueden clasificar el mismo fenómeno diferente y ambas tener razón si sus justificaciones son coherentes con los criterios aplicados.

## De los patrones al código

Sabemos ya identificar lo recursivo. La pregunta inevitable es: **¿qué tiene que ver esto con programar?**

El error habitual es definir la recursividad en código como *"una función que se llama a sí misma"*. La definición no es incorrecta, pero invierte el orden: describe el mecanismo antes de explicar el origen. El resultado es que la recursión parece un truco sintáctico en lugar de lo que realmente es.

**La función recursiva es el reflejo en código de la estructura del dato.**

Cuando un problema tiene estructura recursiva, la solución recursiva es el isomorfismo natural. No se elige por capricho ni por elegancia: se elige porque la estructura del problema lo exige.

### El Nodo como primer ejemplo

Una lista enlazada es una estructura recursiva: un `Nodo` contiene un valor y... otro `Nodo`. La definición incluye referencias al objeto mismo.

```java
class Nodo {
    private int valor;
    private Nodo siguiente;
}
```

Si la **estructura** es recursiva, el **procesamiento** puede serlo:

<div align=center>

<table>
<tr><th>Contar</th><th>Sumar</th></tr>
<tr><td>

```java
public int contar(Nodo nodo) {
    if (nodo == null) {
        return 0;
    } else {
        return 1 + contar(nodo.siguiente);
    }
}
```
</td><td>

```java
public int sumar(Nodo nodo) {
    if (nodo == null) {
        return 0;
    } else {
        return nodo.valor + sumar(nodo.siguiente);
    }
}
```
</td></tr>
</table>

</div>

Cada llamada procesa un nodo y delega el resto a la siguiente llamada. La estructura del código refleja la estructura del dato.

### La consecuencia práctica

Antes de escribir código recursivo, el trabajo previo es **encontrar** la estructura recursiva del problema. No codificar primero y buscar después dónde meter la recursión.

Para eso, el [método tabular](../02-estructuracion/README.md).
