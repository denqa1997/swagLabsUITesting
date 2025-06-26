package authorizationTests;

import baseTest.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import swagLabsSitePages.LoginPage;
import swagLabsSitePages.ProductsPage;

import static propertyManager.SetUpProperty.getProps;

public class AuthorizationSwagLabsTests extends AbstractTest {

    @DisplayName("Авторизация в личном кабинете сайта - Swag Labs")
    @ParameterizedTest
    @MethodSource("testData.TestDataLoginPage#provideArguments")
    void authorizationInSwagLabsByDifferentTypeOfUsers (Object typeOfLogin) {
        ProductsPage productsPage = new LoginPage()
                .setUserName(typeOfLogin)
                .setPassWord(getProps("password"))
                .navigateToTheProductPage();
    }
}
