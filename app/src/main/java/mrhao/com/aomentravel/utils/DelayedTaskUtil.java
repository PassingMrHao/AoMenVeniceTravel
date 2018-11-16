package mrhao.com.aomentravel.utils;

import android.os.Handler;
import android.os.SystemClock;

public  abstract class DelayedTaskUtil {
    private Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            onPostExecute();
        };
    };

    public abstract void onPostExecute();
    /**
     * 延时执行
     * @param delayTime 毫秒值
     */
    public void delayRun(final long delayTime){
        new Thread(){
            public void run() {
                SystemClock.sleep(delayTime);
                handler.sendEmptyMessage(0);
            };
        }.start();
    }
}
