<div align=right>

<sub>[Inicio](README.md) / [00](00-topologia.md) / [01](01-metodo-iterativo.md) / [02](02-recursion-sin-caso-base.md) / [03](03-un-caso-base.md) / [04](04-multiples-casos-base.md) / [05](05-multiples-llamadas-condicional.md) / [**06**](06-multiples-llamadas-ambas.md) / [07](07-interrupcion-recursiva.md) / [08](08-el-estado.md) / [09](09-hacer-y-deshacer.md) / [10](10-el-arbol-de-decisiones.md) / [11](11-una-solucion.md) / [12](12-todas-las-soluciones.md) / [13](13-poda.md) / [14](14-cierre.md)</sub>

</div>

# 06. Múltiples llamadas recursivas (ambas)

## ¿Por qué?

A diferencia del Paso 5 (donde hay una sola llamada recursiva con múltiples retornos), algunos problemas requieren que una función se llame a sí misma **múltiples veces en el mismo caso**.

Esto crea un **árbol de llamadas** recursivas, que es fundamental para entender algoritmos como backtracking y divide y vencerás.

## ¿Qué?

Una función recursiva con múltiples llamadas hace dos o más llamadas a sí misma en el mismo caso:

<div align=center>

<table>
<tr><th>Combinando resultados</th><th>Con operación intercalada</th></tr>
<tr><td>

```java
return funcion(parametros1) + funcion(parametros2);
```
</td><td>

```java
funcion(parametros1);
operacionIntermedia();
funcion(parametros2);
```
</td></tr></table>


</div>

A diferencia del paso anterior (condicional), aquí **todas las llamadas se ejecutan**.

## ¿Para qué?

- **Entender la recursión ramificada**: Ver cómo se generan árboles de llamadas
- **Preparar para algoritmos complejos**: Backtracking, divide y vencerás
- **Recorrer estructuras jerárquicas**: Árboles binarios, grafos, directorios

## ¿Cómo?

Se utiliza el recorrido **inorder** de un árbol binario como ejemplo.

Este problema tiene:

- Un caso base (nodo nulo)
- Dos llamadas recursivas que se ejecutan ambas
- Una operación entre ambas llamadas (imprimir el valor)

## Implementación

Supongamos el siguiente árbol binario y su recorrido inOrder

<div align=center>

<table>
<tr><th>Árbol</th><th>Cliente</th></tr>
<tr><td valign=top>

```
        4
       / \
      2   6
     / \ / \
    1  3 5  7
```
</td><td valign=top>

```java
class Arbol{
    public static void main(String[] args) {
        ArbolInorder arbol = new ArbolInorder();

        Nodo raiz = new Nodo(4);
        raiz.izquierda = new Nodo(2);
        raiz.derecha = new Nodo(6);
        raiz.izquierda.izquierda = new Nodo(1);
        raiz.izquierda.derecha = new Nodo(3);
        raiz.derecha.izquierda = new Nodo(5);
        raiz.derecha.derecha = new Nodo(7);

        arbol.inorder(raiz);
    }    
}
```
</td></tr>
<tr><th>Nodo</th><th>Arbol</th></tr>
<tr><td valign=top>

```java
class Nodo {
    int valor;
    Nodo izquierda;
    Nodo derecha;

    Nodo(int valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }
}
```
</td><td valign=top>


```java
class ArbolInorder {
    public void inorder(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        inorder(nodo.izquierda);
        System.out.print(nodo.valor + " ");
        inorder(nodo.derecha);
    }
}
```
</td></tr>
</table>

</div>

> Los atributos de `Nodo` son de paquete (sin `private`) para mantener el ejemplo mínimo.

### Traza de ejecución

Para `inorder(raiz)`:

```text
inorder(4)
  inorder(2)
    inorder(1)
      inorder(null) → return
      print 1
      inorder(null) → return
    print 2
    inorder(3)
      inorder(null) → return
      print 3
      inorder(null) → return
  print 4
  inorder(6)
    inorder(5)
      inorder(null) → return
      print 5
      inorder(null) → return
    print 6
    inorder(7)
      inorder(null) → return
      print 7
      inorder(null) → return

Salida: 1 2 3 4 5 6 7
```

### Análisis

#### Vocabulario clave

<div align=center>

|||
|-|-|
|**Recursión ramificada**|Una función que se llama a sí misma múltiples veces|
|**Árbol de llamadas**|La estructura que resulta de múltiples llamadas recursivas|
|**Recorrido de árbol**|Visitar todos los nodos de una estructura jerárquica|

</div>

#### Estructura con múltiples llamadas recursivas

```java
tipoRetorno funcion(parametros) {
    if (casoBase) {
        return valor;
    }

    funcion(parametros1);
    operacionIntermedia();
    funcion(parametros2);
}
```

#### Comparación con el paso anterior

<div align=center>

|Aspecto|Paso 5 (Condicionales)|Paso 6 (Múltiples llamadas)|
|-|-|-|
|Llamadas por caso|1|2+|
|Estructura de llamadas|Lineal con bifurcaciones|Árbol|
|Ejemplo|Máximo|Inorder|

</div>

#### Ventajas

<div align=center>

|Ventaja|Explicación|
|-|-|
|**Código legible**|Refleja la estructura del árbol|
|**Recorrido completo**|Visita todos los nodos exactamente una vez|
|**Aplicación amplia**|Árboles binarios, expresiones, directorios|

</div>

### Reflexión final

**Múltiples llamadas recursivas = árboles de llamadas**.

Esto es fundamental para entender algoritmos como:

- Recorrido de árboles y grafos
- Divide y vencerás
- Backtracking (búsqueda exhaustiva)

En el siguiente paso se aborda la **interrupción** de un caso recursivo, lo cual prepara para **backtracking**.

> [Siguiente: Interrupción de caso recursivo](07-interrupcion-recursiva.md)
