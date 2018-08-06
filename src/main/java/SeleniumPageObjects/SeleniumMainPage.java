package SeleniumPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumMainPage {
    @FindBy(xpath = "//*[@id=\"header\"]/h1/a")
    private WebElement textLogoMainPageSelenium;

    @FindBy(id = "menu_download")
    private WebElement buttonLinkToDownloadPage;

    private WebDriver driver;

    public SeleniumMainPage(final WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String getLogoTextOfMainPage(){
        String textLogo;
        textLogo=textLogoMainPageSelenium.getText();
        return textLogo;
    }

    public SeleniumTargetDownloadPage clickOnDownloadPage(){
        buttonLinkToDownloadPage.click();
        return new SeleniumTargetDownloadPage(driver);
    }
}
