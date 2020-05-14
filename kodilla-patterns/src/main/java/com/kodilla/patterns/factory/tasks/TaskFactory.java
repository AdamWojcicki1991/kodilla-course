package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public final Task makeTask(final TaskType taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("SHOPPING TASK", "Johnnie Walker King George V WHISKY 0,7L", 2);
            case PAINTING:
                return new PaintingTask("PAINTING TASK", "Pink", "Toilet");
            case DRIVING:
                return new DrivingTask("DRIVING TASK", "Driving School \"NEW HORIZON\" - 1906  Elliott Street, Manchester UK", "Lamborghini Aventador SVJ Roadster");
            default:
                return null;
        }
    }
}
