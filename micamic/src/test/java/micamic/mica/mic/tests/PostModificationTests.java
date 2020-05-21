package micamic.mica.mic.tests;

import micamic.mica.mic.model.PostData;
import org.testng.annotations.Test;

public class PostModificationTests extends TestBase{

    @Test
    public void testPostModification () throws Exception {
        app.getNavigationHelper().gotoMyPostPage();
        if (! app.getPostHelper().isThereAPost()) {
            app.getPostHelper().createPost(new PostData("Autotest", "Body for autotest"));
        }
        app.getPostHelper().openPost();
        app.getPostHelper().createPost(new PostData("Autotests changes", "Body of the Post will be change automatically"));
        app.getNavigationHelper().gotoPostsPage();
        app.getNavigationHelper().gotoHomePage();
    }
}
