package com.kodilla.patterns.factory.tasks;

import static com.kodilla.patterns.factory.tasks.TaskStatus.EXECUTED;
import static com.kodilla.patterns.factory.tasks.TaskStatus.NOT_EXECUTED;

public final class ShoppingTask implements Task {
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private TaskStatus taskStatus = NOT_EXECUTED;

    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        if (whatToBuy.equals("Johnnie Walker King George V WHISKY 0,7L") && quantity < 3) {
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
