package vsu.project.findjobonhh.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import vsu.project.findjobonhh.models.Vacancy;

public interface HeadhunterApi {
    String BASE_URL = "https://api.hh.ru/";

    // @POST("/resumes") - Создание резюме (загрузка)

    // @GET("/vacancies") - Поиск вакансий по выбранным критериям

    /* PUT /employers/{employer_id}/vacancies/hidden/{vacancy_id} - удаление вакансии (если она ра-
    ботает так, как я думаю, то можно использовать ее, если нет, то самим делать) */

    // POST /negotiations - отклик на вакансию

    // проверка резюме на ошибки - делать как-то самим скорее всего придется

    // Получение контактов разработчиков программы и помощь - сами

    @POST("/resumes")
    void addResume();

    @GET("/vacancies")
    Call<List<Vacancy>> getVacancies(@Query("text") String text,
                                     @Query("search_field") String searchField,
                                     @Query("salary") Integer salary,
                                     @Query("period") Integer period);

    @PUT("/employers/{employer_id}/vacancies/hidden/{vacancy_id}")
    void deleteVacancy(@Path("employer_id") Integer employerId,
                       @Path("vacancy_id") Integer vacancyId);

    @POST("/negotiations")
    void respondOnVacancy(@Query("vacancy_id") Integer vacancyId,
                          @Query("resume_id") Integer resumeId,
                          @Query("message") String message);
}
