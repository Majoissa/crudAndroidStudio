package com.majoissa.basesdedades2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ObtenirTots extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private List<User> userList;
    private DBInterface bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obtenir_tots);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        bd = new DBInterface(this);
        bd.obre();
        Cursor cursor = bd.obtenirTotsElsContactes();

        userList = new ArrayList<>();

        while (cursor.moveToNext()) {
            @SuppressLint("Range") long id = cursor.getLong(cursor.getColumnIndex(DBInterface.CLAU_ID));
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(DBInterface.CLAU_NOM));
            @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex(DBInterface.CLAU_EMAIL));
            userList.add(new User(id, name, email));
        }

        cursor.close();
        bd.tanca();

        adapter = new UserAdapter(userList);
        recyclerView.setAdapter(adapter);
    }
}
