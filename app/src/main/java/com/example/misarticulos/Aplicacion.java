package com.example.misarticulos;

import android.app.Application;
import java.util.List;

public class Aplicacion extends Application {
    private List<Libros> listLibros ;
    private AdaptadorLibro adaptadorLibro;
    @Override
    public void onCreate() {
        super.onCreate();
        listLibros = Libros.ejemploLibros();
        adaptadorLibro = new AdaptadorLibro(this, listLibros);
    }
    public AdaptadorLibro getAdaptador(){
        return this. adaptadorLibro;
    }
    public List<Libros> getLibros(){
        return this.listLibros;
    }
}
