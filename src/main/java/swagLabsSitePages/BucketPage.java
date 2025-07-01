package swagLabsSitePages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BucketPage {
private final SelenideElement
        checkoutButton = $("#checkout");

    public CheckoutPage navigateToTheCheckoutPage() {
        checkoutButton.click();
        return new CheckoutPage();

    }
}
