package login.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
  public static Target APP_LOGIN = Target.the("App login").located(By.tagName("app-login"));
  public static Target LOGIN_PAGE_TITLE =
      Target.the("Login").located(By.className("qa_login_page_title"));
  public static Target USER_NAME_INPUT = Target.the("username").located(By.id("username"));
  public static Target USER_PASSWORD_INPUT = Target.the("password").located(By.id("password"));
  public static Target USER_LOGIN_BUTTON =
      Target.the("Log in").located(By.className("button_button-log-in__vbvo7"));

  public static Target TRANSACTIONS_TABLE_TITLE =
      Target.the("Transactions").located(By.className("..."));
}
