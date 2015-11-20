package com.frameworksystem.starwars.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.frameworksystem.starwars.R;
import com.frameworksystem.starwars.model.Droid;
import com.squareup.picasso.Picasso;

/**
 * Created by felipe.arimateia on 19/11/2015.
 */
public class DroidDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_droid_detail);

        Droid droid = (Droid) getIntent().getSerializableExtra("droid");

        ImageView droidImage = (ImageView)findViewById(R.id.droid_image);
        TextView droidName = (TextView)findViewById(R.id.droid_name);
        TextView droidDescription = (TextView)findViewById(R.id.droid_description);
        TextView droidLink = (TextView)findViewById(R.id.droid_link);

        Picasso.with(this).load(droid.getImage()).into(droidImage);
        droidName.setText(droid.getName());
        droidDescription.setText(droid.getDescription());

        droidLink.setText("Fonte: " + droid.getLink());
    }
}
