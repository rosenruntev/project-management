package uni.fmi.projectmanagement.models;

import uni.fmi.projectmanagement.services.TaskService;

public class ChangeTaskStatusPageModel {

    private String taskName;
    private String status;
    private String userMessage;
    private String assignedDeveloper;
    private String message;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getAssignedDeveloper() {
        return assignedDeveloper;
    }

    public void setAssignedDeveloper(String assignedDeveloper) {
        this.assignedDeveloper = assignedDeveloper;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void navigateToChangeTaskStatusScreen() {
        System.out.println("Навигирано е до страницата за променя на статуса на задача");
    }

    public void clickChangeTaskStatusButton() {
        message = TaskService.changeTaskStatus(taskName, status, userMessage, assignedDeveloper);
    }
}
