package vsu.project.findjobonhh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import vsu.project.findjobonhh.R;

public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        EditText salaryInput = findViewById(R.id.SalaryInput);
        int maxLength = 8;
        salaryInput.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
    }

    public void searchVacancies(View view) {
        Intent intent = new Intent(this, VacanciesActivity.class);
        EditText searchInput = findViewById(R.id.SearchInput);
        EditText cityInput = findViewById(R.id.CityInput);
        EditText salaryInput = findViewById(R.id.SalaryInput);
        Spinner currencySpinner = findViewById(R.id.CurrencySpinner);
        intent.putExtra("text", searchInput.getText());
        intent.putExtra("searchField", cityInput.getText());
        intent.putExtra("salary", salaryInput.getText());
        intent.putExtra("currency", currencySpinner.getSelectedItem().toString());
        startActivity(intent);
    }

    public void transitionToOther(View view) {
        Intent intent = new Intent(this, ActivityOther.class);
        startActivity(intent);
    }
}
