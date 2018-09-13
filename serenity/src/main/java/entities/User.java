package entities;

import java.util.Optional;

public class User {

    private String password;
    private String email;
    private RegistrationStatus registrationStatus;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RegistrationStatus getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(RegistrationStatus registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public static User registerUser(String email, String password) {
        final User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRegistrationStatus(RegistrationStatus.REGISTERED);

        return user;
    }

    public void activateUser() {
        this.registrationStatus = RegistrationStatus.ACTIVATED;
    }

    public void deactivateUser() {
        this.registrationStatus = RegistrationStatus.DEACTIVATED;
    }
}
