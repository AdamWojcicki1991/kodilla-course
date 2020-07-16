package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CadetTask implements Observable {
    private final List<Observer> observers;
    private final Queue<String> tasks;
    private final String taskName;

    public CadetTask(String taskName) {
        this.observers = new ArrayList<>();
        this.tasks = new ArrayDeque<>();
        this.taskName = taskName;
    }

    public void addTask(String task) {
        tasks.offer(task);
        notifyObserver();
    }

    public Queue<String> getTasks() {
        return tasks;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer -> observer.update(this));
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
