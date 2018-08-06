package FirstTestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchGoogleResultPage {


    @FindBy(linkText = "QA — Википедия")
    private WebElement searchNeedLink;

    @FindBys(@FindBy(className = "r"))

    private List<WebElement> searchListLink;
    private WebDriver driver;


    public SearchGoogleResultPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> searchLinkTextList() {
        List<String> listSearchLinkText = new ArrayList<String>();

        for (WebElement element : searchListLink) {
            String actualItemText = element.getText();
            listSearchLinkText.add(actualItemText);
        }
        return listSearchLinkText;
    }

    public SearchWiKiPageResult clickLinkOnWikiPage() {
        searchNeedLink.click();
        return new SearchWiKiPageResult(driver);
    }
}
