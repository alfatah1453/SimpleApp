package com.example.ilhambintang.simpleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Pesanan extends AppCompatActivity {

    int jumlah;
    String pesanan;
    Boolean choco,whip;
    TextView hasil;
    ImageView gambar;

    String kompilasi, topping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan);

        Bundle extras = getIntent().getExtras();
        jumlah= extras.getInt("jumlah");
        pesanan = extras.getString("pesanan");
        choco = extras.getBoolean("chocolate");
        whip = extras.getBoolean("whipCream");

        hasil = (TextView) findViewById(R.id.pesan);
        gambar = (ImageView) findViewById(R.id.foto);

        if (whip == true &&  choco == true) {
            topping = " dengan topping chocolate dan whip chocolate";
            gambar.setImageResource(R.drawable.mixcoffee);
        }
        else if (choco == true) {
            topping = " dengan topping chocolate";
            gambar.setImageResource(R.drawable.chococoffee);
        }
        else if (whip == true) {
            topping = " dengan topping whip chocolate";
            gambar.setImageResource(R.drawable.whipcoffee);
        }
        else {
            topping = "";
            gambar.setImageResource(R.drawable.plaincoffee);
        }

        kompilasi = "Pesanan anda adalah : " + pesanan + " dengan jumlah : " + Integer.toString(jumlah)
                + topping;
        hasil.setText(kompilasi);
    }
    public void kirim(View v) {
        Intent email = new Intent(Intent.ACTION_SEND);

        email.putExtra(Intent.EXTRA_SUBJECT, "ORDERAN COKELAT");
        email.putExtra(Intent.EXTRA_TEXT, kompilasi);

        //kirim hanya ke email
        //email.setType("message/rfc822");
        email.setType("text/plain");

        startActivity(Intent.createChooser(email, "Pilih email"));
    }
}

