package com.example.may_tinh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button  btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAC, btnDEL, btnchia, btnnhan, btncong, btntru, btnbang, btncham;
    TextView textLS, textKQ;
    private String number = null;
    private double a=0, b=0;
    boolean operator=false;
    boolean isEqual=false;
    boolean dot=true;
    boolean del=true;
    String status = null;
    String LS, KQ;
    private boolean isFirstInput = true;


    DecimalFormat decimalFormat = new DecimalFormat("###,###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnchia = findViewById(R.id.btnchia);
        btnnhan = findViewById(R.id.btnnhan);
        btntru = findViewById(R.id.btntru);
        btncong = findViewById(R.id.btncong);

        btnAC = findViewById(R.id.btnAC);
        btnDEL = findViewById(R.id.btnDEL);
        btnbang = findViewById(R.id.btnbang);
        btncham = findViewById(R.id.btncham);

        textLS=findViewById(R.id.textLS);
        textKQ = findViewById(R.id.textKQ);


//        btn0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                numberclick("0");
//            }
//        });
        btn0.setOnClickListener(view -> numberclick("0"));
        btn1.setOnClickListener(view -> numberclick("1"));
        btn2.setOnClickListener(view -> numberclick("2"));
        btn3.setOnClickListener(view -> numberclick("3"));
        btn4.setOnClickListener(view -> numberclick("4"));
        btn5.setOnClickListener(view -> numberclick("5"));
        btn6.setOnClickListener(view -> numberclick("6"));
        btn7.setOnClickListener(view -> numberclick("7"));
        btn8.setOnClickListener(view -> numberclick("8"));
        btn9.setOnClickListener(view -> numberclick("9"));

        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isEqual){
                    LS = textLS.getText().toString();
                    KQ = textKQ.getText().toString();
                    textLS.setText((KQ+"+"));
                }else {
                    LS = textLS.getText().toString();
                    KQ = textKQ.getText().toString();
                    textLS.setText((LS+KQ+"+"));
                }

                if(operator){
                    if(status=="Hieu"){
                        Tru();
                    } else if (status == "Tich") {
                        Nhan();
                    } else if (status=="Thuong") {
                        Chia();
                    }else {
                        Cong();
                    }
                }
                operator = false;
                number = null;
                status="Tong";
                isEqual=false;
            }

        });

        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEqual){
                    LS = textLS.getText().toString();
                    KQ = textKQ.getText().toString();
                    textLS.setText((KQ+"-"));
                }else {
                    LS = textLS.getText().toString();
                    KQ = textKQ.getText().toString();
                    textLS.setText((LS+KQ+"-"));

                }
                if(operator){
                    if(status=="Tong"){
                        Cong();
                    } else if (status == "Tich") {
                        Nhan();
                    } else if (status=="Thuong") {
                        Chia();
                    }else {
                        Tru();
                    }
                }
                operator = false;
                number = null;
                status="Hieu";
                isEqual=false;
            }

        });

        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isEqual){
                    LS = textLS.getText().toString();
                    KQ = textKQ.getText().toString();
                    textLS.setText((KQ+"*"));

                }else {
                    LS = textLS.getText().toString();
                    KQ = textKQ.getText().toString();
                    textLS.setText((LS+KQ+"*"));

                }

                if(operator){
                    if(status=="Tong"){
                        Cong();
                    } else if (status=="Hieu") {
                        Tru();
                    } else if (status=="Thuong") {
                        Chia();
                    }else {
                        Nhan();
                    }
                }
                operator = false;
                number=null;
                status = "Tich";
                isEqual=false;
            }
        });

        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isEqual){
                    LS = textLS.getText().toString();
                    KQ = textKQ.getText().toString();
                    textLS.setText((KQ+"/"));

                }else {
                    LS = textLS.getText().toString();
                    KQ = textKQ.getText().toString();
                    textLS.setText((LS+KQ+"/"));

                }

                if(operator){
                    if(status=="Tong"){
                        Cong();
                    } else if (status == "Hieu") {
                        Tru();
                    } else if (status=="Tich") {
                        Nhan();
                    }else {
                        Chia();
                    }
                }
                operator = false;
                number = null;
                status="Thuong";
                isEqual=false;
            }

        });

        btnbang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LS = textLS.getText().toString();
                KQ = textKQ.getText().toString();
                textLS.setText((LS+KQ));
                if(operator){
                    if(status=="Tong"){
                        Cong();
                    } else if (status == "Hieu") {
                        Tru();
                    } else if (status=="Tich") {
                        Nhan();
                    } else if (status=="Thuong"){
                        Chia();
                    }else {
                        a = Double.parseDouble(textKQ.getText().toString());
                    }
                }
                operator = false;
                isEqual=true;
                dot=false;
            }

        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=null;
                operator=false;
                isFirstInput = true;
//                status=null;
                textKQ.setText("0");
                textLS.setText("");
                a=0;
                b=0;
                dot=true;
                del=true;
//                resetCalculator();
            }
        });

        btnDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(del ){
                    textKQ.setText("0");
                }else {
                    number = number.substring(0,number.length()-1);
                    if(number.length()==0){
                        btnDEL.setClickable(false);

                    } else {
                        if (number.contains(".")){
                            dot=false;
                        }else {
                            dot=true;
                        }
                    }
                }
                textKQ.setText(number);
            }
        });

        btncham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dot){
                    if(number==null){
                        number="0.";
                    }else{
                        number = number + ".";
                    }
                }
                dot=false;
                textKQ.setText(number);
            }
        });
    }

    public void numberclick(String view){
        if(number==null ){
            number=view;
        }else{
            number = number+view;
        }
        textKQ.setText(number);
        operator = true;
        del=false;
        btnDEL.setClickable(true);
    }

    public void Cong(){
        if(a==0){
            a = Double.parseDouble(textKQ.getText().toString());
        }else {
            b = Double.parseDouble(textKQ.getText().toString());
            a = a + b;
        }
        textKQ.setText(decimalFormat.format(a));
        dot=true;
    }

    public void Tru(){
        if(a==0){
            a = Double.parseDouble(textKQ.getText().toString());
        }else {
            b = Double.parseDouble(textKQ.getText().toString());
            a = a - b;
        }
        textKQ.setText(decimalFormat.format(a));
        dot=true;
    }

    public void Nhan() {
        if (number != null) {
            b = Double.parseDouble(number);
            if (isFirstInput) {
                a = b;
                isFirstInput = false;
            } else {
                a = a * b;
            }
            textKQ.setText(decimalFormat.format(a));
            number = null;
        }
        dot = true;
    }


public void Chia() {
    if (number != null) {
        b = Double.parseDouble(number);

        if (isFirstInput) {
            a = b;
            isFirstInput = false;
        } else {
            if (b == 0) {

                textKQ.setText("Không thể chia cho 0");
                return;
            } else {

                a = a / b;
            }
        }

        textKQ.setText(decimalFormat.format(a));
        number = null;
        operator = false;
        dot = true;
    }
}

//    public void resetCalculator() {
//
//
//        isFirstInput = true;
//    }
}