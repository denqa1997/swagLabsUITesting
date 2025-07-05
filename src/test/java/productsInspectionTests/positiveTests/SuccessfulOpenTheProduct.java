package productsInspectionTests.positiveTests;

import baseTest.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import swagLabsSitePages.LoginPage;
import swagLabsSitePages.ProductsPage;
import swagLabsSitePages.ViewOfProductPage;

import static utils.propertyManager.SetUpProperty.getProps;

public class SuccessfulOpenTheProduct extends AbstractTest {

    @Test
    @DisplayName("Успешная авторизация в ЛК, клик по продукту, проверка его цены")
    void successfulOpenTheProductAndCheckPrice () {
        ProductsPage productsPage = new LoginPage()
                .setUserName(getProps("standartLogin"))
                .setPassWord(getProps("password"))
                .navigateToTheProductPage();
        ViewOfProductPage viewOfProductPage = new ProductsPage()
                .clickOnProductSauceLabsBackPack()
                .positiveAssertPrice();
    }
}
