package net.unsweets.butterfly.appnet;

import net.unsweets.butterfly.appnet.api.Token;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppNetClient {
    private final static String TAG = AppNetClient.class.getSimpleName();
    private final Retrofit retrofit;
    private final String token;

    private final Interceptor addAuthorization = new Interceptor() {
        @Override
        public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
            Request build = chain.request()
                .newBuilder()
                .addHeader("Authorization", "Bearer %s" + token)
                .build();
            return chain.proceed(build);
        }
    };
    public final Token tokenApi;

    public AppNetClient(final String token) {
        this.token = token;
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(addAuthorization).build();
        this.retrofit = new Retrofit.Builder()
            .baseUrl(Configuration.API_END_POINT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();

        this.tokenApi = retrofit.create(Token.class);
    }

    public UserStream createStream() {
        return new UserStream(token);
    }
}
