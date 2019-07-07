package packselchap3_9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ripon on 11/19/2015.
 */
public class Google {
    private WebDriver driver;
    private String baseURL;

    public Google(WebDriver driver){
        this.driver = driver;
        baseURL = "https://www.google.com/";
        driver.get(baseURL + "?gws_rd=cr,ssl&ei=qZlNVpOUMNCauQS0iYmoCA&fg=1");
        System.out.println(driver.getTitle());
//<<<<<<< HEAD
   //     if (!driver.getTitle().equals("Google-Selenium Testing Tools")){
//=======
        if (!driver.getTitle().equals("Google-test")){
//>>>>>>> 68fa745cb5b2607eeded53d187bddd54d183c832
            throw new WrongPageException("Incorrect page for Google Home page");
        }
    }
  //  }
    public GoogleSearchPage goToSearchPage(){
        driver.findElement(By.name("q")).sendKeys("Mastering Selenium Testing Tools");
        driver.findElement(By.name("btnK")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        return new GoogleSearchPage(driver);
    }
}
