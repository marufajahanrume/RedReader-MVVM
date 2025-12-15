package org.quantumbadger.redreader.mvvm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.quantumbadger.redreader.mvvm.R;
import org.quantumbadger.redreader.mvvm.model.UserPost;

import java.util.List;

public class UserPostsAdapter extends RecyclerView.Adapter<UserPostsAdapter.UserPostViewHolder>{
    private List<UserPost> postList;

    public UserPostsAdapter(List<UserPost> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public UserPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_post, parent, false);
        return new UserPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserPostViewHolder holder, int position) {
        UserPost post = postList.get(position);

        holder.tvTitle.setText(post.getTitle());
        holder.tvSubreddit.setText("Subreddit: r/" + post.getSubreddit());
        holder.tvUpvotes.setText("Upvotes: " + post.getUpvotes());
        holder.tvComments.setText("Comments: " + post.getComments());
        holder.tvTime.setText("Posted: " + post.getTime());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class UserPostViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvSubreddit, tvUpvotes, tvComments, tvTime;

        public UserPostViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvPostTitle);
            tvSubreddit = itemView.findViewById(R.id.tvSubreddit);
            tvUpvotes = itemView.findViewById(R.id.tvUpvotes);
            tvComments = itemView.findViewById(R.id.tvComments);
            tvTime = itemView.findViewById(R.id.tvTime);
        }
    }
}
