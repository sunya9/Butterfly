package net.unsweets.butterfly.appnet.api;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;

public interface Token {
    @GET("token")
    Call<net.unsweets.butterfly.appnet.models.Token> getCurrentToken();

    @DELETE("token")
    Call<net.unsweets.butterfly.appnet.models.Token> delteToken();
}
