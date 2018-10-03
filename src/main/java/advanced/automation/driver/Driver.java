package advanced.automation.driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Driver {
    private static AndroidDriver<WebElement> androidDriver;
    private static DesiredCapabilities capabilities;
    private static URL server;
    private static boolean webTest = false;

    static {
        try {
            server = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static AndroidDriver<WebElement> getAndroidDriver() {
        if (androidDriver == null) {
            if (server == null) {
                throw new RuntimeException("Could not start android driver. URL of remote server is null.");
            }
            androidDriver = new AndroidDriver<>(server, capabilities);
            androidDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            if (webTest) {
                androidDriver.get("http://m.alza.cz");
            }
        }
        return androidDriver;
    }

    public static void setWebTest(boolean webTest) {
        Driver.webTest = webTest;
    }

    public static DesiredCapabilities getCapabilities() {
        return capabilities;
    }

    public static void setCapabilities(DesiredCapabilities capabilities) {
        Driver.capabilities = capabilities;
    }

    public static void waitForElement(WebElement element, WebElement... orElements) {
        Wait<WebDriver> wait = new WebDriverWait(androidDriver, 20);
        ExpectedCondition<Boolean> expectation = driver -> {
            try {
                if (element.isDisplayed()) {
                    return true;
                }
                for (WebElement webElement: orElements) {
                    if (webElement.isDisplayed()) {
                        return true;
                    }
                }
                return false;
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return false;
            }
        };
        try {
            wait.until(input -> expectation.apply(androidDriver));
        } catch (TimeoutException e) {
            throw new TimeoutException("Timeout exception: Element is not visible after " + 20 + " seconds.", e);
        }
    }

    public static void quit() {
        if (androidDriver != null) {
            androidDriver.quit();
        }
    }
}
