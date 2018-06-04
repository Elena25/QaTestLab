import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class homework2 {

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

        ArrayList<String> xPathes = new ArrayList<String>();

        xPathes.add("//*[@id=\"tab-AdminDashboard\"]/a/span");
        xPathes.add("//*[@id=\"subtab-AdminParentOrders\"]/a/span");
        xPathes.add("//*[@id=\"subtab-AdminCatalog\"]/a/span");
        xPathes.add("/html/body/nav/ul/li[5]/a/span");
        xPathes.add("//*[@id=\"subtab-AdminParentCustomerThreads\"]/a/span");
        xPathes.add("//*[@id=\"subtab-AdminStats\"]/a/span");
        xPathes.add("//*[@id=\"subtab-AdminParentModulesSf\"]/a/span");
        xPathes.add("/html/body/nav/ul/li[10]/a/span");
        xPathes.add("//*[@id=\"subtab-AdminParentShipping\"]/a/span");
        xPathes.add("//*[@id=\"subtab-AdminParentPayment\"]/a/span");
        xPathes.add("//*[@id=\"subtab-AdminInternational\"]/a/span");
        xPathes.add("//*[@id=\"subtab-ShopParameters\"]/a/span");
        xPathes.add("//*[@id=\"subtab-AdminAdvancedParameters\"]/a/span");

        for (String xP: xPathes
             ) {

            WebElement menuitem = driver.findElement(By.xpath(xP));
            String menuName = menuitem.getText();
            menuitem.click();
            System.out.println(menuName);
            driver.navigate().refresh();
        }
            driver.quit();
    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver",homework.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }

}