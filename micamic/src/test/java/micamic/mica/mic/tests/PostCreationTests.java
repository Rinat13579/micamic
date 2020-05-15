package micamic.mica.mic.tests;

import micamic.mica.mic.model.PostData;
import org.testng.annotations.Test;

public class PostCreationTests extends TestBase {

  @Test
  public void testPostCreation() throws Exception {
    app.initPostCreation();
    app.fillPostForm(new PostData("Autotest", "Body for autotest"));
    app.submitPostCreation();
    app.gotoPostsPage();
    app.gotoHomePage();
  }

}
