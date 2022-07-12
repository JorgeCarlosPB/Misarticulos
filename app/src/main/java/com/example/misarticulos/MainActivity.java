package com.example.misarticulos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    Button cerrarSesion = (Button) findViewById(R.id.btn_cerrar_sesion);
    cerrarSesion.setOnClickListener (new View.OnClickListener()
    {
        public void onClick(View view)
        {
            AuthUI.getInstance().signOut( MainActivity.this).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override public void onComplete(@NonNull Task<Void> task) {
                    Intent i = new Intent( MainActivity.this,LoginActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                    MainActivity.this.finish();
                }

            });

        }
    });

    Button escribirBD = (Button) findViewById(R.id.btn_escribir_bd);
    escribirBD.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("mensaje");
            myRef.setValue("Hola mundo");
            }
    });

    /*Button baseDatos = findViewById(R.id.btn_baseDatos);
        baseDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                AuthUI.getInstance().signOut(MainActivity.this).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Intent intent = new Intent(MainActivity.this,BaseDatosLibros.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP / Intent.FLAG_ACTIVITY_NEW_TASK / Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        MainActivity.this.finish();
                    }


                });
            }
        });*/

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("mensaje");
    myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String  value = dataSnapshot.getValue(String.class);
            Log.d("Ejemplo firebase", "Valor:" + value);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            Log.w("Ejemplo Firebase", "Eror al leer.", error.toException());
        }
    });

    Button show_db = (Button) findViewById(R.id.btn_base_datos);
    show_db.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            lanzarLecturaDatos();
        }
    });



    Button datosUsuario = (Button) findViewById(R.id.btn_datos_usuario);
    datosUsuario.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            lanzarDatosUsuario();
        }
    });


    }

    public void lanzarDatosUsuario(){
        Intent i = new Intent(this, UsuarioActivity.class);
        startActivity(i);
    }

    public void lanzarLecturaDatos(){
        Intent i = new Intent(this, BaseDatosActivity.class);
        startActivity(i);
    }
}



