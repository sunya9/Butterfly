package net.unsweets.butterfly.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import net.unsweets.butterfly.BuildConfig;
import net.unsweets.butterfly.R;

public class AuthFragment extends Fragment {

  final static String AUTHENTICATE_URL_BASE = "https://account.app.net/oauth/authenticate?" +
    "redirect_uri=urn:ietf:wg:oauth:2.0:oob" +
    "&scopes=files,update_profile,stream,messages,public_messages,write_post,basic,follow" +
    "&response_type=token" +
    "&client_id=%s";
  private final WebViewClient webviewClient = new WebViewClient() {

    @Override
    public void onPageFinished(WebView view, String url) {
      boolean success = !view.getTitle().equals(getAuthUrl()) && url.equals(getAuthUrl());
      if(success) {
        String token = view.getTitle();
        mWebview.setVisibility(View.INVISIBLE);
      }
    }
  };
  private WebView mWebview;
  private View mView;

  public AuthFragment() {
  }

  public static AuthFragment newInstance() {
    AuthFragment fragment = new AuthFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  private String getAuthUrl() {
    return String.format(AUTHENTICATE_URL_BASE, BuildConfig.APP_DOT_NET_CLIENT_ID);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    if(mView == null) {
      mView = inflater.inflate(R.layout.fragment_auth, container, false);
    }
    return mView;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    if (savedInstanceState == null) {
      mWebview = (WebView) getView().findViewById(R.id.auth_webview);
      WebSettings webSettings = mWebview.getSettings();
      webSettings.setJavaScriptEnabled(true);
      mWebview.setWebViewClient(webviewClient);
      mWebview.loadUrl(getAuthUrl());
    }
  }
}
