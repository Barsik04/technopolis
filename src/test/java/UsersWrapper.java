import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UsersWrapper {
    private WebElement element;
    private WebDriver driver;

    public String USER_NAME_LOCATOR= ".//a[contains(@href,'/profile/' )]/div[contains(@class,'sm_')]";

    public UsersWrapper(WebElement element, WebDriver driver){
        this.driver=driver;
        this.element=element;
    }

    public boolean hasXpath(String xPath){
        try{
            driver.findElement(By.xpath(xPath));
            return true;
        }
        catch (Exception e){
            System.err.println("Нет элементов");
            return false;
        }
    }

    public List<UsersWrapper> users(){
        if(hasXpath(USER_NAME_LOCATOR)){
            ArrayList<UsersWrapper> list=new ArrayList<UsersWrapper>();
            for (WebElement user:driver.findElements(By.xpath(USER_NAME_LOCATOR))) {
                list.add(new UsersWrapper(user,driver));

            }
            System.out.println(list.size());
            return list;

        }


    }


}
