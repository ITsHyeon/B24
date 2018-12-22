package kr.developer.co.b24.network.retrofit.interfaces;

import android.support.annotation.NonNull;

import kr.developer.co.b24.network.retrofit.response.advice.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface GetAdviceByAge{
  @NonNull
  @GET("/advice/age/{age}")
  Call<Response> GetAdviceByAge(@Path(value = "age",encoded = true) int age);
}
