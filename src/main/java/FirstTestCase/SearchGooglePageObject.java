package FirstTestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchGooglePageObject {

    @FindBy(id = "lst-ib")
    private WebElement inputGoogleSearchText;
    @FindBy(name = "btnK")
    private WebElement buttonFindGoogleResults;
    @FindBys(@FindBy(xpath = "//li[@role='presentation']"))
    private List<WebElement> searchListQa;
    private WebDriver driver;

    public SearchGooglePageObject(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputSearchText(final String searchValueText) {
        inputGoogleSearchText.sendKeys(searchValueText);
    }

    public SearchGoogleResultPage clickSearchButton() {
        inputGoogleSearchText.submit();
        return new SearchGoogleResultPage(driver);
    }

    public List<String> getTextConatainsQa() {
        final List<String> resultOfSearch = new ArrayList<String>();
        for (WebElement element : searchListQa) {
            resultOfSearch.add(element.getText());
        }
        return resultOfSearch;
    }
}
