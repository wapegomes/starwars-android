package com.frameworksystem.starwars.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.frameworksystem.starwars.R;
import com.frameworksystem.starwars.model.Film;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by felipets on 11/18/15.
 */
public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {

    private Context context;
    private List<Film> films;

    public FilmsAdapter(Context context, List<Film> films) {
        this.context = context;
        this.films = films;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_film, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Film film = films.get(position);
        Picasso.with(context).load(film.getImage()).into(holder.filmImage);
        holder.filmName.setText(film.getName());
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView filmImage;
        TextView filmName;

        public ViewHolder(View itemView) {
            super(itemView);

            filmImage = (ImageView)itemView.findViewById(R.id.film_image);
            filmName = (TextView)itemView.findViewById(R.id.film_name);
        }
    }
}
