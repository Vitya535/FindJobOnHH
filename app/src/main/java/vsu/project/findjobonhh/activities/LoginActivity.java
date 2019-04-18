package vsu.project.findjobonhh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import vsu.project.findjobonhh.R;

// https://developer.android.com/studio/write/app-link-indexing - что-то интересное
// https://futurestud.io/tutorials/android-basic-authentication-with-retrofit - про авторизацию

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void transitionToLogup(View view) {
        Intent intent = new Intent(this, LogoutActivity.class);
        startActivity(intent);
    }

    public void login(View view) {
        Intent intent = new Intent(this, SummaryActivity.class);
        startActivity(intent);
    }
}
