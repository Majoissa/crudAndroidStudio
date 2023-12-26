package com.majoissa.basesdedades2023;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Obtenir extends AppCompatActivity {

    private EditText obtenir;
    private Button obtenirBtn;
    private DBInterface bd;

    private TextView name;
    private TextView mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obtenir);

        obtenir = findViewById(R.id.idObtener);
        obtenirBtn = findViewById(R.id.btnObtener);
        name = findViewById(R.id.nom);
        mail = findViewById(R.id.mail);
        bd = new DBInterface(this);
        obtenirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    long id = Long.parseLong(obtenir.getText().toString());
                    bd.obre();
                    Cursor cursor = bd.obtenirContacte(id);
                    if (cursor.moveToFirst()) {
                        String nom = cursor.getString(cursor.getColumnIndexOrThrow(DBInterface.CLAU_NOM));
                        String email = cursor.getString(cursor.getColumnIndexOrThrow(DBInterface.CLAU_EMAIL));
                        name.setText(nom);
                        mail.setText(email);
                    } else {
                        Toast.makeText(Obtenir.this, "Contacte no trobat", Toast.LENGTH_LONG).show();
                    }
                    cursor.close();
                    bd.tanca();
                } catch (NumberFormatException nfe) {
                    Toast.makeText(Obtenir.this, "El ID introduït no és vàlid.", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(Obtenir.this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}