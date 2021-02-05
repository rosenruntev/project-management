package uni.fmi.projectmanagement.models;

import uni.fmi.projectmanagement.services.ProjectService;

import java.util.List;

public class AddProjectPageModel {
    private String projectName;
    private String managerName;
    private String message;
    private List<String> developers;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<String> developers) {
        this.developers = developers;
    }

    public void navigateToAddProjectScreen() {
        System.out.println("Навигирано е до страницата за добавяне на нов проект");
    }

    public void clickAddProjectButton() {
        message = ProjectService.addProject(projectName, managerName, developers);
    }
}
