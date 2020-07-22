package com.example.user.clinic;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button submit,login;

    RadioGroup radioSexGroup;
    EditText name,dob,email,mobile,password;
    TextView text;
    LinearLayout pg;
    private DatabaseHelper databaseHelper;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit=(Button)findViewById(R.id.button);
        radioSexGroup=(RadioGroup)findViewById(R.id.radioGroup2);
        name=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.edittext9);
        email=(EditText)findViewById(R.id.editText5);
        mobile=(EditText)findViewById(R.id.editText6);
        dob=(EditText)findViewById(R.id.editText2);
        login=(Button)findViewById(R.id.button2);
        pg=(LinearLayout) findViewById(R.id.layout2);
        text=(TextView)findViewById(R.id.textview03);

        databaseHelper=new DatabaseHelper(this);
        user=new User();

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this,Rcycle.class);
                startActivity(in);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date,mail=email.getText().toString().trim();
                String name1=name.getText().toString().trim();
                Boolean isvalid=emailValidator(mail);
                date=dob.getText().toString().trim();
                Boolean validdob=dobValidator(date);

                if (name1.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"name cannot be empty",Toast.LENGTH_LONG).show();
                } else if(!isvalid) {
                    Toast.makeText(getApplicationContext(), "invalid email", Toast.LENGTH_LONG).show();
                } else if (!validdob){
                    Toast.makeText(getApplicationContext(), "date is not valid", Toast.LENGTH_LONG).show();
                } else if (radioSexGroup.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getApplicationContext(), "select gender", Toast.LENGTH_LONG).show();
                }
                else {

                    if (!databaseHelper.checkUser(email.getText().toString().trim()))
                    {
                        user.setName(name.getText().toString().trim());
                        user.setEmail(email.getText().toString().trim());
                        user.setPassword(password.getText().toString().trim());
                        databaseHelper.addUser(user);
                        progHandle();
                        Intent in=new Intent(MainActivity.this, ListActivity.class);
                        startActivity(in);

                    }
                    else {
                        Toast.makeText(getApplicationContext(),getString(R.string.error_email_exists),Toast.LENGTH_LONG).show();
                    }
                }




            }

        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this,Login.class);
                startActivity(in);

            }
        });


    }
    private boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean dobValidator(String dob)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(dob);
        return matcher.matches();
    }
    private void progHandle(){
        pg.setVisibility(View.VISIBLE);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //Write whatever to want to do after delay specified (1 sec)
                pg.setVisibility(View.GONE);
                Log.d("Handler", "Running Handler");
            }
        }, 5000);


    }

}
