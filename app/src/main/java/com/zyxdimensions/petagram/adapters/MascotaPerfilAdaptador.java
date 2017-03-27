package com.zyxdimensions.petagram.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyxdimensions.petagram.R;
import com.zyxdimensions.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotaPerfilAdaptador extends RecyclerView.Adapter<MascotaPerfilAdaptador.MascotaPerfilViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaPerfilAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaPerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas_perfil,parent,false);
        return new MascotaPerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaPerfilViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFotoPerfil.setImageResource(mascota.getFoto());
        holder.tvCantidadRaitingPerfil.setText(String.valueOf(mascota.getRaiting()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaPerfilViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFotoPerfil;
        private TextView tvCantidadRaitingPerfil;

        public MascotaPerfilViewHolder(View itemView) {
            super(itemView);
            imgFotoPerfil = (ImageView) itemView.findViewById(R.id.imgFotoPerfil);
            tvCantidadRaitingPerfil = (TextView) itemView.findViewById(R.id.tvCantidadRaitingPerfil);
        }
    }
}
