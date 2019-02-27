package vsu.project.findjobonhh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

// https://developer.android.com/studio/write/app-link-indexing - что-то интересное

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void logup(View view) {
        Intent intent = new Intent(this, LogupActivity.class);
        startActivity(intent);
    }
}
