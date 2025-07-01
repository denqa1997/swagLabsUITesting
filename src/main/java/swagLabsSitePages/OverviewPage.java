package swagLabsSitePages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class OverviewPage {
    private final SelenideElement
            finalButton = $("#finish"),
            inventoryItemName = $(".inventory_item_name"),
            summarySubtotalLabel = $(".summary_subtotal_label"),
            summaryTaxLabel = $(".summary_tax_label");


    public OverviewPage checkTheElementsOfTheOverviewPage(String value1, String value2, String value3) {
        inventoryItemName.shouldHave(text(value1));
        summarySubtotalLabel.shouldHave(text(value2));
        summaryTaxLabel.shouldHave(text(value3));
        return this;
    }

    public CompletePage navigateToTheFinishPage() {
        finalButton.click();
        return new CompletePage();
    }
}
