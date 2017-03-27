package com.zyxdimensions.petagram.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zyxdimensions.petagram.pojo.Mascota;
import com.zyxdimensions.petagram.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombreMascota.setText(mascota.getNombre());
        holder.tvCantidadRaiting.setText(String.valueOf(mascota.getRaiting()));


        holder.llContenedorMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.tvCantidadRaiting.setText(String.valueOf( Integer.parseInt((String) holder.tvCantidadRaiting.getText()) + 1 ));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView tvNombreMascota;
        private TextView tvCantidadRaiting;
        private LinearLayout llContenedorMascota;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvCantidadRaiting = (TextView) itemView.findViewById(R.id.tvCantidadRaiting);
            llContenedorMascota = (LinearLayout) itemView.findViewById(R.id.llContenedorMascota);
        }
    }
}
