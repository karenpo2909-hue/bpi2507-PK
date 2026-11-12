package edu.course.lab03;

public class TaskPrioritizer {

    private final PriorityPolicy priorityPolicy;

    public TaskPrioritizer(PriorityPolicy priorityPolicy) {
        if (priorityPolicy == null) {
            throw new IllegalArgumentException("priorityPolicy must not be null");
        }
        this.priorityPolicy = priorityPolicy;
    }

    /**
     * Возвращает задачу с более высоким приоритетом.
     * При равенстве приоритетов возвращает первую задачу.
     */
    public ProjectTask chooseHigherPriority(ProjectTask first, ProjectTask second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("tasks must not be null");
        }

        int priority1 = priorityPolicy.calculatePriority(first);
        int priority2 = priorityPolicy.calculatePriority(second);

        return priority1 >= priority2 ? first : second;
    }
}