package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class uiActions extends commonOps
{
    @Step("Click on Element")
    public static void click(WebElement elem)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.click();
    }

    @Step("Hover to Element")
    public static void moveToElement(WebElement elem)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        action.moveToElement(elem).build().perform();
    }

    @Step("Scroll to Element")
    public static void scrollToElement(WebElement elem)
    {
        js.executeScript("arguments[0].scrollIntoView(true);", elem);
    }
}
