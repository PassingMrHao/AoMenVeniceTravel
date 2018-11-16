package mrhao.com.aomentravel.myActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.CollectResultBean;
import mrhao.com.aomentravel.utils.BaseDialogUtil;
import mrhao.com.aomentravel.utils.DelayedTaskUtil;

public class ZheKouWebActivity extends BaseActivity {


    @BindView(R.id.zhekou_webview)
    WebView webView;

    String baseurl = "";
    String title = "";
    @BindView(R.id.relay_load)
    RelativeLayout relayLoad;
    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.tv_collectTitle)
    TextView tvCollectTitle;
    @BindView(R.id.img_collect)
    ImageView imgCollect;
    SharedPreferences sp;
    Bundle b;
    DelayedTaskUtil de;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhe_kou_web);
        sp = getSharedPreferences("mobuser", 0);
        ButterKnife.bind(this);
        b = getIntent().getExtras();
        String uurl=b.getString("weburl");
        baseurl = uurl.replaceAll("&amp;","&");
        title = b.getString("bt");
        tvCollectTitle.setText(title);
        setBaseDate();
    }

    private void setBaseDate() {

        imgCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BaseDialogUtil.normalDialog(ZheKouWebActivity.this, "收藏", "喜欢就加入收藏吧，可在『我的』—『个人收藏』中查看", new BaseDialogUtil.ShowDialogListener() {
                    @Override
                    public void Positive() {
                        if (sp.getString("username", "").equals("")) {
                            Toast.makeText(ZheKouWebActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ZheKouWebActivity.this, MobLoginActivity.class));
                        } else {
                            Map<String, String> map = new HashMap<>();
                            map.put("userid", sp.getString("username", ""));
                            map.put("type", b.getString("type"));
                            map.put("title", b.getString("title"));
                            map.put("image", b.getString("image"));
                            map.put("tag", b.getString("tag"));
                            map.put("weburl", baseurl);
                            OkHttpUtils.post().url("http://jk.kingtrunk.com/index.php/Home/show/collect").params(map).build()
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onError(Request request, Exception e) {

                                        }

                                        @Override
                                        public void onResponse(String response) {

                                            if (response.contains("\"code\":300")) {
                                                Toast.makeText(ZheKouWebActivity.this, "亲，已经收藏过了", Toast.LENGTH_SHORT).show();
                                            } else if (response.contains("\"code\":200")) {
                                                Toast.makeText(ZheKouWebActivity.this, "收藏成功！", Toast.LENGTH_SHORT).show();
                                            } else if (response.contains("\"code\":400")) {
                                                Toast.makeText(ZheKouWebActivity.this, "收藏失败！", Toast.LENGTH_SHORT).show();
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
                            url.startsWith("mqq://") || url.startsWith("mqqs://") ||
                            url.startsWith("wvjbscheme://")|| url.startsWith("pocketmacaoapp://")
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

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int Progress) {
                if (Progress == 100) {

                    String javascript = "javascript:function hideOther() {" +
                            "document.getElementsByTagName('body')[0].innerHTML;" +
//                        "document.getElementsByClassName('showme')[0].remove();" +
                            "document.getElementsByClassName('fixed')[0].remove();}";
                    //创建方法
                    view.loadUrl(javascript);

                    //加载方法
                    view.loadUrl("javascript:hideOther();");

                    de = new DelayedTaskUtil() {
                        @Override
                        public void onPostExecute() {
                            relayLoad.setVisibility(View.GONE);
                        }
                    };
                    de.delayRun(300);

                }
            }
        });
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

        webView.loadUrl(baseurl);

    }
}
