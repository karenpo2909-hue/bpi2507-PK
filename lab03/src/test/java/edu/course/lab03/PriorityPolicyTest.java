package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityPolicyTest {

    private final ProjectTask smallTask = new ProjectTask("T1", "Small", TaskStatus.NEW, 4);
    private final ProjectTask largeTask = new ProjectTask("T2", "Large", TaskStatus.NEW, 20);
    private final ProjectTask inProgressTask = new ProjectTask("T3", "Active", TaskStatus.IN_PROGRESS, 5);
    private final ProjectTask cancelledTask = new ProjectTask("T4", "Cancelled", TaskStatus.CANCELLED, 10);

    @Test
    void effortPolicyPrefersLargerEstimate() {
        PriorityPolicy policy = new EffortPriorityPolicy();
        assertTrue(policy.calculatePriority(largeTask) > policy.calculatePriority(smallTask));
    }

    @Test
    void effortPolicyReturnsHours() {
        PriorityPolicy policy = new EffortPriorityPolicy();
        assertEquals(20, policy.calculatePriority(largeTask));
    }

    @Test
    void statusPolicyPrefersInProgress() {
        PriorityPolicy policy = new StatusPriorityPolicy();
        assertTrue(policy.calculatePriority(inProgressTask) > policy.calculatePriority(smallTask));
        assertTrue(policy.calculatePriority(smallTask) > policy.calculatePriority(cancelledTask));
    }

    @Test
    void statusPolicyReturnsExpectedValues() {
        PriorityPolicy policy = new StatusPriorityPolicy();
        assertEquals(40, policy.calculatePriority(inProgressTask));
        assertEquals(30, policy.calculatePriority(smallTask));
        assertEquals(10, policy.calculatePriority(cancelledTask));
    }

    @Test
    void prioritizerUsesEffortPolicy() {
        TaskPrioritizer prioritizer = new TaskPrioritizer(new EffortPriorityPolicy());
        ProjectTask result = prioritizer.chooseHigherPriority(smallTask, largeTask);
        assertEquals(largeTask, result);
    }

    @Test
    void prioritizerUsesStatusPolicy() {
        TaskPrioritizer prioritizer = new TaskPrioritizer(new StatusPriorityPolicy());
        ProjectTask result = prioritizer.chooseHigherPriority(cancelledTask, inProgressTask);
        assertEquals(inProgressTask, result);
    }

    @Test
    void canReplacePriorityPolicy() {
        TaskPrioritizer byEffort = new TaskPrioritizer(new EffortPriorityPolicy());
        TaskPrioritizer byStatus = new TaskPrioritizer(new StatusPriorityPolicy());

        // largeTask имеет больше часов, но cancelledTask имеет низкий статус
        ProjectTask effortChoice = byEffort.chooseHigherPriority(largeTask, cancelledTask);
        ProjectTask statusChoice = byStatus.chooseHigherPriority(largeTask, cancelledTask);

        assertEquals(largeTask, effortChoice);      // 20 > 10
        assertEquals(largeTask, statusChoice);      // NEW(30) > CANCELLED(10)
    }
}