package e.sh.mvptest.postlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import e.sh.mvptest.R;
import e.sh.mvptest.data.model.Post;

class AdapterPosts extends RecyclerView.Adapter<AdapterPosts.viewHolder> {
    private ArrayList<Post> posts;

    @Override
    public AdapterPosts.viewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_post, parent, false);
        return new AdapterPosts.viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AdapterPosts.viewHolder holder, int position) {
        Post post = posts.get(position);
//        holder.bind(post);
        holder.tvTitle.setText(post.getTitle());
        holder.tvBody.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        if (posts == null) {
            return 0;
        }
        return posts.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvBody;

        viewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.list_item_post_tv_title);
            tvBody = itemView.findViewById(R.id.list_item_post_tv_body);
        }
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }
}