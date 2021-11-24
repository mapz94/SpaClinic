package com.manager.spaclinic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spaclinic.R;
import com.manager.spaclinic.models.MenuItem;
import com.manager.spaclinic.models.Model;
import com.manager.spaclinic.models.Patient;

import java.util.ArrayList;

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
        if(menuItem == null){
            return;
        }
        holder.itemID.setText("ID: " + menuItem.getID());
        holder.itemTitle.setText(menuItem.getTitle());
        holder.itemSubTitle.setText(menuItem.getSubtitle());
        holder.itemData.setText(menuItem.getStringData());
        holder.parentLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(items.get(position).getClass().equals(Patient.class)){
                    Patient patient = (Patient) items.get(position);
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    View view1 = View.inflate(view.getContext(), R.layout.empty, null);
                    builder.setView(view1)
                            .setTitle("Llamar?")
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .setPositiveButton("Llamar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", patient.getPhone(), null));
                                    view.getContext().startActivity(intent);
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }else{
                    Toast.makeText(view.getContext(), menuItem.getTitle(), Toast.LENGTH_LONG).show();
                }

            }
        });
        holder.parentLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                View view1 = View.inflate(view.getContext(), R.layout.empty, null);
                builder.setView(view1)
                        .setTitle("Eliminar?")
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Class<?> _class = items.get(position).getClass();
                                DAO dao = new DAO(view.getContext());
                                dao.delete(_class, "ID = " + menuItem.getID());
                                Toast.makeText(view.getContext(), "Objeto eliminado", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(view.getContext(), Menu.class);
                                view.getContext().startActivity(intent);
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();

                return false;
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
