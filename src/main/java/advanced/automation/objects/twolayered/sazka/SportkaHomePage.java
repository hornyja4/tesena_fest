package advanced.automation.objects.twolayered.sazka;

import advanced.automation.objects.PageObject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SportkaHomePage extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'buttonMakeABet')]")
    private MobileElement betButton;

    @Override
    public void synchronize() {
        waitForElement(betButton);
    }

    public SportkaBetTypePage onlineBet() {
        betButton.click();
        return new SportkaBetTypePage();
    }
}
