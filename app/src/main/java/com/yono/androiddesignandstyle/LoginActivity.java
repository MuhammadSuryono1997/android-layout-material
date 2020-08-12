package com.yono.androiddesignandstyle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_shrine);
    }

    public void NextProduct(View view) {
        startActivity(new Intent(LoginActivity.this, ProductsActivity.class));
    }

    public void CancelLogin(View view) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }
}
