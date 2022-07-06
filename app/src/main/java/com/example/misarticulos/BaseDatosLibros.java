package com.example.misarticulos;

import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BaseDatosLibros extends AppCompatActivity {
    private RecyclerView recyclerview;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_datos);
        Aplicacion app = (Aplicacion) getApplication();
        recyclerview = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerview.setAdapter(app.getAdaptador());
        layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
    }
}
