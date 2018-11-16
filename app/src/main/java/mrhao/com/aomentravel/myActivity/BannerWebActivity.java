package mrhao.com.aomentravel.myActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.utils.BaseDialogUtil;

import static android.view.KeyEvent.KEYCODE_BACK;

public class BannerWebActivity extends BaseActivity {
    String weburl;
    String bannertitle;

    @BindView(R.id.webview)
    WebView webView;
    @BindView(R.id.relay_load)
    RelativeLayout relayLoad;
    SharedPreferences sp;
    Bundle b;
    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.tv_collectTitle)
    TextView tvCollectTitle;
    @BindView(R.id.img_collect)
    ImageView imgCollect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_web);
        ButterKnife.bind(this);
        sp = getSharedPreferences("mobuser", 0);
        b = getIntent().getExtras();
        weburl = b.getString("bannerweb");
        bannertitle = b.getString("title");
        tvCollectTitle.setText("澳门旅游指南");
        setWebData();
        setCollectEvent();
    }

    private void setCollectEvent() {

        imgCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BaseDialogUtil.normalDialog(BannerWebActivity.this, "收藏", "喜欢就加入收藏吧，可在『我的』—『个人收藏』中查看", new BaseDialogUtil.ShowDialogListener() {
                    @Override
                    public void Positive() {
                        if (sp.getString("username", "").equals("")) {
                            Toast.makeText(BannerWebActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(BannerWebActivity.this, MobLoginActivity.class));
                        } else {
                            Map<String, String> map = new HashMap<>();
                            map.put("userid", sp.getString("username", ""));
                            map.put("type", "资讯攻略");
                            map.put("title", b.getString("title"));
                            map.put("image", b.getString("img"));
                            map.put("tag", b.getString("tag"));
                            map.put("weburl",weburl);
                            OkHttpUtils.post().url("http://jk.kingtrunk.com/index.php/Home/show/collect").params(map).build()
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onError(Request request, Exception e) {

                                        }

                                        @Override
                                        public void onResponse(String response) {

                                            if (response.contains("\"code\":300")) {
                                                Toast.makeText(BannerWebActivity.this, "亲，已经收藏过了", Toast.LENGTH_SHORT).show();
                                            } else if (response.contains("\"code\":200")) {
                                                Toast.makeText(BannerWebActivity.this, "收藏成功！", Toast.LENGTH_SHORT).show();
                                            } else if (response.contains("\"code\":400")) {
                                                Toast.makeText(BannerWebActivity.this, "收藏失败！", Toast.LENGTH_SHORT).show();
                                            }

                                        }
                                    });


                        }
                    }

                    @Override
                    public void Negative() {

                    }
                });


            }
        });
    }




    private void setWebData() {
        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url == null) return false;
                try {
                    if (url.startsWith("alipay://") || url.startsWith("alipays://") ||
                            url.startsWith("mqqapi://") || url.startsWith("mqqapis://") ||
                            url.startsWith("weixin://") || url.startsWith("weixins://") ||
                            url.startsWith("mqq://") || url.startsWith("wvjbscheme://")
                            ) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                        return true;
                    }
                } catch (Exception e) {
                    return false;
                }
                webView.stopLoading();
                view.loadUrl(url);
                return true;
            }

            /**
             * 接受所有安全证书
             * @param view
             * @param handler
             * @param error
             */
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
                super.onReceivedSslError(view, handler, error);
            }

            /**
             * WebView对加载的页面进行常用资源预加载！！！
             *
             * @param view
             * @return
             */
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                // 步骤1:判断拦截资源的条件，即判断url里的图片资源的文件名
                if (request.getUrl().toString().contains("logo.gif")) {
                    // 假设网页里该图片资源的地址为：http://abc.com/imgage/logo.gif
                    // 图片的资源文件名为:logo.gif

                    InputStream is = null;
                    // 步骤2:创建一个输入流

                    try {
                        is = getApplicationContext().getAssets().open("images/abc.png");
                        // 步骤3:获得需要替换的资源(存放在assets文件夹里)
                        // a. 先在app/src/main下创建一个assets文件夹
                        // b. 在assets文件夹里再创建一个images文件夹
                        // c. 在images文件夹放上需要替换的资源（此处替换的是abc.png图片

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // 步骤4:替换资源
                    WebResourceResponse response = new WebResourceResponse("image/png",
                            "utf-8", is);
                    // 参数1：http请求里该图片的Content-Type,此处图片为image/png
                    // 参数2：编码类型
                    // 参数3：存放着替换资源的输入流（上面创建的那个）
                    return response;
                }


                return super.shouldInterceptRequest(view, request);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                relayLoad.setVisibility(View.GONE);
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
     *
     * @param keyCode
     * @param event
     * @return
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KEYCODE_BACK) && webView.canGoBack()) {

            webView.goBack();

            return true;

        }

        if (webView.getUrl().equals(weburl)) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
