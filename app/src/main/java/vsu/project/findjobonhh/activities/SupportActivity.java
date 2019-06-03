package vsu.project.findjobonhh.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import vsu.project.findjobonhh.HeadhunterApp;
import vsu.project.findjobonhh.R;
import vsu.project.findjobonhh.database.DatabaseHelper;
import vsu.project.findjobonhh.database.entity.Developer;

public class SupportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        final Context context = this;
        final Toolbar toolbar = findViewById(R.id.ToolbarForTransition);
        toolbar.setNavigationOnClickListener(
                new Toolbar.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ActivityOther.class);
                        startActivity(intent);
                    }
                }
        );
        TextView fioLabel = findViewById(R.id.FIOLabel);
        TextView emailLabel = findViewById(R.id.EmailLabel);
        TextView fioLabel2 = findViewById(R.id.FIOLabel2);
        TextView emailLabel2 = findViewById(R.id.EmailLabel2);

        DatabaseHelper dbHelper = HeadhunterApp.getDb();
        List<Developer> developers = dbHelper.findAllDevelopers();
        dbHelper.close();

        fioLabel.setText(developers.get(0).getLastName() + " " + developers.get(0).getFirstName() + " " + developers.get(0).getMiddleName());
        emailLabel.setText(developers.get(0).getEmail());
        fioLabel2.setText(developers.get(1).getLastName() + " " + developers.get(1).getFirstName() + " " + developers.get(1).getMiddleName());
        emailLabel2.setText(developers.get(1).getEmail());
    }
}
