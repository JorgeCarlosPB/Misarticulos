package com.example.misarticulos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorLibro extends RecyclerView.Adapter<AdaptadorLibro.ViewHolder>{
    private LayoutInflater inflador; //Crea Layouts a partir del XML protecte
    private List<Libros> lista;
    private Context contexto;


    public AdaptadorLibro(Context contexto, List<Libros> listaLibros) {
        inflador = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.lista = listaLibros;
        this.contexto = contexto;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre, detalle;
        public TextView costo;

        ViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            detalle = (TextView) itemView.findViewById(R.id.detalle);
            costo = (TextView) itemView.findViewById(R.id.costo);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflador.inflate(R.layout.elemento_lista, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {

        Libros items = lista.get(i);
        holder.nombre.setText(items.getNombre());
        holder.detalle.setText(items.getDescripcion());
        holder.costo.setText(items.getCosto());
    }


    @Override
    public int getItemCount() {
        return lista.size();

    }
}
