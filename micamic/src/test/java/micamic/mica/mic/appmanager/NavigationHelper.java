package micamic.mica.mic.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private WebDriver driver;

    public NavigationHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void gotoHomePage() {
      driver.findElement(By.linkText("Домашняя")).click();
    }

    public void gotoPostsPage() throws InterruptedException {
      Thread.sleep(250);
      driver.findElement(By.linkText("Заметки")).click();
    }
}
