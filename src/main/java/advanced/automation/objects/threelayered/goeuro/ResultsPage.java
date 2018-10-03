package advanced.automation.objects.threelayered.goeuro;

import advanced.automation.components.goeuro.Results;
import advanced.automation.objects.PageObject;

public class ResultsPage extends PageObject {
    private Results results;

    @Override
    public void synchronize() {
    }

    public Results results() {
        return results;
    }
}
