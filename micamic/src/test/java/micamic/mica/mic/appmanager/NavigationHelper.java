package micamic.mica.mic.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoHomePage() {
        click(By.linkText("Домашняя"));
    }

    public void gotoPostsPage() {
        click(By.linkText("Заметки"));
    }

    public void gotoMyPostPage() {
        click(By.id("user-dropdown"));
        click(By.linkText("Мои заметки"));
    }
}
