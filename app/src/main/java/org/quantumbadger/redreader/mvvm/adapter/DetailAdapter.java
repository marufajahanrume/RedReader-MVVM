package org.quantumbadger.redreader.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.quantumbadger.redreader.mvvm.R;
import org.quantumbadger.redreader.mvvm.model.DetailItem;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {

    private Context context;
    private List<DetailItem> detailList;

    public DetailAdapter(Context context, List<DetailItem> detailList) {
        this.context = context;
        this.detailList = detailList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item_detail, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DetailItem item = detailList.get(position);
        holder.title.setText(item.getTitle());
        holder.desc.setText(item.getDescription());
        holder.date.setText(item.getPublishDate());
        holder.votes.setText(item.getVotes() + " votes");
        holder.ratingBar.setRating((float) item.getRating());

//        Glide.with(context)
//                .load(item.getImageUrl())
//                .placeholder(R.drawable.placeholder)
//                .into(holder.image);
        if (item.isLocalImage()) {
            holder.image.setImageResource(item.getImageResId());
        } else {
            Glide.with(context)
                    .load(item.getImageUrl())
                    .into(holder.image);
        }
    }

    @Override
    public int getItemCount() {
        return detailList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, desc, votes, date;
        ImageView image;
        RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.detail_title);
            desc = itemView.findViewById(R.id.detail_desc);
            votes = itemView.findViewById(R.id.detail_votes);
            date = itemView.findViewById(R.id.detail_date);
            image = itemView.findViewById(R.id.detail_image);
            ratingBar = itemView.findViewById(R.id.detail_rating);
        }
    }
}
