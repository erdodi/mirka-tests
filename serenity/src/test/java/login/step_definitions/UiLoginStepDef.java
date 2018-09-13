package login.step_definitions;

import common.UiProperties;
import common.UserRole;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import login.steps.UiLoginSteps;
import net.thucydides.core.annotations.Steps;

/** Created by miroslav.darula on 10. 10. 2016. */
public class UiLoginStepDef {

  @Steps private UiLoginSteps uiLoginSteps;

  @Given("^user is on login page$")
  public void userIsOnIndexPage() {
    uiLoginSteps.openLoginPage(UiProperties.USER);
  }

  @Given("^user provides credentials user '(.*)' and password '(.*)'$")
  public void userProvidesCredentials(final String userName, final String userPassword) {
    uiLoginSteps.userProvidesCredentials(UiProperties.USER, userName, userPassword);
  }

  @When("^user provides valid credentials as '(.*)'$")
  public void userProvidesValidCredentials(UserRole userRole) {
    uiLoginSteps.userProvidesCredentials(
        UiProperties.USER,
        UiProperties.USERS.get(userRole)._1,
        UiProperties.USERS.get(userRole)._2);
  }

  @When("^user click LOG IN button$")
  public void userClickLogInButton() {
    uiLoginSteps.userClickLogInButton(UiProperties.USER);
  }

  @When("^user click LOG IN button and check error message$")
  public void userClickLogInButtonAndCheckErrorMessage() {
    uiLoginSteps.userClickLogInButtonAndCheckErrorMessage(UiProperties.USER);
  }

  @When("^user press enter key on login page$")
  public void userPressEnterKeyOnLoginPage() {
    uiLoginSteps.userPressEnterKeyOnLoginPage(UiProperties.USER);
  }

  @Then("^user can see transactions page$")
  public void userCanSeeTransactionsPage() {
    uiLoginSteps.userCanSeeTransactions(UiProperties.USER);
  }

  @Then("^user can see error message on login page$")
  public void userCanSeeErrorOnLoginPage() {
    uiLoginSteps.userCanSeeErrorOnLoginPage(UiProperties.USER);
  }
}
