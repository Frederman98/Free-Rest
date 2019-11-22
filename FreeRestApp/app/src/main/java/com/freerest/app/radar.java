package com.freerest.app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class radar extends AppCompatActivity {
    RadarChart radar;

    String[] labels = {"atencion recibida", "calidad de la comida", "calidad de bebidas", "relacion calidad-precio",
            "horario"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radar);

        radar = (RadarChart) findViewById(R.id.radar);

        RadarDataSet dataSet = new RadarDataSet(dataValues(), "Satisfaccion");

        dataSet.setColor(Color.BLUE);

        RadarData data = new RadarData();
        data.addDataSet(dataSet);

        XAxis xAxis = radar.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        radar.setData(data);
        radar.invalidate();

        //crearRadar();
    }

    private ArrayList<RadarEntry> dataValues(){
        ArrayList<RadarEntry> dataVals = new ArrayList<>();
        dataVals.add(new RadarEntry(5));
        dataVals.add(new RadarEntry(6));
        dataVals.add(new RadarEntry(1));
        dataVals.add(new RadarEntry(9));
        dataVals.add(new RadarEntry(10));
        return dataVals;
    }

    private void crearRadar() {

    }
}
