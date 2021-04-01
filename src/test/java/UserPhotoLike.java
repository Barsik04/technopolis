import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPhotoLike {
    WebDriver driver;
    String PHOTO_LOCATOR="//div[contains(@class,'mctc_navMenu')]/a[contains(@class,'mctc_navMenuSec ')]";
    String FIRST_Photo = ".//div[contains(@class,'ugrid_cnt')]/li[2]/*/a";
    UserPhotoLike(WebDriver driver){
        this.driver=driver;
    }

    public void doLike(){
        driver.findElement(By.xpath(PHOTO_LOCATOR)).click();
        
    }

}
