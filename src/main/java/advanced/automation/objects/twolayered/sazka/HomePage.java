package advanced.automation.objects.twolayered.sazka;

import advanced.automation.objects.PageObject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='SportkaBanner']")
    private MobileElement sportka;

    @Override
    public void synchronize() {
        waitForElement(sportka);
    }

    public SportkaHomePage sportka() {
        sportka.click();
        return new SportkaHomePage();
    }
}
