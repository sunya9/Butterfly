package net.unsweets.butterfly.api;


import android.text.TextUtils;

public class Auth {
  final static String[] SCOPES = new String[]{
    "files", "update_profile", "stream", "messages", "public_messages", "write_post", "basic", "follow"
  };
  final static String AUTHENTICATE_URL = "https://account.app.net/oauth/authenticate";

  public Auth() {
  }

  public String getUrl() {
    return AUTHENTICATE_URL + "?" + TextUtils.join(",", SCOPES);
  }
}
