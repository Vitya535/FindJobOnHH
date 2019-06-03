package vsu.project.findjobonhh;

import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.junit.Test;

import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vsu.project.findjobonhh.activities.MainPageActivity;
import vsu.project.findjobonhh.api.HeadhunterApi;
import vsu.project.findjobonhh.models.ConcreteVacancy;
import vsu.project.findjobonhh.models.VacancyStore;

import static org.junit.Assert.assertEquals;

/**
 * VacancyStore local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class VacancyStoreUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testGetVacanciesWithParams() {
        String text = "p";
        String searchField = "Воронеж";
        Integer salary = 20000;
        String currency = "RUR";

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor
                = new HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT);
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            clientBuilder.addInterceptor(interceptor);
        }

        HeadhunterApi api = new Retrofit.Builder()
                .baseUrl(HeadhunterApi.BASE_URL)
                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(HeadhunterApi.class);

        Call<VacancyStore> call = api.getVacancies(text + " " + searchField, salary, currency);
        final int[] size = new int[1];

        call.enqueue(new Callback<VacancyStore>() {
            @Override
            public void onResponse(@NonNull Call<VacancyStore> call, @NonNull Response<VacancyStore> response) {
                size[0] = response.body().vacancies.size();
                assertEquals(size[0], 20);
            }

            @Override
            public void onFailure(@NonNull Call<VacancyStore> call, @NonNull Throwable t) {

            }
        });
    }
}