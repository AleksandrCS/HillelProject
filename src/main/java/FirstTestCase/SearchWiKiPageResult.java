package FirstTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchWiKiPageResult {

    @FindBy(id = "firstHeading")
    private WebElement logoOfPage;
    private String logoText;
    private WebDriver driver;

    public SearchWiKiPageResult(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTextOfLogo() {
        logoText = logoOfPage.getText();
        return logoText;
    }

}
