package Utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners extends commonOps implements ITestListener
{
    public void onFinish(ITestContext arg0) {
        System.out.println("----------Ending Execution----------");
    }

    public void onStart(ITestContext arg0) {
        System.out.println("----------Starting Execution----------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    }

    public void onTestFailure(ITestResult arg0) {
        if(!getData("platformType").equalsIgnoreCase("api"))
        {
            System.out.println("----------Test Failed----------");
            saveScreenShot(driver);
        }
    }

    public void onTestSkipped(ITestResult arg0) {
    }

    public void onTestStart(ITestResult arg0) {
        System.out.println("----------Starting Test----------");
    }

    public void onTestSuccess(ITestResult arg0) {
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] saveScreenShot(WebDriver driver)
    {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
