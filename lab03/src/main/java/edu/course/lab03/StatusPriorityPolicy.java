package edu.course.lab03;

/**
 * Приоритет по статусу:
 * IN_PROGRESS > NEW > COMPLETED > CANCELLED
 */
public class StatusPriorityPolicy implements PriorityPolicy {

    @Override
    public int calculatePriority(ProjectTask task) {
        if (task == null) {
            throw new IllegalArgumentException("task must not be null");
        }
        return switch (task.getStatus()) {
            case IN_PROGRESS -> 40;
            case NEW -> 30;
            case COMPLETED -> 20;
            case CANCELLED -> 10;
        };
    }
}