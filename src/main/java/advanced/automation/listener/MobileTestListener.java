package advanced.automation.listener;

import advanced.automation.logger.MobileLogger;
import org.testng.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MobileTestListener implements ISuiteListener, ITestListener {
    private Calendar calendar = Calendar.getInstance();

    @Override
    public void onStart(ISuite iSuite) {

    }

    @Override
    public void onFinish(ISuite iSuite) {

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        String testName = iTestResult.getTestClass().getRealClass().getSimpleName();
        MobileLogger.initLogger(testName,
                "test_reports"
                        + File.separator
                        + new SimpleDateFormat("MMMMM").format(calendar.getTime())
                        + File.separator
                        + new SimpleDateFormat("dd.MMMMM").format(calendar.getTime())
                        + File.separator
                        + new SimpleDateFormat("HH.mm").format(calendar.getTime())
                        + File.separator
                        + testName + ".log");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
