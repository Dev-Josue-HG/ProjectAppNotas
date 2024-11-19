package com.intecap.notas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AgregarNotaFragment extends Fragment {
    FloatingActionButton fab;
    private List<String> notasList; // Lista para almacenar las notas
    private NotasAdapter notasAdapter; // Adaptador para la RecyclerView

    private NotasViewModel notasViewModel;

    public AgregarNotaFragment() {
        // Constructor público requerido
    }

    public static AgregarNotaFragment newInstance(String param1, String param2) {
        return new AgregarNotaFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notasList = new ArrayList<>(); // Inicializa la lista de notas
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        notasViewModel = new ViewModelProvider(requireActivity()).get(NotasViewModel.class);

        // Infla la vista del fragmento
        View view = inflater.inflate(R.layout.fragment_agregar_nota, container, false);

        EditText inputNota = view.findViewById(R.id.inputNota);
        Button btnGuardar = view.findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(v -> {
            String nota = inputNota.getText().toString();
            if(!nota.isEmpty()){
                notasViewModel.agregarNota(nota);
                inputNota.setText("");
                Toast.makeText(getContext(), "Nota agregada", Toast.LENGTH_SHORT).show();
            }





        // Configura el RecyclerView
//        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        notasAdapter = new NotasAdapter(notasList);
//        recyclerView.setAdapter(notasAdapter);
//
//        // Inicializa el FloatingActionButton
//        FloatingActionButton fab = view.findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Agrega una nueva nota a la lista
//                notasList.add("Nueva Nota " + (notasList.size() + 1));
//                notasAdapter.notifyItemInserted(notasList.size() - 1);
//                Toast.makeText(getActivity(), "Nota agregada", Toast.LENGTH_SHORT).show();
//            }


        });

        return view;
    }
}