package com.frameworksystem.starwars.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import android.support.v4.app.ShareCompat;
import android.support.v7.widget.ShareActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

import com.frameworksystem.starwars.R;
import com.frameworksystem.starwars.database.DroidDao;
import com.frameworksystem.starwars.model.Droid;
import com.squareup.picasso.Picasso;

/**
 * Created by Lenovo08 on 19/11/2015.
 */

//AppCompatActivity faz a compatiblidade das versões do android
//
public class DroidDetailActivity extends AppCompatActivity {

    private Droid droid;

    //no oncreate se definie o layout da activity
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setando o layout
        setContentView(R.layout.activity_droid_detail);

        //inserindo toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //mesmo comportament da action bar, mas continua customizavel
        setSupportActionBar(toolbar);
        //seta de voltar para a home - recria a pilha - volta para a parent a activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //intent são mensagens entre telas, é possível enviar e receber informações
        droid = (Droid) getIntent().getSerializableExtra("droid");
        //colocando título no topo da tela
        setTitle(droid.getName());

        ImageView droidImage = (ImageView)findViewById(R.id.droid_image);
        TextView droidDescription = (TextView)findViewById(R.id.droid_description);
        TextView droidLink = (TextView)findViewById(R.id.droid_link);

        Picasso.with(this).load(droid.getImage()).into(droidImage);
        droidDescription.setText(droid.getDescription());

        droidLink.setText("Fonte :" +droid.getLink());
    }

    //pegando o menu na toolbar (topo da tela)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.droid_detail, menu);

        //criando a intent e validando tudo, sem precidar de actios send
        ShareCompat.IntentBuilder intent = ShareCompat.IntentBuilder.from(this).setText(droid.getLink()).setType("text/plain");
        ShareActionProvider actionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menu.findItem(R.id.action_share));
        actionProvider.setShareIntent(intent.getIntent());

        //ShareCompat.configureMenuItem(menu, R.id.action_share, intent);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //validando se o usuario clicou no botao share
        if(item.getItemId() == R.id.action_share){
            share();
            return true;
        }
        else if (item.getItemId() == R.id.action_favorite) {
            DroidDao dao = new DroidDao(this);
            boolean result = dao.save(droid);

            if (result) {
                Toast.makeText(this, "Droid favoritado com sucesso", Toast.LENGTH_SHORT)
                        .show();
            }
            else {
                Toast.makeText(this, R.string.msg_error_generic, Toast.LENGTH_SHORT)
                        .show();
            }
        }

        return  super.onOptionsItemSelected(item);
    }

    //metodo para compartilhar contéudo
    private void share() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, droid.getLink());
        intent.putExtra(Intent.EXTRA_TITLE, droid.getName());
        //informando que tipo de arquivo pode ser commpartilhado, neste cado todos tipos
        intent.setType("*/*");
        //verificando se o usuario tem apps para compartilhar
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
