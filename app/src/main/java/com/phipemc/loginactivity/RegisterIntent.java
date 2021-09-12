package com.phipemc.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class RegisterIntent extends AppCompatActivity {

    Button btnSave;
    Button btnCancel;
    Intent intentObj;
    EditText txtName;
    EditText txtPhone;
    EditText txtEmail;
    EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_intent);

        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString();
                String phone = txtPhone.getText().toString();
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                Usuario user = new Usuario(name,phone, email, password);
                Bundle objSend = new Bundle();
                intentObj = new Intent(getApplicationContext(), MainActivity.class);
                objSend.putSerializable("user",user);
                intentObj.putExtras(objSend);
                startActivity(intentObj);
            }
        });

        btnCancel.setOnClickListener(view -> {
            super.onBackPressed();
        });
    }
}