package com.manager.spaclinic.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.manager.spaclinic.DAO;
import com.manager.spaclinic.Menu;
import com.example.spaclinic.R;
import com.manager.spaclinic.models.Service;

public class NewService extends AppCompatDialogFragment {

    private EditText serviceName;
    private EditText serviceCost;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.new_service, null);

        serviceName = view.findViewById(R.id.serviceName);
        serviceCost = view.findViewById(R.id.serviceCost);

        builder.setView(view)
                .setTitle("Nuevo Servicio")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Crear", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(serviceName.getText().toString().isEmpty()
                        || serviceCost.getText().toString().isEmpty()){
                            Toast.makeText(getContext(),"Favor llenar todos los campos.",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Service service = new Service();
                        service.setService(serviceName.getText().toString());
                        service.setCost(Integer.parseInt(serviceCost.getText().toString()));

                        DAO dao = new DAO(getContext());
                        dao.insert(service);
                        Toast.makeText(getContext(),"Servicio creado correctamente!",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getContext(), Menu.class);
                        getContext().startActivity(intent);
                    }
                });

        return builder.create();
    }
}
