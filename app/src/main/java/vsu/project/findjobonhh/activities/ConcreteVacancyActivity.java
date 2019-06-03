package vsu.project.findjobonhh.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.NoCopySpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vsu.project.findjobonhh.HeadhunterApp;
import vsu.project.findjobonhh.R;
import vsu.project.findjobonhh.api.HeadhunterApi;
import vsu.project.findjobonhh.models.ConcreteVacancy;
import vsu.project.findjobonhh.models.Phone;
import vsu.project.findjobonhh.models.VacancyStore;

public class ConcreteVacancyActivity extends AppCompatActivity {

    private ConcreteVacancy concreteVacancy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concrete_vacancy);
        final Context context = this;
        final Toolbar toolbar = findViewById(R.id.ToolbarForTransition);
        toolbar.setNavigationOnClickListener(
                new Toolbar.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, VacanciesActivity.class);
                        startActivity(intent);
                    }
                }
        );
        getVacancy();
    }

    public void getVacancy() {
        Bundle args = getIntent().getExtras();
        if (args != null) {
            String vacancy_id = Objects.requireNonNull(args.get("vacancy_id")).toString();
            HeadhunterApi api = HeadhunterApp.getApi();
            Call<ConcreteVacancy> vacancy = api.getVacancy(vacancy_id);

            vacancy.enqueue(new Callback<ConcreteVacancy>() {
                @Override
                public void onResponse(@NonNull Call<ConcreteVacancy> call, @NonNull Response<ConcreteVacancy> response) {
                    concreteVacancy = response.body();
                    setVacancyData();
                }

                @Override
                public void onFailure(@NonNull Call<ConcreteVacancy> call, @NonNull Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void setVacancyData() {
        TextView vacancyDate = findViewById(R.id.VacancyDate);
        TextView vacancyName = findViewById(R.id.VacancyName);
        TextView vacancySalary = findViewById(R.id.VacancySalary);
        TextView cityName = findViewById(R.id.CityName);
        TextView experienceName = findViewById(R.id.ExperienceName);
        TextView scheduleName = findViewById(R.id.ScheduleName);
        HtmlTextView description = findViewById(R.id.Description);
        TextView contactsName = findViewById(R.id.ContactsName);
        TextView contactsPhone = findViewById(R.id.ContactsPhone);
        TextView contactsEmail = findViewById(R.id.ContactsEmail);

        String date = concreteVacancy.createdAt.split("T")[0];
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime dateCreatedAt = formatter.parseDateTime(date);
        vacancyDate.setText(dateCreatedAt.toString(DateTimeFormat.forPattern("dd.MM.yyyy")));
        vacancyName.setText(concreteVacancy.name);
        String salaryText;
        if (concreteVacancy.salary == null) {
            salaryText = "З/п не указана!";
        } else {
            if (concreteVacancy.salary.from != null) {
                salaryText = "От " + concreteVacancy.salary.from + " " + concreteVacancy.salary.currency;
                if (concreteVacancy.salary.to != null) {
                    salaryText += " до " + concreteVacancy.salary.to + " " + concreteVacancy.salary.currency;
                }
            } else {
                if (concreteVacancy.salary.to != null) {
                    salaryText = "До " + concreteVacancy.salary.to + " " + concreteVacancy.salary.currency;
                } else {
                    salaryText = "З/п не указана!";
                }
            }
            if (concreteVacancy.salary.gross) {
                salaryText += " до вычета НДФЛ";
            } else {
                salaryText += " после вычета НДФЛ";
            }
        }
        vacancySalary.setText(salaryText);
        cityName.setText(concreteVacancy.area.name);
        experienceName.setText(concreteVacancy.experience.name);
        scheduleName.setText(concreteVacancy.schedule.name);
        description.setHtml(concreteVacancy.description);
        if (concreteVacancy.contacts != null) {
            contactsName.setText(concreteVacancy.contacts.name);
            for (Phone phone : concreteVacancy.contacts.phones) {
                contactsPhone.setText("+" + phone.country + " (" + phone.city + ") " + phone.number);
            }
            contactsEmail.setText(concreteVacancy.contacts.email.toString());
        } else {
            contactsName.setText("");
            contactsPhone.setText("Информация не указана!");
            contactsEmail.setText("");
        }
    }
}
