package com.frameworksystem.starwars.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frameworksystem.starwars.R;
import com.frameworksystem.starwars.model.User;
import com.frameworksystem.starwars.ui.activity.RegisterActivity;

/**
 * Created by felipets on 11/30/15.
 */
public class LoginFragment extends Fragment {

    private AppCompatEditText userEmail;
    private AppCompatEditText userPassword;

    private OnLoginListener onLoginListener;


    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userEmail = (AppCompatEditText) view.findViewById(R.id.user_email);
        userPassword = (AppCompatEditText) view.findViewById(R.id.user_password);

        AppCompatButton btnLogin = (AppCompatButton)view.findViewById(R.id.btn_login);
        AppCompatButton btnRegister = (AppCompatButton)view.findViewById(R.id.btn_register);
        AppCompatCheckBox saveUser = (AppCompatCheckBox)view.findViewById(R.id.user_save_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onLoginListener != null) {
                    onLoginListener.onLogin(new User());
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RegisterActivity.class);
                startActivityForResult(intent, 99);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 99 && resultCode == Activity.RESULT_OK && data != null) {
            User user = (User)data.getSerializableExtra("user");
            if (onLoginListener != null) {
                onLoginListener.onLogin(user);
            }
        }
    }

    public void setOnLoginListener(OnLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
    }

    public interface OnLoginListener {
        void onLogin(User user);
    }
}
