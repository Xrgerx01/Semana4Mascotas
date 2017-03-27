package com.zyxdimensions.petagram.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zyxdimensions.petagram.R;
import com.zyxdimensions.petagram.adapters.MascotaAdaptador;
import com.zyxdimensions.petagram.pojo.Mascota;

import java.util.ArrayList;

public class ListadoMascotas extends Fragment {
    ArrayList<Mascota> mascotas;
    private RecyclerView listadoMascotas;
        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_listado_mascotas, container, false);

            listadoMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            llm.setOrientation(LinearLayoutManager.VERTICAL);

            listadoMascotas.setLayoutManager(llm);

            inicializarListaMascotas();
            inicializarAdaptador();

        // Inflate the layout for this fragment
        return v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listadoMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Tulina",5,R.drawable.cat_48));
        mascotas.add(new Mascota("Punker",2,R.drawable.dog_48));
        mascotas.add(new Mascota("Cesar",8,R.drawable.chicken_48));
        mascotas.add(new Mascota("Laika",5,R.drawable.duck_48));
        mascotas.add(new Mascota("Spirit",3,R.drawable.horse_48));
        mascotas.add(new Mascota("Catty",5,R.drawable.turtle_48));
        mascotas.add(new Mascota("Ronny",0,R.drawable.rabbit_48));
    };
}
