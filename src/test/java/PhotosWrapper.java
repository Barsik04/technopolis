import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhotosWrapper {
    private WebElement element;
    private WebDriver driver;

    public String USER_PHOTO_LOCATOR = ".//div[contains(@class,'ugrid_cnt')]/li[contains(@class,'ugrid_i')]//a[contains(@class,'photo-card_cnt')]";

    public PhotosWrapper(WebElement element, WebDriver driver) {
        this.driver = driver;
        this.element = element;
    }

    public PhotosWrapper(WebDriver driver) {
        this.driver = driver;
    }


    public boolean hasXpath(String xPath) {
        return driver.findElement(By.xpath(xPath)).isDisplayed();
    }
    //обертка
    public List<PhotosWrapper> getPhotos() {
        List<PhotosWrapper> list = new ArrayList<PhotosWrapper>();
        if (hasXpath(USER_PHOTO_LOCATOR)) {
            for (WebElement user : driver.findElements(By.xpath(USER_PHOTO_LOCATOR))) {
                list.add(new PhotosWrapper(user, driver));

            }

            return list;

        }
        return Collections.emptyList();

    }

    public void click() {
        this.element.click();
    }
}
