package common.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/** Created by milos.lukac on 12/9/2016. */
public class PaneContent extends PageObject {

  public static Target POP_UP_TITLE =
      Target.the("Pop up title").located(By.className("qa_dialog_title"));

  public static Target POP_UP_PLACEHOLDER =
      Target.the("Pop up placeholder").located(By.className("qa_confirmation_dialog_input"));

  public static Target POP_UP_DIALOG_LABEL =
      Target.the("Pop up dialog input label")
          .located(By.xpath(".//p-dialog[contains(@class, 'qa_confirmation_dialog ')]//label"));

  public static Target POP_UP_CONFIRM_MESSAGE =
      Target.the("Pop up message").located(By.className("ui-confirmdialog-message"));

  public static Target POP_UP_BUTTON_CONFIRM =
      Target.the("Pop up button confirmation").located(By.className("qa_dialog_button_confirm"));

  public static Target POP_UP_BUTTON_BACK =
      Target.the("Pop up button back").located(By.className("qa_dialog_button_back"));

  public static Target POP_UP_DIALOG_BUTTON_PRIMARY =
      Target.the("Dialog button")
          .located(By.xpath(".//p-footer/button[contains(@class, 'primary')]"));

  public static Target POP_UP_DIALOG_BUTTON_SECONDARY =
      Target.the("Dialog button")
          .located(By.xpath(".//p-footer/button[contains(@class, 'secondary')]"));

  public static Target POP_UP_MESSAGE =
      Target.the("Pop up message").located(By.className("ui-growl-message"));

  public static Target DATATABLE_EMPTY_MESSAGE =
      Target.the("Datatable mepty message").located(By.className("ui-datatable-emptymessage"));

  public static Target NEXT_BUTTON =
      Target.the("Next button")
          .located(By.xpath(".//*[contains(@class, 'wizard-navigation-buttons')]/button[2]"));

  public static Target PAGINATION =
      Target.the("Pagination").located(By.className("ui-paginator-bottom"));

  public static Target PAGE_INFO = Target.the("Page info").located(By.className("qa_table_info"));

  public static final Target PAGINATION_DROPDOWN =
      Target.the("Pagination dropdown")
          .located(
              By.xpath(
                  ".//*[contains(@class, 'ui-paginator-bottom')]//div[contains(@class, 'ui-dropdown-trigger')]"));

  public static final Target PAGINATION_ITEM =
      Target.the("Pagination info")
          .located(
              By.xpath(
                  ".//*[contains(@class, 'ui-paginator-bottom')]//div[contains(@class, 'ui-dropdown-panel')]//li"));

  public static final Target NEXT_PAGE =
      Target.the("Next page").located(By.className("ui-paginator-next"));

  public static final Target NEXT_PAGE_DISABLED =
      Target.the("Next page disabled")
          .located(
              By.xpath(
                  ".//*[contains(@class,'ui-paginator-next') and contains(@class,'ui-state-disabled')]"));

  public static final Target FIRST_PAGE =
      Target.the("First page button").located(By.className("ui-paginator-first"));

  public static final Target FIRST_PAGE_DISABLED =
      Target.the("First page disabled")
          .located(
              By.xpath(
                  ".//*[contains(@class,'ui-paginator-first') and contains(@class,'ui-state-disabled')]"));

  public static Target VOUCHER_TYPE_SEARCH_FIELD =
      Target.the("Search field").located(By.className("qa_search_voucher_type_input"));

  public static Target RECORDS_PER_PAGE_SELECT =
      Target.the("Select records per page")
          .located(
              By.xpath(
                  ".//*[contains(@class, 'ui-paginator-bottom')]/p-dropdown//div[contains(@class, 'ui-dropdown-trigger')]"));

  public static Target LOSE_FOCUS =
      Target.the("Lose focus").located(By.className("qa_top_bar_title"));

  public static Target VALID_FROM_DATEPICKER_TRIGGER =
      Target.the("Valid since datepicker trigger")
          .located(
              By.xpath(
                  ".//app-calendar[contains(@class, 'qa_valid_from_input')]/p-calendar/span/button[contains(@class, 'ui-datepicker-trigger')]"));

  public static Target VALID_UNTIL_DATEPICKER_TRIGGER =
      Target.the("Valid since datepicker trigger")
          .located(
              By.xpath(
                  ".//app-calendar[contains(@class, 'qa_valid_until_input')]/p-calendar/span/button[contains(@class, 'ui-datepicker-trigger')]"));
}
