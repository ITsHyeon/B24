package kr.developer.co.b24.network.retrofit.response.advice;

import com.google.gson.annotations.SerializedName;

import kr.developer.co.b24.model.Advice;

public class Response {
  private int status;
  private String message;

  @SerializedName("data")
  private Advice[] advice;

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Advice[] getAdvice() {
    return advice;
  }

  public void setAdvice(Advice[] advice) {
    this.advice = advice;
  }
}
