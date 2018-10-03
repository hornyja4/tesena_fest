package advanced.automation.tests.onelayer;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AlzaTest {
    private AndroidDriver<WebElement> androidDriver;
    private DesiredCapabilities capabilities;

    @BeforeClass
    @Parameters({"udid"})
    public void setupCapabilities(@Optional("MWS0216701000240") String udid) {
        capabilities = DesiredCapabilities.android();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
    }

    @Test
    public void loginToRedmine() throws MalformedURLException {
        androidDriver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        androidDriver.get("http://m.alza.cz");
        androidDriver.findElement(By.xpath("//span[text()='Přihlášení']")).click();
        androidDriver.findElement(By.xpath("//input[@id='loginInput']")).sendKeys("hornyja4");
        androidDriver.findElement(By.xpath("//input[@id='passInput']")).sendKeys("123456");
        androidDriver.findElement(By.xpath("//button[@id='loginBtn']")).click();
    }

    @AfterClass
    public void reset() {
        androidDriver.quit();
    }
}
