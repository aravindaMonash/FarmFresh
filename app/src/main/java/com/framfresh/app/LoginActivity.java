package com.framfresh.app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginActivity extends AppCompatActivity {

    private LinearLayout register;
    private TextView forgotPass;
    private Button login;

    private EditText email;
    private EditText password;



    FirebaseAuth auth;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_2);

        pd = new ProgressDialog(this);
        pd.setMessage("Please Wait....");

        auth = FirebaseAuth.getInstance();


        initComponents();
        clickListenHandler();

    }

    private void initComponents(){

        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        forgotPass = findViewById(R.id.forgot_password);


        email = findViewById(R.id.email);
        password = findViewById(R.id.password);



    }



    private void clickListenHandler(){

        //Register Listener
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerPage = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(registerPage);
            }
        });

        //Login Listener
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pd.show();


                auth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        pd.dismiss();

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();





                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull  Exception e) {


                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });


            }
        });

        //Forgot Password Listener

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });






    }


}
