package vsu.project.findjobonhh.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import vsu.project.findjobonhh.models.ConcreteVacancy;
import vsu.project.findjobonhh.models.VacancyStore;

public interface HeadhunterApi {
    String BASE_URL = "https://api.hh.ru";

    @GET("/vacancies")
    Call<VacancyStore> getVacancies(@Query("text") String text,
                                    @Query("salary") Integer salary,
                                    @Query("currency") String currency);

    @GET("/vacancies/{vacancy_id}")
    Call<ConcreteVacancy> getVacancy(@Path("vacancy_id") String vacancy_id);
}
