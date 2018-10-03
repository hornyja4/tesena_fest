package advanced.automation.tests.twolayered;

import advanced.automation.objects.twolayered.sazka.HomePage;
import org.testng.annotations.Test;

public class SazkaTest extends advanced.automation.SazkaTest {

    @Test
    public void sportkaTest() {
        HomePage homePage = new HomePage();
        homePage.sportka()
                .onlineBet();
    }
}
