package advanced.automation.components.sazka;

import advanced.automation.objects.PageObject;
import advanced.automation.objects.threelayered.SportkaHomePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SportkaBanner extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Sportka']")
    private MobileElement sportka;

    @Override
    public void synchronize() {
        waitForElement(sportka);
    }

    public SportkaHomePage sportkaHomePage() {
        sportka.click();
        return new SportkaHomePage();
    }
}
