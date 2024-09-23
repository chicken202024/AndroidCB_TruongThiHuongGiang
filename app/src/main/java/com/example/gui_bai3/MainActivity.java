package com.example.gui_bai3;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public void tinhBMI(){
        Button btnTinhBMI = findViewById(R.id.btntinhBMI);
        EditText nhapten, nhapcc, nhapcn, ketqua, chuandoan;
        nhapten = findViewById(R.id.nhapten);
        nhapcc = findViewById(R.id.nhapcc);
        nhapcn = findViewById(R.id.nhapcn);
        ketqua = findViewById(R.id.ketqua);
        chuandoan = findViewById(R.id.chuandoan);
//        double H = Double.parseDouble(nhapcc.getText()+"");
//        double W = Double.parseDouble(nhapcn.getText()+"");
//        double BMI = W/Math.pow(H,2);
//        String chandoan="";

        btnTinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(nhapcc.getText()) || TextUtils.isEmpty(nhapcn.getText()) || TextUtils.isEmpty(nhapten.getText())){
                    Toast.makeText(MainActivity.this, "Vui long nhap day du thong tin", Toast.LENGTH_SHORT).show();
                }

                double H = Double.parseDouble(nhapcc.getText()+"");
                double W = Double.parseDouble(nhapcn.getText()+"");
                double BMI = W/Math.pow(H,2);
                String chandoan="";
                if(BMI<18)
                {
                    chandoan="Ban gay";
                } else if (BMI<=24.9) {
                    chandoan = "Ban binh thuong";
                } else if (BMI<=29.9) {
                    chandoan = "Ban beo phi do 1";
                } else if (BMI<34.9) {
                    chandoan = "Ban beo phi do 2";
                } else {
                    chandoan = "Ban beo phi do 3";
                }
                DecimalFormat dcf = new DecimalFormat("#.0");
                ketqua.setText(dcf.format(BMI));
                chuandoan.setText(chandoan);

            }


        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       tinhBMI();
    }


}