package co.quindio.sena.meappunto.fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import co.quindio.sena.meappunto.R;
import co.quindio.sena.meappunto.adaptadores.NecesidadesAdapter;
import co.quindio.sena.meappunto.clases.entidades.NecesidadVo;
import co.quindio.sena.meappunto.interfaces.IFragments;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InicioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    TextView etiNecesidades;
    RecyclerView recyclerNecesidades;
    ArrayList<NecesidadVo> necesidadesList;
    IFragments interfaceFragments;
    Activity activity;

    public InicioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InicioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InicioFragment newInstance(String param1, String param2) {
        InicioFragment fragment = new InicioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_inicio, container, false);

        recyclerNecesidades= (RecyclerView) view.findViewById(R.id.recyclerNecesidades);
        recyclerNecesidades.setLayoutManager(new LinearLayoutManager(getContext()));
        etiNecesidades= (TextView) view.findViewById(R.id.etiNecesito);

        cargarNecesidades();

        NecesidadesAdapter adapter=new NecesidadesAdapter(necesidadesList);

        if (necesidadesList.size()>0){
            recyclerNecesidades.setAdapter(adapter);
            etiNecesidades.setText("Necesito");
        }else{
            etiNecesidades.setText("No se han Publicado Necesidades...");
        }

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Detalle necesidad",Toast.LENGTH_SHORT).show();
                interfaceFragments.enviarDetalleNecesidad
                        (necesidadesList.get(recyclerNecesidades.getChildAdapterPosition(view)));
            }
        });

        return view;
    }

    private void cargarNecesidades() {
        necesidadesList=new ArrayList<>();
       necesidadesList.add(new NecesidadVo(1,"Imágen corporativa","se necesita un logotipo","Se espera para noviembre","Activa",2));
        necesidadesList.add(new NecesidadVo(2,"Sistema de inventario de materiales","se necesita un logotipo","Se espera para noviembre","Activa",0));
        necesidadesList.add(new NecesidadVo(3,"Software Contable","se necesita un logotipo","Se espera para noviembre","Activa",1));
        necesidadesList.add(new NecesidadVo(4,"Propuesta de Logo","se necesita un logotipo","Se espera para noviembre","Activa",4));

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            this.activity= (Activity) context;
            interfaceFragments= (IFragments) this.activity;
        }
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
