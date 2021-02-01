package com.example.animasyon;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView ımg;
Animation anm;
    public boolean InternetKontrol() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager.getActiveNetworkInfo() != null
                && manager.getActiveNetworkInfo().isAvailable()
                && manager.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ımg=findViewById(R.id.imageView);

        if(InternetKontrol()){
            new arkaplancalıs().execute();
            Toast.makeText(this, "YÜKLENİYOR...", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "LÜTFEN İNTERNET BAĞLANTINIZI KONTROL EDİN", Toast.LENGTH_SHORT).show();
            finish();
        }
                anm = AnimationUtils.loadAnimation(MainActivity.this,R.anim.animasyon);
                ımg.startAnimation(anm);
   }
    public class arkaplancalıs extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                    Thread.sleep(3500);
                    Intent git = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(git);
                } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
