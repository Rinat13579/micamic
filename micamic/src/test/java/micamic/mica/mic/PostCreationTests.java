package micamic.mica.mic;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PostCreationTests extends TestBase {

  @Test
  public void testPostCreation() throws Exception {
    driver.findElement(By.linkText("Создать запись")).click();
    driver.findElement(By.id("id_name")).click();
    driver.findElement(By.id("id_name")).clear();
    driver.findElement(By.id("id_name")).sendKeys("test");
    driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/p")).click();
    driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/p")).clear();
    driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/p")).sendKeys("Body");
    driver.findElement(By.xpath("//div[@id='div_id_is_published']/label")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
    driver.findElement(By.linkText("Заметки")).click();
    driver.findElement(By.linkText("Домашняя")).click();
  }

}
