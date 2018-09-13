package user_registration.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import user_registration.steps.UserRegistrationSteps;

public class UserRegistrationStepDef {

    @Steps
    UserRegistrationSteps userStorySteps;

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
}
