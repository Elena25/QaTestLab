import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class homework {

    public static void main(String[] args) {
        WebDriver driver = initChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        WebElement email= driver.findElement(By.id("email"));//Login
        email.sendKeys("webinar.test@gmail.com");
        WebElement password= driver.findElement(By.id("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement submitbutton= driver.findElement(By.name("submitLogin"));
        submitbutton.submit();

        WebElement avatar= driver.findElement(By.className("employee_avatar_small"));//Logout
        avatar.click();
        WebElement logout= driver.findElement(By.id("header_logout"));
        logout.click();
        driver.quit();
    }
    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver",homework.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }

}
