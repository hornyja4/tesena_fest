package advanced.automation.tests.threelayered;

import advanced.automation.objects.threelayered.goeuro.HomePage;
import org.testng.annotations.Test;

public class GoEuroTest extends advanced.automation.GoEuroTest {

    @Test
    public void installGoEuroAppAndSearch() {
        HomePage homePage = new HomePage();
        homePage.search()
                .results()
                .busResults()
                .trainResults();
    }
}
