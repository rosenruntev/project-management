package uni.fmi.projectmanagement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.fmi.projectmanagement.models.AddSubTaskPageModel;

import static org.junit.Assert.assertEquals;

public class AddSubTaskSteps {

    private AddSubTaskPageModel addSubTaskPageModel = new AddSubTaskPageModel();

    @Given("^Потребителя отваря екрана за добавяне на подзадача$")
    public void openAddSubTaskScreen() {
        addSubTaskPageModel.navigateToAddSubTaskScreen();
    }

    @When("^Въвежда име на подзадачата \"([^\"]*)\"$")
    public void addSubTaskName(String name) {
        addSubTaskPageModel.setTaskName(name);
    }

    @When("^Въвежда описание на подзадачата \"([^\"]*)\"$")
    public void addSubTaskDescription(String description) {
        addSubTaskPageModel.setDescription(description);
    }

    @When("^Въвежда името на главната задача \"([^\"]*)\"$")
    public void addSubTaskParentTask(String parentTask) {
        addSubTaskPageModel.setParentTask(parentTask);
    }

    @When("^Въвежда името на разработчика за подзадачата \"([^\"]*)\"$")
    public void addSubTaskDeveloper(String developer) {
        addSubTaskPageModel.setDeveloperName(developer);
    }

    @When("^Натиска бутона за добавяне на подзадачата$")
    public void clickAddSubTaskButton() {
        addSubTaskPageModel.clickAddSubTaskButton();
    }

    @Then("Вижда съобщението на екрана \"([^\"]*)\"$")
    public void checkAddedSubTaskMessage(String expectedMessage) {
        assertEquals(expectedMessage, addSubTaskPageModel.getMessage());
    }
}
