package com.example.todoapp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result_Task_Layout extends AppCompatActivity {

    TextView accTask, accWaktu, accJenis;
    String accTaskS, accJenisS, accWaktuS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_task_layout);

        accTask = findViewById(R.id.accTask);
        accJenis = findViewById(R.id.accJenis);
        accWaktu = findViewById(R.id.accWaktu);
        Bundle bundle = getIntent().getExtras();
        accTaskS = bundle.getString("data001");
        accWaktuS = bundle.getString("data002");
        accJenisS = bundle.getString("data003");
        accTask.setText(accTaskS);
        accJenis.setText(accJenisS);
        accWaktu.setText(accWaktuS);

    }
}
