package com.toni.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class PalabraListaAdapter extends RecyclerView.Adapter<PalabraListaAdapter.PalabraListaHolder> {

    private final LinkedList<String> listaPalabras;
    private LayoutInflater inflater;

    public PalabraListaAdapter(Context context, LinkedList<String> listaPalabras){
        inflater = LayoutInflater.from(context);
        this.listaPalabras = listaPalabras;
    }

    @NonNull
    @Override
    public PalabraListaAdapter.PalabraListaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = inflater.inflate(R.layout.palabra_item, parent, false);
        return new PalabraListaHolder(item, this);
    }

    @Override
    public void onBindViewHolder(@NonNull PalabraListaAdapter.PalabraListaHolder holder, int position) {
        String currentItem = listaPalabras.get(position);
        holder.txtPalabra.setText(currentItem);
    }

    @Override
    public int getItemCount() {
        return listaPalabras.size();
    }

    class PalabraListaHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView txtPalabra;
        final PalabraListaAdapter adapter;

        public  PalabraListaHolder(View item, PalabraListaAdapter adapter){
            super(item);
            txtPalabra = item.findViewById(R.id.txtPalabraLista);
            this.adapter = adapter;
            item.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int posicion = getLayoutPosition();
            String elemento = listaPalabras.get(posicion);
            listaPalabras.set(posicion, "Seleccionado " + elemento);
            adapter.notifyDataSetChanged();
        }
    }
}
