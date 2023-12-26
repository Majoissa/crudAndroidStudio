package com.majoissa.basesdedades2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAfegir, btnObtenir, btnObtenirTots, btnActualitzar, btnEsborrar;
    DBInterface bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bd = new DBInterface(this);

        //Listeners dels botons
        btnAfegir = (Button) findViewById(R.id.btnAfegir);
        btnAfegir.setOnClickListener(this);

        btnObtenirTots = (Button) findViewById(R.id.btnObtenirTots);
        btnObtenirTots.setOnClickListener(this);

        btnObtenir = (Button) findViewById(R.id.btnObtenir);
        btnObtenir.setOnClickListener(this);

        btnEsborrar = (Button) findViewById(R.id.btnEsborrar);
        btnEsborrar.setOnClickListener(this);

        btnActualitzar = (Button) findViewById(R.id.btnActualitzar);
        btnActualitzar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //Afegir
        if (v == btnAfegir) {
            startActivity(new Intent(this, Afegir.class));
            }

        //Obtenir
        if (v == btnObtenir) {
            startActivity(new Intent(this, Obtenir.class));
        }

        //Actualizar
        if (v == btnActualitzar) {
            startActivity(new Intent(this, Actualitzar.class));
        }

        //ObtenirTots
        if (v == btnObtenirTots){
            startActivity(new Intent(this, ObtenirTots.class));
        }

        //esborrar
        if (v == btnEsborrar){
            startActivity(new Intent(this, Esborrar.class));
        }
    }
}