package routin_qin.tirage.fragments;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import routin_qin.tirage.activities.RandomActivity;
import routin_qin.tirage.database.DataBaseHelper;
import routin_qin.tirage.lists.CategoriesAdapter;
import routin_qin.tirage.R;
import routin_qin.tirage.activities.AddElementActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class ElementsFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public ElementsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_elements, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FloatingActionButton fab_add = (FloatingActionButton) view.findViewById(R.id.fab_elements_add);
        FloatingActionButton fab_random = (FloatingActionButton) view.findViewById(R.id.fab_elements_random);

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addElementIntent = new Intent(getActivity(), AddElementActivity.class);
                startActivity(addElementIntent);
            }
        });

        fab_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent randomIntent = new Intent(getActivity(), RandomActivity.class);
                startActivity(randomIntent);
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.rw_categories);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        List<String> titles = new ArrayList<>();
        List<String> descriptions = new ArrayList<>();
        DataBaseHelper db = new DataBaseHelper(getActivity());
        Cursor data = db.getAllData();

        while(data.moveToNext()){
            titles.add(data.getString(1));
            descriptions.add(data.getString(2));
        }

        mAdapter = new CategoriesAdapter(titles, descriptions);
        recyclerView.setAdapter(mAdapter);

        if(titles.size() > 0){
            fab_random.show();
        } else {
            fab_random.hide();
        }
    }
}
