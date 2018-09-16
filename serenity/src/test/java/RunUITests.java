import common.UiProperties;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = {"src/test/resources/features"},
  plugin = {"pretty", "html:target/cucumber"},
  tags = {"@test"}
)
public class RunUITests {

  @SuppressWarnings("ResultOfMethodCallIgnored")
  @BeforeClass
  public static void setUp() {
    UiProperties.getInstance();
  }
}
