package micamic.mica.mic.appmanager;

import micamic.mica.mic.model.PostData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostHelper {
    private WebDriver driver;

    public PostHelper(WebDriver driver) {
        this.driver = driver;
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
