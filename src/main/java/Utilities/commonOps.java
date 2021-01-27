package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class commonOps extends base
{

    public static String getData (String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("Configuration\\dataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            try
        {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
            catch(Exception e)
        {
            System.out.println("Exception in reading XML file: " + e);
        }
            doc.getDocumentElement().normalize();
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static void initBrowser(String browserType)
    {
        if(browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if(browserType.equalsIgnoreCase("firefox"))
            driver = initFFDriver();
        else if(browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid platform name stated");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Long.parseLong(getData("timeout")));
        action = new Actions(driver);
        js = (JavascriptExecutor)driver;
    }

    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static WebDriver initFFDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    @BeforeClass
    @Parameters({"platform","browser"})
    public void startSession(String platform, String browser)
    {
        if(platform.equalsIgnoreCase("web"))
        {
                initBrowser(browser);
        }
        else if(platform.equalsIgnoreCase("api"))
        {

        }
        else
            throw new RuntimeException("Invalid platform name stated");
        managePages.init();
    }

    @BeforeMethod
    @Parameters({"url","platform"})
    public void beforeMethod(@Optional("url") String url, String platform)
    {
        if(platform.equalsIgnoreCase("web"))
            driver.get(url);
    }

    @AfterClass
    public void closeSession()
    {
        if(getData("platformType").equalsIgnoreCase("web"))
            driver.quit();
    }
}
