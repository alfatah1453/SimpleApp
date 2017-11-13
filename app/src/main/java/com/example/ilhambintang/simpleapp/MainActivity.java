package com.example.ilhambintang.simpleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    int jumlah = 0;
    TextView jml;
    EditText nama;
    CheckBox whipCream, chocolate;
    String pesan;
    Boolean wC, choco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jml = (TextView) findViewById(R.id.jumlah);
        nama = (EditText) findViewById(R.id.nama);
        whipCream = (CheckBox) findViewById(R.id.checkboxWhipCream);
        chocolate = (CheckBox) findViewById(R.id.checkboxChocolate);
        
    //TODO 

    }

    public void btnPlus(View v) {
        jumlah++;
        jml.setText(""+jumlah);

    }
    public void btnMinus(View v) {
        if(jumlah>0) {
            jumlah--;
            jml.setText("" + jumlah);
        }
    }

    public void pesan(View v) {
        pesan = nama.getText().toString();
        wC = whipCream.isChecked();
        choco = chocolate.isChecked();

        Bundle bundle = new Bundle();
        bundle.putString("pesanan", pesan);
        bundle.putInt("jumlah",jumlah);
        bundle.putBoolean("whipCream", wC);
        bundle.putBoolean("chocolate", choco);

        Intent intent = new Intent(this,Pesanan.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

