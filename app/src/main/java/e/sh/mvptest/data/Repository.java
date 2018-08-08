package e.sh.mvptest.data;

import java.util.ArrayList;

import e.sh.mvptest.data.model.Post;
import e.sh.mvptest.data.model.User;
import e.sh.mvptest.data.source.remote.APIClient;
import e.sh.mvptest.data.source.remote.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    public void loadUser(final LoadCallback.Users callback) {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<ArrayList<User>> call = apiInterface.getUser();
        call.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                if (response.isSuccessful()) {
                    callback.onLoadedData(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });
    }

    public void loadPost(final LoadCallback.Posts callback,User user) {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<ArrayList<Post>> call = apiInterface.getPost(user.getId());
        call.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                if (response.isSuccessful()) {
                    callback.onLoadedData(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        });
    }
}