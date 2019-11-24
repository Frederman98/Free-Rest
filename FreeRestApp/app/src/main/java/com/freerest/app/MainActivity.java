package com.freerest.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    PieChart pastel;
    RadarChart radar;

    private float[] datosPastel = {25.3f, 10.6f, 66.76f, 44.32f, 46.01f};
    private String[] etiquetasPastel = {"Unidad 1", "Uniadad 2" , "Unidad 3" , "Unidad 4", "Unidad 5"};

    String[] labels = {"atencion recibida", "calidad de la comida", "calidad de bebidas", "relacion calidad-precio",
            "horario"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pastel = (PieChart) findViewById(R.id.pastel1);

        crearGraficoPastel();

        pastel.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Log.d(TAG, "onValueSelected: Value select from chart.");
                Log.d(TAG, "onValueSelected: " + e.toString());
                Log.d(TAG, "onValueSelected: " + h.toString());

                Intent intent = new Intent(MainActivity.this, radar.class);
                intent.putExtra("DatosUN", h.toString());
                startActivity(intent);

            }

            @Override
            public void onNothingSelected() {

            }
        });

        pastel.setHoleRadius(0);
        pastel.setTransparentCircleAlpha(0);
        pastel.setEntryLabelTextSize(0);

//crenado graico de radar

        radar = (RadarChart) findViewById(R.id.radar);

        RadarDataSet dataSet = new RadarDataSet(dataValues(), "Satisfaccion");

        dataSet.setColor(Color.BLUE);

        RadarData data = new RadarData();
        data.addDataSet(dataSet);

        XAxis xAxis = radar.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        radar.setData(data);
        radar.invalidate();
        radar.setScaleY(1.7f);
        radar.setScaleX(1.7f);

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

    private void crearGraficoPastel() {

        Log.d(TAG, "addDataSet started");
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        for (int i=0; i<datosPastel.length; i++){
            pieEntries.add(new PieEntry(datosPastel[i], etiquetasPastel[i]));
        }

        //add colors to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);
        colors.add(Color.MAGENTA);


        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");
        pieDataSet.setColors(colors);

        PieData pieData = new PieData(pieDataSet);


        pastel.setData(pieData);
    }
}
