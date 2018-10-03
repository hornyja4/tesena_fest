package advanced.automation.tests.threelayered;

import advanced.automation.objects.threelayered.HomePage;
import org.testng.annotations.Test;

public class SazkaTest extends advanced.automation.SazkaTest {

    @Test
    public void sportkaTest() {
        HomePage homePage = new HomePage();
        homePage.sportka();
    }
}
