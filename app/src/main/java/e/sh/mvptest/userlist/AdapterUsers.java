package e.sh.mvptest.userlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import e.sh.mvptest.R;
import e.sh.mvptest.data.model.User;

class AdapterUsers extends RecyclerView.Adapter<AdapterUsers.viewHolder> {
    private ArrayList<User> users;
    private Interaction interaction;

    public AdapterUsers(Interaction interaction) {
        this.interaction = interaction;
    }

    @Override
    public AdapterUsers.viewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_user, parent, false);
        return new AdapterUsers.viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AdapterUsers.viewHolder holder, int position) {
        User user = users.get(position);
        holder.tvUsername.setText(user.getName());
        holder.tvPhone.setText(user.getPhone());
    }

    @Override
    public int getItemCount() {
        if (users == null) {
            return 0;
        }
        return users.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tvUsername, tvPhone;

        viewHolder(View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.list_item_user_tv_username);
            tvPhone = itemView.findViewById(R.id.list_item_user_tv_phone);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    interaction.setUserToUserFragment(getUsers().get(getAdapterPosition()));
                }
            });
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    public interface Interaction {
        void setUserToUserFragment(User user);
    }
}