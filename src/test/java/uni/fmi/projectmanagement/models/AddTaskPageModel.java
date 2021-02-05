package uni.fmi.projectmanagement.models;

import uni.fmi.projectmanagement.services.TaskService;

public class AddTaskPageModel {

    private String taskName;
    private String description;
    private String projectName;
    private String message;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void navigateToAddTaskScreen() {
        System.out.println("Навигирано е до страницата за добавяне на задачи");
    }

    public void clickAddTaskButton() {
        message = TaskService.addTaskToProject(taskName, description, projectName);
    }
}
