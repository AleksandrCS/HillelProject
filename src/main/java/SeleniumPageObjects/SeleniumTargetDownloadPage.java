package SeleniumPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SeleniumTargetDownloadPage {

    @FindBys(@FindBy(xpath = "//*[@id=\"mainContent\"]/table[1]/tbody/tr/td[1]"))
    List<WebElement> verifyValueOfFirstColumn;

    private WebDriver driver;

    public SeleniumTargetDownloadPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getStringListValueWichVerify(){
        List<String> stringList=verifyValueOfFirstColumn.stream().map(WebElement::getText).collect(Collectors.toList());
        return stringList;
    }

}
