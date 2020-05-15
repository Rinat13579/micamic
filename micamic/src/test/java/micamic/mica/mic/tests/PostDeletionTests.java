package micamic.mica.mic.tests;

import org.testng.annotations.Test;

public class PostDeletionTests extends TestBase {

    @Test
    public void testPostDeletion () throws Exception {
        app.getNavigationHelper().gotoMyPostPage();
        app.getPostHelper().openPost();
        app.getPostHelper().deletePost();
        app.getNavigationHelper().gotoPostsPage();
        app.getNavigationHelper().gotoHomePage();
    }
}
