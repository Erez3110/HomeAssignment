package SanityTests;

import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class webTest_777 extends commonOps
{
    @Test(description = "Print Optional Languages")
    @Description("Go to https://de.777.com/ and print all the supported languages")
    @Parameters("url")
    public void test01_PrintLanguageOptions(String url)
    {
        System.out.println(url + " Website Support the Following Languages: ");
        for (WebElement language:mainPage_777.language_link)
        {
            System.out.println(language.getAttribute("innerText"));
        }
    }

    @Test(description = "Verify languages")
    @Description("Verify the languages of the main header")
    public void test02_VerifyAllLanguages()
    {
        webFlows.switchLanguage("English");
        softAssertion.assertEquals(mainPage_777.englishHeader_lbl.getText(),"WELCOME BONUS");
        webFlows.switchLanguage("Deutsch");
        softAssertion.assertEquals(mainPage_777.dutchHeader_lbl.getText(),"WILLKOMMENSBONUS");
        webFlows.switchLanguage("Suomi");
        softAssertion.assertEquals(mainPage_777.suomiHeader_lbl.getText(), "TERVETULOBONUKSENA");
        softAssertion.assertAll();
    }
}
