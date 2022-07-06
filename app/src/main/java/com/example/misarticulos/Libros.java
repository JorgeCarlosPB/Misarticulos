package com.example.misarticulos;

import java.util.ArrayList;
import java.util.List;

public class Libros {
    private String nombre;
    private String descripcion;
    private String costo;

    public Libros(String nombre, String descripcion, String costo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;

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

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public static List<Libros> ejemploLibros(){
        List<Libros> listaLibros = new ArrayList<>();
        listaLibros.add(new Libros("Camisa","Camisa a rayas de color azul","100Bs"));
        listaLibros.add(new Libros("Zapatos","Zapatos de cuero color marrón","250Bs"));
        listaLibros.add(new Libros("Pantalones","Pantalones jeans color azul","150Bs"));
        return listaLibros;
    }

}
