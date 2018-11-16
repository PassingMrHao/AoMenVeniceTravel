package mrhao.com.aomentravel.myActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;

import mrhao.com.aomentravel.MainActivity;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.MaJiaUrlBean;
import mrhao.com.aomentravel.bean.MobJieMianBean;
import mrhao.com.aomentravel.utils.DelayedTaskUtil;

public class LoadingActivity extends BaseActivity {
    final String Mobkey = "258ea60e36fdf";
    final String MobTable = "jiemian";
    MobJieMianBean mobean;

    MaJiaUrlBean urlBean;
    boolean b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sp=getSharedPreferences("first",0);
        b = sp.getBoolean("judgeFirst", true);
        if(b){
            startActivity(new Intent(LoadingActivity.this, WelcomeActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.activity_loading);

        DelayedTaskUtil de = new DelayedTaskUtil() {
            @Override
            public void onPostExecute() {

                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if(networkInfo == null || !networkInfo.isAvailable())
                {
                    //当前无可用网络
                    Toast.makeText(LoadingActivity.this, "内容加载失败，请检查您的网络设置", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoadingActivity.this, MainActivity.class));
                    finish();
                } else
                {
                    //当前有可用网络
                    youwang2();
                }

            }
        };
        de.delayRun(2500);
    }


    public void youwang2() {


        Map<String, String> map = new HashMap<>();
        map.put("", "");
        OkHttpUtils.get().url("http://jk.kingtrunk.com/index.php/Home/show/nlist").params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {

                        Gson gs = new Gson();
                        urlBean = gs.fromJson(response, MaJiaUrlBean.class);
                        if (urlBean.getData().get(0).getType().equals("0")) {
                            // 0：原生界面  其他：跳转weburl
                            startActivity(new Intent(LoadingActivity.this, MainActivity.class));
                            finish();
                        } else {

                            Intent hao = new Intent(LoadingActivity.this, WebUrlActivity.class);
                            Bundle b = new Bundle();
                            b.putString("url", urlBean.getData().get(0).getUrl());
                            hao.putExtras(b);
                            startActivity(hao);

                            finish();


                        }

                    }
                });



    }






    public void youwang() {
        Map<String, String> map = new HashMap<>();
        map.put("key", Mobkey);
        map.put("table", MobTable);
        map.put("k", "eXVhbnNoZW5n");
        OkHttpUtils.get().url("http://apicloud.mob.com/ucache/get").params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                    }
                    @Override
                    public void onResponse(String response) {
                        Gson gs = new Gson();
                        mobean = gs.fromJson(response, MobJieMianBean.class);
                        if (mobean.getResult().getV().equals("0")) {
                            startActivity(new Intent(LoadingActivity.this, MainActivity.class));
                            finish();
                        } else {
                            lookurl();
                            finish();
                        }
                    }
                });
    }

    public void lookurl() {
        Map<String, String> map = new HashMap<>();
        map.put("key", Mobkey);
        map.put("table", MobTable);
        map.put("k", "d2VidXJs");
        OkHttpUtils.get().url("http://apicloud.mob.com/ucache/get").params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }
                    @Override
                    public void onResponse(String response) {
                        Gson gs = new Gson();
                        mobean = gs.fromJson(response, MobJieMianBean.class);
                        Intent hao = new Intent(LoadingActivity.this, WebUrlActivity.class);
                        Bundle b = new Bundle();
                        b.putString("url", mobean.getResult().getV());
                        hao.putExtras(b);
                        startActivity(hao);
                    }
                });
    }





}
