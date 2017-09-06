package co.quindio.sena.meappunto.actividades;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;

import co.quindio.sena.meappunto.R;
import co.quindio.sena.meappunto.clases.entidades.NecesidadVo;
import co.quindio.sena.meappunto.fragments.DetalleNecesidadFragment;
import co.quindio.sena.meappunto.fragments.InicioFragment;
import co.quindio.sena.meappunto.fragments.PublicarNecesidadFragment;
import co.quindio.sena.meappunto.interfaces.IFragments;

public class SesionEmpresarioActivity extends AppCompatActivity implements IFragments{

    Fragment miFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion_empresario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        miFragment=null;

        miFragment=new InicioFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.content_sesion_empresario,miFragment).commit();
        setTitle("Mis Necesidades");

        FloatingActionButton btn1 = (FloatingActionButton) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miFragment=new PublicarNecesidadFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content_sesion_empresario,miFragment).commit();
                setTitle("Publicar necesidad");
            }
        });

        FloatingActionButton btn2 = (FloatingActionButton) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miFragment=new InicioFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content_sesion_empresario,miFragment).commit();
                setTitle("Mis Necesidades");
            }
        });





    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void enviarDetalleNecesidad(NecesidadVo necesidadVo) {
        DetalleNecesidadFragment detalleFragment=new DetalleNecesidadFragment();
        Bundle bundleEnvio=new Bundle();
        bundleEnvio.putSerializable("necesidadVo",necesidadVo);
        detalleFragment.setArguments(bundleEnvio);

        //cargar el fragment en el activity
       // getSupportFragmentManager().
         //       beginTransaction().
           //     replace(R.id.content_sesion_empresario,detalleFragment).addToBackStack(null).commit();

        getSupportFragmentManager().beginTransaction().replace(R.id.content_sesion_empresario,detalleFragment).commit();
    }
}
