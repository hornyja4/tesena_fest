package advanced.automation.objects.threelayered;

import advanced.automation.components.sazka.SportkaBanner;
import advanced.automation.objects.PageObject;

public class HomePage extends PageObject {
    private SportkaBanner sportkaBanner;

    @Override
    public void synchronize() {
    }

    public SportkaHomePage sportka() {
        return sportkaBanner.sportkaHomePage();
    }
}
