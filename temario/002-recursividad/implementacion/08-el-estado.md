<div align=right>

<sub>[Inicio](README.md) / [00](00-topologia.md) / [01](01-metodo-iterativo.md) / [02](02-recursion-sin-caso-base.md) / [03](03-un-caso-base.md) / [04](04-multiples-casos-base.md) / [05](05-multiples-llamadas-condicional.md) / [06](06-multiples-llamadas-ambas.md) / [07](07-interrupcion-recursiva.md) / [**08**](08-el-estado.md) / [09](09-hacer-y-deshacer.md) / [10](10-el-arbol-de-decisiones.md) / [11](11-una-solucion.md) / [12](12-todas-las-soluciones.md) / [13](13-poda.md) / [14](14-cierre.md)</sub>

</div>

# 08. El estado en la recursión

## ¿Por qué?

Hasta ahora las funciones recursivas no modificaban lo que recibían: se limitaban a reducir el problema o a devolver algo calculado. Lo que ocurría dentro no escapaba hacia fuera.

Cuando el parámetro es un **objeto mutable** —una lista, por ejemplo— y la función **lo modifica**, las reglas cambian. Todas las llamadas comparten el mismo objeto. Lo que una llamada modifica, la siguiente lo ve.

Entender esta diferencia es el requisito previo para lo que viene.

## ¿Qué?

La diferencia entre pasar un **primitivo** y pasar un **objeto mutable** a través de llamadas recursivas, y qué implica cada uno para el estado visible al volver de la llamada.

## ¿Para qué?

- Predecir qué estado verá cada llamada al regresar
- Entender por qué en algunos patrones hay que deshacer lo que se hizo
- Saber cuándo el estado "viaja solo" y cuándo hay que gestionarlo explícitamente

## ¿Cómo?

### Fase 1 — Con primitivo

```java
class ElEstado {

    static void conPrimitivo(int n, int valorLocal) {
        if (n == 0) {
            valorLocal = 999;
            System.out.println("  Caso base. valorLocal = " + valorLocal);
            return;
        }
        System.out.println("  Antes  f(" + n + "): valorLocal = " + valorLocal);
        conPrimitivo(n - 1, valorLocal);
        System.out.println("  Después f(" + n + "): valorLocal = " + valorLocal);
    }

    public static void main(String[] args) {
        conPrimitivo(3, 0);
    }
}
```

```
  Antes  f(3): valorLocal = 0
  Antes  f(2): valorLocal = 0
  Antes  f(1): valorLocal = 0
  Caso base. valorLocal = 999
  Después f(1): valorLocal = 0
  Después f(2): valorLocal = 0
  Después f(3): valorLocal = 0
```

El caso base asigna `999` a su copia local. Las llamadas exteriores no se enteran: al volver, `valorLocal` sigue siendo `0` en cada una de ellas.

> **Observación**: Cada marco de la pila tiene su propia copia del primitivo. Lo que ocurre dentro no escapa hacia afuera.


### Fase 2 — Con objeto mutable

```java
class Caja {
    int valor = 0;
}

class ElEstado {

    static void conCaja(int n, Caja caja) {
        if (n == 0) {
            caja.valor = 999;
            System.out.println("  Caso base. caja.valor = " + caja.valor);
            return;
        }
        System.out.println("  Antes  f(" + n + "): caja.valor = " + caja.valor);
        conCaja(n - 1, caja);
        System.out.println("  Después f(" + n + "): caja.valor = " + caja.valor);
    }

    public static void main(String[] args) {
        conCaja(3, new Caja());
    }
}
```

```
  Antes  f(3): caja.valor = 0
  Antes  f(2): caja.valor = 0
  Antes  f(1): caja.valor = 0
  Caso base. caja.valor = 999
  Después f(1): caja.valor = 999
  Después f(2): caja.valor = 999
  Después f(3): caja.valor = 999
```

El caso base asigna `999` al campo del objeto. Todos los marcos lo ven al volver: comparten la misma `Caja`.

> **Pregunta**: Si al volver de la llamada el objeto tiene un valor distinto al que tenía al entrar... ¿cómo podría volver al estado original?


## Análisis

<div align=center>

||Primitivo (`int valorLocal`)|Objeto mutable (`Caja caja`)|
|-|-|-|
|Cada llamada tiene|Su propia copia|Una referencia al mismo objeto|
|Modificar el parámetro|Solo afecta a esa llamada|Afecta a todas las llamadas|
|Al volver, el valor es|El mismo de antes de llamar|El que haya quedado tras la llamada interna|
|Para "volver atrás"|No hace falta hacer nada|Hay que deshacer la modificación explícitamente|

</div>

La pregunta del final de la Fase 2 tiene respuesta, y esa respuesta es el tema del siguiente paso.

> [Siguiente: Hacer y deshacer](09-hacer-y-deshacer.md)
