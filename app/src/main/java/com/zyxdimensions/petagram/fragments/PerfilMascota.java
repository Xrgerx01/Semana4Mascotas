package com.zyxdimensions.petagram.fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.zyxdimensions.petagram.R;
import com.zyxdimensions.petagram.adapters.MascotaAdaptador;
import com.zyxdimensions.petagram.adapters.MascotaPerfilAdaptador;
import com.zyxdimensions.petagram.pojo.Mascota;

import java.util.ArrayList;

public class PerfilMascota extends Fragment {
    ArrayList<Mascota> mascotas;
    RecyclerView listadoMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);

        listadoMascotas = (RecyclerView) v.findViewById(R.id.rvMascotasPerfil);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);

        listadoMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();
        // Inflate the layout for this fragment
        return v;
    }
    public void inicializarAdaptador(){
        MascotaPerfilAdaptador adaptador = new MascotaPerfilAdaptador(mascotas, getActivity());
        listadoMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(5,R.drawable.cat_48));
        mascotas.add(new Mascota(2,R.drawable.cat_48));
        mascotas.add(new Mascota(8,R.drawable.cat_48));
        mascotas.add(new Mascota(5,R.drawable.cat_48));
        mascotas.add(new Mascota(3,R.drawable.cat_48));
        mascotas.add(new Mascota(5,R.drawable.cat_48));
        mascotas.add(new Mascota(0,R.drawable.cat_48));
        mascotas.add(new Mascota(5,R.drawable.cat_48));
        mascotas.add(new Mascota(3,R.drawable.cat_48));
    };
}
