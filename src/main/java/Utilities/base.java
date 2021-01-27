package Utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class base
{
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static JavascriptExecutor js = null;
    public static SoftAssert softAssertion = new SoftAssert();;

    public static PageObjects.mainPage_777 mainPage_777;
    public static PageObjects.w3schools_Table w3schools_Table;
}
