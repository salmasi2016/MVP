package e.sh.mvptest.postlist;

import java.util.ArrayList;

import e.sh.mvptest.data.Repository;
import e.sh.mvptest.data.model.Post;
import e.sh.mvptest.data.LoadCallback;
import e.sh.mvptest.data.model.User;

public class PostListPresenter implements PostListContract.Presenter {
    private PostListContract.View mView;
    private Repository repository = new Repository();

    public PostListPresenter(PostListContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void loadData(User user) {
        mView.showProgress();
        repository.loadPost(new LoadCallback.Posts() {
            @Override
            public void onLoadedData(ArrayList<Post> postList) {
                mView.showPost(postList);
            }
        },user);

    }
}
