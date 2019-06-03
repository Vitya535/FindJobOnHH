package vsu.project.findjobonhh.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vsu.project.findjobonhh.HeadhunterApp;
import vsu.project.findjobonhh.R;
import vsu.project.findjobonhh.database.DatabaseHelper;

public class LoadSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_summary);
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
        EditText dayInput = findViewById(R.id.DayInput);
        int maxLength = 2;
        dayInput.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
        EditText yearInput = findViewById(R.id.YearInput);
        maxLength = 4;
        yearInput.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
        EditText salaryInput = findViewById(R.id.SalaryInput);
        maxLength = 9;
        salaryInput.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        final Spinner spinner = findViewById(R.id.MonthsSpinner);

        String[] months = new String[]{
                "Месяц",
                "января",
                "февраля",
                "марта",
                "апреля",
                "мая",
                "июня",
                "июля",
                "августа",
                "сентября",
                "октября",
                "ноября",
                "декабря"
        };

        final List<String> monthsList = new ArrayList<>(Arrays.asList(months));

        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, monthsList) {

            @Override
            public boolean isEnabled(int position) {
                return position != 0;
            }

            @Override
            public View getDropDownView(int position, View convertView, @NotNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        spinner.setAdapter(spinnerArrayAdapter);
    }

    public void loadResume(View view) {
        TextView firstnameInput = findViewById(R.id.FirstnameInput);
        TextView surnameInput = findViewById(R.id.SurnameInput);
        TextView phoneInput = findViewById(R.id.MobilePhoneInput);
        Spinner citySpinner = findViewById(R.id.CitySpinner);
        TextView dayInput = findViewById(R.id.DayInput);
        Spinner monthSpinner = findViewById(R.id.MonthsSpinner);
        TextView yearInput = findViewById(R.id.YearInput);
        RadioGroup groupButtonsSex = findViewById(R.id.GroupButtonsSex);
        RadioGroup groupButtonsExperience = findViewById(R.id.GroupButtonsExperience);
        TextView specializationInput = findViewById(R.id.SpecializationInput);
        TextView salaryInput = findViewById(R.id.SalaryInput);
        Spinner currencySpinner2 = findViewById(R.id.CurrencySpinner2);

        int checkedRBSexId = groupButtonsSex.getCheckedRadioButtonId();
        int checkedRBExperienceId = groupButtonsExperience.getCheckedRadioButtonId();
        RadioButton checkedRBSex = findViewById(checkedRBSexId);
        RadioButton checkedRBExperience = findViewById(checkedRBExperienceId);

        String monthNumber;
        if (monthSpinner.getSelectedItemPosition() > 0 && monthSpinner.getSelectedItemPosition() <= 9) {
            monthNumber = yearInput.getText() + "-0" + monthSpinner.getSelectedItemPosition() + "-" + dayInput.getText();
        } else {
            monthNumber = yearInput.getText() + "-1" + monthSpinner.getSelectedItemPosition() + "-" + dayInput.getText();
        }

        DatabaseHelper helper = HeadhunterApp.getDb();
        helper.addResume(firstnameInput.getText().toString(), surnameInput.getText().toString(),
                phoneInput.getText().toString(), citySpinner.getSelectedItem().toString(),
                monthNumber,
                checkedRBSex.getText().toString(),
                checkedRBExperience.getText().toString(), specializationInput.getText().toString(),
                Integer.valueOf(salaryInput.getText().toString()), currencySpinner2.getSelectedItem().toString());
        transitionToMainPage();
    }

    private void transitionToMainPage() {
        Intent intent = new Intent(this, MainPageActivity.class);
        startActivity(intent);
    }
}
