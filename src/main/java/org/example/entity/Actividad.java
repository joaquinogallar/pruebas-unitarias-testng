package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Actividad {
    private String nombre;
    private List<Socio> listaInscriptos;
    private Socio encargado;

    public Actividad(String nombre) {
        this.nombre = nombre;
        this.listaInscriptos = new ArrayList<>();
        this.encargado = null;
    }

    public boolean inscribirSocio(Socio s) {
        if (s == null || listaInscriptos.contains(s)) {
            return false; // Si el socio ya está inscrito o es null, no lo inscribimos
        }
        listaInscriptos.add(s);
        return true;
    }

    public boolean setEncargado(Socio s) {
        if (s == null || !listaInscriptos.contains(s) || encargado != null) {
            return false; // El encargado debe ser un socio inscrito en la actividad
        }
        encargado = s;
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Socio> getListaInscriptos() {
        return listaInscriptos;
    }

    public Socio getEncargado() {
        return encargado;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "nombre='" + nombre + '\'' +
                ", inscriptos=" + listaInscriptos +
                ", encargado=" + encargado +
                '}';
    }
}