# 002. Recursividad

## ¿Por qué?

Antes de implementar recursividad en código, es necesario entender **qué es lo recursivo** como patrón estructural que existe independientemente de la programación.

Un error tradicional es comenzar con "una función que se llama a sí misma" sin que tengamos vocabulario conceptual para distinguir:

- ¿Por qué esta función se llama a sí misma y no usa un bucle?
- ¿Qué propiedades del problema hacen que la recursión sea natural aquí?
- ¿Cómo reconozco cuándo un problema es inherentemente recursivo?

Sin este vocabulario previo, la recursividad se percibe como "truco sintáctico mágico" en lugar de lo que realmente es: **la traducción a código de estructuras autocontenidas**.

## ¿Qué?

Habiendo hecho una reflexión acerca de los [***patrones***](intro/README.md), tenemos cuatro categorías claramente definidas:

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

```java
class Nodo {
    int valor;
    Nodo siguiente;
}
```

***¿Una lista enlazada es recursiva?***

||||
|-|-|-|
¿La estructura se contiene a sí misma?|**Sí**|Cada `Nodo` contiene otro `Nodo` (el siguiente)
¿Hay autosimilitud a diferentes escalas?|**Sí**|Una lista de 5 elementos contiene una lista de 4 elementos
¿La definición incluye referencias al objeto mismo?|**Sí**|`Nodo` se define conteniendo `Nodo`

**Definición recursiva de lista:**

Una lista es:

- VACÍA (null)
- O un elemento seguido de una lista

### Procesamiento recursivo de lista

Si la **estructura** es recursiva, el **procesamiento** puede ser recursivo:

Conteo de elementos:

```java
    public static int contar(Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return 1 + contar(nodo.siguiente);
        }
    }
```

- `contar()` se llama a sí misma
- Cada llamada procesa un nodo y delega el resto a la siguiente llamada
- La estructura del código refleja la estructura del dato

Sumar elementos:

```java
    public static int sumar(Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return nodo.valor + sumar(nodo.siguiente);
        }
    }
```

### Elementos fundamentales identificados

Toda función recursiva tiene:

<div align=center>

|Caso base|Caso recursivo|
|-|-|
Detiene la llamada recursiva|Es la parte donde la función se llama a sí misma,<br>normalmente con argumentos diferentes<br>o avanzando hacia el caso base.

</div>

```java
    tipoRetorno funcionRecursiva(parametros) {
        if (condicionCasoBase) {
            return valorDirecto;
        } else {
                procesoLocal = procesoLocal + funcionRecursiva(parametrosReducidos);
                return procesoLocal;
        }
    }
```

### Primera implementación formal: factorial

```java
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
```

¿Es recursiva esta implementación de factorial?

||||
|-|-|-|
|¿La estructura se contiene a sí misma?|Sí|`factorial(n)` se define en términos de `factorial(n-1)`
|¿Hay autosimilitud a diferentes escalas?|Sí|Calcular `5!` es calcular `4!`, que es calcular `3!`...
|¿La definición incluye referencias al objeto mismo?|Sí|La definición de factorial usa factorial

> Antes de seguir: [la pila de llamadas](laPilaDeLlamadas.md)

## 2Do / 2Think

Es secuencial/recurrente/iterativo/recursivo:

1. La definición matemática de factorial: `n! = n × (n-1)!`
1. El proceso de calcular factorial con bucle `for`
1. La implementación recursiva de factorial mostrada anteriormente

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
