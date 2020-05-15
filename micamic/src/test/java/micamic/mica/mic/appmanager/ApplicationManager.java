package micamic.mica.mic.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    protected WebDriver driver;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private PostHelper postHelper;

    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://micamic.ru/");
        sessionHelper = new SessionHelper(driver);
        postHelper = new PostHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper.login("a", "fghvbnrty");
    }

    public void stop() {
        driver.quit();
    }

    public PostHelper getPostHelper() {
        return postHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
