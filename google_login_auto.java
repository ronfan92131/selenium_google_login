package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class google_login_auto {

    @Test
    public void WebDriver() throws InterruptedException {

        //1. create a chrome driver object
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeDriver driver = new ChromeDriver();

        //2. get an url
        String url = "https://accounts.google.com/signin";
        driver.get(url);

        //3. login process: input username; click next; then password; then click next again,
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.name("identifier")).sendKeys("mr060111@gmail.com");
        driver.findElement(By.xpath("//span[contains(.,'Next')]")).click();
        driver.findElement(By.name("password")).sendKeys("Lge10225");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'Next')]")));
        element.click();


        Thread.sleep(5000);

        //4. end the driver, check the result "Tests passed: or Failed"
        //driver.quit();  //quit will keep a copy of the chrome window
        driver.close();   //close will remove the chrome window

    }
}
