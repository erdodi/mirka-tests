package common;

import com.google.common.base.Function;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.model.TestStep;
import net.thucydides.core.steps.StepEventBus;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UiCommonUtils {
  private static final String[] FORMAT_STRINGS = {
    "M/d/yyyy, h:mm a",
    "M/d/yyyy h:mm a",
    "M/d/yyyy H:mm",
    "d.M.yyyy, H:mm",
    "d.M.yyyy H:mm",
    "d.M.yyyy, h:mm a",
    "d.M.yyyy h:mm a",
    "MMMM d, yyyy",
    "d. MMMM yyyy",
    "d MMMM, yyyy",
    "MMM d, yyyy, h:mm:ss a",
    "MMM d, yyyy h:mm:ss a",
    "MMM d, yyyy H:mm:ss",
    "d. MMM. yyyy, H:mm:ss",
    "d. MMM. yyyy H:mm:ss",
    "MMM d, yyyy",
    "d. MMM yyyy"
  };
  //
  //  public static String simplifyMonetaryAmount(String amount) {
  //    if (UiProperties.LANGUAGE_VERSION.get().equals(Language.DEUTSCH)) {
  //      amount = amount.substring(0, amount.length() - 2);
  //    } else if (UiProperties.LANGUAGE_VERSION.get().equals(Language.ENGLISH)) {
  //      amount = amount.substring(1);
  //    }
  //
  //    amount = amount.replaceAll("[\\s\\,\\.]", "");
  //    amount = amount.replaceFirst("^0+(?!$)", "");
  //    return amount;
  //  }
  //
  //  public static String simplifyNonMonetaryAmount(String amount) {
  //    if (!amount.contains(".")) {
  //      amount = amount.replace(",", "").concat("00");
  //      return amount;
  //    } else if (amount.substring(amount.lastIndexOf(".") + 1).length() == 1) {
  //      amount = amount.replaceAll("[\\s\\,\\.]", "").concat("0");
  //    } else {
  //      amount = amount.replaceAll("[\\s\\,\\.]", "");
  //    }
  //
  //    if (amount.startsWith("0")) {
  //      amount = amount.substring(1);
  //      return amount;
  //    }
  //
  //    return amount;
  //  }
  //
  //  public static String formatValueForInput(String value) {
  //    String language = UiProperties.LANGUAGE_VERSION.get().toString();
  //    value = value.replaceAll("[\\s\\,\\.]", "");
  //
  //    if (value.endsWith("00")) {
  //      return value.substring(0, value.length() - 2);
  //    }
  //
  //    while (value.length() < 3) {
  //      value = new StringBuilder(value).insert(0, "0").toString();
  //    }
  //
  //    switch (language) {
  //      case "English": {
  //        return new StringBuilder(value).insert(value.length() - 2, ".").toString();
  //      }
  //      case "Deutsch": {
  //        return new StringBuilder(value).insert(value.length() - 2, ",").toString();
  //      }
  //      default:
  //        throw new IllegalStateException("Language not supported.");
  //    }
  //  }
  //
  //  public static boolean getBooleanFromString(String expression) {
  //    return expression.equalsIgnoreCase(CommonTranslations.YES.translate());
  //  }
  //
  //  public static String getAnswerByBoolean(String booleanValue) {
  //    if (booleanValue.equals("true")) {
  //      return CommonTranslations.YES.translate();
  //    } else {
  //      return CommonTranslations.NO.translate();
  //    }
  //  }
  //
  //  public static String periodDurationToDisplayedFormat(String periodDuration) {
  //    String dayString;
  //    String monthString;
  //    String yearString;
  //    String result = "";
  //
  //    if (PeriodDuration.parse(periodDuration).period().isPresent()) {
  //      int daysCount = PeriodDuration.parse(periodDuration).period().get().getDays();
  //      int monthsCount = PeriodDuration.parse(periodDuration).period().get().getMonths();
  //      int yearsCount = PeriodDuration.parse(periodDuration).period().get().getYears();
  //
  //      if (yearsCount > 0) {
  //        yearString = String.valueOf(yearsCount) + (yearsCount > 1
  //          ? CommonTranslations.YEARS.translate() : CommonTranslations.YEAR.translate());
  //        result = yearString;
  //      }
  //      if (monthsCount > 0) {
  //        monthString = String.valueOf(monthsCount) + (monthsCount > 1
  //          ? CommonTranslations.MONTHS.translate() : CommonTranslations.MONTH.translate());
  //
  //        if (yearsCount > 0) {
  //          result = result.concat(", ").concat(monthString);
  //        } else {
  //          result = monthString;
  //        }
  //      }
  //      if (daysCount > 0) {
  //        dayString = String.valueOf(daysCount) + (daysCount > 1
  //          ? CommonTranslations.DAYS.translate() : CommonTranslations.DAY.translate());
  //
  //        if (yearsCount > 0 || monthsCount > 0) {
  //          result = result.concat(", ").concat(dayString);
  //        } else {
  //          result = dayString;
  //        }
  //      }
  //
  //    } else {
  //      result = "-";
  //    }
  //    return result;
  //  }
  //
  //  public static Boolean voucherTypeAttributeIsPresent(VoucherTypeResponse voucherTypeResponse,
  //                                                      String attributeName) {
  //    return voucherTypeResponse.getVoucherAttributes().stream().anyMatch(a ->
  // a.getName().equals(attributeName)
  //      && voucherTypeResponse.getVoucherAttributes().stream().filter(b ->
  // b.getName().equals(attributeName)).findAny()
  //      .get().getValue() != null);
  //  }
  //
  //  public static Boolean voucherTypeAttributeIsMandatoryAndEmpty(VoucherTypeResponse
  // voucherTypeResponse,
  //                                                                String attributeName) {
  //    return voucherTypeResponse.getVoucherAttributes().stream().anyMatch(a ->
  // a.getName().equals(attributeName)
  //      && voucherTypeResponse.getVoucherAttributes().stream().filter(b ->
  // b.getName().equals(attributeName)).findAny()
  //      .get().getMandatory() && !voucherTypeAttributeIsPresent(voucherTypeResponse,
  // attributeName));
  //  }
  //
  //  public static String getVoucherTypeAttribute(VoucherTypeResponse voucherTypeResponse,
  //                                               String attributeName) {
  //    return voucherTypeResponse.getVoucherAttributes().stream().filter(e ->
  // e.getName().equals(attributeName)).findFirst().get()
  //      .getValue();
  //  }

  public static List<Target> getTargetListFromFields(Field[] fields, Actor actor) {
    List<Target> list = new ArrayList<>();
    Target targetObject = Target.the("").located(By.className(""));

    try {
      for (Field field : fields) {
        field.setAccessible(true);
        if (!(field.get(targetObject) instanceof Target)) {
          continue;
        }
        Target target = (Target) field.get(targetObject);
        if (target.getName().contains("LABEL") && target.resolveFor(actor).isCurrentlyVisible()) {
          list.add(target);
        }
      }
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    return list;
  }

  /*
   * if you want to click on check-box use this method instead of standard approach actor.attemptsTo(Click.on(target))
   * for click on other web-elements you can use standard approach
   * because IEWebDriver has bug in 64bit version
   * if target is check-box, must be identified it's input element e.g. by xpath
   */
  public static void clickOnTargetWithJavascript(Actor actor, Target target) {
    Point location = target.resolveFor(actor).getLocation();
    int x = location.getX();
    int y = location.getY();
    WebDriver driver = UiProperties.BROWSER;
    String script = String.format("document.elementFromPoint(%d, %d).click();", x, y);

    ((JavascriptExecutor) driver).executeScript(script);
  }

  public static String getLocaleFromLocalStorage(WebDriver driver) {
    return (String)
        ((JavascriptExecutor) driver)
            .executeScript("return window.localStorage.getItem('user.locale');");
  }

  private static void clearLocalStorage(WebDriver driver) {
    ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
  }

  private static void setLocalStorage(WebDriver driver, String locale) {
    ((JavascriptExecutor) driver)
        .executeScript(String.format("window.localStorage.setItem('user.locale', '%s');", locale));
  }
  //
  //  // change local storage if it is needed
  //  public static void changeLocalStorageIfItIsNeeded() {
  //    WebDriver driver = UiProperties.BROWSER;
  //    String language = UiProperties.LANGUAGE_VERSION.get().toString();
  //    switch (language) {
  //      case "English": {
  //        if (compareLocalStorageWithLanguage(driver, "en")) {
  //          clearLocalStorage(driver);
  //          setLocalStorage(driver, "en");
  //          driver.navigate().refresh();
  //        }
  //        break;
  //      }
  //      case "Deutsch": {
  //        if (compareLocalStorageWithLanguage(driver, "de")) {
  //          clearLocalStorage(driver);
  //          setLocalStorage(driver, "de");
  //          driver.navigate().refresh();
  //        }
  //        break;
  //      }
  //      default:
  //        throw new IllegalStateException("Language not supported.");
  //    }
  //  }

  public static void waitForLoginPage() {
    WebDriver driver = UiProperties.BROWSER;
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(
        ExpectedConditions.not(
            ExpectedConditions.textToBe(By.className("qa_login_page_title"), "")));
  }

  public static void waitPageIsCompleted(Actor actor, Target target) {
    WebDriver driver = UiProperties.BROWSER;
    WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
    webDriverWait.until(
        (Function<WebDriver, Boolean>)
            input ->
                ((JavascriptExecutor) driver)
                    .executeScript("return document.readyState")
                    .equals("complete"));
    UiCommonUtils.waitForElement(target, actor);
  }

  public static void waitForElement(Target target, Actor actor) {
    WebDriver driver = UiProperties.BROWSER;
    WebElementFacade element = target.resolveFor(actor);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public static void waitUntilTitleIsNotEmpty(Target target, Actor actor) {
    WebDriver driver = UiProperties.BROWSER;
    //    WebElementFacade element = target.resolveFor(actor);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    //
    // wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementValue(element,
    // "")));
    wait.until(
        ExpectedConditions.textMatches(By.className("qa_top_bar_title"), Pattern.compile("\\s*")));
  }

  public static void waitUntilElementDisappears(By locator) {
    WebDriver driver = UiProperties.BROWSER;
    WebDriverWait wait = new WebDriverWait(driver, 120);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
  }

  public static void waitForData() {
    WebDriver driver = UiProperties.BROWSER;
    WebDriverWait wait = new WebDriverWait(driver, 60);

    try {
      wait.until(
          ExpectedConditions.and(
              ExpectedConditions.invisibilityOfElementLocated(
                  By.className("ui-datatable-emptymessage")),
              ExpectedConditions.invisibilityOfElementLocated(By.className("ui-blockui"))
              //
              // ExpectedConditions.not(ExpectedConditions.attributeContains(By.className("block-ui"), "class", "enabled"))
              ));
    } catch (TimeoutException e) {
      e.printStackTrace();
    }
  }
  //
  //  public static String formatVoucherTypeVersionId(Integer id) {
  //    return String.format("%04d", id);
  //  }
  //
  //  public static String formatVoucherTypeLastChangeDate(String displayedValueAsPattern,
  // ZonedDateTime lastChange) {
  //    if (UiProperties.LANGUAGE_VERSION.get().toString().equals("English")) {
  //      displayedValueAsPattern = displayedValueAsPattern.replace("Last change: ", "");
  //    } else {
  //      displayedValueAsPattern = displayedValueAsPattern.replace("Zuletzt bearbeitet: ", "");
  //    }
  //
  //    String pattern = getPattern(displayedValueAsPattern);
  //    return lastChange.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime()
  //      .format(DateTimeFormatter.ofPattern(pattern));
  //  }

  public static String formatDateToDisplayedValue(
      Target displayedValueAsPattern, ZonedDateTime date) {
    Actor actor = UiProperties.USER;
    String displayedText = Text.of(displayedValueAsPattern).viewedBy(actor).asString();
    String pattern = getPattern(displayedText);

    switch (UiProperties.LANGUAGE_VERSION.toString()) {
      case "English":
        return date.withZoneSameInstant(ZoneId.systemDefault())
            .format(DateTimeFormatter.ofPattern(pattern).withLocale(Locale.ENGLISH));
      case "Deutsch":
        return date.withZoneSameInstant(ZoneId.systemDefault())
            .format(DateTimeFormatter.ofPattern(pattern).withLocale(Locale.GERMANY));
      default:
        return "Not supported language";
    }
  }

  public static String getPattern(String dateAsPattern) {
    Locale locale;
    //    dateAsPattern = removeUnnecessaryZerosFromDate(dateAsPattern);

    switch (UiProperties.LANGUAGE_VERSION.toString()) {
      case "English":
        locale = Locale.ENGLISH;
        break;
      case "Deutsch":
        locale = Locale.GERMANY;
        break;
      default:
        throw new IllegalArgumentException();
    }

    for (String parse : FORMAT_STRINGS) {
      try {
        ZonedDateTime.parse(
            dateAsPattern,
            DateTimeFormatter.ofPattern(parse, locale).withZone(ZoneId.systemDefault()));
        return parse;
      } catch (DateTimeParseException e) {
        try {
          System.out.println("Failed with ZonedDateTime.parse by parser " + parse);
          LocalDate.parse(
              dateAsPattern,
              DateTimeFormatter.ofPattern(parse, locale).withZone(ZoneId.systemDefault()));
          return parse;
        } catch (DateTimeParseException e1) {
          System.out.println("Failed with LocalDate.parse by parser " + parse);
        }
      }
    }

    throw new DateTimeParseException(
        "This string can't be parsed: ".concat(dateAsPattern), dateAsPattern, 0);
  }

  public static String removeUnnecessaryZerosFromDate(String date) {
    StringBuilder stringBuilder = new StringBuilder(date);
    Character indexZero = date.charAt(0);
    Character indexThree = date.charAt(3);
    int indexComma = date.indexOf(',');
    int indexOfColon = date.indexOf(':');

    if (indexZero.equals('0')) {
      stringBuilder.deleteCharAt(0);
    }
    if (indexThree.equals('0')) {
      stringBuilder.deleteCharAt(3);
    }
    if (indexOfColon >= 0) {
      Character indexOfZeroInTime = date.charAt(indexOfColon - 2);
      if (indexOfZeroInTime.equals('0')) {
        stringBuilder.deleteCharAt(indexOfColon - 2);
      }
    }
    if (indexComma >= 0) {
      Character indexOfZeroInDate = date.charAt(indexComma - 2);
      if (indexOfZeroInDate.equals('0')) {
        stringBuilder.deleteCharAt(indexComma - 2);
      }
    }
    return stringBuilder.toString();
  }

  public static ZonedDateTime createLocalDateTimeFromDisplayedValue(String date) {

    return ZonedDateTime.parse(
        date, DateTimeFormatter.ofPattern(getPattern(date)).withZone(ZoneId.systemDefault()));
  }

  public static String formatDateToDisplayedValueInCalendarInputField(ZonedDateTime date) {
    switch (UiProperties.LANGUAGE_VERSION.toString()) {
      case "English":
        return date.format(DateTimeFormatter.ofPattern("MMMM d, yyyy").withLocale(Locale.ENGLISH));
      case "Deutsch":
        return date.format(DateTimeFormatter.ofPattern("d. MMMM yyyy").withLocale(Locale.GERMANY));
      default:
        return "Not supported language";
    }

    //    int day = date.getDayOfMonth();
    //    Month month = date.getMonth();
    //    int year = date.getYear();
    //
    //    switch (month) {
    //      case JANUARY:
    //        return prepareValueForCalendar(day, MonthsShortFormatTranslations.JANUARY.translate(),
    // year);
    //      case FEBRUARY:
    //        return prepareValueForCalendar(day,
    // MonthsShortFormatTranslations.FEBRUARY.translate(), year);
    //      case MARCH:
    //        return prepareValueForCalendar(day, MonthsShortFormatTranslations.MARCH.translate(),
    // year);
    //      case APRIL:
    //        return prepareValueForCalendar(day, MonthsShortFormatTranslations.APRIL.translate(),
    // year);
    //      case MAY:
    //        return prepareValueForCalendar(day, MonthsShortFormatTranslations.MAY.translate(),
    // year);
    //      case JUNE:
    //        return prepareValueForCalendar(day, MonthsShortFormatTranslations.JUNE.translate(),
    // year);
    //      case JULY:
    //        return prepareValueForCalendar(day, MonthsShortFormatTranslations.JULY.translate(),
    // year);
    //      case AUGUST:
    //        return prepareValueForCalendar(day, MonthsShortFormatTranslations.AUGUST.translate(),
    // year);
    //      case SEPTEMBER:
    //        return prepareValueForCalendar(day,
    // MonthsShortFormatTranslations.SEPTEMBER.translate(), year);
    //      case OCTOBER:
    //        return prepareValueForCalendar(day, MonthsShortFormatTranslations.OCTOBER.translate(),
    // year);
    //      case NOVEMBER:
    //        return prepareValueForCalendar(day,
    // MonthsShortFormatTranslations.NOVEMBER.translate(), year);
    //      case DECEMBER:
    //        return prepareValueForCalendar(day,
    // MonthsShortFormatTranslations.DECEMBER.translate(), year);
    //      default:
    //        return "Not supported month";
    //    }
  }

  private static String prepareValueForCalendar(int day, String month, int year) {
    switch (UiProperties.LANGUAGE_VERSION.toString()) {
      case "English":
        return month
            .concat(" ")
            .concat(String.valueOf(day))
            .concat(", ")
            .concat(String.valueOf(year));
      case "Deutsch":
        return String.valueOf(day)
            .concat(". ")
            .concat(month)
            .concat(" ")
            .concat(String.valueOf(year));
      default:
        return "Not supported language";
    }
  }

  public static LocalDate createDateFromString(String date) {
    String pattern = getPattern(date);
    return LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
  }

  public static String getDefaultUrl() {
    if (Boolean.valueOf(System.getProperty("localhost"))) {
      return "http://localhost:4200";
    }
    return UiProperties.URL;
  }

  public static String generateBsBuildName() {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("d.M.yyyy HH:mm:SS"));
  }

  public String getRandomString() {
    return RandomStringUtils.randomAlphanumeric(15);
  }

  public static Integer getExampleNumberFromDescription(Integer testRun) {
    String description = "";
    try {
      List<TestStep> testSteps =
          StepEventBus.getEventBus()
              .getBaseStepListener()
              .getTestOutcomes()
              .get(testRun)
              .getTestSteps();
      description = testSteps.get(testSteps.size() - 1).getDescription();
      int indexHash = description.indexOf("#");
      description = description.substring(indexHash + 1);
      int indexSpace = description.indexOf(" ");
      description = description.substring(0, indexSpace - 1);
      return Integer.valueOf(description);
    } catch (Exception e) {
      System.out.println("Getting example number for scenario outline failed");
    }
    return Integer.valueOf(description);
  }
}
