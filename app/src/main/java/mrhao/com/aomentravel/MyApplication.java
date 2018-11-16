package mrhao.com.aomentravel;

import android.app.Application;

import com.bumptech.glide.Glide;

import cn.smssdk.SMSSDK;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SMSSDK.initSDK(this, "258ea60e36fdf", "7c5bc7f1635716f025389a7953f3c7e8");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if(level==TRIM_MEMORY_UI_HIDDEN){
            Glide.get(this).clearMemory();
        }
        Glide.get(this).trimMemory(level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        //内存低的时候，清理Glide缓存
        Glide.get(this).clearMemory();
    }
}
