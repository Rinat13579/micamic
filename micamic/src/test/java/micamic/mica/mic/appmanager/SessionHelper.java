package micamic.mica.mic.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        if (isElementPresent(By.linkText("Войти"))) {
            click(By.linkText("Войти"));
            type(By.id("id_username"), username);
            type(By.id("id_password"), password);
            click(By.xpath("(//button[@type='submit'])[3]"));
        }
    }

}
