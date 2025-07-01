package smokeTests.positiveSmokeTests;

import baseTest.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import swagLabsSitePages.*;

import static propertyManager.SetUpProperty.getProps;
import static swagLabsSitePages.CheckoutPage.checkTitleText;
import static swagLabsSitePages.ViewOfProductPage.rightProductName;

public class SuccessfulOrdering extends AbstractTest {
    @Test
    @DisplayName("Успешное оформление заказа на предмет из магазина")
     void successfulOrderingItem() {
        ProductsPage productsPage = new LoginPage()
                .setUserName(getProps("standartLogin"))
                .setPassWord(getProps("password"))
                .navigateToTheProductPage();

        ViewOfProductPage viewOfProductPage = new ProductsPage()
                .clickOnProductSauceLabsBackPack();

        BucketPage bucketPage = new ViewOfProductPage()
                .addProductToTheCart()
                .checkThatProductWasAddedToTheCart(rightProductName);

        CheckoutPage checkoutPage = new BucketPage()
                .navigateToTheCheckoutPage();

        OverviewPage overviewPage = new CheckoutPage()
                .checkThatItsCheckoutPage(checkTitleText)
                .fillingInInformationToSendTheOrder("Den", "Kul", "413003")
                .navigateToTheOverviewPage();

        CompletePage completePage = new OverviewPage()
                .checkTheElementsOfTheOverviewPage(rightProductName, "29.99", "2.40")
                .navigateToTheFinishPage();

        ProductsPage productsPage1 = new CompletePage()
                .checkTheSuccessfulOrdering("Thank you for your order!")
                .backToTheProductsPage();
    }
}
