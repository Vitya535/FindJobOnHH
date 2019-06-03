package vsu.project.findjobonhh.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vsu.project.findjobonhh.HeadhunterApp;
import vsu.project.findjobonhh.R;
import vsu.project.findjobonhh.api.HeadhunterApi;
import vsu.project.findjobonhh.models.Vacancy;
import vsu.project.findjobonhh.models.VacancyStore;
import vsu.project.findjobonhh.recycler_views.adapters.VacancyAdapter;

public class VacanciesActivity extends AppCompatActivity {

    RecyclerView recyclerViewVacancies;
    VacancyAdapter vacancyAdapter;
    private List<Vacancy> vacancyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacancies);
        recyclerViewVacancies = findViewById(R.id.RecyclerViewVacancy);
        final Context context = this;
        final Toolbar toolbar = findViewById(R.id.ToolbarForTransition);
        toolbar.setNavigationOnClickListener(
                new Toolbar.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, MainPageActivity.class);
                        startActivity(intent);
                    }
                }
        );
        initRecyclerView();
        getVacancies();
    }

    private void getVacancies() {
        Bundle args = getIntent().getExtras();
        if (args != null) {
            String text = Objects.requireNonNull(args.get("text")).toString();
            String searchField = Objects.requireNonNull(args.get("searchField")).toString();
            Integer salary = Integer.valueOf(Objects.requireNonNull(args.get("salary")).toString());
            String currency = Objects.requireNonNull(args.get("currency")).toString();
            HeadhunterApi api = HeadhunterApp.getApi();
            Call<VacancyStore> call = api.getVacancies(text + " " + searchField, salary, currency);

            call.enqueue(new Callback<VacancyStore>() {
                @Override
                public void onResponse(@NonNull Call<VacancyStore> call, @NonNull Response<VacancyStore> response) {
                    vacancyAdapter.setVacancies(Objects.requireNonNull(response.body()).vacancies);
                    TextView vacanciesCount = findViewById(R.id.VacancyCount);
                    vacanciesCount.setText(response.body().vacancies.size() + " вакансий");
                }

                @Override
                public void onFailure(@NonNull Call<VacancyStore> call, @NonNull Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void initRecyclerView() {
        vacancyAdapter = new VacancyAdapter(vacancyList, this);
        recyclerViewVacancies.setAdapter(vacancyAdapter);
        recyclerViewVacancies.setLayoutManager(new LinearLayoutManager(this));
    }
}
