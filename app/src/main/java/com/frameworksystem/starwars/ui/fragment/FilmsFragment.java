package com.frameworksystem.starwars.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frameworksystem.starwars.Mock;
import com.frameworksystem.starwars.R;
import com.frameworksystem.starwars.ui.adapters.FilmsAdapter;

/**
 * Created by felipets on 11/18/15.
 */
public class FilmsFragment extends Fragment {

    private RecyclerView recyclerView;
    private FilmsAdapter filmsAdapter;


    public static Fragment newInstance() {
        return new FilmsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridLayoutManager layoutManager =
                new GridLayoutManager(getActivity(), 2);

        filmsAdapter = new FilmsAdapter(getActivity(), Mock.getFilms());

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(filmsAdapter);
    }
}
