package advanced.automation.objects.twolayered.goeuro;

import advanced.automation.components.goeuro.BusResults;
import advanced.automation.components.goeuro.Results;
import advanced.automation.objects.PageObject;

public class ResultsPage extends PageObject {
    private Results results;

    @Override
    public void synchronize() {
    }

    public Results busResults() {
        return results.busResults();
    }

    public Results trainResults() {
        return results.busResults();
    }
}
