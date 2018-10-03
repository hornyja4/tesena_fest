package advanced.automation.tests.onelayer;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SazkaTest {
    private DesiredCapabilities capabilities;
    private AndroidDriver<MobileElement> androidDriver;

    @BeforeClass
    @Parameters({"udid", "automationName"})
    public void setupCapabilities(@Optional("MWS0216701000240") String udid, @Optional("UIAutomator2") String automationName) {
        File app = new File("src\\test\\resources\\sazka.apk");
        capabilities = DesiredCapabilities.android();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability("udid", udid);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
    }

    @Test
    public void installGoEuroAppAndSearch() throws MalformedURLException, InterruptedException {
        androidDriver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        androidDriver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='SportkaBanner']")).click();
        androidDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'buttonMakeABet')]")).click();
        synchronized (androidDriver) {
            androidDriver.wait(5000);
        }
    }

    @AfterClass
    public void reset() {
        androidDriver.quit();
    }
}
