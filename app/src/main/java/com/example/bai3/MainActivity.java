package com.example.bai3;

import static android.app.PendingIntent.getActivity;
import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.Manifest;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_goi, btn_gui;
    EditText ed_sdt, ed_tinnhan;
    private static final int REQUEST_CALL_PERMISSION = 1;
    private static final int REQUEST_SEND_PERMISSION = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_goi = findViewById(R.id.btn_goi);
        btn_gui = findViewById(R.id.btn_gui);
        ed_sdt = findViewById(R.id.ed_sdt);
        ed_tinnhan = findViewById(R.id.ed_tinnhan);
        btn_goi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Goi();
            }
        });

        btn_gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gui();
            }
        });
    }

    private void Goi(){
        String SDT = ed_sdt.getText().toString().trim();

        if(SDT.isEmpty()){
            Toast.makeText(this,"Vui lòng nhap số dien thoại", Toast.LENGTH_SHORT).show();
            return;
        }
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE ) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
        }
        else{
            Intent intencall = new Intent(Intent.ACTION_CALL);
            intencall.setData(Uri.parse("tel:" + SDT));
            startActivity(intencall);
        }
    }

    private void Gui(){
        String SDT = ed_sdt.getText().toString().trim();
        String ND = ed_tinnhan.getText().toString().trim();
        if(SDT.isEmpty() || ND.isEmpty()){
            Toast.makeText(this,"Vui long nhap so dien thoai va tin nhan", Toast.LENGTH_SHORT).show();
            return;
        }
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS  ) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},REQUEST_SEND_PERMISSION);
        }
        else{
            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(SDT, null, ND,null, null);
                Toast.makeText(this, "Tin nhan da duoc gui", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Toast.makeText(this, "Gui tin nhan that bai!", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(requestCode == REQUEST_CALL_PERMISSION){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Goi();
            }else{
                Toast.makeText(this, "Quyen goi dien bi tu choi", Toast.LENGTH_SHORT).show();
            }
        }

        if(requestCode == REQUEST_SEND_PERMISSION){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Gui();
            }else{
                Toast.makeText(this, "Quyen nhan tin bi tu choi", Toast.LENGTH_SHORT).show();
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}