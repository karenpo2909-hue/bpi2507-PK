package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTaskTest {

    @Test
    void createsValidTask() {
        ProjectTask task = new ProjectTask(new TaskId("T-1"), "Implement login", 8);

        assertEquals("T-1", task.getId().value());
        assertEquals("Implement login", task.getTitle());
        assertEquals(TaskStatus.NEW, task.getStatus());
        assertEquals(8, task.getEstimatedHours());
        assertFalse(task.isCompleted());
    }

    @Test
    void changeStatusWorks() {
        ProjectTask task = new ProjectTask(new TaskId("T-1"), "Implement login", 8);
        task.changeStatus(TaskStatus.IN_PROGRESS);
        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());

        task.changeStatus(TaskStatus.COMPLETED);
        assertTrue(task.isCompleted());
    }

    @Test
    void increaseEstimateWorks() {
        ProjectTask task = new ProjectTask(new TaskId("T-1"), "Implement login", 8);
        task.increaseEstimate(4);
        assertEquals(12, task.getEstimatedHours());
    }

    @Test
    void constructorRejectsNullId() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask(null, "Title", 5));
    }

    @Test
    void constructorRejectsBlankTitle() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask(new TaskId("T-1"), "", 5));
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask(new TaskId("T-1"), null, 5));
    }

    @Test
    void constructorRejectsNonPositiveHours() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask(new TaskId("T-1"), "Title", 0));
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask(new TaskId("T-1"), "Title", -3));
    }

    @Test
    void increaseEstimateRejectsNonPositive() {
        ProjectTask task = new ProjectTask(new TaskId("T-1"), "Title", 5);
        assertThrows(IllegalArgumentException.class, () -> task.increaseEstimate(0));
        assertThrows(IllegalArgumentException.class, () -> task.increaseEstimate(-2));
    }

    @Test
    void changeStatusRejectsNull() {
        ProjectTask task = new ProjectTask(new TaskId("T-1"), "Title", 5);
        assertThrows(IllegalArgumentException.class, () -> task.changeStatus(null));
    }

    @Test
    void taskIdRejectsBlankValue() {
        assertThrows(IllegalArgumentException.class, () -> new TaskId(""));
        assertThrows(IllegalArgumentException.class, () -> new TaskId("   "));
        assertThrows(IllegalArgumentException.class, () -> new TaskId(null));
    }

    @Test
    void taskIdsWithSameValueAreEqual() {
        TaskId id1 = new TaskId("T-1");
        TaskId id2 = new TaskId("T-1");
        assertEquals(id1, id2);
        assertEquals(id1.hashCode(), id2.hashCode());
    }
}