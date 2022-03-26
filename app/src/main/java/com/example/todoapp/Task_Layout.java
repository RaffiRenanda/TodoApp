package com.example.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Task_Layout extends AppCompatActivity {
    TextView emailText;
    EditText edtTask, edtJenis, edtTime;
    FloatingActionButton fab;
    String tambahTaks, tambahJenis, tambahWaktu;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        tambahTaks = edtTask.getText().toString();
        tambahJenis = edtJenis.getText().toString();
        tambahWaktu = edtTime.getText().toString();

        edtTask = findViewById(R.id.addTask);
        edtJenis = findViewById(R.id.jenisTask);
        edtTime = findViewById(R.id.waktuTask);

        if (item.getItemId() == R.id.meSubm) {


            if (edtTask.getText().toString().isEmpty()) {
                edtTask.setError("Nama Task");
            } else if (edtJenis.getText().toString().isEmpty()) {
                edtJenis.setError("Jenis Task");
            } else if (edtTime.getText().toString().isEmpty()) {
                edtTime.setError("Waktu Task");
            } else {

                Toast.makeText(getApplicationContext(), "Task Tersimpan...", Toast.LENGTH_SHORT).show();
                Bundle b = new Bundle();
                b.putString("data001", tambahTaks);
                b.putString("data002", tambahWaktu);
                b.putString("data003", tambahJenis);

                Intent inten = new Intent(getApplicationContext(), Result_Task_Layout.class);
                inten.putExtras(b);
                startActivity(inten);
            }
            }else if (item.getItemId() == R.id.meOut) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }

            return super.onOptionsItemSelected(item);
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_layout);

        emailText = findViewById(R.id.tf_email);
        Bundle bundle = getIntent().getExtras();
        String email = bundle.getString("data1");
        emailText.setText(email);


        edtTask = findViewById(R.id.addTask);
        edtJenis = findViewById(R.id.jenisTask);
        edtTime = findViewById(R.id.waktuTask);
        fab = findViewById(R.id.fabSimpan);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahTaks = edtTask.getText().toString();
                tambahJenis = edtJenis.getText().toString();
                tambahWaktu = edtTime.getText().toString();

                if (edtTask.getText().toString().isEmpty()) {
                    edtTask.setError("Nama Task");
                } else if (edtJenis.getText().toString().isEmpty()) {
                    edtJenis.setError("Jenis Task");
                } else if (edtTime.getText().toString().isEmpty()) {
                    edtTime.setError("Waktu Task");
                } else {
                    Snackbar.make(view, "Task Tersimpan", Snackbar.LENGTH_SHORT).show();

                    Bundle bb = new Bundle();
                    bb.putString("data001", tambahTaks);
                    bb.putString("data002", tambahWaktu);
                    bb.putString("data003", tambahJenis);

                    Intent in = new Intent(getApplicationContext(), Result_Task_Layout.class);
                    in.putExtras(bb);
                    startActivity(in);

                }
            }
        });

    }


}