package com.example.finalchance;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CompAdapter extends RecyclerView.Adapter<CompAdapter.ViewHolder> {
    List<Entity> entityList;
    RecyclerView d_viewer;
    Context context;
    private D_ListListener listener;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView d_name;
        TextView d_level;
        TextView d_type;
        ImageView d_image;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            d_name = itemView.findViewById(R.id.d_name);
            d_level = itemView.findViewById(R.id.d_level);
            d_type = itemView.findViewById(R.id.d_type);
            d_image = itemView.findViewById(R.id.d_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
        }
    }

    public CompAdapter(Context context, List<Entity> entityList, RecyclerView d_viewer, D_ListListener listener){
        this.context = context;
        this.d_viewer = d_viewer;
        this.entityList = entityList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CompAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.d_list_item, parent, false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompAdapter.ViewHolder holder, int position) {
        Entity entity = entityList.get(position);
        holder.d_name.setText(""+entity.getName());
        holder.d_level.setText(""+entity.getLevel());
        holder.d_type.setText(""+entity.getType());
        holder.d_image.setImageBitmap(BitmapFactory.decodeByteArray(entity.getImg(), 0, entity.getImg().length));
    }

    @Override
    public int getItemCount() {
        return entityList.size();
    }

    public interface D_ListListener{
        void onClick(View v, int position);
    }
}



