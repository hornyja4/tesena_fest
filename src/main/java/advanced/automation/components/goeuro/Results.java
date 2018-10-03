package advanced.automation.components.goeuro;

import advanced.automation.objects.PageObject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Results extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@content-desc='bus']")
    private MobileElement busResults;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@content-desc='train']")
    private MobileElement trainResults;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id, 'error_root_layout')]")
    protected MobileElement noResultsError;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'price')]")
    protected MobileElement price;

    public Results busResults() {
        busResults.click();
        return new BusResults();
    }

    public Results trainResults() {
        trainResults.click();
        return new TrainResults();
    }

    @Override
    public void synchronize() {
        waitForElement(price, noResultsError);
    }
}
