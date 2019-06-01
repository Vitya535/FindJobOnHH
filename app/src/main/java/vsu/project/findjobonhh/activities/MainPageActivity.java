package vsu.project.findjobonhh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import vsu.project.findjobonhh.R;

// Активити главной страницы (с нее же можно залогиниться), с нее можно сделать поиск вакансий
// С любой из страниц можно сделать logout (выход из аккаунта), загрузку (создание) резюме

public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    public void searchVacancies(View view) {
        Intent intent = new Intent(this, VacanciesActivity.class);
        EditText searchInput = findViewById(R.id.SearchInput);
        intent.putExtra("text", searchInput.getText());
        startActivity(intent);
    }
}
