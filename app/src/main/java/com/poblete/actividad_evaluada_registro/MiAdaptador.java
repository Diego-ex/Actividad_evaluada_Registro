package com.poblete.actividad_evaluada_registro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolderDatos> {
    ArrayList<Usuario> listaUsuario;

    public MiAdaptador(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    @NonNull
    @Override
    public MiAdaptador.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //enlace
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycler_simple_item, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.ViewHolderDatos holder, int position) {
        holder.asignarDatos(listaUsuario.get(position));
    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView texto;
        Button button;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            texto = itemView.findViewById(R.id.texto);
            button = itemView.findViewById(R.id.button);

        }

        public void asignarDatos(Usuario nUsuario) {
            texto.setText((CharSequence) nUsuario);
        }
    }
}
