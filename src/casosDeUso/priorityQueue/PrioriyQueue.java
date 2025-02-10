package src.casosDeUso.priorityQueue;

import java.util.PriorityQueue;

class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(new PriorityComparator());

        taskQueue.add(new Task("> Ordenar la habitación", 6));
        taskQueue.add(new Task("> Ver Netflix", 1));
        taskQueue.add(new Task("> Entender colas de prioridad", 10));
        taskQueue.add(new Task("> Estudiar", 8));
        taskQueue.add(new Task("> Comer", 5));

        System.out.println("Qué hacer (ya ordenado por prioridad):");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
    }
}