package swagLabsSitePages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private static final String ERROR_MESSAGE = "Epic sadface: Username and password do not match any user in this service";
    private final SelenideElement
            userNameField = $("#user-name"),
            passWordField = $("#password"),
            loginButton = $("#login-button"),
        errorMessage = $x("//button[@class='error-button']/parent::h3");


    public LoginPage setUserName(Object value) {
        userNameField.setValue(String.valueOf(value));
        return this;
    }

    public LoginPage setPassWord(Object value) {
        passWordField.setValue(String.valueOf(value));
        return this;
    }

    public LoginPage clickOnTheLoginButton() {
        loginButton.click();
        return this;
    }

    public LoginPage checkMessageWithUnsuccessfullyAuthorization () {
        errorMessage.shouldHave(text(ERROR_MESSAGE));
        return this;
    }



    public ProductsPage navigateToTheProductPage () {
        loginButton.submit();
        return new ProductsPage();
    }
}
