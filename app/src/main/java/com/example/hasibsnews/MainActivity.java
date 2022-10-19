package com.example.hasibsnews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<Model> list = new ArrayList<>();
    Model model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        list.add(new Model(R.drawable.prothomalo, "Prothom Alo", 3.4f, "https://www.prothomalo.com/"));
        list.add(new Model(R.drawable.bangladeshprotidin, "Bangladesh Protidin", 3.4f, "https://www.bd-pratidin.com/"));
        list.add(new Model(R.drawable.ittefaq, "Doinik Ittefaq", 3.4f, "https://www.ittefaq.com.bd/"));
        list.add(new Model(R.drawable.kalerkontho, "Kaler Kontho", 3.4f, "https://www.kalerkantho.com/"));
        list.add(new Model(R.drawable.noyadigonto, "Daily Naya Diganta", 3.4f, "https://www.dailynayadiganta.com/"));
        list.add(new Model(R.drawable.amadersongbad, "Amader Songbad", 3.4f, "https://www.amarsangbad.com/"));
        list.add(new Model(R.drawable.jugantor, "Jugantor", 3.4f, "https://www.jugantor.com/"));
        list.add(new Model(R.drawable.amadersomoy, "Amader Shomoy", 3.4f, "https://www.dainikamadershomoy.com/"));


        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new Adapter(this, list);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                startActivity(new Intent(MainActivity.this, WebviewActivity.class)
                        .putExtra("url", list.get(position).getUrl())
                );
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


    }

    @Override
    public void onBackPressed() {

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure want to Exit ?")
                .setIcon(R.drawable.ic_baseline_exit_to_app_24)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.super.onBackPressed();
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create();
        dialog.show();

    }
}