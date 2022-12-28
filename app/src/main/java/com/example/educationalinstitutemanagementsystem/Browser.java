package com.example.educationalinstitutemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import android.app.Activity;
        import android.graphics.Bitmap;
        import android.os.Bundle;

        import android.view.View;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;
        import android.widget.Button;
        import android.widget.EditText;
        import android.webkit.WebSettings;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;


public class Browser extends Activity {
    Button b1;
    EditText ed1;

    private WebView mywebView;

    private WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        mywebView=(WebView) findViewById(R.id.webview1);
        mywebView.setWebViewClient(new WebViewClient());
        Bundle bb=getIntent().getExtras();
        String ss=bb.getString("LINK");

        //String ss="https://www.youtube.com/";
        mywebView.loadUrl(ss);
        WebSettings webSettings=mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }

    public class mywebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed(){
        if(mywebView.canGoBack()) {
            mywebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }


}
