package micamic.mica.mic.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    protected WebDriver driver;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private PostHelper postHelper;

    public void init() {
        driver = new ChromeDriver();
        postHelper = new PostHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://micamic.ru/");
        sessionHelper.login("a", "fghvbnrty");
    }

    public void stop() {
        driver.quit();
    }

    private boolean isAlertPresent() {
      try {
        driver.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

    public PostHelper getPostHelper() {
        return postHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
