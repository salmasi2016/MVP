package e.sh.mvptest.data;

import java.util.ArrayList;

import e.sh.mvptest.data.model.Post;
import e.sh.mvptest.data.model.User;

public interface LoadCallback {

    interface Users {
        void onLoadedData(ArrayList<User> userList);
    }

    interface Posts {
        void onLoadedData(ArrayList<Post> postList);
    }
}