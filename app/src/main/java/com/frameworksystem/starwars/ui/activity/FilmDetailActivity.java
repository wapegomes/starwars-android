package com.frameworksystem.starwars.ui.activity;

import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.frameworksystem.starwars.R;
import com.frameworksystem.starwars.model.Droid;
import com.frameworksystem.starwars.model.Film;
import com.squareup.picasso.Picasso;

/**
 * Created by Lenovo08 on 24/11/2015.
 */
public class FilmDetailActivity extends AppCompatActivity {

    private Film film;

    @Override
    //no oncreate se define o layout da activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setando layout
        setContentView(R.layout.activity_film_detail);

        //inserindo toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //mesmo comportament da action bar, mas continua customizavel
        setSupportActionBar(toolbar);
        //seta de voltar para a home - recria a pilha - volta para a parent a activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //intent são mensagens entre telas, é possível enviar e receber informações
        film = (Film) getIntent().getSerializableExtra("film");
        //colocando título no topo da tela
        //setTitle(film.getName());

        ImageView filmImage = (ImageView)findViewById(R.id.film_image);
        TextView filmDescription = (TextView)findViewById(R.id.film_description);
        TextView filmLink = (TextView)findViewById(R.id.film_link);
        TextView filmName = (TextView)findViewById(R.id.film_name);
        TextView filmYear = (TextView)findViewById(R.id.film_year);

        //carregando imagem
        Picasso.with(this).load(film.getImage()).into(filmImage);
        //carregando demais atributos
        filmDescription.setText(film.getDescription());
        filmName.setText(film.getName());
        filmYear.setText(String.valueOf(film.getYear()));
        filmLink.setText(film.getLink());

        filmLink.setText("Fonte :" + film.getLink());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.film_detail, menu);

        //criando a intent e validando tudo, sem precidar de actios send
        ShareCompat.IntentBuilder intent = ShareCompat.IntentBuilder.from(this).setText(film.getLink()).setType("text/plain");
        ShareActionProvider actionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menu.findItem(R.id.action_share));
        actionProvider.setShareIntent(intent.getIntent());

        //ShareCompat.configureMenuItem(menu, R.id.action_share, intent);
        return super.onCreateOptionsMenu(menu);
            }



    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
