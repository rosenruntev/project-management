package uni.fmi.projectmanagement.services;

import uni.fmi.projectmanagement.models.Developer;
import uni.fmi.projectmanagement.models.Project;
import uni.fmi.projectmanagement.models.Task;
import uni.fmi.projectmanagement.models.TaskStatus;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class TaskService {
    private static final Set<Task> TASKS = new HashSet<>();

    static {
        Task task = new Task("Test", "Test");
        Task secondTask = new Task("Test2", "Test2");
        Task thirdTask = new Task("Test3", "Test3");

        Project project = ProjectService.getProjectByName("Test");

        task.setProject(project);
        secondTask.setProject(project);
        secondTask.setTaskStatus(TaskStatus.Finished);
        thirdTask.setProject(project);

        TASKS.add(task);
        TASKS.add(secondTask);
        TASKS.add(thirdTask);
    }

    public static String addTaskToProject(String taskName, String taskDescription, String projectName) {
        if (taskName == null || taskName.isEmpty()) {
            return "Моля въведете име на задачата";
        } else if (taskDescription == null || taskDescription.isEmpty()) {
            return "Моля въведете описание на задачата";
        } else if (projectName == null || projectName.isEmpty()) {
            return "Моля въведете име на проекта";
        }

        Project project = ProjectService.getProjectByName(projectName);
        if (project == null) {
            return "Проекта не съществува";
        }

        Task task = new Task(taskName, taskDescription);
        TASKS.add(task);
        task.setProject(project);

        Set<Task> currentTasks = project.getTasks();
        currentTasks.add(task);
        project.setTasks(currentTasks);

        return "Успешно добавихте задачата";
    }

    public static String addSubtaskToTask(String taskName, String taskDescription, String parentTaskName, String developerName) {
        if (taskName == null || taskName.isEmpty()) {
            return "Моля въведете име на подзадачата";
        } else if (taskDescription == null || taskDescription.isEmpty()) {
            return "Моля въведете описание на подзадачата";
        } else if (parentTaskName == null || parentTaskName.isEmpty()) {
            return "Моля въведете името на главната задача";
        }

        Optional<Task> parentTask = TASKS.stream().filter(t -> t.getName().equals(parentTaskName)).findFirst();
        if (!parentTask.isPresent()) {
            return "Задачата не е намерена";
        }

        Project project = parentTask.get().getProject();
        Task task = new Task(taskName, taskDescription);
        task.setProject(project);
        task.setParentTask(parentTask.get());

        TASKS.add(task);
        parentTask.get().getChildTasks().add(task);
        project.getTasks().add(task);

        if (developerName != null && !developerName.isEmpty()) {
            Developer developer = ProjectService.getDeveloperByName(developerName);
            if (developer == null) {
                return "Разработчика не е намерен";
            }

            task.setDeveloper(developer);
            developer.getTasks().add(task);
        }

        return "Успешно добавихте подзадачата";
    }

    public static String changeTaskStatus(String taskName, String taskStatus, String message, String assignedDeveloper) {
        if (taskName == null || taskName.isEmpty()) {
            return "Моля въведете име на задачата";
        } else if (taskStatus == null || taskStatus.isEmpty()) {
            return "Моля въведете статус на задачата";
        } else if (message == null || message.isEmpty()) {
            return "Моля въведете съобщение при смяна на статуса на задачата";
        }

        TaskStatus status = TaskStatus.valueOf(taskStatus);
        Optional<Task> task = TASKS.stream().filter(t -> t.getName().equals(taskName)).findFirst();
        if (!task.isPresent()) {
            return "Задачата не е намерена";
        }

        if (task.get().getTaskStatus() == TaskStatus.Finished) {
            return "Не може да се промени статуса на завършена задача";
        } else if (status == TaskStatus.InProgress) {
            if (task.get().getDeveloper() == null && (assignedDeveloper == null || assignedDeveloper.isEmpty())) {
                return "Не може да се започне работа по задачата без разработчик";
            } else {
                if (task.get().getDeveloper() == null) {
                    Developer developer = ProjectService.getDeveloperByName(assignedDeveloper);
                    if (developer == null) {
                        return "Разработчика не съществува";
                    }

                    task.get().setDeveloper(developer);
                }

                Developer developer = task.get().getDeveloper();
                Set<Task> developerTasks = developer.getTasks();
                developerTasks.add(task.get());
                developer.setTasks(developerTasks);
            }
        } else if (status == TaskStatus.Finished || status == TaskStatus.Declined || status == TaskStatus.New) {
            Developer developer = task.get().getDeveloper();
            if (developer != null) {
                developer.getTasks().remove(task.get());
            }
        }

        task.get().setTaskStatus(status);
        return "Успешно променихте статуса на задачата";
    }
}
