package mrhao.com.aomentravel.myActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gyf.barlibrary.ImmersionBar;

import mrhao.com.aomentravel.R;

public class BaseActivity extends AppCompatActivity {

    ImmersionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        bar = ImmersionBar.with(this);
        bar.init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bar != null) {
            bar.destroy();
        }
    }
}
