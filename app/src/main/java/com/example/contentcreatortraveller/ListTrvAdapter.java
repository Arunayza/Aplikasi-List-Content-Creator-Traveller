package com.example.contentcreatortraveller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListTrvAdapter extends RecyclerView.Adapter<ListTrvAdapter.ListViewHolder> {

    private ArrayList<Traveler> listTraveler;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListTrvAdapter(ArrayList<Traveler> list) {
        this.listTraveler = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_traveler, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Traveler trv = listTraveler.get(position);
        Glide.with(holder.itemView.getContext())
                .load(trv.getPhoto())
                .apply(new RequestOptions().override(88, 80))
                .into(holder.imgPhoto);
        holder.tvAlias.setText(trv.getAlias());
        holder.tvDesk.setText(trv.getDeskripsi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listTraveler.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTraveler.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvAlias, tvDesk;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvAlias = itemView.findViewById(R.id.tv_item_alias);
            tvDesk = itemView.findViewById(R.id.tv_item_desk);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Traveler data);
    }
}
