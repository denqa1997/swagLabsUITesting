package authorizationTests.positiveTests;

import baseTest.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import swagLabsSitePages.LoginPage;
import swagLabsSitePages.ProductsPage;

import static utils.propertyManager.SetUpProperty.getProps;

public class PositiveAuthorizationSwagLabsTests extends AbstractTest {

    @DisplayName("Успешная авторизация в личном кабинете сайта - Swag Labs под разными типами логинов")
    @ParameterizedTest
    @MethodSource("testData.TestDataLoginPage#provideArguments")
    void authorizationInSwagLabsByDifferentTypeOfUsers (Object typeOfLogin) {
        ProductsPage productsPage = new LoginPage()
                .setUserName(typeOfLogin)
                .setPassWord(getProps("password"))
                .navigateToTheProductPage();
    }
}
