package micamic.mica.mic;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PostCreationTests extends TestBase {

  @Test
  public void testPostCreation() throws Exception {
    Thread.sleep(250);
    driver.findElement(By.linkText("Создать запись")).click();
    driver.findElement(By.id("id_name")).click();
    driver.findElement(By.id("id_name")).clear();
    driver.findElement(By.id("id_name")).sendKeys("Autotest");
    driver.switchTo().frame("id_post_iframe");
    driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]")).sendKeys("Body for autotest");
    driver.switchTo().defaultContent();
    driver.findElement(By.xpath("//div[@id='div_id_is_published']/label")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
    driver.findElement(By.linkText("Заметки")).click();
    driver.findElement(By.linkText("Домашняя")).click();
  }

}
