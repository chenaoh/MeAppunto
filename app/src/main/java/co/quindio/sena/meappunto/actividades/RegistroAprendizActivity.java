package co.quindio.sena.meappunto.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import co.quindio.sena.meappunto.R;

public class RegistroAprendizActivity extends AppCompatActivity {

    Spinner comboProgramaDeFormacion,comboCentroDeFormacion,comboTrimestre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_aprendiz);

        comboCentroDeFormacion= (Spinner) findViewById(R.id.comboCentroFormacion);
        comboProgramaDeFormacion= (Spinner) findViewById(R.id.comboProgramaFormacion);
        comboTrimestre= (Spinner) findViewById(R.id.comboTrimestre);

        ArrayAdapter<CharSequence> adapterCentro=
                ArrayAdapter.createFromResource(this,R.array.items_centro,android.R.layout.simple_spinner_item);
        comboCentroDeFormacion.setAdapter(adapterCentro);

        ArrayAdapter<CharSequence> adapterPrograma=
                ArrayAdapter.createFromResource(this,R.array.items_programa,android.R.layout.simple_spinner_item);
        comboProgramaDeFormacion.setAdapter(adapterPrograma);

        ArrayAdapter<CharSequence> adapterTrimestre=
                ArrayAdapter.createFromResource(this,R.array.items_trimestre,android.R.layout.simple_spinner_item);
        comboTrimestre.setAdapter(adapterTrimestre);

    }
}
