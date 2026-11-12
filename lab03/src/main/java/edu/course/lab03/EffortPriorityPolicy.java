package edu.course.lab03;

/**
 * Чем больше оценка трудоёмкости — тем выше приоритет.
 */
public class EffortPriorityPolicy implements PriorityPolicy {

    @Override
    public int calculatePriority(ProjectTask task) {
        if (task == null) {
            throw new IllegalArgumentException("task must not be null");
        }
        return task.getEstimatedHours();
    }
}