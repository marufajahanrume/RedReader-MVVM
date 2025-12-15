package org.quantumbadger.redreader.mvvm.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.quantumbadger.redreader.mvvm.CardDetailsActivity;
import org.quantumbadger.redreader.mvvm.DetailActivity;
import org.quantumbadger.redreader.mvvm.R;
import org.quantumbadger.redreader.mvvm.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private Context context;
    private List<Post> postList;

    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.title.setText(post.getTitle());
        holder.subreddit.setText(post.getSubreddit());
        holder.author.setText(post.getAuthor());
        holder.upvotes.setText("Upvotes: " + post.getUpvotes());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CardDetailsActivity.class);
            intent.putExtra("TITLE", post.getTitle());
            intent.putExtra("URL", post.getRedditUrl());
            context.startActivity(intent);
        });


        // Optional fake publish date (or add a field to model)
//        holder.date.setText("Published: Oct " + (2025 - (position % 2)) );

        // Hide image but keep logic for later re-use
        holder.image.setVisibility(View.GONE);
        Glide.with(context)
                .load(post.getImageUrl())
                .placeholder(R.drawable.placeholder)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView title, author, subreddit, upvotes;
        ImageView image;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.post_title);
            author = itemView.findViewById(R.id.post_author);
            subreddit = itemView.findViewById(R.id.post_subreddit);
            upvotes = itemView.findViewById(R.id.post_upvotes);
//            date = itemView.findViewById(R.id.post_date);
            image = itemView.findViewById(R.id.post_image);
        }
    }
}
