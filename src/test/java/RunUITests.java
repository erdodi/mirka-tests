import common.UiProperties;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = {"src/test/resources/features"},
    plugin = {"pretty", "html:target/cucumber"},
    tags = "@test")
public class RunUITests {

  @BeforeClass
  public static void setUp() {
    UiProperties.init();
  }
}
