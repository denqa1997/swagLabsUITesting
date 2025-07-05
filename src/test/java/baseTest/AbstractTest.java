package baseTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;
import static utils.CommonActions.clearDirectories;
import static utils.propertyManager.SetUpProperty.getProps;

public class AbstractTest {
    @BeforeAll
    static void configureBrowser() {
        SelenideLogger.addListener("allure-selenide", new AllureSelenide());
        ChromeOptions options = new ChromeOptions()
                .addArguments(
                        "--incognito",
                        "--disable-dev-shm-usage",
                        "--disable-popup-blocking",
                        "--disable-infobars"
                );
        Configuration.browserCapabilities = options;
        clearDirectories();
    }
    @BeforeEach
    void setUpDriver() {
        open((String) getProps("URL"));
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }
    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }
}
