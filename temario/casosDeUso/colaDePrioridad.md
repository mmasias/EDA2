# Ejemplo de una cola de prioridad

Supongamos que tenemos una clase Tarea con dos atributos: nombre de la tarea y prioridad y queremos que las tareas con mayor prioridad (números más grandes) sean procesadas primero.

|[Task](/src/casosDeUso/priorityQueue/Task.java)|[PriorityQueue](/src/casosDeUso/priorityQueue/PrioriyQueue.java)|[PriorityComparator](/src/casosDeUso/priorityQueue/PriorityComparator.java)|
|-|-|-|
|Tarea, con descripción y prioridad|Las tareas al entrar se ordenan de manera que aquellas con mayor prioridad (números más grandes) se sitúan al frente de la cola.|PriorityComparator es un comparador personalizado que define el orden de los elementos en la PriorityQueue.|
||Al utilizar poll(), se obtiene y se remueve siempre la tarea con la mayor prioridad restante, demostrando la utilidad del comparador para controlar el orden de los elementos en una PriorityQueue.||
