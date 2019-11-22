package com.freerest.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    PieChart pastel;
    Button boton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pastel = (PieChart) findViewById(R.id.pastel1);
        boton1 = (Button) findViewById(R.id.button);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, grafico_barras.class);
                startActivity(intent);
            }
        });

        crearGraficoPastel();


    }

    private void crearGraficoPastel() {

        Description description = new Description();
        description.setText("Grafico de pastel");
        pastel.setDescription(description);
        //pastel.setUsePercentValues(true);

        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        //cambiar los valores por cant_u1 ... u4

        pieEntries.add(new PieEntry(1000, "unidad 1"));
        pieEntries.add(new PieEntry(5300, "unidad 2"));
        pieEntries.add(new PieEntry(4200, "unidad 3"));
        pieEntries.add(new PieEntry(2580, "unidad 4"));

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "descripcion");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData pieData = new PieData(pieDataSet);


        pastel.setData(pieData);
    }
}
