package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class w3schools_Table
{
    @FindBy(id = "customers")
    public WebElement customers_table;

    @FindBy(xpath = "//table[@id='customers']/tbody/tr")
    public List<WebElement> tableRows_list;
}
