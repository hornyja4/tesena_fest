package advanced.automation.objects.twolayered.alza;

import advanced.automation.objects.PageObject;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id = "loginInput")
    private MobileElement username;

    @FindBy(id = "passInput")
    private MobileElement password;

    @FindBy(id = "loginBtn")
    private MobileElement submitButton;

    @Override
    public void synchronize() {
        waitForElement(username);
    }

    public HomePage login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submitButton.click();
        return new HomePage();
    }
}
