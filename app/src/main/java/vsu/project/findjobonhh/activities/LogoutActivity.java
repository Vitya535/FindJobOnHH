package vsu.project.findjobonhh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import vsu.project.findjobonhh.R;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logup);
    }

    public void transitionToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void transitionToGetPassword(View view) {
        Intent intent = new Intent(this, GetPasswordActivity.class);
        startActivity(intent);
    }
}
