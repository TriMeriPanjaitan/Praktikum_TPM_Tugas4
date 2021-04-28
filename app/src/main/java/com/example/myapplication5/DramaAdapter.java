package com.example.myapplication5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DramaAdapter extends RecyclerView.Adapter<DramaAdapter.ViewHolder> {
    private ArrayList<Drama> drama;
    private Context context;

    public DramaAdapter(ArrayList<Drama> drama, Context context) {
        this.drama = drama;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.drama_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(drama.get(position));
    }

    @Override
    public int getItemCount() {
        return drama.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView ivPhoto;
        CardView cvCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_name);
            ivPhoto = itemView.findViewById(R.id.iv_photo);
            cvCardView = itemView.findViewById(R.id.cv_cardview);
        }

        public void bind(Drama drama){
            tvTitle.setText(drama.getsName());
            Glide.with(itemView.getContext())
                    .load(drama.getsImage())
                    .apply(new RequestOptions().override(40,60))
                    .into(ivPhoto);
            cvCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_DATA, drama);
                    context.startActivity(intent);
                }
            });
        }
    }
}