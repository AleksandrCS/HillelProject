import FirstTestCase.SearchGooglePageObject;
import FirstTestCase.SearchGoogleResultPage;
import FirstTestCase.SearchWiKiPageResult;
import SeleniumPageObjects.SeleniumMainPage;
import SeleniumPageObjects.SeleniumTargetDownloadPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class FirstHomeWorkRefactoringTest {

    private boolean verifyListLinkTextcontainQa;
    private WebDriver driver;
    private List<String> linkText;
    private List<String> textOfFirstColumn;

    final private List<String> containsLinkTextValueVerify = Arrays.asList("qa", "QA", "Quality Assurance");
    final private List<String> containsLanguageOfProgrammInColumn = Arrays.
            asList("Java", "C#", "Ruby", "Python", "Javascript (Node)");
    final private String verifyTextOfLogoMainPage = "Browser Automation";
    final private String searchTextRequestForGoogle = "qa";
    final private String verifyLogoTextOnWikiPage = "QA";

    @Before
    public void initialWebDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void closeWebDriver() {
        driver.close();
    }


    /**
     * первый тест кейс: проверить лого на странице вики на соответствие "QA"
     */
    @Test
    public void firstTestCaseWithWikiPage() {

        driver.get("https://www.google.com/");
        SearchGooglePageObject startPage = new SearchGooglePageObject(driver);
        startPage.inputSearchText(searchTextRequestForGoogle);
        Assert.assertTrue("List of text result contains not only 'QA' ", startPage.getTextConatainsQa().
                contains(searchTextRequestForGoogle));
        SearchGoogleResultPage resultOfSearchKeyWordPage = startPage.clickSearchButton();

        /**
         * лишний код, чисто в практических целях
         * проверка на наличие слова "QA" в тексте ссылок, найденных в результате поиска по google.com
         */

        linkText = resultOfSearchKeyWordPage.searchLinkTextList();
        linkText.removeAll(Collections.singleton(""));
        for (String element : linkText) {
                verifyListLinkTextcontainQa = element.contains("QA") || element.contains("Quality Assurance") || element.contains("qa");
                if(!verifyListLinkTextcontainQa)
                    break;
        }

        Assert.assertTrue("Текст ссылки не содержит слово 'QA'", verifyListLinkTextcontainQa);
        System.out.println("Все ссылки подходят");
        SearchWiKiPageResult wikiPageFinal = resultOfSearchKeyWordPage.clickLinkOnWikiPage();
        Assert.assertEquals("", verifyLogoTextOnWikiPage, wikiPageFinal.getTextOfLogo());
    }



    /**
     * второе задание, проверить на странице загрузок selenium наличие таблицы и сравить значения
     */
    @Test
    public void testCaseVerifySeleniumTable() {
        driver.get("https://www.seleniumhq.org/");
        SeleniumMainPage mainPage = new SeleniumMainPage(driver);
        Assert.assertEquals("Это не страница загрузки ", verifyTextOfLogoMainPage, mainPage.getLogoTextOfMainPage());
        SeleniumTargetDownloadPage downloadPage = mainPage.clickOnDownloadPage();
        textOfFirstColumn = downloadPage.getStringListValueWichVerify();

        textOfFirstColumn.stream().forEach(element -> {
            Assert.assertTrue(containsLanguageOfProgrammInColumn.contains(element));
        });

        }

}

