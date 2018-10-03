package advanced.automation.components.goeuro;


public class BusResults extends Results {

    @Override
    public void synchronize() {
        waitForElement(price, noResultsError);
    }
}
