package advanced.automation.objects.twolayered.sazka;

import advanced.automation.objects.PageObject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SportkaBetTypePage extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'buttonFillBet')]")
    private MobileElement newBet;

    @Override
    public void synchronize() {
        waitForElement(newBet);
    }
}
