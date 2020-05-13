package com.kodilla.patterns.factory.tasks;

import static com.kodilla.patterns.factory.tasks.TaskStatus.EXECUTED;
import static com.kodilla.patterns.factory.tasks.TaskStatus.NOT_EXECUTED;

public final class PaintingTask implements Task {
    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private TaskStatus taskStatus = NOT_EXECUTED;

    public PaintingTask(final String taskName, final String color, final String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        if (color.equals("Pink") && whatToPaint.equals("Toilet")) {
            taskStatus = EXECUTED;
        } else {
            taskStatus = NOT_EXECUTED;
        }
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return taskStatus == EXECUTED;
    }
}
