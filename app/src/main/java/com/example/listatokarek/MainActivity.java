package com.example.listatokarek;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public class Samochod{
        String marka;
        String model;
        int rocznik;
        boolean wlasciciel;
        int stan;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Spinner marka = findViewById(R.id.marka);
        ListView model = findViewById(R.id.model);
        SeekBar rocznik = findViewById(R.id.rocznik);
        CheckBox wlasciciel = findViewById(R.id.wlasciciel);
        RadioGroup historia = findViewById(R.id.historia);
        ListView lista = findViewById(R.id.lista);
        ArrayList<Samochod> samochodyLista = new ArrayList<>();
        rocznik.setMax(Calendar.getInstance().get(Calendar.YEAR));

        ArrayAdapter<Samochod> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
        lista.setAdapter(arrayAdapter);

        ArrayList<String> modeleToyota = new ArrayList<>();
        modeleToyota.add("Corolla");
        modeleToyota.add("Avensis");
        modeleToyota.add("GT86");
        ArrayList<String> [] modele = new ArrayList[3];
        modele[0] = modeleToyota;

        ArrayList<String> modeleMazda = new ArrayList<>();
        modeleMazda.add("RX7");
        modeleMazda.add("RX8");
        modeleMazda.add("MX5");
        modele[1] = modeleMazda;

        ArrayList<String> modeleBMW = new ArrayList<>();
        modeleBMW.add("M3");
        modeleBMW.add("535d");
        modeleBMW.add("135i");
        modele[2] = modeleBMW;

        marka.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String wybranaMarka = adapterView.getSelectedItem().toString();
                ArrayAdapter<String> adapterModele = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, modele[i]);
                model.setAdapter(adapterModele);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}