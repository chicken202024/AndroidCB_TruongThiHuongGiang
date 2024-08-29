package com.example.bai2_rolldice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn_random;
    ImageView img_dice;
    private Random random;

    private void RollDice(){
        int SoNgauNhien = random.nextInt(6)+1;

        switch (SoNgauNhien){
            case 1:
                img_dice.setImageResource(R.drawable.dice1);
                break;

            case 2:
                img_dice.setImageResource(R.drawable.dice2);
                break;

            case 3:
                img_dice.setImageResource(R.drawable.dice3);
                break;

            case 4:
                img_dice.setImageResource(R.drawable.dice4);
                break;

            case 5:
                img_dice.setImageResource(R.drawable.dice5);
                break;

            case 6:
                img_dice.setImageResource(R.drawable.dice6);
                break;

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_random = findViewById(R.id.btn_random);
        img_dice = findViewById(R.id.img_dice);
        random = new Random();

        btn_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RollDice();
            }
        });
    }
}