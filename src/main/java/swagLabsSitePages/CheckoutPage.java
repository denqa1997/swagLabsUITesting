package swagLabsSitePages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    public static String checkTitleText = "Checkout: Your Information";
    private final SelenideElement
            titleCheckoutPage = $(".title"),
            firstNameField = $("#first-name"),
            lastNameField = $("#last-name"),
            postalCodeField = $("#postal-code"),
            continueButton = $("#continue");

    public CheckoutPage checkThatItsCheckoutPage(String value) {
        titleCheckoutPage.shouldHave(text(value));
        return this;
    }

    public CheckoutPage fillingInInformationToSendTheOrder(String value1, String value2, String value3) {
        firstNameField.setValue(value1);
        lastNameField.setValue(value2);
        postalCodeField.setValue(value3);
        return this;
    }

    public OverviewPage navigateToTheOverviewPage() {
        continueButton.click();
        return new OverviewPage();
    }

}
