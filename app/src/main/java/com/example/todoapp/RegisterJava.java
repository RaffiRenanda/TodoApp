package com.example.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class RegisterJava extends AppCompatActivity {
    Button btnReg;

    EditText ednama, edPassword, edEmail, edRepass;

    String nama, password, email, repassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        btnReg = findViewById(R.id.btnRegistrasiBaru);
        ednama = findViewById(R.id.RegNama);
        edPassword = findViewById(R.id.RegPass);
        edRepass = findViewById(R.id.RegRepas);
        edEmail = findViewById(R.id.RegEmail);

        final EditText EditChek1 = (EditText) findViewById(R.id.RegPass);
        final EditText EditChek2 = (EditText) findViewById(R.id.RegRepas);
        CheckBox c1 = (CheckBox) findViewById(R.id.checkBoxpass);
        CheckBox c2 = (CheckBox) findViewById(R.id.checkBoxpass2);

        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked) {
                    EditChek1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else{
                    EditChek1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }
            }
        });

        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked) {
                    EditChek2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else{
                    EditChek2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }
            }
        });


        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = ednama.getText().toString();
                password = edPassword.getText().toString();
                repassword = edRepass.getText().toString();
                email = edEmail.getText().toString();

                if (ednama.getText().toString().isEmpty()) {
                    ednama.setError("Nama Tidak boleh kosong");
                } else if (edEmail.getText().toString().isEmpty()) {
                    edEmail.setError("Email Tidak boleh kosong");
                } else if (edPassword.getText().toString().isEmpty()) {
                    edPassword.setError("Password Tidak boleh kosong");
                } else if (edRepass.getText().toString().isEmpty()) {
                    edRepass.setError("Re-Password Tidak boleh kosong");
                } else {

                    if (edPassword.getText().toString().equals(edRepass.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil...", Toast.LENGTH_SHORT).show();
                        Bundle bundle = new Bundle();

                        bundle.putString("data1", nama);

                        Intent i = new Intent(RegisterJava.this, Task_Layout.class);
                        i.putExtras(bundle);
                        startActivity(i);

                    } else {
                        Snackbar.make(view, "Password dan Repassword  harus sama!!", Snackbar.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}