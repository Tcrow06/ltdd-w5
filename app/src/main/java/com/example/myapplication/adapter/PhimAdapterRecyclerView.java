package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.dto.DienVien;
import com.example.myapplication.dto.Phim;

import java.util.List;

public class PhimAdapterRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_MOVIE = 0;
    private static final int ITEM_ACTOR = 1;
    private List<Object> objects;

    public PhimAdapterRecyclerView(List<Object> objects) {
        this.objects = objects;
    }
    @Override
    public int getItemViewType(int position) {
        if (objects.get(position) instanceof Phim) {
            return ITEM_MOVIE;
        } else {
            return ITEM_ACTOR;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == ITEM_MOVIE){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_movie, parent, false);
            return new MovieViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_actor, parent, false);
            return new ActorViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MovieViewHolder){
            Phim phim = (Phim)objects.get(position);
            ((MovieViewHolder) holder).tvCode.setText(phim.getCode());
            ((MovieViewHolder) holder).tvName.setText(phim.getName());
            ((MovieViewHolder) holder).tvGenre.setText(phim.getGenre());
            ((MovieViewHolder) holder).tvShortDescription.setText(phim.getShortDescription());
            ((MovieViewHolder) holder).tvPic.setImageResource(phim.getPic());
        }else if (holder instanceof ActorViewHolder){
            ActorViewHolder actorHolder = (ActorViewHolder) holder;
            DienVien dv = (DienVien) objects.get(position);
            actorHolder.tvName.setText(dv.getName());
            actorHolder.tvGender.setText(dv.getGender());
            actorHolder.tvBird.setText(dv.getBird());
            actorHolder.tvPic.setImageResource(dv.getPic());
        }

    }

    @Override
    public int getItemCount() {
        return objects != null ? objects.size() : 0;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvCode;
        private final TextView tvName;
        private final TextView tvGenre;
        private final TextView tvShortDescription;
        private final ImageView tvPic;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCode = itemView.findViewById(R.id.tv_code);
            tvName = itemView.findViewById(R.id.tv_name);
            tvGenre = itemView.findViewById(R.id.tv_genre);
            tvShortDescription = itemView.findViewById(R.id.tv_short_desc);
            tvPic = itemView.findViewById(R.id.imagePic);
        }
    }
    public static class ActorViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvName;
        private final TextView tvGender;
        private final TextView tvBird;
        private final ImageView tvPic;

        public ActorViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvGender = itemView.findViewById(R.id.tv_genre);
            tvBird = itemView.findViewById(R.id.tv_short_desc);
            tvPic = itemView.findViewById(R.id.imagePic);
        }
    }
}
