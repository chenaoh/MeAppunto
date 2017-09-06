package co.quindio.sena.meappunto.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import co.quindio.sena.meappunto.R;

public class SeleccionaUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecciona_usuario);
    }

    public void onClick(View view) {
        Intent intent=null;

        switch (view.getId()){
            case R.id.btnRegistroEmpresario:
                intent=new Intent(SeleccionaUsuarioActivity.this,RegistroEmpresarioActivity.class);
                break;
            case R.id.btnRegistroAprendiz:
                intent=new Intent(SeleccionaUsuarioActivity.this,RegistroAprendizActivity.class);
                break;
        }

        startActivity(intent);
    }
}
