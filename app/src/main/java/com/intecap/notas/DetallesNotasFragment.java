package com.intecap.notas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DetallesNotasFragment extends Fragment {


    public DetallesNotasFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static DetallesNotasFragment newInstance(String param1, String param2) {
        DetallesNotasFragment fragment = new DetallesNotasFragment();
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
        return inflater.inflate(R.layout.fragment_detalles_notas, container, false);
    }
}