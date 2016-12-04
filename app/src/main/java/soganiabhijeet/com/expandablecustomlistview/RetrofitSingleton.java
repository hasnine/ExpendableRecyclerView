package soganiabhijeet.com.expandablecustomlistview;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitSingleton {private static final String BASE_URL = "Yur API's Base URL";
    private static Retrofit retrofit = null;
    private static Context sContext;
    private static Retrofit sRetrofit;


    private RetrofitSingleton() {

    }

    public synchronized static Retrofit getInstance(Context context) {

        sContext=context;

        if(sRetrofit==null){
            createRetrofit();
        }
        return sRetrofit;
    }

    private static void createRetrofit(){
        OkHttpClient okHttpClient= new OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS)
                .cache(new Cache(sContext.getCacheDir(),10*1024*1024))
                .build();
        sRetrofit= new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}