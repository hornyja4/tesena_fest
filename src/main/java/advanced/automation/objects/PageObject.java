package advanced.automation.objects;

import advanced.automation.driver.Driver;
import advanced.automation.factory.Factory;
import advanced.automation.logger.MobileLogger;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public abstract class PageObject {
    public static Logger LOG = MobileLogger.getLogger();
    protected AndroidDriver<WebElement> driver = Driver.getAndroidDriver();

    public PageObject() {
        Factory.initElements(this);
        Factory.processPageObjectComponents(this);
        synchronize();
    }

    public abstract void synchronize();

    protected void waitForElement(WebElement element, WebElement... orElements) {
        Driver.waitForElement(element, orElements);
    }
}
