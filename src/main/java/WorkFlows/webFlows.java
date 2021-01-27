package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class webFlows extends commonOps
{
    @Step("Switch website language")
    public static void switchLanguage(String language)
    {
        uiActions.moveToElement(mainPage_777.language_dropDown);
        if(language.equalsIgnoreCase("English"))
        {
            uiActions.click(mainPage_777.language_link.get(0));
        }
        else if(language.equalsIgnoreCase("Deutsch"))
        {
            uiActions.click(mainPage_777.language_link.get(1));
        }
        else if(language.equalsIgnoreCase("Suomi"))
        {
            uiActions.click(mainPage_777.language_link.get(2));
        }
    }

    @Step("Get cell value")
    public static String getTableCellText(WebElement table,
                                          int searchColumn,
                                          String searchText,
                                          int returnColumn)
    {
        uiActions.scrollToElement(table);
        String returnedValue;
        for (WebElement row:w3schools_Table.tableRows_list)
        {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if(!columns.isEmpty())
            {
                if(columns.get(searchColumn).getText().equalsIgnoreCase(searchText))
                {
                    returnedValue = columns.get(returnColumn).getText();
                    return returnedValue;
                }
            }
        }
        return null;
    }

    @Step("Get cell value by XPath")
    public static String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumn)
    {
        uiActions.scrollToElement(table);
        String returnValue = driver.findElement(By.xpath("//tr[contains(td[" + (searchColumn+1) + "], '" + searchText + "')]/td[" + (returnColumn+1) + "]")).getText();
        assert returnValue != null;
        return returnValue;
    }
}
