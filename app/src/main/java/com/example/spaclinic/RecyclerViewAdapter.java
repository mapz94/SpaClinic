package com.example.spaclinic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spaclinic.models.MenuItem;
import com.example.spaclinic.models.Model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Model> items = new ArrayList<Model>();
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<Model> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        MenuItem menuItem = items.get(position).getMenuItem();
        if(menuItem.equals(null)){
            return;
        }
        holder.itemID.setText("ID: " + menuItem.getID());
        holder.itemTitle.setText(menuItem.getTitle());
        holder.itemSubTitle.setText(menuItem.getSubtitle());
        holder.itemData.setText(menuItem.getStringData());
        holder.parentLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(context, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public RelativeLayout parentLayout;
        public TextView itemID, itemTitle, itemSubTitle, itemData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById((R.id.menuItemLayout));
            itemID = itemView.findViewById(R.id.itemID);
            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemSubTitle = itemView.findViewById(R.id.itemSubTitle);
            itemData = itemView.findViewById(R.id.itemData);
        }
    }
}
