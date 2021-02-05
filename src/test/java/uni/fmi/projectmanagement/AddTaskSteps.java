package uni.fmi.projectmanagement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.fmi.projectmanagement.models.AddTaskPageModel;

import static org.junit.Assert.assertEquals;

public class AddTaskSteps {

    private AddTaskPageModel addTaskPageModel = new AddTaskPageModel();

    @Given("^Потребителя отваря екрана за добавяне на задача$")
    public void openAddTaskScreen() {
        addTaskPageModel.navigateToAddTaskScreen();
    }

    @When("^Въвежда име на задачата \"([^\"]*)\"$")
    public void addTaskName(String name) {
        addTaskPageModel.setTaskName(name);
    }

    @When("^Въвежда описание на задачата \"([^\"]*)\"$")
    public void addTaskDescription(String description) {
        addTaskPageModel.setDescription(description);
    }

    @When("^Въвежда името на проекта \"([^\"]*)\"$")
    public void addProjectName(String name) {
        addTaskPageModel.setProjectName(name);
    }

    @When("^Натиска бутона за добавяне на задача$")
    public void clickAddTaskButton() {
        addTaskPageModel.clickAddTaskButton();
    }

    @Then("^Вижда съобщение на екрана \"([^\"]*)\"$")
    public void checkAddedTaskMessage(String expectedMessage) {
        assertEquals(expectedMessage, addTaskPageModel.getMessage());
    }
}
