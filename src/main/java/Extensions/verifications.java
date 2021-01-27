package Extensions;

import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.*;

public class verifications extends commonOps
{
    @Step("Verify Text in Element")
    public static void textInElement(WebElement elem, String expectedValue)
    {
        assertEquals(elem.getText(),expectedValue);
    }

    public static boolean verifyTableCellText(WebElement table,
                                       int searchColumn,
                                       String searchText,
                                       int returnColumn,
                                       String expectedText)
    {

        String returnedValue = webFlows.getTableCellText(table,searchColumn,searchText,returnColumn);
        assert returnedValue != null;
        return returnedValue.equalsIgnoreCase(expectedText);
    }

    public static void verifyTableCellText(String actualValue, String expectedText)
    {
        assertEquals(actualValue,expectedText);
    }
}
