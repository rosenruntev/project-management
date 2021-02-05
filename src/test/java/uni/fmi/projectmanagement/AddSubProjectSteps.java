package uni.fmi.projectmanagement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.fmi.projectmanagement.models.AddSubProjectPageModel;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddSubProjectSteps {

    private AddSubProjectPageModel addSubProjectPageModel = new AddSubProjectPageModel();

    @Given("^Потребителя отваря екрана за добавяне на подпроекти$")
    public void openAddSubProjectScreen() {
        addSubProjectPageModel.navigateToAddSubProjectScreen();
    }

    @When("^Въвежда името на подпроекта \"([^\"]*)\"$")
    public void addProjectName(String name) {
        addSubProjectPageModel.setProjectName(name);
    }

    @When("^Въвежда името на мениджъра \"([^\"]*)\"$")
    public void addProjectManager(String manager) {
        addSubProjectPageModel.setManagerName(manager);
    }

    @When("^Въвежда списък с разработчици за подпроекта$")
    public void addDevelopers(List<String> developers) {
        addSubProjectPageModel.setDevelopers(developers);
    }

    @When("^Въвежда името на главния проект \"([^\"]*)\"$")
    public void addParentProjectName(String name) {
        addSubProjectPageModel.setParentProjectName(name);
    }

    @When("^Натиска бутона за добавяне на подпроекта$")
    public void clickAddSubProjectButton() {
        addSubProjectPageModel.clickAddSubProjectButton();
    }

    @Then("^Вижда съобщението \"([^\"]*)\"$")
    public void checkAddedSubProjectMessage(String expectedMessage) {
        assertEquals(expectedMessage, addSubProjectPageModel.getMessage());
    }
}
