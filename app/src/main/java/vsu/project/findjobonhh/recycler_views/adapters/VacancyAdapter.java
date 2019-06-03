package vsu.project.findjobonhh.recycler_views.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

import vsu.project.findjobonhh.R;
import vsu.project.findjobonhh.activities.ConcreteVacancyActivity;
import vsu.project.findjobonhh.models.Vacancy;
import vsu.project.findjobonhh.recycler_views.holders.VacancyHolder;

public class VacancyAdapter extends RecyclerView.Adapter<VacancyHolder> {

    private List<Vacancy> vacancies;
    private Context mContext;

    public VacancyAdapter(List<Vacancy> vacancies, Context mContext) {
        this.vacancies = vacancies;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public VacancyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vacancy_item, viewGroup, false);
        return new VacancyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VacancyHolder vacancyHolder, int i) {
        final Vacancy vacancy = vacancies.get(i);
        vacancyHolder.getVacancyHeader().setText(vacancy.name);
        vacancyHolder.getVacancyCity().setText(vacancy.area.name);
        vacancyHolder.getVacancyCompany().setText(vacancy.employer.name);
        String date = vacancy.createdAt.split("T")[0];
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime dateCreatedAt = formatter.parseDateTime(date);
        vacancyHolder.getVacancyDate().setText(dateCreatedAt.toString(DateTimeFormat.forPattern("dd.MM.yyyy")));
        vacancyHolder.getVacancyDescription().setText(vacancy.snippet.responsibility);

        vacancyHolder.getItemLayout().setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ConcreteVacancyActivity.class);
                        intent.putExtra("vacancy_id", vacancy.id);
                        mContext.startActivity(intent);
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return vacancies.size();
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
        notifyDataSetChanged();
    }
}
