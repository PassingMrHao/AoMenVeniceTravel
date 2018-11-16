package mrhao.com.aomentravel.myActivity;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.IOException;
import java.io.InputStream;

import mrhao.com.aomentravel.R;

import static android.view.KeyEvent.KEYCODE_BACK;

public class WebUrlActivity extends BaseActivity {
    WebView webView;
    String weburl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_url);
        webView=findViewById(R.id.webview);
        Bundle b=getIntent().getExtras();
        weburl=b.getString("url");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url == null) return false;
                try {
                    if (url.startsWith("alipay://") || url.startsWith("alipays://") ||
                            url.startsWith("mqqapi://") || url.startsWith("mqqapis://") ||
                            url.startsWith("weixin://") || url.startsWith("weixins://") ||
                            url.startsWith("mqq://") || url.startsWith("mqqs://")
                            ) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                        return true;
                    }
                } catch (Exception e) {
                    return false;
                }

                view.loadUrl(url);
                return true;
            }
        });

        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        WebSettings webSettings = webView.getSettings();
        // 设置可以访问文件
        webSettings.setAllowFileAccess(true);
        // 设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        webSettings.setGeolocationEnabled(true);
        // webSettings.setDatabaseEnabled(true);
        // 使用localStorage则必须打开
        //设置 缓存模式
        webSettings.setAppCacheEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        // 开启 DOM storage API 功能
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl(weburl);

    }

    /**
     * Back键控制网页后退，点击手机Back键不会直接返回桌面，关闭APP
     * @param keyCode
     * @param event
     * @return
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KEYCODE_BACK) && webView.canGoBack()) {

            webView.goBack();

            return true;

        }

        if(webView.getUrl().equals(weburl)){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}

