package micamic.mica.mic.tests;

import micamic.mica.mic.model.PostData;
import org.testng.annotations.Test;

public class PostDeletionTests extends TestBase {

    @Test
    public void testPostDeletion () throws Exception {
        app.getNavigationHelper().gotoMyPostPage();
        if (! app.getPostHelper().isThereAPost()) {
            app.getPostHelper().createPost(new PostData("Autotest", "Body for autotest"));
        }
        app.getPostHelper().openPost();
        app.getPostHelper().deletePost();
        app.getNavigationHelper().gotoPostsPage();
        app.getNavigationHelper().gotoHomePage();
    }
}
