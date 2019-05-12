package vsu.project.findjobonhh.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import vsu.project.findjobonhh.R;

// эта активити отвечает за отображение вакансий при поиске
// около каждой вакансии будет ссылка Откликнуться и Не показывать
// по нажатию на Откликнуться - предлагается заполнить резюме для отклика
// по нажатию на Не показывать - возможно можно будет вернуть ее обратно
/* по нажатию на название вакансии - открывается ее подробное описание и также присутствуют кнопки
    Откликнуться и Не показывать */
// помощь по программе и контакты разработчиков будут в подвале страничек?

public class VacanciesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacancies);
    }
}
