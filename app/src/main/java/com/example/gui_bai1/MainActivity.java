package com.example.gui_bai1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText soA,soB;
    TextView ketQua;
    Button btnTinhTong, btnTinhHieu, btnTinhTich, btnTinhThuong, btnUCLN, btnThoat;

    private int khoitao(){
        soA = findViewById(R.id.soA);
        soB = findViewById(R.id.soB);
        ketQua = findViewById(R.id.ketQua);
        btnTinhTong = findViewById(R.id.btnTinhTong);
        btnTinhHieu = findViewById(R.id.btnTinhHieu);
        btnTinhTich = findViewById(R.id.btnTinhTich);
        btnTinhThuong = findViewById(R.id.btnTinhThuong);
        btnUCLN = findViewById(R.id.btnUCLN);
        btnThoat = findViewById(R.id.btnThoat);

        btnTinhTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt (soA.getText().toString());
                int b= Integer.parseInt(soB.getText().toString());
                int Tong = a+b;
                ketQua.setText(String.valueOf(Tong));
            }
        });

        btnTinhHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt (soA.getText().toString());
                int b= Integer.parseInt(soB.getText().toString());
                int Hieu = a-b;
                ketQua.setText(String.valueOf(Hieu));
            }
        });

        btnTinhTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt (soA.getText().toString());
                int b= Integer.parseInt(soB.getText().toString());
                int Tich = a*b;
                ketQua.setText(String.valueOf(Tich));
            }
        });

        btnTinhThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt (soA.getText().toString());
                int b= Integer.parseInt(soB.getText().toString());
                int Thuong = a/b;
                ketQua.setText(String.valueOf(Thuong));
            }
        });

        btnUCLN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(soA.getText().toString());
                    int b = Integer.parseInt(soB.getText().toString());
                    int ucln = timUCLN(a, b);
                    ketQua.setText(String.valueOf(ucln));
                } catch (NumberFormatException e) {
                    ketQua.setText("Invalid input");
                }
            }
        });


        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        return 0;
    }

    private int timUCLN(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        khoitao();
    }
}