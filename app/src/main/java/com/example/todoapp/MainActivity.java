package com.example.todoapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;

    EditText ednama, edpassword;

    TextView butReg;

    String nama, password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btSignIn1);
        butReg = findViewById(R.id.cobaSlideReg);
        ednama = findViewById(R.id.LogNama);
        edpassword = findViewById(R.id.LogPassword);

        final EditText EditChek = (EditText) findViewById(R.id.LogPassword);
        CheckBox c = (CheckBox) findViewById(R.id.checkBox);

        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked) {
                    EditChek.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else{
                    EditChek.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }
            }
        });

        butReg.setOnClickListener(new View.OnClickListener(){
                                      @Override
                                      public void onClick(View view) {
                                          Intent i = new Intent(MainActivity.this, RegisterJava.class);

                                          startActivity(i);
                                      }
                                  });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = ednama.getText().toString();
                password = edpassword.getText().toString();


                if (nama.equals("raffi renanda") && password.equals("raffi")) {
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("data1", nama);

                    Intent i = new Intent(MainActivity.this, Task_Layout.class);
                    i.putExtras(bundle);
                    startActivity(i);

                } else if (nama.equals(nama) && password.equals("raffi")) {
                    Toast.makeText(MainActivity.this, "Nama yang anda masukkan salah", Toast.LENGTH_SHORT).show();
                } else if (nama.equals("raffi renanda") && password.equals(password)) {
                    Toast.makeText(MainActivity.this, "Password salah", Toast.LENGTH_SHORT).show();
                }else if (ednama.getText().toString().isEmpty()) {
                    ednama.setError("Nama Tidak boleh kosong");
                } else {
                    Toast.makeText(MainActivity.this, "Email dan Password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}