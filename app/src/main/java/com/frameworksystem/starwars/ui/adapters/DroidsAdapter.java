package com.frameworksystem.starwars.ui.adapters;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.frameworksystem.starwars.R;
import com.frameworksystem.starwars.model.Droid;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by felipets on 11/18/15.
 */
public class DroidsAdapter extends RecyclerView.Adapter<DroidsAdapter.ViewHolder> {

    private Context context;
    private List<Droid> droids;

    public DroidsAdapter(Context context, List<Droid> droids) {
        this.context = context;
        this.droids = droids;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_droid, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Droid droid = droids.get(position);
        Picasso.with(context).load(droid.getImage()).into(holder.droidImage);
        holder.droidDescription.setText(droid.getDescription());
        holder.droidName.setText(droid.getName());
    }

    @Override
    public int getItemCount() {
        return droids.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView droidImage;
        TextView droidDescription;
        TextView droidName;

        public ViewHolder(View itemView) {
            super(itemView);

            droidImage = (ImageView)itemView.findViewById(R.id.droid_image);
            droidDescription = (TextView)itemView.findViewById(R.id.droid_description);
            droidName = (TextView)itemView.findViewById(R.id.droid_name);
        }
    }
}
