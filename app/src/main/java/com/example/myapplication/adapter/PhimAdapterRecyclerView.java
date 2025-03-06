package com.example.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

    private Context context;

    private int lastPosition = -1;

    public PhimAdapterRecyclerView(Context context, List<Object> objects) {
        this.context = context;
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
            View view = LayoutInflater.from(context).inflate(R.layout.row_item_movie, parent, false);
            return new MovieViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(context).inflate(R.layout.row_actor, parent, false);
            return new ActorViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        Object object = objects.get(position);

        if (viewType == ITEM_MOVIE) {
            Phim phim = (Phim) object;
            MovieViewHolder movieHolder = (MovieViewHolder) holder;
            movieHolder.tvCode.setText(phim.getCode());
            movieHolder.tvName.setText(phim.getName());
            movieHolder.tvGenre.setText(phim.getGenre());
            movieHolder.tvShortDescription.setText(phim.getShortDescription());
            movieHolder.tvPic.setImageResource(phim.getPic());
        }else if (viewType == ITEM_ACTOR){
            ActorViewHolder actorHolder = (ActorViewHolder) holder;
            DienVien dv = (DienVien) object;
            actorHolder.tvName.setText(dv.getName());
            actorHolder.tvGender.setText(dv.getGender());
            actorHolder.tvBird.setText(dv.getBird());
            actorHolder.tvPic.setImageResource(dv.getPic());
        }

        //Thiết lập animation cho item
        setAnimation(holder.itemView, position);

        //Thiết lập sự kiện animation khi click vào item
        holder.itemView.setOnClickListener( a -> {
            Animation rotateAnimation = AnimationUtils.loadAnimation(context, R.anim.zom);
            a.startAnimation(rotateAnimation);
        });

        holder.itemView.setOnLongClickListener(d -> {
            if (position >= 0 && position < objects.size()) {
                objects.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, objects.size());
            }
            return true;
        });



    }
    private void setAnimation(View view, int position){
        if(position > lastPosition){
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.item_animation_fade_slide);
            view.startAnimation(animation);
            lastPosition = position;
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

            tvPic = itemView.findViewById(R.id.tv_pic);
            if (tvPic == null) {
                Log.e("MovieViewHolder", "tvPic is NULL!");
            }
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
            tvGender = itemView.findViewById(R.id.tv_gender);
            tvBird = itemView.findViewById(R.id.tv_bird);
            tvPic = itemView.findViewById(R.id.tv_pic);
        }
    }
}
