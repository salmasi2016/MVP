package e.sh.mvptest.userlist;

import java.util.ArrayList;

import e.sh.mvptest.data.model.User;

public interface UserListContract {

    interface View {
        void showProgress();

        void hideProgress();

        void showUser(ArrayList<User> data);
    }

    interface Presenter {
        void loadData();
    }
}
