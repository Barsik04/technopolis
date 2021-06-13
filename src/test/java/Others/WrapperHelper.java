package Others;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WrapperHelper {
    private WebElement element;
    private WebDriver driver;


    public WrapperHelper(WebElement element, WebDriver driver) {
        this.driver = driver;
        this.element = element;

    }


    public void click() {
        this.element.click();
    }
}
