package com.zyxdimensions.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zyxdimensions.petagram.adapters.MascotaAdaptador;
import com.zyxdimensions.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotasRaiting extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listadoMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_raiting);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listadoMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listadoMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

    }
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listadoMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Punker",2,R.drawable.dog_48));
        mascotas.add(new Mascota("Ronny",0,R.drawable.rabbit_48));
        mascotas.add(new Mascota("Laika",5,R.drawable.duck_48));
        mascotas.add(new Mascota("Catty",5,R.drawable.turtle_48));
    }
}
