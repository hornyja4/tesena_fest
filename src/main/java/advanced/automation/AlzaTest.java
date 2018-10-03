package advanced.automation;

import advanced.automation.driver.Driver;
import advanced.automation.listener.MobileTestListener;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

@Listeners(MobileTestListener.class)
public class AlzaTest {

    @BeforeClass
    @Parameters({"udid"})
    public void setupCapabilities(@Optional("MWS0216701000240") String udid) {
        DesiredCapabilities capabilities = DesiredCapabilities.android();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        Driver.setCapabilities(capabilities);
        Driver.setWebTest(true);
    }

    @AfterClass
    public void reset() {
        Driver.quit();
    }
}
