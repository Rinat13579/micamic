package micamic.mica.mic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.fail;

public class TestBase {
    protected WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      driver.get("https://micamic.ru/");
      driver.findElement(By.linkText("Войти")).click();
      driver.findElement(By.id("id_username")).click();
      driver.findElement(By.id("id_username")).clear();
      driver.findElement(By.id("id_username")).sendKeys("a");
      driver.findElement(By.id("id_password")).click();
      driver.findElement(By.id("id_password")).clear();
      driver.findElement(By.id("id_password")).sendKeys("fghvbnrty");
      driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
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
}
