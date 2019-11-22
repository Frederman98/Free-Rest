package com.freerest.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class grafico_barras extends AppCompatActivity {
    BarChart barras1;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico_barras);

        barras1 = (BarChart) findViewById(R.id.barras1);
        boton = (Button) findViewById(R.id.button2);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(grafico_barras.this, radar.class);
                startActivity(intent);
            }
        });
        crearBarras();

    }

    private void crearBarras() {
        ArrayList<BarEntry> barEntries = new ArrayList<>();

        //cambiar los valores por cant_u1 ... u4

        barEntries.add(new BarEntry(1,44));
        barEntries.add(new BarEntry(2,88));
        barEntries.add(new BarEntry(3,66));
        barEntries.add(new BarEntry(4,33));

        BarDataSet barDataSet = new BarDataSet(barEntries, "dates");
        //pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        ArrayList<String> categorias = new ArrayList<>();
        categorias.add("comida");
        categorias.add("bebidas");
        categorias.add("otros");


        BarData barData = new BarData(barDataSet);


        barras1.setData(barData);

        barras1.setTouchEnabled(true);
        barras1.setDragEnabled(true);
        barras1.setScaleEnabled(true);

    }
}
