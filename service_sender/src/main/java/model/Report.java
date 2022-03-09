package model;

import java.util.Map;

public class Report {
    private String name;
    private String lastName;
    private Map<String, Integer> task_time;

    public Report() {}

    public Report(String name, String lastName, Map<String, Integer> task_time){
        this.name = name;
        this.lastName = lastName;
        this.task_time = task_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Integer> getTask_time() {
        return task_time;
    }

    public void setTask_time(Map<String, Integer> task_time) {
        this.task_time = task_time;
    }

    @Override
    public String toString() {
        return "Report{" +
                "name = " + name +
                ", lastName = " + lastName +
                ", task_time = '" + task_time +
                '}';
    }
}
