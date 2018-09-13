package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionVariableUi {
  private static SessionVariableUi ourInstance = new SessionVariableUi();

  public static SessionVariableUi getInstance() {
    return ourInstance;
  }

  public static WebDriver BROWSER;

  private SessionVariableUi() {
    BROWSER = new ChromeDriver();
  }
}
