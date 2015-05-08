package edu.upc.eetac.dsa.griverola.libros_android.api;

import java.util.HashMap;
import java.util.Map;


public class Libros {
    private int idlibros;
    private String titulo;
    private String autor;
    private String lengua;
    private String edicion;
    private String fechaedicion;
    private String fechaimpresion;
    private String editorial;
    private long lasmodified;
    private Map<String,Link> links = new HashMap<String, Link>();
    private String eTag;

    public int getIdlibros() {
        return idlibros;
    }

    public void setIdlibros(int idlibros) {
        this.idlibros = idlibros;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLengua() {
        return lengua;
    }

    public void setLengua(String lengua) {
        this.lengua = lengua;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getFechaedicion() {
        return fechaedicion;
    }

    public void setFechaedicion(String fechaedicion) {
        this.fechaedicion = fechaedicion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getFechaimpresion() {
        return fechaimpresion;
    }

    public void setFechaimpresion(String fechaimpresion) {
        this.fechaimpresion = fechaimpresion;
    }

    public long getLasmodified() {
        return lasmodified;
    }

    public void setLasmodified(long lasmodified) {
        this.lasmodified = lasmodified;
    }

    public Map<String, Link> getLinks() {
        return links;
    }

    public String geteTag() {
        return eTag;
    }

    public void seteTag(String eTag) {
        this.eTag = eTag;
    }
}
