package e.sh.mvptest.data.source.remote;

import java.util.ArrayList;

import e.sh.mvptest.data.model.Post;
import e.sh.mvptest.data.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/users")
    Call<ArrayList<User>> getUser();

    @GET("/posts")
    Call<ArrayList<Post>> getPost(@Query("userId") int userId);
}