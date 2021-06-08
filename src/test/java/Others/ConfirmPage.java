package Others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmPage {
    WebDriver driver;
    String CLOSE = "//*[@value=\"Закрыть\"]";
    private String DELETE ="//input[contains(@data-l, 'confirm')]";

    public ConfirmPage(WebDriver driver){
        this.driver=driver;


    }


    public void confirm(){
        WebElement delete = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DELETE)));
        delete.click();

        WebElement close = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLOSE)));
        close.click();

    }
}
