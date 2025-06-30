package addToBucketTests.positiveTests;

import baseTest.AbstractTest;
import org.junit.jupiter.api.Test;
import swagLabsSitePages.BucketPage;
import swagLabsSitePages.LoginPage;
import swagLabsSitePages.ProductsPage;
import swagLabsSitePages.ViewOfProductPage;

import static propertyManager.SetUpProperty.getProps;

public class AddProductToTheBucket extends AbstractTest {

    @Test
    void successAddProductToTheBucket() {
        ProductsPage productsPage = new LoginPage()
                .setUserName(getProps("standartLogin"))
                .setPassWord(getProps("password"))
                .navigateToTheProductPage();

        ViewOfProductPage viewOfProductPage = new ProductsPage()
                .clickOnProductSauceLabsBackPack();

        BucketPage bucketPage = new ViewOfProductPage()
                .addProductToTheCart()
                .checkThatProductWasAddedToTheCart();
    }
}
