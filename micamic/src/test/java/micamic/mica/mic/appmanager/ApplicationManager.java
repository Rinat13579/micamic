package micamic.mica.mic.appmanager;

import micamic.mica.mic.model.PostData;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    protected WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://micamic.ru/");
        login("a", "fghvbnrty");
    }

    private void login(String username, String password) {
        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.id("id_username")).click();
        driver.findElement(By.id("id_username")).clear();
        driver.findElement(By.id("id_username")).sendKeys(username);
        driver.findElement(By.id("id_password")).click();
        driver.findElement(By.id("id_password")).clear();
        driver.findElement(By.id("id_password")).sendKeys(password);
        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
          fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
      try {
        driver.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }

    private boolean isAlertPresent() {
      try {
        driver.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

    private String closeAlertAndGetItsText() {
      try {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        if (acceptNextAlert) {
          alert.accept();
        } else {
          alert.dismiss();
        }
        return alertText;
      } finally {
        acceptNextAlert = true;
      }
    }

    public void gotoHomePage() {
      driver.findElement(By.linkText("Домашняя")).click();
    }

    public void gotoPostsPage() throws InterruptedException {
      Thread.sleep(250);
      driver.findElement(By.linkText("Заметки")).click();
    }

    public void submitPostCreation() {
      driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
    }

    public void fillPostForm(PostData postData) {
      driver.findElement(By.id("id_name")).click();
      driver.findElement(By.id("id_name")).clear();
      driver.findElement(By.id("id_name")).sendKeys(postData.getTitle());
      driver.switchTo().frame("id_post_iframe");
      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]")).sendKeys(postData.getBody());
      driver.switchTo().defaultContent();
      driver.findElement(By.xpath("//div[@id='div_id_is_published']/label")).click();
    }

    public void initPostCreation() {
      driver.findElement(By.linkText("Создать запись")).click();
    }
}
