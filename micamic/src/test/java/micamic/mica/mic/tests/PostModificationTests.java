package micamic.mica.mic.tests;

import micamic.mica.mic.model.PostData;
import org.testng.annotations.Test;

public class PostModificationTests extends TestBase{

    @Test
    public void testPostModification () throws Exception {
        app.getNavigationHelper().gotoMyPostPage();
        app.getPostHelper().openPost();
        app.getPostHelper().initModification();
        app.getPostHelper().fillPostForm(new PostData("Autotests changes", "Body of the Post will be change automatically"));
        app.getPostHelper().submitPostCreation();
        app.getNavigationHelper().gotoPostsPage();
        app.getNavigationHelper().gotoHomePage();
    }
}
