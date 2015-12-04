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
import com.frameworksystem.starwars.api.DroidApi;
import com.frameworksystem.starwars.model.Droid;
import com.frameworksystem.starwars.ui.adapters.DroidsAdapter;

import java.util.List;

/**
 * Created by felipets on 11/18/15.
 */
public class DroidsFragment extends Fragment {

    private RecyclerView recyclerView;
    private DroidsAdapter droidsAdapter;


    public static Fragment newInstance() {
        return new DroidsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int collum = getResources().getInteger(R.integer.droids_collum);

        GridLayoutManager layoutManager =
                new GridLayoutManager(getActivity(), collum);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(layoutManager);

        getDroids();
    }

    private void getDroids(){

        final DroidApi droidApi = new DroidApi(getActivity());
        droidApi.droids(new DroidApi.OnDroidsListener() {
            @Override
            public void onDroids(final List<Droid> droids, int errorCode) {

               getActivity().runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       if (droids != null) {
                           droidsAdapter = new DroidsAdapter(getActivity(), droids, recyclerView);
                           recyclerView.setAdapter(droidsAdapter);
                       }
                       else {
                           Toast.makeText(getActivity(), R.string.msg_error_generic,
                                   Toast.LENGTH_SHORT).show();
                       }
                   }
               });
            }
        });
    }
}
