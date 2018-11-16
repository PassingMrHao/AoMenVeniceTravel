package mrhao.com.aomentravel.findActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;

public class WoDeAboutActivity extends AppCompatActivity {

    @BindView(R.id.about_chahao)
    ImageView aboutChahao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wo_de_about);
        ButterKnife.bind(this);
        /*设置窗口样式activity宽高start*/
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay();  //为获取屏幕宽、高
        WindowManager.LayoutParams p = getWindow().getAttributes();  //获取对话框当前的参数值

        p.height = (int) (d.getHeight() * 0.68);   //设置屏幕的高度占比
        p.width = (int) (d.getWidth() * 0.88);    //设置屏幕的宽度占比
        p.alpha = 1.0f;      //设置本身透明度
        p.dimAmount = 0.58f;      //设置窗口外黑暗度
        getWindow().setAttributes(p);
        setFinishOnTouchOutside(true); //是否触摸Activity界外关闭


        aboutChahao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
