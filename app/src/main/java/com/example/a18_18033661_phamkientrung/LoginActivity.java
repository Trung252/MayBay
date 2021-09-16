package com.example.a18_18033661_phamkientrung;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a18_18033661_phamkientrung.Entity.Account;
import com.example.a18_18033661_phamkientrung.Handler.AccountDatabaseHandler;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;
import java.util.Date;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtEmail, edtPass;
    Button btnLogin;

    FirebaseAuth auth;

    AccountDatabaseHandler db;

    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new AccountDatabaseHandler(this);

        MappingId();

        edtEmail.setText("trung123@gmail.com");
        edtPass.setText("123456");

        btnLogin.setOnClickListener(this);
    }

    private void MappingId() {
        edtEmail = findViewById(R.id.edt_email);
        edtPass = findViewById(R.id.edt_pass);

        btnLogin = findViewById(R.id.btnLogin);

        auth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        if(v.equals(btnLogin))
            Login();
    }

    private void Login() {
        String email = edtEmail.getText().toString();
        String password = edtPass.getText().toString();

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Date currentTime = Calendar.getInstance().getTime();
                            account = new Account(email, currentTime);
                            db.add(account);
                            Toast.makeText(LoginActivity.this,"Login at " + currentTime, Toast.LENGTH_SHORT).show();
                            Log.d("Time", currentTime + "");
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this,"Invalid username or password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}