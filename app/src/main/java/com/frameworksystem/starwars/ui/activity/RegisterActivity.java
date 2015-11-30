package com.frameworksystem.starwars.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.frameworksystem.starwars.R;
import com.frameworksystem.starwars.model.Film;
import com.frameworksystem.starwars.model.User;
import com.squareup.picasso.Picasso;

/**
 * Created by renan on 26/11/15.
 */
public class RegisterActivity extends AppCompatActivity {

    private AppCompatEditText userName;
    private AppCompatEditText userEmail;
    private AppCompatEditText userPassword;
    private AppCompatEditText userConfirmPassword;
    private ImageView userImage;

    //no oncreate se define o layout da activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setando layout
        setContentView(R.layout.activity_register_user);

        userImage = (ImageView)findViewById(R.id.user_image);
        userEmail = (AppCompatEditText)findViewById(R.id.user_email);
        userPassword = (AppCompatEditText)findViewById(R.id.user_password);
        userConfirmPassword = (AppCompatEditText)findViewById(R.id.user_confirm_passsword);
        userName = (AppCompatEditText)findViewById(R.id.user_name);

        AppCompatButton bntCadastrar = (AppCompatButton)findViewById(R.id.btn_cadastrar);
        bntCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createUser();
            }
        });
    }

    private void createUser(){

        String password = userPassword.getText().toString();
        String confirmPassWord = userConfirmPassword.getText().toString();

        if(password.equals(confirmPassWord)){

            User user = new User();

            user.setName(userName.getText().toString());
            user.setEmail(userEmail.getText().toString());
            //forma de comunicação no andorid é a intent
            Intent intent = new Intent();
            //passando parametros para a outra tela
            intent.putExtra("user", user);
            setResult(RESULT_OK, intent);
            //fechar a tela via progração
            finish();
        }
    }

}
