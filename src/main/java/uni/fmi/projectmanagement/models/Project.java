package uni.fmi.projectmanagement.models;

import java.util.*;


public class Project {

    private String name;
    private Set<Developer> developers = new HashSet<>();
    private Set<Task> tasks = new HashSet<>();
    private Manager manager;
    private Set<Project> childProjects = new HashSet<>();
    private Project parentProject;

    public Project(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public Set getTasks() {
        return tasks;
    }

    public void setTasks(Set tasks) {
        this.tasks = tasks;
    }

    public Project getParentProject() {
        return parentProject;
    }

    public void setParentProject(Project project) {
        parentProject = project;
    }

    public Set<Project> getChildProjects() {
        return childProjects;
    }

    public void setChildProjects(Set<Project> projects) {
        childProjects = projects;
    }
}