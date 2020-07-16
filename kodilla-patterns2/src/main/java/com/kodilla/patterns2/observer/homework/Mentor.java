package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String username;
    private int updateCount;

    public Mentor(String username) {
        this.username = username;
    }

    @Override
    public void update(CadetTask cadetTask) {
        System.out.println(username + ": New Task received " + cadetTask.getTaskName() + "\n" + " (total: " + cadetTask.getTasks().size() + " tasks");
        updateCount++;
    }

    public String getUsername() {
        return username;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
