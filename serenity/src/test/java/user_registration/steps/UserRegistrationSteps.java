package user_registration.steps;

import entities.RegistrationStatus;
import entities.User;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRegistrationSteps {

    User user;

    @Step("A new user can be registered with email {0}")
    public void a_user_can_be_registered(String email, String password) {
        user = User.registerUser(email, password);
        assertThat(user).isNotNull();
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getPassword()).isEqualTo(password);
    }

    @Step("A new user has status {0}")
    public void a_new_user_has_status(String status) {
        assertThat(user).isNotNull();
        assertThat(user.getRegistrationStatus()).describedAs("Not correct initial status.")
          .isEqualTo(RegistrationStatus.valueOf(status));
     }

    @Step("A user can be activated")
    public void a_user_can_be_activated() {
        user.activateUser();
        assertThat(user.getRegistrationStatus()).isEqualTo(RegistrationStatus.ACTIVATED);
    }

    @Step("A user can log in")
    public void a_user_can_log_in() {
        assertThat(user.getRegistrationStatus()).isEqualTo(RegistrationStatus.ACTIVATED);
        assertThat(true).isTrue();
    }
}
