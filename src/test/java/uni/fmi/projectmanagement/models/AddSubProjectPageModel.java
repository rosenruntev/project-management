package uni.fmi.projectmanagement.models;

import uni.fmi.projectmanagement.services.ProjectService;

import java.util.List;

public class AddSubProjectPageModel {
    private String projectName;
    private String managerName;
    private List<String> developers;
    private String parentProjectName;
    private String message;

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

    public List<String> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<String> developers) {
        this.developers = developers;
    }

    public String getParentProjectName() {
        return parentProjectName;
    }

    public void setParentProjectName(String parentProjectName) {
        this.parentProjectName = parentProjectName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void navigateToAddSubProjectScreen() {
        System.out.println("Навигирано е до страницата за добавяне на подпроект");
    }

    public void clickAddSubProjectButton() {
        message = ProjectService.addSubProject(projectName, managerName, developers, parentProjectName);
    }
}
