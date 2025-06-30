package swagLabsSitePages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {
    private final SelenideElement sauceLabsBackpack = $x("//div[contains(text(), 'Sauce Labs Backpack')]");

    public ViewOfProductPage clickOnProductSauceLabsBackPack() {
        sauceLabsBackpack.click();
        return new ViewOfProductPage();
    }
}
