package baseTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;
import static propertyManager.SetUpProperty.getProps;
import static utils.CommonActions.clearDirectories;

public class AbstractTest {

    @BeforeAll
    static void configureBrowser() {
        ChromeOptions options = new ChromeOptions()
                .addArguments(
                        "--incognito",
                        "--disable-dev-shm-usage",
                        "--start-fullscreen",
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
