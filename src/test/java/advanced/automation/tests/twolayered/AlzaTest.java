package advanced.automation.tests.twolayered;

import advanced.automation.objects.twolayered.alza.AlzaPage;
import org.testng.annotations.Test;

public class AlzaTest extends advanced.automation.AlzaTest {

    @Test
    public void loginToRedmine() {
        AlzaPage alzaPage = new AlzaPage();
        alzaPage
                .clickToLogin()
                .login("hornyja4", "123456");
    }

}
