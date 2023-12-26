package com.majoissa.basesdedades2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Afegir extends AppCompatActivity {

    private Button afegirBtn;
    private EditText nom;
    private EditText email;
    private DBInterface bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir);

        afegirBtn = findViewById(R.id.button);
        nom = findViewById(R.id.editTextText);
        email = findViewById(R.id.editTextText2);
        bd = new DBInterface(this);

        afegirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomStr = nom.getText().toString();
                String emailStr = email.getText().toString();
                bd.obre();  // Abre la base de datos
                long id = bd.insereixContacte(nomStr, emailStr);
                bd.tanca();  // Cierra la base de datos
                if (id > 0) {
                    Toast.makeText(Afegir.this, "Contacte afegit", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Afegir.this, "Error al afegir contacte", Toast.LENGTH_SHORT).show();
                }
                // Limpiar los campos de texto
                nom.setText("");
                email.setText("");
            }
        });

    }

    }