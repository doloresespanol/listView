package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdapterView.OnItemClickListener kliknietyElement = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String kategoria = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, kategoria, Toast.LENGTH_SHORT).show();
            }
        };
        ListView listViewKategorie = findViewById(R.id.listViewKategorie);
        listViewKategorie.setOnItemClickListener(kliknietyElement);

        AdapterView.OnItemSelectedListener wybranyElement = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String kategoria = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, kategoria, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };

        Spinner listViewKategorie1 = findViewById(R.id.spinner);
        listViewKategorie1.setOnItemSelectedListener(wybranyElement);

        ArrayList<String> planszowki = new ArrayList<>();
        planszowki.add("Cyklady");
        planszowki.add("Santorini");
        planszowki.add("Szachy");
        planszowki.add("UNO");
        planszowki.add("Monopoly");
        planszowki.add("Sonar");
        planszowki.add("Remik");

        ArrayAdapter<String> adapterPlanszowki = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,planszowki);
        ListView listViewPlanszowki = findViewById(R.id.listViewPlanszowki);
        listViewPlanszowki.setAdapter(adapterPlanszowki);

        AdapterView.OnItemClickListener clickedElement = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                planszowki.remove(position);
                adapterPlanszowki.notifyDataSetChanged();
            }
        };
        listViewPlanszowki.setOnItemClickListener(clickedElement);
        EditText editTekst = findViewById(R.id.editText);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nazwa = editTekst.getText().toString();
                planszowki.add(nazwa);
                adapterPlanszowki.notifyDataSetChanged();
            }
        });
    }
}