package advanced.automation.objects.threelayered.goeuro;

import advanced.automation.objects.PageObject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'search_button')]")
    private MobileElement searchButton;

    @Override
    public void synchronize() {
        waitForElement(searchButton);
    }

    public ResultsPage search() {
        searchButton.click();
        return new ResultsPage();
    }
}
