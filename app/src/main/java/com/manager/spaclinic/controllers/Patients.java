package com.manager.spaclinic.controllers;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manager.spaclinic.DAO;
import com.example.spaclinic.R;
import com.manager.spaclinic.RecyclerViewAdapter;
import com.manager.spaclinic.dialog.NewPatient;
import com.manager.spaclinic.models.Model;
import com.manager.spaclinic.models.Patient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Patients#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Patients extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recycler;

    private ArrayList<Model> items = new ArrayList<Model>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FloatingActionButton addButton;

    public Patients() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Patients.
     */
    // TODO: Rename and change types and number of parameters
    public static Patients newInstance(String param1, String param2) {
        Patients fragment = new Patients();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patients, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addButton = getView().findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Runnable r = new Runnable() {
                    public void run() {
                        openDialog();
                    }
                };
                r.run();
            }
        });

        recycler = getView().findViewById(R.id.recycler);

        DAO dao = new DAO(getContext());

        items = (ArrayList<Model>) dao.GetAll(Patient.class, "");

        Recycle(items);
    }

    public void Recycle(ArrayList<Model> items) {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), items);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void openDialog(){
        NewPatient newPatient = new NewPatient();
        newPatient.show(getParentFragmentManager(), "Nuevo Paciente");
    }
}