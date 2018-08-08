package e.sh.mvptest.userlist;

import android.content.Context;
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
import e.sh.mvptest.data.model.User;

public class UserListFragment extends Fragment implements UserListContract.View, AdapterUsers.Interaction {
    private UserListContract.Presenter presenter;
    private RecyclerView rvUser;
    private AdapterUsers adapterUsers;
    private Interaction interaction;

    public static UserListFragment newInstance() {
        UserListFragment fragment = new UserListFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        interaction = (Interaction) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter =new UserListPresenter(this);
        adapterUsers = new AdapterUsers(UserListFragment.this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvUser = view.findViewById(R.id.fragment_user_rv_users);
        rvUser.setLayoutManager(new LinearLayoutManager(getContext()));
        rvUser.setItemAnimator(new DefaultItemAnimator());
        rvUser.setAdapter(adapterUsers);
        presenter.loadData();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showUser(ArrayList<User> data) {
        adapterUsers.setUsers(data);
    }

    @Override
    public void setUserToUserFragment(User user) {
        interaction.goToPostFragment(user);
    }

    public interface Interaction {

        void goToPostFragment(User user);
    }
}