
package com.intecap.notas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotasAdapter extends RecyclerView.Adapter<NotasAdapter.NotaViewHolder> {
    private List<String> notasList;

    public NotasAdapter(List<String> notasList) {
        this.notasList = notasList;
    }

    @NonNull
    @Override
    public NotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_nota, parent, false);
        return new NotaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotaViewHolder holder, int position) {
        String nota = notasList.get(position);
        holder.textViewNota.setText(nota);

        // Hacer que el elemento sea clickeable para editar
        holder.itemView.setOnClickListener(v -> {
            // Poner el EditText en modo edición
            holder.textViewNota.setVisibility(View.GONE);
            holder.editTextNota.setVisibility(View.VISIBLE);
            holder.editTextNota.setText(nota);
            holder.editTextNota.requestFocus();
        });

        // Cuando el usuario termine de editar, actualizamos el texto
        holder.editTextNota.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String updatedNota = holder.editTextNota.getText().toString();
                notasList.set(position, updatedNota); // Actualiza la lista
                notifyItemChanged(position);
                holder.textViewNota.setText(updatedNota);
                holder.textViewNota.setVisibility(View.VISIBLE);
                holder.editTextNota.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notasList.size();
    }

    public static class NotaViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNota;
        EditText editTextNota;

        public NotaViewHolder(View itemView) {
            super(itemView);
            textViewNota = itemView.findViewById(R.id.textViewNota);
            editTextNota = itemView.findViewById(R.id.editTextNota);
        }
    }
}
