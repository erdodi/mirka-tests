package com.wirecard.vas.test.voucher.ui.login.steps;

import com.wirecard.vas.test.voucher.domain.common.types.StatusCode;
import com.wirecard.vas.test.voucher.ui.common.pages.PaneContent;
import com.wirecard.vas.test.voucher.ui.common.steps.UiCommonSteps;
import com.wirecard.vas.test.voucher.ui.common.translations.CommonTranslations;
import com.wirecard.vas.test.voucher.ui.common.translations.TransactionTranslations;
import com.wirecard.vas.test.voucher.ui.login.pages.LoginPage;
import com.wirecard.vas.test.voucher.ui.transactions.pages.TransactionsPage;
import com.wirecard.vas.test.voucher.config.session.variable.SessionVariable;
import com.wirecard.vas.test.voucher.domain.RestClients.VoucherRestClient;
import com.wirecard.vas.test.voucher.domain.common.response.LoginResponse;
import com.wirecard.vas.test.voucher.domain.common.types.VoucherPath;
import com.wirecard.vas.test.voucher.config.Bootstrap;
import com.wirecard.vas.test.voucher.config.types.UserRole;
import com.wirecard.vas.test.voucher.ui.common.UiCommonUtils;
import com.wirecard.vas.test.voucher.ui.settings.steps.UiSettingsSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.apache.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class UiLoginSteps {

  private static final String LOGIN_SUCCESS_SCHEMA = "schemas/voucher-login-success-response.json";

  private LoginPage loginPage;

  @Steps
  private UiSettingsSteps uiSettingsSteps;
  @Steps
  private UiCommonSteps uiCommonSteps;

  @Step
  public void openLoginPage(Actor actor) {
    actor.attemptsTo(Open.url(UiCommonUtils.getDefaultUrl()));
    UiCommonUtils.waitForLoginPage();
    UiCommonUtils.changeLocalStorageIfItIsNeeded();
    UiCommonUtils.waitForLoginPage();
    assertThat(Text.of(LoginPage.LOGIN_PAGE_TITLE).viewedBy(actor).asString()).describedAs("Title is not correct")
      .isEqualTo(CommonTranslations.LOGIN_PAGE_TITLE.translate());
  }

  @Step
  public void userProvidesCredentials(Actor actor, String userName, String userPassword) {
    actor.attemptsTo(
      Enter.theValue(userName).into(LoginPage.USER_NAME_INPUT),
      Enter.theValue(userPassword).into(LoginPage.USER_PASSWORD_INPUT)
    );
  }

  @Step
  public void userCanSeeErrorOnLoginPage(Actor actor) {
    assertThat(Text.of(PaneContent.POP_UP_MESSAGE).viewedBy(actor).asString()).describedAs("Title is not correct")
      .isEqualTo(CommonTranslations.LOGIN_PAGE_ERROR_MESSAGE.translate());
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

  public void userIsLoggedInAsRoleByJwt(Actor actor, UserRole userRole) {
    String userNameByRole = Bootstrap.getConfig().getUsersCredentials().getUserCredentialsByName(userRole).getUsername();
    String userPasswordByRole = Bootstrap.getConfig().getUsersCredentials().getUserCredentialsByName(userRole).getPassword();
    SessionVariable.USERNAME.set(userNameByRole);
    SessionVariable.PASSWORD.set(userPasswordByRole);

    Boolean localhost = Boolean.valueOf(System.getProperty("localhost"));

    if (localhost) {
      openLoginPage(actor);
      userProvidesCredentials(actor, userNameByRole, userPasswordByRole);
      userPressEnterKeyOnLoginPage(actor);
    } else {
      VoucherRestClient.request();
      VoucherRestClient.setBasicAuth();
      VoucherRestClient.get(VoucherPath.VOUCHER_TOKEN_PATH.getPath(), SessionVariable.BRAND_NAME.get().toString());

      final LoginResponse success =
        VoucherRestClient.validateAndExtractResponse(StatusCode.OK, LOGIN_SUCCESS_SCHEMA, LoginResponse.class);
      actor.attemptsTo(Open.url(success.getRedirectUri().toString()));
      UiCommonUtils.changeLocalStorageIfItIsNeeded();
    }
    userCanSeeTransactions(actor);
  }

  @Step
  public void userClickLogInButtonAndCheckErrorMessage(final Actor actor) {
    actor.attemptsTo(Click.on(LoginPage.USER_LOGIN_BUTTON));
    assertThat(Text.of(PaneContent.POP_UP_MESSAGE).viewedBy(actor).asString()).describedAs("Title is not correct")
      .isEqualTo(CommonTranslations.LOGIN_PAGE_ERROR_MESSAGE.translate());
  }

  @Step
  public void userCanSeeTransactions(final Actor actor) {
    UiCommonUtils.waitPageIsCompleted(actor, TransactionsPage.APP_TRANSACTION_LIST);
    UiCommonUtils.waitForData();
    uiCommonSteps.checkTopBarTitle(actor, TransactionTranslations.TRANSACTIONS_PAGE_TITLE.translate());
  }
}
