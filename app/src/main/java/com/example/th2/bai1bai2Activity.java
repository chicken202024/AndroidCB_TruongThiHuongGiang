package com.example.th2;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;

import java.util.Random;

public class bai1bai2Activity extends AppCompatActivity {
    int imgID[]={R.drawable.anh0, R.drawable.anh2, R.drawable.anh3};
    int colorID[]={R.color.color_1, R.color.color_2, R.color.color_5};
    LinearLayout layout;
    ImageView imgAnimal;
    ProgressBar progressBar;


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.m001_act_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bai1bai2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        gotviews();

        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator colorAnim = ObjectAnimator.ofArgb(
                progressBar,
                "indeterminateTint",  // Thuộc tính để thay đổi màu
                Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);

        // Đặt thời gian cho mỗi lần chuyển đổi màu
        colorAnim.setDuration(2000);  // 2 giây cho mỗi chu kỳ màu
        colorAnim.setEvaluator(new ArgbEvaluator());  // Đánh giá màu chuyển tiếp
        colorAnim.setRepeatCount(ObjectAnimator.INFINITE);  // Lặp vô tận
        colorAnim.setRepeatMode(ObjectAnimator.REVERSE);  // Chuyển màu ngược lại sau khi hoàn thành
        colorAnim.start();

    }



    private void gotviews(){
        layout = findViewById(R.id.bai1bai2);
        imgAnimal = findViewById(R.id.imgAnimal);
        layout.setBackgroundResource(colorID[new Random().nextInt(colorID.length)]);
        imgAnimal.setImageResource(imgID[new Random().nextInt(imgID.length)]);
    }
}


