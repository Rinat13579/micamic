package micamic.mica.mic.appmanager;

import micamic.mica.mic.model.PostData;
import org.openqa.selenium.*;

public class PostHelper extends HelperBase {

    public PostHelper(WebDriver driver) {
        super(driver);
    }

    public void submitPostCreation() {
        click(By.xpath("(//button[@type='submit'])[3]"));
    }

    public void fillPostForm(PostData postData) {
        type(By.id("id_name"), postData.getTitle());
        fillFrame("id_post_iframe", By.xpath("/html/body/div[2]/div[3]/div[2]"), postData.getBody());
    }



    public void initPostCreation() throws InterruptedException {
        Thread.sleep(250);
        click(By.linkText("Создать запись"));
    }

    public void openPost() {
        click(By.linkText("Читать далее"));
    }

    public void deletePost() {
        click(By.xpath("//div[2]/div/button"));
        click(By.linkText("Удалить"));
    }

    public void initModification() {
        click(By.linkText("Редактировать"));
    }

    public void changePublish() {
        click(By.xpath("//div[@id='div_id_is_published']/label"));
    }
}
