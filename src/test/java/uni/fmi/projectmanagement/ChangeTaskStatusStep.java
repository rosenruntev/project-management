package uni.fmi.projectmanagement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.fmi.projectmanagement.models.ChangeTaskStatusPageModel;

import static org.junit.Assert.assertEquals;

public class ChangeTaskStatusStep {

    private ChangeTaskStatusPageModel changeTaskStatusPageModel = new ChangeTaskStatusPageModel();

    @Given("^Потребителя отваря екрана за промяна на статуса на задачата$")
    public void openChangeTaskStatusScreen() {
        changeTaskStatusPageModel.navigateToChangeTaskStatusScreen();
    }

    @When("^Въвежда име на задачата която ще бъде променена \"([^\"]*)\"$")
    public void addTaskName(String name) {
        changeTaskStatusPageModel.setTaskName(name);
    }

    @When("^Въвежда статуса на задачата \"([^\"]*)\"$")
    public void addTaskStatus(String name) {
        changeTaskStatusPageModel.setStatus(name);
    }

    @When("^Въвежда съобщение \"([^\"]*)\"$")
    public void addMessage(String message) {
        changeTaskStatusPageModel.setUserMessage(message);
    }

    @When("^Въвежда разработчик за задачата \"([^\"]*)\"$")
    public void addTaskDeveloper(String developer) {
        changeTaskStatusPageModel.setAssignedDeveloper(developer);
    }

    @When("^Натиска бутона за промяна на статуса на задачата$")
    public void clickChangeTaskStatusButton() {
        changeTaskStatusPageModel.clickChangeTaskStatusButton();
    }

    @Then("^Вижда съобщението за статуса на екрана \"([^\"]*)\"$")
    public void checkStatusChangedMessage(String expectedMessage) {
        assertEquals(expectedMessage, changeTaskStatusPageModel.getMessage());
    }
}
