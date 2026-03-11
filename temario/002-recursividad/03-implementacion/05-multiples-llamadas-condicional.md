<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [Estructuración](/temario/002-recursividad/02-estructuracion/README.md) / [**Implementación**](/temario/002-recursividad/03-implementacion/README.md) / [Aplicación](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Inicio](README.md) / [00](00-topologia.md) / [01](01-metodo-iterativo.md) / [02](02-recursion-sin-caso-base.md) / [03](03-un-caso-base.md) / [04](04-multiples-casos-base.md) / [**05**](05-multiples-llamadas-condicional.md) / [06](06-multiples-llamadas-ambas.md) / [07](07-interrupcion-recursiva.md) / [08](08-el-estado.md) / [09](09-hacer-y-deshacer.md) / [10](10-el-arbol-de-decisiones.md) / [11](11-una-solucion.md) / [12](12-todas-las-soluciones.md) / [13](13-poda.md) / [14](14-cierre.md)

</div>

# 05. Casos recursivos condicionales

## ¿Por qué?

Hasta ahora hemos visto funciones con un solo caso recursivo. Algunos problemas necesitan **elegir entre diferentes caminos recursivos** según una condición.

Es necesario aprender a implementar funciones recursivas con **casos recursivos condicionales**.

## ¿Qué?

Una función recursiva con casos recursivos condicionales usa `if/else` para seleccionar diferentes caminos de ida:

```java
if (condicionBase) {
    return valorDirecto;
} else {
    return funcion(parametrosModificados);
}
```

La llamada recursiva es una sola, pero el camino de ida varía según los datos.

## ¿Para qué?

- **Bifurcación inteligente**: Adaptar el comportamiento según los datos
- **Mayor eficiencia**: No explorar caminos innecesarios
- **Control de flujo**: Tomar decisiones en tiempo de ejecución

## ¿Cómo?

### Conexión con Estructuración

Se reutiliza [**máximo de una lista**](../02-estructuracion/maximo.md).

Este problema tiene:

- Un caso base
- Una llamada recursiva
- Dos caminos de retorno según una condición (nuevo máximo vs mismo máximo)

## Implementación

### Máximo de una lista

```java
class MaximoListaRecursivo {

    public int maximo(int[] lista) {
        assert lista.length > 0;
        return maximoRecursivo(lista, 0, lista[0]);
    }

    private int maximoRecursivo(int[] lista, int indice, int maximoActual) {
        if (indice >= lista.length) {
            return maximoActual;
        }

        if (lista[indice] > maximoActual) {
            return maximoRecursivo(lista, indice + 1, lista[indice]);
        } else {
            return maximoRecursivo(lista, indice + 1, maximoActual);
        }
    }

    public static void main(String[] args) {
        MaximoListaRecursivo maximo = new MaximoListaRecursivo();
        int[] lista = {3, 7, 2, 9, 5};

        System.out.println(maximo.maximo(lista));
    }
}
```

### Traza de ejecución

Para `maximo({3, 7, 2, 9, 5})`:

```text
maximoRecursivo({3,7,2,9,5}, 0, 3)
  ¿3 > 3? No --> mismo máximo
  --> maximoRecursivo(..., 1, 3)
    ¿7 > 3? Si --> nuevo máximo: 7
    --> maximoRecursivo(..., 2, 7)
      ¿2 > 7? No --> mismo máximo
      --> maximoRecursivo(..., 3, 7)
        ¿9 > 7? Si --> nuevo máximo: 9
        --> maximoRecursivo(..., 4, 9)
          ¿5 > 9? No --> mismo máximo
          --> maximoRecursivo(..., 5, 9)
            ¿fin? Si --> return 9
```

## Análisis

### Vocabulario clave

<div align=center>

|||
|-|-|
|**Casos recursivos condicionales**|Una llamada recursiva con múltiples caminos de ida|
|**Bifurcación controlada**|Usamos `if/else` para decidir con qué estado continuar|
|**Decisión en tiempo de ejecución**|El camino se elige dinámicamente según los datos|

</div>

### Estructura con casos recursivos condicionales

```java
tipoRetorno funcion(parametros) {
    if (casoBase) {
        return valor;
    }

    if (condicion) {
        return funcion(parametros1);
    } else {
        return funcion(parametros2);
    }
}
```

En el caso que hemos visto:

<div align=center>

|||
|-|-|
`condicion`|`lista[indice] > maximoActual`
`parametros1`|`(lista, indice + 1, lista[indice])`
`parametros2`|`(lista, indice + 1, maximoActual)`

</div>

### Comparación con el paso anterior

<div align=center>

|Aspecto|Paso 4 (Múltiples casos base)|Paso 5 (Casos recursivos condicionales)|
|-|-|-|
|Casos base|2+|1|
|Casos recursivos|1|1 (con múltiples caminos de ida)|
|Decisión|En los casos base|En la llamada del caso recursivo|
|Ejemplo|Encontrar elemento|Máximo|

</div>

### Ventajas

<div align=center>

|Ventaja|Explicación|
|-|-|
|**Un sola llamada recursiva**|Más eficiente que múltiples llamadas|
|**Control de flujo**|Adaptamos el comportamiento según los datos|
|**Código flexible**|Diferentes estrategias según la situación|

</div>

## Reflexión final

**Casos recursivos condicionales = bifurcación inteligente**.

Una sola llamada recursiva puede tener múltiples caminos de ida según una condición. Esto es más eficiente que hacer múltiples llamadas recursivas.

En el siguiente paso se abordan las funciones que hacen **múltiples llamadas recursivas** que se ejecutan **todas**.

> [Siguiente: Múltiples llamadas (ambas)](06-multiples-llamadas-ambas.md)
