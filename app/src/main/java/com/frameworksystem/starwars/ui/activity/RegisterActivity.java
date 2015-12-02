package com.frameworksystem.starwars.ui.activity;


import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.os.EnvironmentCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.frameworksystem.starwars.R;
import com.frameworksystem.starwars.api.UserApi;
import com.frameworksystem.starwars.model.Film;
import com.frameworksystem.starwars.model.User;
import com.frameworksystem.starwars.ui.fragment.LoginFragment;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by renan on 26/11/15.
 */
public class RegisterActivity extends AppCompatActivity {

    private AppCompatEditText userName;
    private AppCompatEditText userEmail;
    private AppCompatEditText userPassword;
    private AppCompatEditText userConfirmPassword;
    private ImageView userImage;
    private Uri mImageCaptureUri;
    private UserApi userApi;

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

        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog();
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
            user.setPassword(password);

            register(user);
        }
    }

    private void createDialog() {

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Escolha sua foto")
                .setPositiveButton("Camera", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        openCamera();
                    }
                })
                .setNegativeButton("Galeria", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        openGallery();
                    }
                }).create();

        dialog.show();
    }

    private void openGallery() {

        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(Intent.createChooser(intent, "Complete action using"), 101);
        }
    }

    private void openCamera() {

        mImageCaptureUri = Uri.fromFile(createFilePhoto());

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, mImageCaptureUri);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 102);
        }
    }

    private File createFilePhoto() {

        File directory = new File(Environment.getExternalStorageDirectory(), "StarWarsApp");

        if (!directory.exists()){
            directory.mkdir();
        }
        
        File filePhoto = new File(directory, "profile_" + System.currentTimeMillis() + ".jpg");
        return filePhoto;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 101 && data!= null) {
                mImageCaptureUri = data.getData();
                Picasso.with(this).load(mImageCaptureUri).into(userImage);
            }
            else if (requestCode == 102) {
                Picasso.with(this).load(mImageCaptureUri).into(userImage);
            }
        }
    }

    private void register(User user) {
        userApi = new UserApi(this);
        userApi.register(user, new LoginFragment.OnLoginListener() {
            @Override
            public void onLogin(User user, int errorCode) {

                if (user != null) {
                    uploadPhoto(user);
                } else {
                    showError(errorCode);
                }
            }
        });
    }

    private void showError(int errorCode) {
        String message = getString(R.string.msg_error_generic);

        if (errorCode == 409) {
            message = "E-mail já cadastrado";
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT)
                .show();
    }

    private void uploadPhoto(final User user) {

        if (mImageCaptureUri == null) {
            close(user);
            return;
        }

        String path = convertMediaUriToPath(mImageCaptureUri);
        userApi.uploadPhoto(user.getId(), path, new OnUploadPhotoUser() {
            @Override
            public void onUpload(User mUser) {
                if (mUser != null) {
                    close(mUser);
                }
                else {
                    close(user);
                }
            }
        });
    }

    private void close(User user) {
        Intent intent = new Intent();
        intent.putExtra("user", user);
        setResult(RESULT_OK, intent);
        finish();
    }

    public interface OnUploadPhotoUser {
        void onUpload(User user);
    }

    private String convertMediaUriToPath(Uri uri) {
        String [] proj={MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String path = cursor.getString(column_index);
        cursor.close();
        return path;
    }
}
