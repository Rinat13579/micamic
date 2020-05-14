package micamic.mica.mic;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PostCreationTests extends TestBase {

  @Test
  public void testPostCreation() throws Exception {
    driver.get("https://micamic.ru/");
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("id_username")).click();
    driver.findElement(By.id("id_username")).clear();
    driver.findElement(By.id("id_username")).sendKeys("Dark_Elf");
    driver.findElement(By.id("id_password")).click();
    driver.findElement(By.id("id_password")).clear();
    driver.findElement(By.id("id_password")).sendKeys("Aigulechka1");
    driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
    driver.findElement(By.linkText("Create post")).click();
    driver.findElement(By.id("id_name")).click();
    driver.findElement(By.id("id_name")).clear();
    driver.findElement(By.id("id_name")).sendKeys("test");
    driver.findElement(By.xpath("//div[2]/div[3]/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='div_id_is_published']/label")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
    driver.findElement(By.linkText("Posts")).click();
    driver.findElement(By.xpath("//a/h3")).click();
    driver.findElement(By.linkText("Home")).click();
  }

}
