package co.quindio.sena.meappunto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import co.quindio.sena.meappunto.actividades.LoginActivity;
import co.quindio.sena.meappunto.actividades.SeleccionaUsuarioActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        Intent intent=null;

        switch (view.getId())
        {
            case R.id.btnRegistrarse:
                intent=new Intent(MainActivity.this,SeleccionaUsuarioActivity.class);
                break;
            case R.id.btnIngresar:
                intent=new Intent(MainActivity.this,LoginActivity.class);
                break;
        }

        startActivity(intent);

    }
}
