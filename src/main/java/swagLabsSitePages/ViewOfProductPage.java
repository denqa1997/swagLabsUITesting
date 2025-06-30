package swagLabsSitePages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ViewOfProductPage {
    public static final String
            sauceLabsBackpackPrice = "$29.99",
            wrongSauceLabsBackpackPrice = "$30.00",
            productName = "Sauce Labs Backpack";
    private final SelenideElement
            priceSelector = $(".inventory_details_price"),
            addToCartButton = $("#add-to-cart"),
            removeButton = $("#remove"),
            shoppingCartBadge = $(".shopping_cart_badge"),
            shoppingCartLink = $(".shopping_cart_link"),
            inventoryItemName = $(".inventory_item_name"),
            inventoryItemPrice = $(".inventory_item_price");

    public ViewOfProductPage positiveAssertPrice() {
        Assertions.assertEquals(sauceLabsBackpackPrice, priceSelector.getText());
        return this;
    }

    public ViewOfProductPage negativeAssertPrice() {
        Assertions.assertEquals(wrongSauceLabsBackpackPrice, priceSelector.getText());
        return this;
    }

    public ViewOfProductPage addProductToTheCart() {
        addToCartButton.click();
        return this;
    }

    public BucketPage checkThatProductWasAddedToTheCart() {
        removeButton.shouldBe(visible);
        shoppingCartBadge.shouldHave(text("1"));
        shoppingCartLink.click();
        inventoryItemName.shouldHave(text(productName));
        inventoryItemPrice.shouldHave(text(sauceLabsBackpackPrice));
        return new BucketPage();
    }
}
