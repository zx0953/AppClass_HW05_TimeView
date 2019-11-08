package com.example.appclass_hw05_timeview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerHour;
    Spinner spinnerMin;
    Spinner spinnerSec;
    Spinner spinnerMonth;
    Spinner spinnerDay;
    EditText editYear;
    TextView textToShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editYear = findViewById(R.id.editYear);
        spinnerMin = findViewById(R.id.spinnerMin);
        spinnerSec = findViewById(R.id.spinnerSec);
        spinnerHour = findViewById(R.id.spinnerHour);
        spinnerMonth = findViewById(R.id.spinnerMonth);
        spinnerDay = findViewById(R.id.spinnerDay);
        textToShow = findViewById(R.id.textToShow);
        addItemsOnSpinner();

    }

    public void btnViewOnclick(View view) {
        String strYear = editYear.getText().toString();
        Boolean year229 = false;
        String strMonth = spinnerMonth.getSelectedItem().toString();
        String strDay = spinnerDay.getSelectedItem().toString();
        String strHour = spinnerHour.getSelectedItem().toString();
        String strMin = spinnerMin.getSelectedItem().toString();
        String strSec = spinnerSec.getSelectedItem().toString();
        if (!strYear.equals("")) {
            Integer intYear = Integer.parseInt(strYear);

            if (intYear % 4 > 0) {
                Toast.makeText(this, "這年不是閏年", Toast.LENGTH_SHORT).show();
            } else {
                if (intYear % 100 > 0) {
                    Toast.makeText(this, "這年是閏年", Toast.LENGTH_SHORT).show();
                    year229 = true;
                } else {
                    if (intYear % 400 > 0) {
                        Toast.makeText(this, "這年不是閏年", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "這年是閏年", Toast.LENGTH_SHORT).show();
                        year229 = true;
                    }
                }
            }
            if (strMonth.equals("04") || strMonth.equals("06") || strMonth.equals("09") || strMonth.equals("11")) {
                if (strDay.equals("31")) {
                    spinnerDay.setSelection(29);
                    strDay = spinnerDay.getSelectedItem().toString();
                }
            }

            if (strMonth.equals("02")) {
                Integer intDay = Integer.parseInt(strDay);
                if (intDay >= 29) {
                    if (year229) {
                        spinnerDay.setSelection(28);
                    } else {
                        spinnerDay.setSelection(27);
                    }
                    strDay = spinnerDay.getSelectedItem().toString();
                }
            }

            textToShow.setText(strYear + "/" + strMonth + "/" + strDay + "  " + strHour + ":" + strMin + ":" + strSec);
        } else {
            Toast.makeText(this, "請輸入年份", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void addItemsOnSpinner() {

        List<String> list59 = new ArrayList<String>();
        for (int i = 0; i <= 59; i++) {
            if(i<10){
                list59.add("0" + i);
            }else{
                list59.add("" + i);
            }
        }
        ArrayAdapter<String> dataAdapter59 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list59);
        dataAdapter59.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        List<String> list23 = new ArrayList<String>();
        for (int i = 0; i <= 23; i++) {
            if(i<10){
                list23.add("0" + i);
            }else{
                list23.add("" + i);
            }

        }
        ArrayAdapter<String> dataAdapter23 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list23);
        dataAdapter23.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        List<String> list12 = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            if(i<10){
                list12.add("0" + i);
            }else{
                list12.add("" + i);
            }
        }
        ArrayAdapter<String> dataAdapter12 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list12);
        dataAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        List<String> list31 = new ArrayList<String>();
        for (int i = 1; i <= 31; i++) {
            if(i<10){
                list31.add("0" + i);
            }else{
                list31.add("" + i);
            }
        }
        ArrayAdapter<String> dataAdapter31 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list31);
        dataAdapter31.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerHour.setAdapter(dataAdapter23);
        spinnerMin.setAdapter(dataAdapter59);
        spinnerSec.setAdapter(dataAdapter59);
        spinnerMonth.setAdapter(dataAdapter12);
        spinnerDay.setAdapter(dataAdapter31);
    }
}
