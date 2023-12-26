package com.majoissa.basesdedades2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Esborrar extends AppCompatActivity {
    private EditText idEt;
    private Button btnBorrar;
    private DBInterface bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esborrar);

        idEt = findViewById(R.id.idBorrar);
        btnBorrar = findViewById(R.id.btnBorrar);
        bd = new DBInterface(this);

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = Long.parseLong(idEt.getText().toString());
                bd.obre();
                boolean deleted = bd.esborraContacte(id);
                bd.tanca();
                if (deleted) {
                    Toast.makeText(Esborrar.this, "Contacte esborrat", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Esborrar.this, "Error al esborrar contacte", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}