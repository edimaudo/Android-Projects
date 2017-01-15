package com.edimaudo.webviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());//prevents adnroid from loading default web browser
        webView.getSettings().setJavaScriptEnabled(true);//set javascript eneable
        webView.loadUrl("http://www.google.com");//lad url
        //webView.loadData("");//load data
    }
}
