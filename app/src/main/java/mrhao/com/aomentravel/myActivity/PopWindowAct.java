package mrhao.com.aomentravel.myActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;

public class PopWindowAct extends AppCompatActivity {


    @BindView(R.id.chahao)
    ImageView chahao;
    @BindView(R.id.zhidaol)
    Button zhidaol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pop_window);
        ButterKnife.bind(this);
        setTitle("");
        /*设置窗口样式activity宽高start*/
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay();  //为获取屏幕宽、高
        WindowManager.LayoutParams p = getWindow().getAttributes();  //获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 0.46);   //高度设置为屏幕的0.6
        p.width = (int) (d.getWidth() * 0.86);    //宽度设置为屏幕的0.7
        p.alpha = 1.0f;      //设置本身透明度
        p.dimAmount = 0.68f;      //设置窗口外黑暗度
        getWindow().setAttributes(p);
        setFinishOnTouchOutside(false);

        /*设置窗口样式activity宽高end*/


        zhidaol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        chahao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
