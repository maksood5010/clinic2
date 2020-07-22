package com.example.user.clinic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner sp;
    EditText edBlood,name,email,password;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edBlood=(EditText)findViewById(R.id.edBlood);
        name=(EditText)findViewById(R.id.editText7);
        email=(EditText)findViewById(R.id.editText8);
        password=(EditText)findViewById(R.id.editText9);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.groups,
                R.layout.color_spinner_layout
        );
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        sp=(Spinner)findViewById(R.id.spinner);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(this);




    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (sp.getSelectedItem().toString().equals("Blood group")){

        }
        else {

            edBlood.setText(sp.getSelectedItem().toString());
            Toast.makeText(getBaseContext(), sp.getSelectedItem().toString(),
                    Toast.LENGTH_SHORT).show();
        }
        }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
