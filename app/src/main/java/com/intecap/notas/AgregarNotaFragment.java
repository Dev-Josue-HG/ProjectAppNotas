package com.intecap.notas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AgregarNotaFragment extends Fragment {

    public AgregarNotaFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static AgregarNotaFragment newInstance(String param1, String param2) {
        AgregarNotaFragment fragment = new AgregarNotaFragment();

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agregar_nota, container, false);
    }
}