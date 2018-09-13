package login.steps;

import static org.assertj.core.api.Assertions.assertThat;

import common.UiCommonUtils;
import common.pages.PaneContent;
import login.pages.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

public class UiLoginSteps {

  private static final String LOGIN_SUCCESS_SCHEMA = "schemas/voucher-login-success-response.json";

  private LoginPage loginPage;

  // Steps of another Steps class called inside this class
  //  @Steps
  //  private UiCommonSteps uiCommonSteps;

  @Step
  public void openLoginPage(Actor actor) {
    actor.attemptsTo(Open.url(UiCommonUtils.getDefaultUrl()));
    UiCommonUtils.waitForLoginPage();
    assertThat(Text.of(LoginPage.LOGIN_PAGE_TITLE).viewedBy(actor).asString())
        .describedAs("Title is not correct")
        .isEqualTo("Login page");
  }

  @Step
  public void userProvidesCredentials(Actor actor, String userName, String userPassword) {
    actor.attemptsTo(
        Enter.theValue(userName).into(LoginPage.USER_NAME_INPUT),
        Enter.theValue(userPassword).into(LoginPage.USER_PASSWORD_INPUT));
  }

  @Step
  public void userCanSeeErrorOnLoginPage(Actor actor) {
    assertThat(Text.of(PaneContent.POP_UP_MESSAGE).viewedBy(actor).asString())
        .describedAs("Title is not correct")
        .isEqualTo("Error message...");
  }

  @Step
  public void userClickLogInButton(Actor actor) {
    actor.attemptsTo(Click.on(LoginPage.USER_LOGIN_BUTTON));
    UiCommonUtils.waitForData();
  }

  @Step
  public void userPressEnterKeyOnLoginPage(Actor actor) {
    LoginPage.USER_PASSWORD_INPUT.resolveFor(actor).submit();
  }

  @Step
  public void userClickLogInButtonAndCheckErrorMessage(final Actor actor) {
    actor.attemptsTo(Click.on(LoginPage.USER_LOGIN_BUTTON));
    assertThat(Text.of(PaneContent.POP_UP_MESSAGE).viewedBy(actor).asString())
        .describedAs("Title is not correct")
        .isEqualTo("Error message...");
  }

  @Step
  public void userCanSeeTransactions(final Actor actor) {
    UiCommonUtils.waitPageIsCompleted(actor, LoginPage.TRANSACTIONS_TABLE_TITLE);
    UiCommonUtils.waitForData();
    // tu bolo volane skontrolovanie ci nabehol prehlad skontrolovanim nadpisu tabulky...
    // tato metoda je implementovana akoby vseobecna ... skontroluj daco co je na kazdej obrazovke
    // rovnake len s inym nadpisom abo podobne
    //    uiCommonSteps.checkTopBarTitle(actor,
    // TransactionTranslations.TRANSACTIONS_PAGE_TITLE.translate());
  }
}
