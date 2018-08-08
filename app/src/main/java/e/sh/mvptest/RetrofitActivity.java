package e.sh.mvptest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import e.sh.mvptest.data.model.User;
import e.sh.mvptest.postlist.PostListFragment;
import e.sh.mvptest.userlist.UserListFragment;

public class RetrofitActivity extends AppCompatActivity implements UserListFragment.Interaction {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        setFragment(UserListFragment.newInstance());
    }

    private void setFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.retrofit_fl_layout, fragment);
//        if (fragment instanceof PostFragment) {
//            fragmentTransaction.addToBackStack(null);
//        }
        fragmentTransaction.commit();
    }

    @Override
    public void goToPostFragment(User user) {
        setFragment(PostListFragment.newInstance(user));
    }
}