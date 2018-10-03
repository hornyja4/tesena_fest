package advanced.automation.tests.twolayered;
import advanced.automation.objects.twolayered.goeuro.HomePage;
import org.testng.annotations.Test;

public class GoEuroTest extends advanced.automation.GoEuroTest {

    @Test
    public void installGoEuroAppAndSearch() {
        HomePage homePage = new HomePage();
        homePage.search()
                .busResults();
    }

}
