package addToBucketTests.positiveTests;

import baseTest.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import swagLabsSitePages.BucketPage;
import swagLabsSitePages.LoginPage;
import swagLabsSitePages.ProductsPage;
import swagLabsSitePages.ViewOfProductPage;

import static utils.propertyManager.SetUpProperty.getProps;
import static swagLabsSitePages.ViewOfProductPage.rightProductName;

public class AddProductToTheBucket extends AbstractTest {

    @Test
    @DisplayName("Добавление продукта в корзину + проверка добавления")
    void successAddProductToTheBucket() {
        ProductsPage productsPage = new LoginPage()
                .setUserName(getProps("standartLogin"))
                .setPassWord(getProps("password"))
                .navigateToTheProductPage();

        ViewOfProductPage viewOfProductPage = new ProductsPage()
                .clickOnProductSauceLabsBackPack();

        BucketPage bucketPage = new ViewOfProductPage()
                .addProductToTheCart()
                .checkThatProductWasAddedToTheCart(rightProductName);
    }
}
