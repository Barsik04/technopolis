package Others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WrapperHelper {
    private WebElement element;
    private WebDriver driver;
    private String LOCATOR;

    public WrapperHelper(WebElement element, WebDriver driver,String LOCATOR) {
        this.driver = driver;
        this.element = element;
        this.LOCATOR=LOCATOR;
    }

    public WrapperHelper(WebElement element, WebDriver driver) {
        this.driver = driver;
        this.element = element;

    }

    public WrapperHelper(WebDriver driver,String LOCATOR){
        this.driver=driver;
        this.LOCATOR=LOCATOR;
    }

    private boolean hasXpath(String xPath) {

        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));

        return element.isDisplayed();
    }

    public List<WrapperHelper> getElements() {
        List<WrapperHelper> list = new ArrayList<WrapperHelper>();
        if (hasXpath(LOCATOR)) {
            for (WebElement elem : driver.findElements(By.xpath(LOCATOR))) {
                list.add(new WrapperHelper(elem, driver));

            }
            return list;
        }
        return Collections.emptyList();
    }

    public void click() {
        this.element.click();
    }
}
