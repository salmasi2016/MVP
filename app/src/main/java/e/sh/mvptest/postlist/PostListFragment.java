package e.sh.mvptest.postlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import e.sh.mvptest.R;
import e.sh.mvptest.data.model.Post;
import e.sh.mvptest.data.model.User;
import e.sh.mvptest.util.Tool;

public class PostListFragment extends Fragment implements PostListContract.View {
    private PostListContract.Presenter presenter;
    private RecyclerView rvPost;
    private AdapterPosts adapterPosts;
    private User user;

    public static PostListFragment newInstance(User user) {
        PostListFragment fragment = new PostListFragment();
        Bundle args = new Bundle();
        args.putParcelable(Tool.POST_FRAGMENT_USER_ID, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new PostListPresenter(this);
        adapterPosts = new AdapterPosts();
        Bundle args = getArguments();
        if (args == null) return;
        setUser((User) args.getParcelable(Tool.POST_FRAGMENT_USER_ID));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPost = view.findViewById(R.id.fragment_post_rv_posts);
        rvPost.setLayoutManager(new LinearLayoutManager(getContext()));
        rvPost.setItemAnimator(new DefaultItemAnimator());
        rvPost.setAdapter(adapterPosts);
        presenter.loadData(getUser());
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showPost(ArrayList<Post> data) {
        adapterPosts.setPosts(data);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}