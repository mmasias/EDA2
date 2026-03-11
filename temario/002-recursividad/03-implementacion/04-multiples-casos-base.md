<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [Estructuración](/temario/002-recursividad/02-estructuracion/README.md) / [**Implementación**](/temario/002-recursividad/03-implementacion/README.md) / [Aplicación](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Inicio](README.md) / [00](00-topologia.md) / [01](01-metodo-iterativo.md) / [02](02-recursion-sin-caso-base.md) / [03](03-un-caso-base.md) / [**04**](04-multiples-casos-base.md) / [05](05-multiples-llamadas-condicional.md) / [06](06-multiples-llamadas-ambas.md) / [07](07-interrupcion-recursiva.md) / [08](08-el-estado.md) / [09](09-hacer-y-deshacer.md) / [10](10-el-arbol-de-decisiones.md) / [11](11-una-solucion.md) / [12](12-todas-las-soluciones.md) / [13](13-poda.md) / [14](14-cierre.md)

</div>

# 04. Múltiples casos base

## ¿Por qué?

Un solo caso base no siempre es suficiente. Algunos problemas necesitan mayor granularidad para cubrir todas las situaciones base.

Es necesario aprender a implementar funciones recursivas con **múltiples casos base**.

## ¿Qué?

Una función recursiva con múltiples casos base tiene dos o más condiciones que devuelven un valor directo:

- Caso base 1: Situación base tipo A
- Caso base 2: Situación base tipo B
- ...

Cada situación base tiene su propia condición de retorno.

## ¿Para qué?

- **Mayor precisión**: Diferentes situaciones requieren diferentes respuestas
- **Detección temprana**: Es posible detectar problemas o éxitos antes
- **Código más legible**: Cada situación tiene su propio caso explícito

## ¿Cómo?

### Conexión con Estructuración

Se reutiliza **Encontrar elemento**, ya estructurado en [Estructuración](../02-estructuracion/encontrarElemento.md).

En este problema se requieren dos casos base:

- Lista vacía --> elemento no encontrado
- Elemento encontrado --> éxito

## Implementación

### Buscar un elemento en una lista

```java
class EncontrarElementoRecursivo {

    public boolean buscar(int[] lista, int elemento) {
        return buscarRecursivo(lista, elemento, 0);
    }

    private boolean buscarRecursivo(int[] lista, int elemento, int indice) {

        if (indice >= lista.length) {
            return false;
        }

        if (lista[indice] == elemento) {
            return true;
        }

        return buscarRecursivo(lista, elemento, indice + 1);
    }

    public static void main(String[] args) {
        EncontrarElementoRecursivo buscar = new EncontrarElementoRecursivo();
        int[] lista = {5, 6, 3, 5, 2, 4};

        System.out.println(buscar.buscar(lista, 3));
        System.out.println(buscar.buscar(lista, 9));
        System.out.println(buscar.buscar(lista, 5));
    }
}
```

> Una reflexión acerca de la implementación: la versión de propuesta en la sección de estructuración es más "pura" en términos de recursión funcional, dado que crea nuevas estructuras, mientras que la implementación propuesta aquí es más eficiente  en memoria (dado que no crea copias de arrays) **pero** introduce un parámetro adicional.

### Traza de ejecución

Para `buscar({5, 6, 3, 5, 2, 4}, 3)`:

```text
buscarRecursivo({5,6,3,5,2,4}, 3, 0)
  5 == 3? No --> continuar
  --> buscarRecursivo({5,6,3,5,2,4}, 3, 1)
    6 == 3? No --> continuar
    --> buscarRecursivo({5,6,3,5,2,4}, 3, 2)
      3 == 3? Si --> return true (CASO BASE 2)
```

Para `buscar({5, 6, 3, 5, 2, 4}, 9)`:

```text
buscarRecursivo({5,6,3,5,2,4}, 9, 0)
  5 == 9? No --> continuar
  --> buscarRecursivo({5,6,3,5,2,4}, 9, 1)
    6 == 9? No --> continuar
    --> buscarRecursivo({5,6,3,5,2,4}, 9, 2)
      3 == 9? No --> continuar
      --> buscarRecursivo({5,6,3,5,2,4}, 9, 3)
        5 == 9? No --> continuar
        --> buscarRecursivo({5,6,3,5,2,4}, 9, 4)
          2 == 9? No --> continuar
          --> buscarRecursivo({5,6,3,5,2,4}, 9, 5)
            4 == 9? No --> continuar
            --> buscarRecursivo({5,6,3,5,2,4}, 9, 6)
              indice >= length? Si --> return false (CASO BASE 1)
```

## Análisis

### Vocabulario clave

<div align=center>

|||
|-|-|
**Múltiples casos base**|dos o más condiciones que devuelven valores directos
**Granularidad**|Nivel de detalle en los casos base (más casos = más granularidad)
**Caso base de éxito**|La condición que confirma que estamos bien (ej: elemento encontrado)
**Caso base de fallo**|La condición que detecta un problema (ej: llegamos al final sin encontrar)

</div>

### Estructura con múltiples casos base

```java
tipoRetorno funcion(parametros) {

    if (condicionCasoBase1) {
        return resultado1;
    }

    if (condicionCasoBase2) {
        return resultado2;
    }

    return funcion(parametrosModificados);
}
```

### Ventajas de múltiples casos base

<div align=center>

|Ventaja|Explicación|
|-|-|
|**Mayor claridad**|Cada situación base tiene su propio caso|
|**Detección temprana**|Es posible detectar problemas antes de continuar|
|**Código más legible**|Más fácil de entender qué pasa en cada situación|

</div>

### Conexión

La tabla de **Encontrar elemento** tiene dos casos base explícitos:

<div align=center>

|Situación|Resultado|Código|
|-|-|-|
|Lista vacía (llegamos al final)|No encontrado|if (indice >= length) {<br>&nbsp;&nbsp;&nbsp;return false;<br>}|
|Elemento encontrado|Encontrado|if (lista[i] == elemento) {<br>&nbsp;&nbsp;&nbsp;return true;<br>}|

</div>

## Comparación con el paso anterior

<div align=center>

|Aspecto|Paso 3 (Un caso base)|Paso 4 (Múltiples casos base)|
|-|-|-|
|Casos base|1|2+|
|Granularidad|Menor|Mayor|
|Ejemplo|Factorial|Encontrar elemento|
|Complejidad|Más simple|Más detallado|

</div>

## Reflexión final

**Múltiples casos base = mayor precisión**.

No todos los problemas se resuelven con un solo caso base. En ocasiones se requiere:

- Casos base de éxito y de fallo
- Casos base para diferentes tamaños de entrada
- Casos base para diferentes situaciones del problema

En el siguiente paso se abordan las funciones que hacen **múltiples llamadas recursivas** en el mismo caso.

> [Siguiente: Múltiples llamadas (ambas)](05-multiples-llamadas-condicional.md)
