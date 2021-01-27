package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
    public static void init()
    {
        mainPage_777 = PageFactory.initElements(driver, PageObjects.mainPage_777.class);
        w3schools_Table = PageFactory.initElements(driver, PageObjects.w3schools_Table.class);
    }
}
