package user_registration.step_definitions;

import static common.UiProperties.BROWSER;
import static common.UiProperties.USER;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import login.pages.LoginPage;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import user_registration.steps.UserRegistrationSteps;

public class UserRegistrationStepDef {

  @Steps UserRegistrationSteps userStorySteps;

  @Given("^user navigates to login page$")
  public void userNavigatesToIndexPage() {
    userStorySteps.openPage(USER, "https://www.centrum.sk/");
  }

  @When("^user accepts GDPR prompt$")
  public void userAcceptsGDPR() {
    USER.attemptsTo(Click.on(By.id("onetrust-accept-btn-handler")));
  }

  @Then("^user provides credentials username '(.*)' and password '(.*)'$")
  public void userProvidesCredentials(final String userName, final String userPassword) {
    USER.attemptsTo(
        Enter.theValue(userName).into(LoginPage.USER_NAME_INPUT),
        Enter.theValue(userPassword).into(LoginPage.USER_PASSWORD_INPUT).thenHit(Keys.ENTER));
  }

  @Then("^user navigates to incoming mail '(.*)'$")
  public void userNavigatesToMailPage(String mailUrl) {
    userStorySteps.openPage(USER, mailUrl);
    USER.attemptsTo(
        Click.on(By.id("compose_button")),
        Enter.theValue("mirusqa@gmail.com").into(By.id("recipient_rightclick_to")),
        Enter.theValue("Mail od Serenity").into(By.id("subject_input")),
        Click.on(By.className("b-content")));
  }

  // predpoklad ze pouzivatel sa vie zaregistrovat
  @Given("^A new user can be registered with email (.*)$")
  public void registerUser(String email) {
    userStorySteps.a_user_can_be_registered(email, "turul123");
  }

  // potom novy pouzivatel by mal mat stav REGISTERED
  @Then("^A new user has (.*) status$")
  public void checkStatus(String status) {
    userStorySteps.a_new_user_has_status(status);
  }

  // ak sa pouzivatel da aktivovat
  @When("^A user can be activated$")
  public void activateUser() {
    userStorySteps.a_user_can_be_activated();
  }

  // potom by sa mal vediet prihlasit
  @Then("^A user can log in$")
  public void thatMyFirstTestWorks() {
    userStorySteps.a_user_can_log_in();
  }

  @Then("^Close the browser$")
  public void thenCloseBrowserAndEndTest() {
    BROWSER.quit();
  }
}
