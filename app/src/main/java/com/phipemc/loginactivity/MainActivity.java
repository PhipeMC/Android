package com.phipemc.loginactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent iObj;
    EditText txtUser;
    EditText txtUserPassword;
    Button btnLogin;
    TextView txtLink;
    Button btnRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUser = findViewById(R.id.txtUser);
        txtUserPassword = findViewById(R.id.txtUserPassword);
        txtLink = findViewById(R.id.txtLink);
        btnRes = findViewById(R.id.btnResolution);

        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            Usuario user = (Usuario) parametros.getSerializable("user");
            txtUser.setText(user.getEmail());
            txtUserPassword.setText(user.getPassword());
        }

        txtLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterIntent.class));
            }
        });

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ResolutionAcivity.class));
            }
        });

        btnLogin = (Button) findViewById(R.id.btnLogin);

    }
}