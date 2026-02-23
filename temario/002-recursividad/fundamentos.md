# Fundamentos

## ¿Por qué?

Antes de implementar recursividad en código fue necesario entender **qué es lo recursivo** como patrón estructural que existe independientemente de la programación.

Un error tradicional es comenzar con la clásica definición de _"una función que se llama a sí misma"_, obviando el adquirir criterio para distinguir:

- ¿Por qué esta función se llama a sí misma y no usa un bucle?
- ¿Qué propiedades del problema hacen que la recursión sea natural aquí?
- ¿Cómo reconozco cuándo un problema es inherentemente recursivo?

Sin este criterio la recursividad se percibe como "truco sintáctico mágico" en lugar de lo que realmente es: **la traducción a código de estructuras autocontenidas**.

## ¿Qué?

Habiendo hecho una reflexión acerca de los [***patrones***](induccion/README.md), tenemos por fin cuatro categorías claramente definidas:

- **Lo secuencial**: orden determinado, no repetición
- **Lo recurrente**: reaparición eventual, sin patrón fijo
- **Lo iterativo**: repetición consecutiva, periodicidad regular
- **Lo recursivo**: estructura autocontenida, autosimilitud

Con lo cual, lo recursivo no es un capricho o un formalismo altamente abstracto, sino que

|Tiene propiedades estructurales específicas|Podemos identificarlo mediante criterios formales|No todo lo que se repite es recursivo|Lo recursivo se define por autorreferencia, no por temporalidad
|-|-|-|-|
|||||

## ¿Para qué?

Ahora que entendemos qué es lo recursivo estructuralmente, podemos responder:

**¿Por qué existen funciones recursivas en programación?**

Porque ciertos problemas tienen **estructura recursiva inherente**:

- Un río se ramifica (cada afluente ES un río)
- Una oración se anida (cada cláusula subordinada ES una oración)
- Un directorio contiene subdirectorios (cada subdirectorio ES un directorio)
- Un árbol binario tiene subárboles (cada subárbol ES un árbol)

Cuando la **estructura del problema** es recursiva, la **solución recursiva** es el isomorfismo natural.

**La función recursiva es el reflejo en código de la estructura del dato.**

## ¿Cómo?

### Lista enlazada

¿Qué es una lista?: Una lista es un nodo seguido de una lista.

***¿Una lista enlazada es recursiva?***

||||
|-|-|-|
¿La estructura se contiene a sí misma?|**Sí**|Cada `Nodo` contiene otro `Nodo` (el siguiente)
¿Hay autosimilitud a diferentes escalas?|**Sí**|Una lista de 5 elementos contiene una lista de 4 elementos
¿La definición incluye referencias al objeto mismo?|**Sí**|`Nodo` se define conteniendo `Nodo`

#### Definición recursiva de lista*

Una lista es:

- VACÍA (null)
- O un elemento seguido de una lista

```java
class Nodo {
   private int valor;
   private Nodo siguiente;
}
```

#### Procesamiento recursivo de lista

Si la **estructura** es recursiva, el **procesamiento** puede ser recursivo:

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
<tr><td></td><td></td></tr>
</table>

</div>

- `contar()` y `sumar()` se llaman a sí mismos
- Cada llamada procesa un nodo y delega el resto a la siguiente llamada
- La estructura del código refleja la estructura del dato

### Elementos identificados

<div align=center>

|Caso base|Caso recursivo|
|-|-|
Detiene la llamada recursiva|Es la parte donde la función se llama a sí misma,<br>normalmente con argumentos diferentes<br>o avanzando hacia el caso base.

</div>

```
Función funcionRecursiva(parametro)
    
    SI (es condicion caso base) ENTONCES
        RETORNAR valorDirecto;
    SINO
         parametrosReducidos = avanzarACasoBase(parametros);
         procesoLocal = combinar(problema, funcionRecursiva(parametrosReducidos));
         RETORNAR procesoLocal;
    FIN_SI

Fin_Función
```

> Antes de seguir: [la pila de llamadas](laPilaDeLlamadas.md)

Es más, incluso antes de seguir!!!

Hasta aquí hemos aprendido a identificar los patrones estructurales. Aquí hemos visto los fundamentos, aprendiendo vocabulario y viendo un ejemplo recursivo hecho.

Pero saber identificar no es suficiente. Antes de escribir código, necesitamos **encontrar** la recursividad en un problema.

Para esto, usaremos el **[método tabular](estructuracion/README.md)** como método que nos permita estructurar la solución recursiva antes de programar.
