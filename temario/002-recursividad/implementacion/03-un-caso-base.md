<div align=right>

<sub>[Inicio](README.md) / [00](00-topologia.md) / [01](01-metodo-iterativo.md) / [02](02-recursion-sin-caso-base.md) / [**03**](03-un-caso-base.md) / [04](04-multiples-casos-base.md) / [05](05-multiples-llamadas-condicional.md) / [06](06-multiples-llamadas-ambas.md) / [07](07-interrupcion-recursiva.md) / [08](08-el-estado.md) / [09](09-hacer-y-deshacer.md) / [10](10-el-arbol-de-decisiones.md) / [11](11-una-solucion.md) / [12](12-todas-las-soluciones.md) / [13](13-poda.md) / [14](14-cierre.md)</sub>

</div>

# 03. Un caso base

## ¿Por qué?

Después de ver qué pasa sin caso base (Paso 2), es necesario implementar nuestra **primera función recursiva funcional**.

El caso base es el componente que deja de generar nuevas llamadas y devuelve un valor directo, iniciando la resolución de la pila.

## ¿Qué?

Una función recursiva con un caso base es aquella que:

- Tiene una condición que detiene la recursión
- Se llama a sí misma **con argumentos que tienden al caso base**
- Retorna un valor en cada llamada

## ¿Para qué?

Entender la estructura:

<div align=center>

|Caso base|+|Caso recursivo|+|Tendencia al caso base|
|:-:|-|:-:|-|:-:|
|Deja de generar llamadas||Realiza las llamadas||Converge|

</div>

- **Implementar la primera recursión funcional**: Ver una función recursiva completa
- **Conectar con estructuración**: Traducir el método tabular a código

## ¿Cómo?

### Conexión con Estructuración

Se reutiliza **Factorial**, ya estructurado en [Estructuración](../estructuracion/factorial.md).

<div align=center>

||n|f(n)|
|-|-|-|
|**CB**|0|1|
|...|...|...|
|**CR n-1**|4|24|
|**CR n**|5|120|

**Relación encontrada**: `f(n) = n × f(n-1)`

</div>

Ahora solo falta traducir esa estructura a código.

## Implementación

### Factorial (recursivo)

```java
class FactorialRecursivo {

    static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(0));
        System.out.println(factorial(5));
        System.out.println(factorial(10));
    }
}
```

### Traza de ejecución

Para `factorial(5)`:

```
factorial(5)
    5 * factorial(4)
      4 * factorial(3)
        3 * factorial(2)
          2 * factorial(1)
            1 * factorial(0)
              1 (caso base)
            1 * 1 = 1
          2 * 1 = 2
        3 * 2 = 6
      4 * 6 = 24
    5 * 24 = 120
```

## Análisis

### Vocabulario clave

<div align=center>

||||
|-|-|-|
|**Caso base**|`if (n == 0) {return 1;}`|La condición que devuelve sin nuevas llamadas
|**Caso recursivo**|`return n * factorial(n - 1);`|La parte donde la función se llama a sí misma
|**Tendencia al caso base**|`n - 1`|Cada llamada se acerca al caso base

</div>

### Estructura de toda función recursiva

```java
tipoRetorno funcionRecursiva(parametros) {
    if (condicionCasoBase) {
        return valorDirecto;
    } else {
        return proceso + funcionRecursiva(parametrosReducidos);
    }
}
```

<div align=center>

|Método tabular|Código Java|
|-|-|
|Caso base: f(0) = 1|`if (n == 0) return 1;`|
|f(n) = n × f(n-1)|`return n * factorial(n - 1);`|

</div>

**La tabla ya nos dio la fórmula. Solo falta traducirla a Java.**

## Comparación con pasos anteriores

<div align=center>

|Aspecto|Paso 1 (Iterativo)|Paso 2 (Sin caso base)|Paso 3 (Con caso base)|
|-|-|-|-|
|Se llama a sí mismo|No|Sí (infinito)|Sí (controlado)|
|Tiene caso base|N/A|No|Sí|
|Resultado|Funciona|StackOverflow|Funciona|

</div>

## Reflexión final

Esta es nuestra primera función recursiva completa y funcional:

- Tiene caso base
- Tiene caso recursivo
- Tiende al caso base
- Conecta con la estructura que ya conocíamos de la batería

En el siguiente paso se abordan los casos que requieren **más de un caso base**.

> [Siguiente: Múltiples casos base](04-multiples-casos-base.md)
