package co.quindio.sena.meappunto.interfaces;

import co.quindio.sena.meappunto.clases.entidades.NecesidadVo;
import co.quindio.sena.meappunto.fragments.DetalleNecesidadFragment;
import co.quindio.sena.meappunto.fragments.InicioFragment;
import co.quindio.sena.meappunto.fragments.PublicarNecesidadFragment;

/**
 * Created by CHENAO on 5/09/2017.
 */

public interface IFragments extends InicioFragment.OnFragmentInteractionListener, PublicarNecesidadFragment.OnFragmentInteractionListener,DetalleNecesidadFragment.OnFragmentInteractionListener {

    void enviarDetalleNecesidad(NecesidadVo necesidadVo);

}
