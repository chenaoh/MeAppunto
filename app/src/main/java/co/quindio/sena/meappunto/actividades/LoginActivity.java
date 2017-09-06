package co.quindio.sena.meappunto.actividades;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import co.quindio.sena.meappunto.R;

public class LoginActivity extends AppCompatActivity {

    EditText campoUsuario,campoPass;
    TextView mensajeValidacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoUsuario= (EditText) findViewById(R.id.campoUsuario);
        campoPass= (EditText) findViewById(R.id.campoPass);
        mensajeValidacion=(TextView) findViewById(R.id.txtMsj);
    }

    public void onClick(View view) {
        //if(validaFormulario()){
        if(true){
           // Toast.makeText(this,"VALIDO",Toast.LENGTH_SHORT).show();
            mensajeValidacion.setVisibility(View.GONE);
            Intent miIntent=new Intent(LoginActivity.this,SesionEmpresarioActivity.class);
            startActivity(miIntent);
        }else{
            Toast.makeText(this,"NO VALIDO",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validaFormulario() {
        campoUsuario.setError(null);
        campoPass.setError(null);
        mensajeValidacion.setText("");

        String nombre=campoUsuario.getText().toString();
        String correo=campoPass.getText().toString();
        boolean retorno;

        if (!TextUtils.isEmpty(nombre) && !TextUtils.isEmpty(correo)) {
            retorno = true;

            if (!isNombreValid(nombre)){
                //  mensajeValidacion.setText("Por favor ingrese su nombre completo");
                campoUsuario.setError("El Nombre es muy corto");
                retorno = false;
            }else if (!isEmailValid(correo)){
                //mensajeValidacion.setText("el correo es invalido");
                campoPass.setError("El correo no es Valido");
                retorno = false;
            }

        }else{

            if (TextUtils.isEmpty(nombre) && TextUtils.isEmpty(correo)) {
                campoUsuario.setError("El Nombre es requerido");
                campoPass.setError("El Correo es requerido");
            }else{
                if (TextUtils.isEmpty(nombre)) {
                    //mensajeValidacion.setText("el campo nombre es requerido");
                    campoUsuario.setError("El Nombre es requerido");
                    campoPass.setError(null);
                } else if (TextUtils.isEmpty(correo)) {
                    // mensajeValidacion.setText("el campo correo es requerido");
                    campoPass.setError("El Correo es requerid");
                    campoUsuario.setError(null);
                }
            }

            retorno = false;
        }

        if (retorno==false){
            mensajeValidacion.setText("Diligencie el formulario para continuar");
            mensajeValidacion.setVisibility(View.VISIBLE);
        }

        return retorno;
    }

    private boolean isNombreValid(String nombre) {
        //TODO: Replace this with your own logic
        return nombre.length() > 8;
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

}
