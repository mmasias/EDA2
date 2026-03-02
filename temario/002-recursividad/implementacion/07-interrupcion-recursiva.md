<div align=right>

<sub>[Inicio](README.md) / [00](00-topologia.md) / [01](01-metodo-iterativo.md) / [02](02-recursion-sin-caso-base.md) / [03](03-un-caso-base.md) / [04](04-multiples-casos-base.md) / [05](05-multiples-llamadas-condicional.md) / [06](06-multiples-llamadas-ambas.md) / [**07**](07-interrupcion-recursiva.md) / [08](08-el-estado.md) / [09](09-hacer-y-deshacer.md) / [10](10-el-arbol-de-decisiones.md) / [11](11-una-solucion.md) / [12](12-todas-las-soluciones.md) / [13](13-poda.md) / [14](14-cierre.md)</sub>

</div>

# 07. Interrupción de caso recursivo

## ¿Por qué?

Al explorar soluciones recursivamente, no todas las ramas merecen ser exploradas hasta el final.

Es posible **interrumpir** un caso recursivo, es decir, detener la exploración de una rama antes de llegar al caso base.

## ¿Qué?

La interrupción recursiva consiste en detectar que una rama no es viable y detenerla antes de llegar al caso base:

```java
if (condicionDeInterrupcion) {
    return resultadoDeInterrupcion;
}
return funcion(parametrosModificados);
```

## ¿Para qué?

- **Eficiencia**: No explorar ramas que no pueden llevar a una solución
- **Optimización**: Ahorrar recursos al detectar fallos prematuros
- **Control**: Terminar prematuramente cuando se detecta una condición imposible

## ¿Cómo?

### Conexión con Estructuración

Se reutiliza **encontrarElemento**, ya estructurado en [Estructuración](../estructuracion/encontrarElemento.md).

La versión original recorre toda la lista. Si se asume que la lista está **ordenada**, es posible interrumpir la búsqueda cuando se pasa el valor buscado.

## Implementación

### Buscar elemento con interrupción

```java
class BusquedaConInterrupcion {

    public boolean buscarOrdenado(int[] lista, int elemento) {
        return buscarRecursivo(lista, elemento, 0);
    }

    private boolean buscarRecursivo(int[] lista, int elemento, int indice) {
        if (indice >= lista.length) {
            return false;
        }

        if (lista[indice] == elemento) {
            return true;
        }

        if (lista[indice] > elemento) {
            return false;
        }

        return buscarRecursivo(lista, elemento, indice + 1);
    }

    public static void main(String[] args) {
        BusquedaConInterrupcion busqueda = new BusquedaConInterrupcion();
        int[] ordenada = {2, 4, 6, 8, 10};

        System.out.println(busqueda.buscarOrdenado(ordenada, 6));
        System.out.println(busqueda.buscarOrdenado(ordenada, 5));
        System.out.println(busqueda.buscarOrdenado(ordenada, 11));
    }
}
```

### Traza de ejecución

Para `buscarOrdenado({2, 4, 6, 8, 10}, 5)`:

```text
buscarRecursivo({2,4,6,8,10}, 5, 0)
  ¿2 == 5? No
  ¿2 > 5? No --> continuar
  --> buscarRecursivo(..., 5, 1)
    ¿4 == 5? No
    ¿4 > 5? No --> continuar
    --> buscarRecursivo(..., 5, 2)
      ¿6 == 5? No
      ¿6 > 5? Si --> return false (INTERRUPCIÓN)
```

**Sin interrupción**, se habría continuado hasta el final del array.
**Con interrupción**, se detiene la búsqueda cuando se sabe que no tiene sentido seguir.

## Análisis

### Vocabulario clave

<div align=center>

||||
|-|-|-|
|**Interrupción recursiva**|Detener una rama recursiva antes del caso base|
|**Retorno prematuro**|Devolver un resultado antes de completar toda la ejecución|

</div>

### Estructura con interrupción recursiva

```java
tipoRetorno funcion(parametros) {
    if (casoBase1) {
        return resultado1;
    }

    if (condicionDeInterrupcion) {
        return resultadoDeInterrupcion;
    }

    return funcion(parametrosModificados);
}
```

### Analogía: buscar en un diccionario

Al buscar la palabra "gato" en un diccionario:

- **Sin interrupción**: Se recorre desde "A" hasta "Z"
- **Con interrupción**: Si se llega a "gato" → encontrado. Si se llega a "gaviota" → se detiene (ya pasó el lugar donde estaría "gato")

## Comparación con pasos anteriores

<div align=center>

|Aspecto|Paso 6 (Múltiples llamadas)|Paso 7 (Interrupción)|
|-|-|-|
|Decisión|Selecciona un camino u otro|**Detiene** el camino actual|
|Propósito|Adaptar comportamiento|**Ahorrar cálculos**|
|Ejemplo|Inorder|Búsqueda con poda|

</div>

## Reflexión final

**Interrupción recursiva = eficiencia**.

No todas las ramas recursivas merecen ser exploradas hasta el final. Si se detecta que una rama no puede llevar a una solución válida, se **interrumpe**.

Esta técnica permite:

- Detectar fallos prematuros
- Evitar cálculos innecesarios
- Optimizar la exploración recursiva

> [Siguiente: El estado en la recursión](08-el-estado.md)
