package vsu.project.findjobonhh.recycler_views.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vsu.project.findjobonhh.R;
import vsu.project.findjobonhh.models.Vacancy;
import vsu.project.findjobonhh.recycler_views.holders.VacancyHolder;

public class VacancyAdapter extends RecyclerView.Adapter<VacancyHolder> {

    private List<Vacancy> vacancies;

    public VacancyAdapter(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    @NonNull
    @Override
    public VacancyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vacancy_item, viewGroup, false);
        return new VacancyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VacancyHolder vacancyHolder, int i) {
        Vacancy vacancy = vacancies.get(i);
        vacancyHolder.getVacancyHeader().setText("Что-то там");
        vacancyHolder.getVacancyCity().setText("Воронеж");
        vacancyHolder.getVacancyCompany().setText("апрвпцыу");
        vacancyHolder.getVacancyContacts().setText("Контакты");
        vacancyHolder.getVacancyRespond().setText("Откликнуться");
        vacancyHolder.getVacancyDate().setText("Сегодня");
        vacancyHolder.getVacancyDescription().setText(vacancy.getDescription());
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
    }
}
