package common;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import java.util.HashMap;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UiProperties {

  private static UiProperties ourInstance = new UiProperties();

  public static UiProperties getInstance() {
    return ourInstance;
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
    BROWSER = new ChromeDriver();
    LANGUAGE_VERSION = Language.ENGLISH;

    // TODO Customize
    USER = Actor.named("Mirka");
    URL = "http://empirica-stream.vyv.local:9090/core/";

    USERS = new HashMap<>();
    USERS.put(UserRole.ADMIN_USER, Tuple.of("admin", "admin1234"));
    USERS.put(UserRole.EMPIRICA_TESTER, Tuple.of("mirusqua", "turulko"));
  }
}
