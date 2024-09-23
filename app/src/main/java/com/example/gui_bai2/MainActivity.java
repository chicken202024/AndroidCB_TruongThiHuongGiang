package com.example.gui_bai2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText doF, doC;
    Button btndoF, btndoC, btnClear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        chuyenDoi();
    }

    private void chuyenDoi(){
        doF = findViewById(R.id.doF);
        doC = findViewById(R.id.doC);
        btndoF = findViewById(R.id.btndoF);
        btndoC= findViewById(R.id.btndoC);
        btnClear = findViewById(R.id.btnClear);

        btndoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!doF.getText().toString().isEmpty()){
                    try{
                        double f = Double.parseDouble(doF.getText().toString());
                        double c = (f -32) * 5 / 9;
                        doC.setText(String.valueOf(c));
                    }catch (NumberFormatException e){
                        doF.setError("Vui long nhap so hop le");
                    }
                }else {
                    doF.setError("Vui long nhap gia tri Fahrenheit");
                }

            }
        });

        btndoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!doC.getText().toString().isEmpty()){
                    try{
                        double c = Double.parseDouble(doC.getText().toString());
                        double f = (c * 9 / 5) + 32;
                        doF.setText(String.valueOf(f));
                    }catch (NumberFormatException e){
                        doC.setError("Vui long nhap so hop le");
                    }
                }else {
                    doC.setError("Vui long nhap gia tri Fahrenheit");
                }

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doC.setText("");
                doF.setText("");
            }
        });
    }
}