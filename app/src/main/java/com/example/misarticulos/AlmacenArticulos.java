package com.example.misarticulos;

import java.util.List;
public interface AlmacenArticulos {
    void guardarArticulos(String titulo, String detalle, String fecha, String imagen);
    List<String> listaArticulos(int i, String respuesta);
}
