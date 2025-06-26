package baseTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static propertyManager.SetUpProperty.getProps;

public class AbstractTest {
    @BeforeEach
    void setUpDriver () {
        open((String) getProps("URL"));
    }

    @AfterEach
    void closeBrowser () {
        closeWebDriver();
    }
}
