package vsu.project.findjobonhh.recycler_views.holders;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import vsu.project.findjobonhh.R;

public class VacancyHolder extends RecyclerView.ViewHolder {
    private TextView vacancyCity, vacancyHeader, vacancyCompany, vacancyDescription, vacancyDate, vacancyContacts, vacancyRespond;
    private ConstraintLayout itemLayout;

    public VacancyHolder(@NonNull View itemView) {
        super(itemView);

        vacancyCity = itemView.findViewById(R.id.VacancyCity);
        vacancyHeader = itemView.findViewById(R.id.VacancyHeader);
        vacancyCompany = itemView.findViewById(R.id.VacancyCompany);
        vacancyDescription = itemView.findViewById(R.id.VacancyDescription);
        vacancyDate = itemView.findViewById(R.id.VacancyDate);
        vacancyContacts = itemView.findViewById(R.id.VacancyContacts);
        vacancyRespond = itemView.findViewById(R.id.VacancyRespond);
        itemLayout = itemView.findViewById(R.id.item_layout);
    }

    public TextView getVacancyCity() {
        return vacancyCity;
    }

    public void setVacancyCity(TextView vacancyCity) {
        this.vacancyCity = vacancyCity;
    }

    public TextView getVacancyHeader() {
        return vacancyHeader;
    }

    public void setVacancyHeader(TextView vacancyHeader) {
        this.vacancyHeader = vacancyHeader;
    }

    public TextView getVacancyCompany() {
        return vacancyCompany;
    }

    public void setVacancyCompany(TextView vacancyCompany) {
        this.vacancyCompany = vacancyCompany;
    }

    public TextView getVacancyDescription() {
        return vacancyDescription;
    }

    public void setVacancyDescription(TextView vacancyDescription) {
        this.vacancyDescription = vacancyDescription;
    }

    public TextView getVacancyDate() {
        return vacancyDate;
    }

    public void setVacancyDate(TextView vacancyDate) {
        this.vacancyDate = vacancyDate;
    }

    public TextView getVacancyContacts() {
        return vacancyContacts;
    }

    public void setVacancyContacts(TextView vacancyContacts) {
        this.vacancyContacts = vacancyContacts;
    }

    public TextView getVacancyRespond() {
        return vacancyRespond;
    }

    public void setVacancyRespond(TextView vacancyRespond) {
        this.vacancyRespond = vacancyRespond;
    }

    public ConstraintLayout getItemLayout() {
        return itemLayout;
    }

    public void setItemLayout(ConstraintLayout itemLayout) {
        this.itemLayout = itemLayout;
    }
}
