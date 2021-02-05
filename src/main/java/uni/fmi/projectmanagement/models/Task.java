package uni.fmi.projectmanagement.models;

import java.util.*;

public class Task {

    private String name;
    private String description;
    private Project project;
    private Developer developer;
    private Set<Task> childTasks = new HashSet<>();
    private Task parentTask;
    private TaskStatus taskStatus = TaskStatus.New;

    public Task(String name, String description) {
        setName(name);
        setDescription(description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus status) {
        this.taskStatus = status;
    }

    public Task getParentTask() {
        return parentTask;
    }

    public void setParentTask(Task task) {
        this.parentTask = task;
    }

    public Set<Task> getChildTasks() {
        return childTasks;
    }

    public void setChildTasks(Set<Task> tasks) {
        this.childTasks = tasks;
    }
}