package e.sh.mvptest.userlist;

import java.util.ArrayList;

import e.sh.mvptest.data.Repository;
import e.sh.mvptest.data.model.User;
import e.sh.mvptest.data.LoadCallback;

public class UserListPresenter implements UserListContract.Presenter {
    private UserListContract.View mView;
    private Repository repository = new Repository();

    public UserListPresenter(UserListContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void loadData() {
        mView.showProgress();
        repository.loadUser(new LoadCallback.Users() {
            @Override
            public void onLoadedData(ArrayList<User> userList) {
                mView.showUser(userList);
            }
        });

    }
}
