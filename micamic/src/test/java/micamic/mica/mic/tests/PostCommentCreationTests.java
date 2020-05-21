package micamic.mica.mic.tests;

import org.testng.annotations.Test;

public class PostCommentCreationTests extends TestBase {

    @Test
    public void testPostCommentCreation () {
        app.getNavigationHelper().gotoPostsPage();
        app.getPostHelper().openPost();
        app.getPostHelper().commentPost();
        app.getNavigationHelper().gotoPostsPage();
        app.getNavigationHelper().gotoHomePage();
    }
}
