package src.casosDeUso.priorityQueue;

import java.util.Comparator;

class PriorityComparator implements Comparator<Task> {
    public int compare(Task task1, Task task2) {
        return Integer.compare(task2.priority, task1.priority);
    }
}
