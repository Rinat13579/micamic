package micamic.mica.mic.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    protected WebDriver driver;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private PostHelper postHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
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
