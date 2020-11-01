package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Note extends AppCompatActivity {

    private EditText noteEt;
    private Button loadbtn;
    private Button savebtn;
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        noteEt = findViewById(R.id.noteEt);
        loadbtn = findViewById(R.id.loadbtn);
        savebtn = findViewById(R.id.savebtn);

        sp = getSharedPreferences("USER_PREF", Context.MODE_PRIVATE);





        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "";
                message = noteEt.getText().toString();


                SharedPreferences.Editor editor = sp.edit();
                editor.putString("NOTES", message);
                editor.commit();
                Toast.makeText(Note.this, "SAVED!", Toast.LENGTH_SHORT).show();


            }
        });

        loadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder str = new StringBuilder();
                if (sp.contains("NOTES")) {
                    noteEt.setText(sp.getString("NOTES", ""));
                }





            }
        });


    }
}