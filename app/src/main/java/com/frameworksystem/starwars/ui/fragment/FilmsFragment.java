package com.frameworksystem.starwars.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.frameworksystem.starwars.Mock;
import com.frameworksystem.starwars.R;
import com.frameworksystem.starwars.api.FilmsApi;
import com.frameworksystem.starwars.model.Film;
import com.frameworksystem.starwars.ui.adapters.FilmsAdapter;

import java.util.List;

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

        int collum = getResources().getInteger(R.integer.films_collum);

        GridLayoutManager layoutManager =
                new GridLayoutManager(getActivity(), collum);


        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(layoutManager);

        getFilms();
    }

    private void getFilms(){

        final FilmsApi filmsApi = new FilmsApi(getActivity());
        filmsApi.droids(new FilmsApi.OnFilmsListener() {
            @Override
            public void onFilms(final List<Film> films, int errorCode) {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (films != null) {
                            filmsAdapter = new FilmsAdapter(getActivity(), films);
                            recyclerView.setAdapter(filmsAdapter);
                        } else {
                            Toast.makeText(getActivity(), R.string.msg_error_generic,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
