package advanced.automation.components.goeuro;

public class TrainResults extends Results {

    @Override
    public void synchronize() {
        waitForElement(price, noResultsError);
    }

}
