package advanced.automation.objects.twolayered.alza;

import advanced.automation.objects.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlzaPage extends PageObject {

    @FindBy(xpath = "//span[text()='Přihlášení']")
    private WebElement loginButton;

    @Override
    public void synchronize() {
        waitForElement(loginButton);
    }

    public LoginPage clickToLogin() {
        loginButton.click();
        return new LoginPage();
    }
}
