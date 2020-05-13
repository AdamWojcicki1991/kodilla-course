package com.kodilla.patterns.factory.tasks;

import static com.kodilla.patterns.factory.tasks.TaskStatus.EXECUTED;
import static com.kodilla.patterns.factory.tasks.TaskStatus.NOT_EXECUTED;

public final class DrivingTask implements Task {
    private final String taskName;
    private final String where;
    private final String using;
    private TaskStatus taskStatus = NOT_EXECUTED;

    public DrivingTask(final String taskName, final String where, final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() {
        if (where.equals("Driving School \"NEW HORIZON\" - 1906  Elliott Street, Manchester UK") && using.equals("Lamborghini Aventador SVJ Roadster")) {
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
