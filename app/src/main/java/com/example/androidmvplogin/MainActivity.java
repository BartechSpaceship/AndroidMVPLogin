package com.example.androidmvplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidmvplogin.Presenter.ILoginPresenter;
import com.example.androidmvplogin.Presenter.LoginPresenter;
import com.example.androidmvplogin.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

   EditText edt_email;
   EditText edt_password;
   Button btnLogin;

   ILoginPresenter mILoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btn_login);
        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);


        //Init
        mILoginPresenter = new LoginPresenter(this);

        //Event
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mILoginPresenter.onLogin(edt_email.getText().toString(), edt_password.getText().toString());
            }
        });


    }

    @Override
    public void onLoginSuccess(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
