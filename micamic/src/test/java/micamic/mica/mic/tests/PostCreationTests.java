package micamic.mica.mic.tests;

import micamic.mica.mic.model.PostData;
import org.testng.annotations.Test;

public class PostCreationTests extends TestBase {

  @Test
  public void testPostCreation() throws Exception {
    app.getPostHelper().createPost(new PostData("Autotest", "Body for autotest"));
    app.getNavigationHelper().gotoPostsPage();
    app.getNavigationHelper().gotoHomePage();
  }

}
