package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class mainPage_777
{
    @FindBy(xpath = "//div[@class='FloatColumn']/ul/li/a")
    public List<WebElement> language_link;

    @FindBy(id = "ChooseLanguageDlgOpener")
    public WebElement language_dropDown;

    @FindBy(xpath = "//span[@class='futura all-devices all-locations']")
    public WebElement englishHeader_lbl;

    @FindBy(xpath = "//span[@class='futura all-devices start-screen-top']")
    public WebElement dutchHeader_lbl;

    @FindBy(xpath = "//span[@class='futura all-devices all-locations']")
    public WebElement suomiHeader_lbl;
}
