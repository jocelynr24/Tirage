package routin_qin.tirage.fragments;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import routin_qin.tirage.database.DataBaseHelper;
import routin_qin.tirage.lists.CategoriesAdapter;
import routin_qin.tirage.R;
import routin_qin.tirage.activities.AddCategoryActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public CategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_categories_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), AddCategoryActivity.class);
                startActivity(myIntent);
            }
        });


        recyclerView = (RecyclerView) view.findViewById(R.id.rw_categories);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        List<String> input = new ArrayList<>();


        DataBaseHelper db = new DataBaseHelper(getActivity());
        Cursor data = db.getAllData();


        while(data.moveToNext()){
            input.add(data.getString(1));
            //input.add(data.getString(2));
        }



        //for (int i = 0; i < 100; i++) {
        //    input.add("Test" + i);
        //}// define an adapter
        mAdapter = new CategoriesAdapter(input);
        recyclerView.setAdapter(mAdapter);

        /*final RecyclerView rv = (RecyclerView) view.findViewById(R.id.rw_categories);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new CategoriesAdapter());*/





    }

}
