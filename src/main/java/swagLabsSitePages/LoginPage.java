package swagLabsSitePages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement
            userNameField = $("#user-name"),
            passWordField = $("#password"),
            loginButton = $("#login-button");


    public LoginPage setUserName(Object value) {
        userNameField.setValue(String.valueOf(value));
        return this;
    }

    public LoginPage setPassWord(Object value) {
        passWordField.setValue(String.valueOf(value));
        return this;
    }

    public ProductsPage navigateToTheProductPage () {
        loginButton.submit();
        return new ProductsPage();
    }
}
