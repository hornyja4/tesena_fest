package advanced.automation;

import advanced.automation.driver.Driver;
import advanced.automation.listener.MobileTestListener;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;

@Listeners(MobileTestListener.class)
public class GoEuroTest {

    @BeforeClass
    @Parameters({"udid"})
    public void setupCapabilities(@Optional("MWS0216701000240") String udid) {
        File app = new File("src\\test\\resources\\goEuro.apk");
        DesiredCapabilities capabilities = DesiredCapabilities.android();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability("udid", udid);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        Driver.setCapabilities(capabilities);
    }

    @AfterClass
    public void reset() {
        Driver.quit();
    }
}
