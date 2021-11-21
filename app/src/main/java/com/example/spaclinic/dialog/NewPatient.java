package com.example.spaclinic.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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

import com.example.spaclinic.DAO;
import com.example.spaclinic.R;
import com.example.spaclinic.models.Patient;

public class NewPatient extends AppCompatDialogFragment {

    private EditText rut;
    private EditText firstName;
    private EditText lastName;
    private EditText birthdate;
    private EditText address;
    private EditText phone;
    private EditText email;
    private EditText emergencyPhone;
    private EditText occupation;
    private EditText patientAllergies;
    private EditText patientDrugs;
    private EditText patientHabits;
    private EditText patientMorbidHistory;
    private EditText patientSurgicalHistory;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.new_patient, null);

        rut = view.findViewById(R.id.rut);
        firstName = view.findViewById(R.id.firstName);
        lastName = view.findViewById(R.id.lastName);
        birthdate = view.findViewById(R.id.birthdate);
        address = view.findViewById(R.id.address);
        email = view.findViewById(R.id.email);
        phone = view.findViewById(R.id.phone);
        emergencyPhone = view.findViewById(R.id.emergencyPhone);
        occupation = view.findViewById(R.id.occupation);
        patientAllergies = view.findViewById(R.id.patientAllergies);
        patientDrugs = view.findViewById(R.id.patientDrugs);
        patientHabits = view.findViewById(R.id.patientHabits);
        patientMorbidHistory = view.findViewById(R.id.patientMorbidHistory);
        patientSurgicalHistory = view.findViewById(R.id.patientSurgicalHistory);

        builder.setView(view)
                .setTitle("Nuevo Paciente")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Crear", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(rut.getText().toString().isEmpty()
                        || firstName.getText().toString().isEmpty()
                        || lastName.getText().toString().isEmpty()
                        || birthdate.getText().toString().isEmpty()
                        || address.getText().toString().isEmpty()
                        || phone.getText().toString().isEmpty()
                        || email.getText().toString().isEmpty()
                        || emergencyPhone.getText().toString().isEmpty()
                        || occupation.getText().toString().isEmpty()
                        || patientAllergies.getText().toString().isEmpty()
                        || patientDrugs.getText().toString().isEmpty()
                        || patientHabits.getText().toString().isEmpty()
                        || patientMorbidHistory.getText().toString().isEmpty()
                        || patientSurgicalHistory.getText().toString().isEmpty()){
                            Toast.makeText(getContext(),"Favor llenar todos los campos.",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Patient patient = new Patient();
                        patient.setRut(rut.getText().toString());
                        patient.setFirstName(firstName.getText().toString());
                        patient.setLastName(lastName.getText().toString());
                        patient.setBirthdate(birthdate.getText().toString());
                        patient.setAddress(address.getText().toString());
                        patient.setPhone(phone.getText().toString());
                        patient.setEmail(email.getText().toString());
                        patient.setEmergencyPhone(emergencyPhone.getText().toString());
                        patient.setOccupation(occupation.getText().toString());
                        patient.setAllergies(patientAllergies.getText().toString());
                        patient.setDrugs(patientDrugs.getText().toString());
                        patient.setHabits(patientHabits.getText().toString());
                        patient.setMorbid(patientMorbidHistory.getText().toString());
                        patient.setClinical(patientSurgicalHistory.getText().toString());


                        DAO dao = new DAO(getContext());
                        dao.insert(patient);
                        Toast.makeText(getContext(),"Paciente creado correctamente!",Toast.LENGTH_SHORT).show();
                    }
                });

        return builder.create();
    }
}
