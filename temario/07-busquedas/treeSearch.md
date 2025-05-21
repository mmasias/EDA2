# Búsqueda en Árbol

## ¿Por qué?

La búsqueda en árboles, especialmente en árboles binarios de búsqueda (BST) y sus variantes balanceadas, es un método eficiente para encontrar elementos en una colección de datos. Los árboles permiten una organización jerárquica que acelera las operaciones de búsqueda, inserción y eliminación, convirtiéndose en una herramienta clave en la construcción de estructuras de datos más complejas.

## ¿Qué?

Un árbol binario de búsqueda (BST) es una estructura de datos en la que cada nodo tiene un valor mayor que todos los valores del subárbol izquierdo y menor que todos los valores del subárbol derecho. La búsqueda en un BST implica comparar el valor objetivo con el nodo actual y navegar hacia la izquierda o derecha según corresponda, repitiendo el proceso hasta encontrar el valor o alcanzar una hoja.

## ¿Para qué?

La búsqueda en árboles es esencial en aplicaciones que requieren búsqueda, inserción y eliminación eficientes de datos:

- Sistemas de bases de datos que emplean índices basados en árboles para búsquedas rápidas.
- Implementación de estructuras de datos avanzadas, como árboles AVL o B-trees, que mantienen un equilibrio para mejorar la eficiencia.
- Aplicaciones como autocompletar, jerarquías y motores de búsqueda personalizados.

## ¿Cómo?

### Implementación

```java
class Node {
    int value;
    Node left, right;

    Node(int item) {
        value = item;
        left = right = null;
    }
}

public class BinaryTreeSearch {
    Node root;

    // Método para buscar un valor en el árbol binario de búsqueda
    public Node search(Node root, int target) {
        if (root == null || root.value == target) {
            return root; // Devuelve el nodo si lo encuentra o si el árbol está vacío
        }

        // Si el objetivo es menor que el nodo actual, busca en el subárbol izquierdo
        if (target < root.value) {
            return search(root.left, target);
        }

        // De lo contrario, busca en el subárbol derecho
        return search(root.right, target);
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    public static void main(String[] args) {
        BinaryTreeSearch tree = new BinaryTreeSearch();
        int[] data = {15, 10, 20, 8, 12, 16, 25};
        for (int num : data) {
            tree.insert(num);
        }

        int target = 16;
        Node result = tree.search(tree.root, target);
        if (result != null) {
            System.out.println("Elemento encontrado: " + result.value);
        } else {
            System.out.println("Elemento no encontrado");
        }
    }
}
```

Esta implementación muestra cómo buscar y agregar nodos en un árbol binario de búsqueda. 

Variantes balanceadas, como árboles AVL o B-trees, mejoran la eficiencia manteniendo el árbol equilibrado.
