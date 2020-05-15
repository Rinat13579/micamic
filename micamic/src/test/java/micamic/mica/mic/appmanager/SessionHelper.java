package micamic.mica.mic.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper {
    private WebDriver driver;

    public SessionHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.id("id_username")).click();
        driver.findElement(By.id("id_username")).clear();
        driver.findElement(By.id("id_username")).sendKeys(username);
        driver.findElement(By.id("id_password")).click();
        driver.findElement(By.id("id_password")).clear();
        driver.findElement(By.id("id_password")).sendKeys(password);
        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
    }
}
