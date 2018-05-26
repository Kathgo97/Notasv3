package com.katherine.notasv3.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.katherine.notasv3.Adapter;
import com.katherine.notasv3.Database.DBHelper;
import com.katherine.notasv3.Model.Person;
import com.katherine.notasv3.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowPerson extends Fragment {


    private static List<Person> contenido;
    public ShowPerson() {
    }


    public static ShowPerson newInstance() {
        ShowPerson fragment = new ShowPerson();
        Bundle args = new Bundle();
        contenido = DBHelper.myDB.allUsers();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_person, container, false);

        // Set the adapter
        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
        recyclerView.setAdapter(new Adapter(contenido));
        return view;
    }




}
