package com.frameworksystem.starwars.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.frameworksystem.starwars.R;
import com.frameworksystem.starwars.model.Droid;
import com.squareup.picasso.Picasso;

/**
 * Created by felipets on 11/17/15.
 */
public class DroidFragment extends Fragment {

    private Droid mDroid;

    public static Fragment newInstance(Droid droid) {
        Bundle args = new Bundle();
        args.putSerializable("droid", droid);

        Fragment fragment = new DroidFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDroid = (Droid) getArguments().getSerializable("droid");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_droid, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView droidImage = (ImageView)view.findViewById(R.id.droid_image);
        TextView droidName = (TextView)view.findViewById(R.id.droid_name);
        TextView droidDescription = (TextView)view.findViewById(R.id.droid_description);
        TextView droidLink = (TextView)view.findViewById(R.id.droid_link);

        Picasso.with(getActivity()).load(mDroid.getImage()).into(droidImage);
        droidName.setText(mDroid.getName());
        droidDescription.setText(mDroid.getDescription());
        droidLink.setText(mDroid.getLink());

    }
}
