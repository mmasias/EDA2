<div align=right>

<sub>[Inicio](README.md) / [00](00-topologia.md) / [01](01-metodo-iterativo.md) / [**02**](02-recursion-sin-caso-base.md) / [03](03-un-caso-base.md) / [04](04-multiples-casos-base.md) / [05](05-multiples-llamadas-condicional.md) / [06](06-multiples-llamadas-ambas.md) / [07](07-interrupcion-recursiva.md) / [08](08-el-estado.md) / [09](09-hacer-y-deshacer.md) / [10](10-el-arbol-de-decisiones.md) / [11](11-una-solucion.md) / [12](12-todas-las-soluciones.md) / [13](13-poda.md) / [14](14-cierre.md)</sub>

</div>

# 02. Recursión sin caso base

## ¿Por qué?

Es necesario experimentar qué sucede cuando una función recursiva **no tiene caso base**.

## ¿Qué?

Una función recursiva sin caso base se llama a sí misma indefinidamente, haciendo crecer la pila de llamadas hasta que se produce un **StackOverflowError**.


## ¿Para qué?

- **Entender la necesidad del caso base**: Ver por qué es obligatorio
- **Comprender el stack overflow**: Experimentar el error en vivo
- **Valorar la condición de parada**: Entender qué pasa sin ella

## ¿Cómo?

## Implementación

### Suma recursiva sin caso base

```java
class SumaRecursivaRota {

    static int sumarNPrimeros(int n) {
        return n + sumarNPrimeros(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumarNPrimeros(5));
    }
}
```

> Nota: Este código intencionalmente falla. Se produce un StackOverflowError.

### Salida esperada

```
Exception in thread "main" java.lang.StackOverflowError
    at SumaRecursivaRota.sumarNPrimeros(SumaRecursivaRota.java:3)
    at SumaRecursivaRota.sumarNPrimeros(SumaRecursivaRota.java:3)
    at SumaRecursivaRota.sumarNPrimeros(SumaRecursivaRota.java:3)
    ...
```

### ¿Qué está pasando?

La pila de llamadas crece indefinidamente:

```
sumarNPrimeros(5)
   llama a sumarNPrimeros(4)
     llama a sumarNPrimeros(3)
       llama a sumarNPrimeros(2)
         llama a sumarNPrimeros(1)
           llama a sumarNPrimeros(0)
             llama a sumarNPrimeros(-1)
               llama a sumarNPrimeros(-2)
                 ... hasta que la pila se desborda
```

## Análisis

### Vocabulario

- **StackOverflowError**: La pila de llamadas tiene un límite. Cuando se llena, el programa explota.
- **Caso base**: La condición que devuelve un valor directo sin nuevas llamadas. Sin él, la pila crece indefinidamente.
- **Condición de parada**: Sin ella, no hay forma de salir de la recursión.

### La manida analogía del bucle infinito

¡No es exactamente igual! De hecho, enfatiza lo que no importa (la repetición en ausencia del caso base) y oscurece lo que sí importa (por qué existe la recursión). Peor aún: induce a pensar que recursión e iteración son dos formas de hacer lo mismo y que la diferencia es técnica (stack vs. registro). Eso es falso en el caso general.

```java
while (true) {

}

void funcionInfinita() {
    funcionInfinita();
}
```

> Por la cadena de contextos, por la pila, por la terminación, por la legitimidad, por la estabilidad...

### Comparación con el caso anterior

<div align=center>

|Aspecto|Paso 1 (Iterativo)|Paso 2 (Recursión sin caso base)|
|-|-|-|
|Se llama a sí mismo|No|Sí|
|Tiene condición de parada|Sí, i <= n|No|
|Resultado|Funciona|StackOverflowError|

</div>

## Reflexión: ¿cómo lo arreglamos?

El problema es que `sumarNPrimeros` **nunca deja de llamarse a sí misma**.

Se requiere un **caso base**:

```java
static int sumarNPrimeros(int n) {
    if (n == 0) {
        return 0;
    }

    return n + sumarNPrimeros(n - 1);
}
```

## Reflexión final

**Sin caso base, no hay recursión válida**.

El caso base es el punto donde se deja de generar llamadas y se devuelve un valor que permite resolver las llamadas pendientes en la pila.

En el siguiente paso se presenta la primera función recursiva **funcional**.

> [Siguiente: Un caso base](03-un-caso-base.md)
