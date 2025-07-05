package addToBucketTests.negativeTests;

import baseTest.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import swagLabsSitePages.BucketPage;
import swagLabsSitePages.LoginPage;
import swagLabsSitePages.ProductsPage;
import swagLabsSitePages.ViewOfProductPage;

import static utils.propertyManager.SetUpProperty.getProps;
import static swagLabsSitePages.ViewOfProductPage.wrongProductName;

public class NegativeAddProductToTheBucket extends AbstractTest {

    @Test
    @DisplayName("Проверка что в корзину добавили не тот продукт, который ожидаем")
    void successAddProductToTheBucket() {
        ProductsPage productsPage = new LoginPage()
                .setUserName(getProps("standartLogin"))
                .setPassWord(getProps("password"))
                .navigateToTheProductPage();

        ViewOfProductPage viewOfProductPage = new ProductsPage()
                .clickOnProductSauceLabsBackPack();

        BucketPage bucketPage = new ViewOfProductPage()
                .addProductToTheCart()
                .checkThatProductWasAddedToTheCart(wrongProductName);
    }
}


