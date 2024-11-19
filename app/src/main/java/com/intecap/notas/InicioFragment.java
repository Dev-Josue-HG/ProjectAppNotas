package com.intecap.notas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class InicioFragment extends Fragment {

    public NotasViewModel notasViewModel;

    public InicioFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static InicioFragment newInstance(String param1, String param2) {
        InicioFragment fragment = new InicioFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        notasViewModel = new ViewModelProvider(requireActivity()).get(NotasViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String> notasList = new ArrayList<>();
        NotasAdapter adapter = new NotasAdapter(notasList);
        recyclerView.setAdapter(adapter);

        notasViewModel.getNotas().observe(getViewLifecycleOwner(), notas -> {
            notasList.clear();
            notasList.addAll(notas);
            adapter.notifyDataSetChanged();

        });
        // Inflate the layout for this fragment
        return view;
                //inflater.inflate(R.layout.fragment_inicio, container, false);
    }
}