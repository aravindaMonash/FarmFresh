package com.framfresh.app;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;


public class RegistrationActivity extends AppCompatActivity{

    private Button register;
    private LinearLayout login;

    private TextView dob;
    FirebaseAuth auth;

    EditText email;


    ProgressDialog pd;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);




        pd = new ProgressDialog(this);
        pd.setMessage("Please Wait....");

        //auth = FirebaseAuth.getInstance();



        email = findViewById(R.id.email);

        initComponents();

        clickListenHandler();




    }

    private void initComponents(){

        //Register Button
        register = findViewById(R.id.register);
        //Login Button
        login = findViewById(R.id.login);

        dob = findViewById(R.id.dob);



    }



    private void clickListenHandler(){



        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendar(dob);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerPage = new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(registerPage);
            }
        });

      //  mDatabase=FirebaseDatabase.getInstance().getReference().child("users");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getApplicationContext(),MainActivity.class));

//                pd.show();
//
//                auth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                    @Override
//                    public void onSuccess(AuthResult authResult) {
//
//
//
//
//
//
//                    }
//                });





            }
        });
    }




    //Opening a Calendar Dialog
    private void openCalendar(final TextView dateFieldButton) {
        DatePickerDialog datePickerDialog = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            datePickerDialog = new DatePickerDialog(this);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    String date = year + "-" + month + "-" + dayOfMonth;
                    dateFieldButton.setText(date);
                }
            });
        }

        datePickerDialog.show();
    }


    private boolean fieldRequiredCheck(String firstName,String lastName, String email, String dateOfBirth, String street, String city, String pincode) {


        return  !firstName.equals("") && !lastName.equals("") &&
                !email.equals("")   &&
                !dateOfBirth.equals("")  && !street.equals("") &&
                !city.equals("") ;


    }


    private void toast(String txt){
        Toast toast = Toast.makeText(getApplicationContext(),txt,Toast.LENGTH_SHORT);
        toast.show();
    }

    private int generateID(){
        Random rnd = new Random();
        int id = 202000 + rnd.nextInt(65)+10;
        return id;
    }





}
