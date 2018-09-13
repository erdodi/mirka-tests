package com.wirecard.vas.test.voucher.ui.login.step_definitions;

import com.wirecard.vas.test.voucher.config.session.variable.SessionVariableUi;
import com.wirecard.vas.test.voucher.config.Bootstrap;
import com.wirecard.vas.test.voucher.config.types.UserRole;
import com.wirecard.vas.test.voucher.ui.login.steps.UiLoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Created by miroslav.darula on 10. 10. 2016.
 */
public class UiLoginStepDef {

  @Steps
  private UiLoginSteps uiLoginSteps;

  @Given("^user is on login page$")
  public void userIsOnIndexPage() {
    uiLoginSteps.openLoginPage(SessionVariableUi.USER.get());
  }

  @Given("^user provides credentials user '(.*)' and password '(.*)'$")
  public void userProvidesCredentials(final String userName, final String userPassword){
    uiLoginSteps.userProvidesCredentials(SessionVariableUi.USER.get(), userName, userPassword);
  }

  @When("^user provides valid credentials as '(.*)'$")
  public void userProvidesValidCredentials(UserRole userRole) {
    uiLoginSteps.userProvidesCredentials(
      SessionVariableUi.USER.get(),
      Bootstrap.getConfig().getUsersCredentials().getUserCredentialsByName(userRole).getUsername(),
      Bootstrap.getConfig().getUsersCredentials().getUserCredentialsByName(userRole).getPassword()
    );
  }

  @When("^user click LOG IN button$")
  public void userClickLogInButton(){
    uiLoginSteps.userClickLogInButton(SessionVariableUi.USER.get());
  }

  @When("^user click LOG IN button and check error message$")
  public void userClickLogInButtonAndCheckErrorMessage(){
    uiLoginSteps.userClickLogInButtonAndCheckErrorMessage(SessionVariableUi.USER.get());
  }

  @When("^user press enter key on login page$")
  public void userPressEnterKeyOnLoginPage(){
    uiLoginSteps.userPressEnterKeyOnLoginPage(SessionVariableUi.USER.get());
  }

  @Then("^user can see transactions page$")
  public void userCanSeeTransactionsPage() {
    uiLoginSteps.userCanSeeTransactions(SessionVariableUi.USER.get());
  }

  @Then("^user can see error message on login page$")
  public void userCanSeeErrorOnLoginPage(){
    uiLoginSteps.userCanSeeErrorOnLoginPage(SessionVariableUi.USER.get());
  }

  @Given("^User is logged in Voucher UI as '(.*)'$")
  public void userIsLoggedInAsRole(UserRole userRole){
    uiLoginSteps.userIsLoggedInAsRoleByJwt(SessionVariableUi.USER.get(), userRole);
  }
}
