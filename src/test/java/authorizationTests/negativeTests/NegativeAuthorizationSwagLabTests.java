package authorizationTests.negativeTests;

import baseTest.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import swagLabsSitePages.LoginPage;

import static utils.propertyManager.SetUpProperty.getProps;

public class NegativeAuthorizationSwagLabTests extends AbstractTest {

    @DisplayName("Неуспешная авторизация в личном кабинете сайта - Swag Labs под разными типами логинов")
    @ParameterizedTest
    @MethodSource("testData.TestDataLoginPage#provideArguments")
    void authorizationInSwagLabsByDifferentTypeOfUsers (Object typeOfLogin) {

        LoginPage loginPage = new LoginPage()
                .setUserName(typeOfLogin)
                .setPassWord(getProps("badPassword"))
                .clickOnTheLoginButton()
                .checkMessageWithUnsuccessfullyAuthorization();
    }
}

