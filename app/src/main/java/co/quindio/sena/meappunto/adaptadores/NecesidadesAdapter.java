package co.quindio.sena.meappunto.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.quindio.sena.meappunto.R;
import co.quindio.sena.meappunto.clases.entidades.NecesidadVo;

/**
 * Created by CHENAO on 5/09/2017.
 */

public class NecesidadesAdapter extends RecyclerView.Adapter<NecesidadesAdapter.NecesidadesHolder> implements View.OnClickListener{

    private View.OnClickListener listener;
    ArrayList<NecesidadVo> necesidadesList;

    public NecesidadesAdapter(ArrayList<NecesidadVo> necesidadesList) {
        this.necesidadesList = necesidadesList;
    }

    @Override
    public NecesidadesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista  = LayoutInflater.from(parent.getContext()).inflate(R.layout.necesidades_list,parent,false);
        RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);
        vista.setOnClickListener(this);

        return new NecesidadesHolder(vista);
    }

    @Override
    public void onBindViewHolder(NecesidadesHolder holder, int position) {
        holder.etiNombre.setText(necesidadesList.get(position).getNombre().toString());
        holder.etiPostulados.setText(necesidadesList.get(position).getCantPostulados().toString()+" Postulados");
    }

    @Override
    public int getItemCount() {
        return necesidadesList.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class NecesidadesHolder extends RecyclerView.ViewHolder {

        TextView etiNombre,etiPostulados;

        public NecesidadesHolder(View itemView) {
            super(itemView);
            etiNombre= (TextView) itemView.findViewById(R.id.etiNecesidad);
            etiPostulados= (TextView) itemView.findViewById(R.id.etiPostulados);
        }
    }
}
