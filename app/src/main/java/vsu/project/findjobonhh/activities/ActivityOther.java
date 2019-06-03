package vsu.project.findjobonhh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import vsu.project.findjobonhh.R;

public class ActivityOther extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
    }

    public void transitionToSupport(View view) {
        Intent intent = new Intent(this, SupportActivity.class);
        startActivity(intent);
    }

    public void transitionToMainPage(View view) {
        Intent intent = new Intent(this, MainPageActivity.class);
        startActivity(intent);
    }

    public void transitionToLoadResume(View view) {
        Intent intent = new Intent(this, LoadSummaryActivity.class);
        startActivity(intent);
    }
}
