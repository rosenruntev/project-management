package uni.fmi.projectmanagement.services;

import uni.fmi.projectmanagement.models.Developer;
import uni.fmi.projectmanagement.models.Manager;
import uni.fmi.projectmanagement.models.Project;

import java.util.*;

public class ProjectService {
    private static final Set<Project> PROJECTS = new HashSet<>();
    private static final Set<Manager> MANAGERS = new HashSet<>();
    private static final Set<Developer> DEVELOPERS = new HashSet<>();

    static {
        Manager manager = new Manager("Ivan Ivanov");
        MANAGERS.add(manager);

        DEVELOPERS.add(new Developer("Ivan Georgiev"));
        DEVELOPERS.add(new Developer("Georgi Georgiev"));

        Project project = new Project("Test");
        project.setManager(manager);
        PROJECTS.add(project);
    }

    public static Project getProjectByName(String name) {
        Optional<Project> foundProject = PROJECTS.stream().filter(p -> p.getName().equals(name)).findFirst();
        if (foundProject.isPresent()) {
            return foundProject.get();
        }

        return null;
    }

    public static Manager getManagerByName(String name) {
        Optional<Manager> foundManager = MANAGERS.stream().filter(m -> m.getName().equals(name)).findFirst();
        if (foundManager.isPresent()) {
            return foundManager.get();
        }

        return null;
    }

    public static Developer getDeveloperByName(String name) {
        Optional<Developer> foundDeveloper = DEVELOPERS.stream().filter(d -> d.getName().equals(name)).findFirst();
        if (foundDeveloper.isPresent()) {
            return foundDeveloper.get();
        }

        return null;
    }

    public static String addProject(String projectName, String managerName, List<String> namesOfDevelopers) {
        if (projectName == null) {
            return "Моля въведете име на проекта";
        } else if (managerName == null) {
            return "Моля въведете мениджър на проекта";
        }

        Manager manager = getManagerByName(managerName);
        if (manager == null) {
            return "Мениджъра не съществува";
        } else if(namesOfDevelopers == null) {
            return "Моля въведете разработчици за проекта";
        }

        Set<Developer> developers = new HashSet<>();
        namesOfDevelopers.stream().forEach(name -> {
            developers.add(getDeveloperByName(name));
        });

        Project project = new Project(projectName);
        PROJECTS.add(project);

        project.setManager(manager);
        manager.getProjects().add(project);

        project.setDevelopers(developers);
        developers.stream().forEach(d -> d.setProject(project));

        return "Успешно добавихте проекта";
    }

    public static String addSubProject(String projectName, String managerName, List<String> namesOfDevelopers, String parentProjectName) {
        if (projectName == null) {
            return "Моля въведете име на проекта";
        }

        Manager manager = getManagerByName(managerName);
        if (manager == null) {
            return "Мениджъра не съществува";
        } else if(namesOfDevelopers == null) {
            return "Моля въведете разработчици за проекта";
        }

        Set<Developer> developers = new HashSet<>();
        namesOfDevelopers.stream().forEach(name -> {
            developers.add(getDeveloperByName(name));
        });

        if (parentProjectName == null) {
            return "Моля въведете име на главния проект";
        }

        Project parentProject = getProjectByName(parentProjectName);
        if (parentProject == null) {
            return "Проекта не съществува";
        }

        Project project = new Project(projectName);
        PROJECTS.add(project);
        project.setManager(manager);
        manager.getProjects().add(project);
        project.setDevelopers(developers);
        project.setParentProject(parentProject);
        parentProject.getChildProjects().add(project);

        return "Успешно добавихте подпроекта";
    }
}
