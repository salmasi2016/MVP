package e.sh.mvptest.postlist;

import java.util.ArrayList;

import e.sh.mvptest.data.model.Post;
import e.sh.mvptest.data.model.User;

public interface PostListContract {

    interface View {
        void showProgress();

        void hideProgress();

        void showPost(ArrayList<Post> data);
    }

    interface Presenter {
        void loadData(User user);
    }
}