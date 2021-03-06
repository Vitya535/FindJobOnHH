package vsu.project.findjobonhh;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import net.danlew.android.joda.JodaTimeAndroid;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vsu.project.findjobonhh.api.HeadhunterApi;
import vsu.project.findjobonhh.database.DatabaseHelper;

public class HeadhunterApp extends Application {

    private static HeadhunterApi sApi;

    private static DatabaseHelper dbHelper;

    public static HeadhunterApi getApi() {
        return sApi;
    }

    public static DatabaseHelper getDb() {
        return dbHelper;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
        sApi = createApi(buildRetrofit(buildOkHttp()));
        dbHelper = new DatabaseHelper(this);
        addData();
    }

    private void addData() {
        dbHelper.addDeveloper("Виктор", "Кушнеренко", "Константинович", "kushnerenko.viktor@gmail.com");
        dbHelper.addDeveloper("Павел", "Рудин", "Игоревич", "rudinp@yandex.ru");
    }

    private HeadhunterApi createApi(Retrofit retrofit) {
        return retrofit.create(HeadhunterApi.class);
    }

    private Retrofit buildRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(HeadhunterApi.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient buildOkHttp() {
        OkHttpClient.Builder clientBuilder
                = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor
                = new HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT);
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            clientBuilder.addInterceptor(interceptor);
        }
        return clientBuilder.build();
    }
}
