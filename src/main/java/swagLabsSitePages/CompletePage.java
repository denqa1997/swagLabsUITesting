package swagLabsSitePages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CompletePage {
    private final SelenideElement
            headerText = $(".complete-header"),
            backToProductsButton = $("#back-to-products");

    public CompletePage checkTheSuccessfulOrdering(String value) {
        headerText.shouldHave(text(value));
        return this;
    }

    public ProductsPage backToTheProductsPage() {
        backToProductsButton.click();
        return new ProductsPage();
    }
}
