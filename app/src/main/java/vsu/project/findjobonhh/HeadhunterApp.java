package vsu.project.findjobonhh;

import android.app.Application;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vsu.project.findjobonhh.api.HeadhunterApi;

public class HeadhunterApp extends Application {

    private static HeadhunterApi sApi;

    public static HeadhunterApi getApi() {
        return sApi;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApi = createApi(buildRetrofit(buildOkHttp()));
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
