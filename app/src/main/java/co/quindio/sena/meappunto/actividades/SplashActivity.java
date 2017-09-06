package co.quindio.sena.meappunto.actividades;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.quindio.sena.meappunto.MainActivity;
import co.quindio.sena.meappunto.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                // Intent intent=new Intent(SplashScreen.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },1500);


    }
}
