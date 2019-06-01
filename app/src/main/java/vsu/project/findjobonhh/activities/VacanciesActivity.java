package vsu.project.findjobonhh.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vsu.project.findjobonhh.HeadhunterApp;
import vsu.project.findjobonhh.R;
import vsu.project.findjobonhh.models.Vacancy;
import vsu.project.findjobonhh.recycler_views.adapters.VacancyAdapter;

// эта активити отвечает за отображение вакансий при поиске
// около каждой вакансии будет ссылка Откликнуться и Не показывать
// по нажатию на Откликнуться - предлагается заполнить резюме для отклика
// по нажатию на Не показывать - возможно можно будет вернуть ее обратно
/* по нажатию на название вакансии - открывается ее подробное описание и также присутствуют кнопки
    Откликнуться и Не показывать */
// помощь по программе и контакты разработчиков будут в подвале страничек?

public class VacanciesActivity extends AppCompatActivity {

    RecyclerView recyclerViewVacancies;
    VacancyAdapter vacancyAdapter;
    private List<Vacancy> vacancies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacancies);
        recyclerViewVacancies = findViewById(R.id.RecyclerViewVacancy);
        initRecyclerView();
        getVacancies();
    }

    private void getVacancies() {
        Bundle args = getIntent().getExtras();
        if (args != null) {
            String name = Objects.requireNonNull(args.get("text")).toString();
            Call<List<Vacancy>> call = HeadhunterApp.getApi().getVacancies(name, null, null, null);

            call.enqueue(new Callback<List<Vacancy>>() {
                @Override
                public void onResponse(@NonNull Call<List<Vacancy>> call, @NonNull Response<List<Vacancy>> response) {
                    vacancyAdapter.setVacancies(response.body());
                }

                @Override
                public void onFailure(@NonNull Call<List<Vacancy>> call, @NonNull Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        initRecyclerView();
    }

    private void initRecyclerView() {
        vacancyAdapter = new VacancyAdapter(vacancies);
        recyclerViewVacancies.setAdapter(vacancyAdapter);
        recyclerViewVacancies.setLayoutManager(new LinearLayoutManager(this));
    }
}
