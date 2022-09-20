package common;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import java.util.HashMap;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UiProperties {

  private static UiProperties ourInstance;

  public static void init() {

    if (ourInstance == null) {
      ourInstance = new UiProperties();
    }
  }

  public static WebDriver BROWSER;
  public static Language LANGUAGE_VERSION;
  public static Actor USER;
  public static String URL;

  // TODO Ak bude treba pre jednu rolu viacej pouzivatelov prerobim inac...
  // Map of User role and login credentials
  // e.g.: ADMIN -> admin/admin1234
  public static Map<UserRole, Tuple2<String, String>> USERS;

  private UiProperties() {
    System.setProperty(
        "webdriver.chrome.driver", "src/test/resources/chromedriver_105.0.5195.52.exe");
    BROWSER =
        new ChromeDriver(
            new ChromeOptions()
                .setBinary(
                    "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"));

    LANGUAGE_VERSION = Language.ENGLISH;

    // TODO Customize
    USER = Actor.named("Mirka");
    URL = "https://www.centrum.sk/";

    USERS = new HashMap<>();
    USERS.put(UserRole.ADMIN_USER, Tuple.of("admin", "admin1234"));
    USERS.put(UserRole.EMPIRICA_TESTER, Tuple.of("mirusqua", "turulko"));
  }
}
