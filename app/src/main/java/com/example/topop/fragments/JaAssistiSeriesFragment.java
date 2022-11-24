package com.example.topop.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.topop.R;
import com.example.topop.activity.activity_movie_details;
import com.example.topop.activity.activity_serie_details;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JaAssistiSeriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JaAssistiSeriesFragment extends Fragment {

    View myViewSerie;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public JaAssistiSeriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JaAssistiSeriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JaAssistiSeriesFragment newInstance(String param1, String param2) {
        JaAssistiSeriesFragment fragment = new JaAssistiSeriesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myViewSerie = inflater.inflate(R.layout.fragment_ja_assisti_series, container, false);
        getActivity().setTitle("Principal");
        CardView cardView1 = myViewSerie.findViewById(R.id.CardViewSerie1);
        // onClickListener para quando selecionar um CardView

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), activity_serie_details.class);
                startActivity(intent);
            }
        });

        return myViewSerie;
    }
}