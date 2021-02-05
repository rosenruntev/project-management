package uni.fmi.projectmanagement.models;

import uni.fmi.projectmanagement.services.TaskService;

public class AddSubTaskPageModel {
    private String taskName;
    private String description;
    private String parentTask;
    private String developerName;
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

    public String getParentTask() {
        return parentTask;
    }

    public void setParentTask(String parentTask) {
        this.parentTask = parentTask;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void navigateToAddSubTaskScreen() {
        System.out.println("Навигирано е до страницата за добавяне на подзадачи");
    }

    public void clickAddSubTaskButton() {
        message = TaskService.addSubtaskToTask(taskName, description, parentTask, developerName);
    }
}
