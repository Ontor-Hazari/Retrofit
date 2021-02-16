package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.model.ModelPost;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<ModelPost> posts;
    Context context;

    public Adapter(List<ModelPost> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vh = LayoutInflater.from(context).inflate(R.layout.recycelerlayout,parent,false);

        return new ViewHolder(vh);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

              holder.title.setText(posts.get(position).getTitle());
              holder.description.setText(posts.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView title,description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


             title = itemView.findViewById(R.id.text_title);
             description = itemView.findViewById(R.id.text_description);
        }
    }


}
