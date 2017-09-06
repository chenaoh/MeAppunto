package co.quindio.sena.meappunto.clases.entidades;

import java.io.Serializable;

/**
 * Created by CHENAO on 5/09/2017.
 */

public class NecesidadVo implements Serializable {

    private Integer necesidadId;
    private String nombre;
    private String descripcion;
    private String observaciones;
    private String estado;
    private Integer cantPostulados;


    public NecesidadVo(Integer necesidadId, String nombre, String descripcion, String observaciones, String estado, Integer cantPostulados) {
        this.necesidadId = necesidadId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
        this.estado = estado;
        this.cantPostulados = cantPostulados;
    }

    public Integer getNecesidadId() {
        return necesidadId;
    }

    public void setNecesidadId(Integer necesidadId) {
        this.necesidadId = necesidadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCantPostulados() {
        return cantPostulados;
    }

    public void setCantPostulados(Integer cantPostulados) {
        this.cantPostulados = cantPostulados;
    }
}
