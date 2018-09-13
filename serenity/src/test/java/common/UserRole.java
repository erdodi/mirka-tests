package common;

public enum UserRole {

  // TODO Customize
  ADMIN_USER("AdminUser"),
  EMPIRICA_TESTER("EmpiricaTester");

  private final String userRole;

  UserRole(final String userRole) {
    this.userRole = userRole;
  }

  public String getUserRole() {
    return userRole;
  }
}
