package com.majoissa.basesdedades2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Actualitzar extends AppCompatActivity {

    private EditText idTv;
    private EditText name;
    private EditText email;
    private Button actBtn;
    private DBInterface bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualitzar);
        idTv = findViewById(R.id.editTextText3);
        name = findViewById(R.id.editTextText4);
        email = findViewById(R.id.editTextText5);
        actBtn = findViewById(R.id.button3);
        bd = new DBInterface(this);

        actBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = Long.parseLong(idTv.getText().toString());
                String nomStr = name.getText().toString();
                String emailStr = email.getText().toString();
                bd.obre();
                boolean result = bd.actualitzarContacte(id, nomStr, emailStr);
                bd.tanca();
                if (result) {
                    Toast.makeText(Actualitzar.this, "Contacte actualitzat", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Actualitzar.this, "Error al actualitzar contacte", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}