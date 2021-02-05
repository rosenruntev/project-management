package uni.fmi.projectmanagement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.fmi.projectmanagement.models.AddProjectPageModel;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddProjectSteps {

    private AddProjectPageModel addProjectPage = new AddProjectPageModel();

    @Given("^Потребителя отваря екрана за добавяне на проект$")
    public void openAddProjectScreen() {
        addProjectPage.navigateToAddProjectScreen();
    }

    @When("^Въвежда име на проекта \"([^\"]*)\"$")
    public void addProjectName(String name) {
        addProjectPage.setProjectName(name);
    }

    @When("^Въвежда име на мениджъра \"([^\"]*)\"$")
    public void addProjectManager(String name) {
        addProjectPage.setManagerName(name);
    }

    @When("^Въвежда списък с разработчици$")
    public void addDevelopers(List<String> developers) {
        addProjectPage.setDevelopers(developers);
    }

    @When("^Натиска бутона за добавяне на проекта$")
    public void clickAddProjectButton() {
        addProjectPage.clickAddProjectButton();
    }

    @Then("^Вижда съобщение \"([^\"]*)\"$")
    public void checkAddedProjectMessage(String expectedMessage) {
        assertEquals(expectedMessage, addProjectPage.getMessage());
    }
}