package mrhao.com.aomentravel.myActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.myAdapter.MyViewPagerAdapter;

public class WelcomeActivity extends BaseActivity {


    @BindView(R.id.yindao_page)
    ViewPager yindaoPage;
    @BindView(R.id.yindao_idt)
    LinearLayout yindaoIdt;

    View v1, v2, v3,v4;
    List<View> viewList;
    Button btnLvcheng;
    LinearLayout.LayoutParams mdots;   //指示器布局参数
    List<ImageView> dot_list = new ArrayList<ImageView>();  //指示器容器列表
    int currentIndex;   //当前指示器索引

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        setPageYinDao();
        initDots();
    }

    /**
     * 初始化指示器
     */
    private void initDots() {
        mdots = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mdots.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
        for (int i = 0; i < viewList.size(); i++) {
            ImageView im = new ImageView(getApplicationContext());
            im.setBackgroundResource(R.drawable.dot_unselect);
//            im.setImageResource(R.drawable.dot_unselect);
            im.setSelected(false);
            yindaoIdt.addView(im, mdots);
            dot_list.add(im);
        }
        dot_list.get(0).setSelected(true);
    }

    private void setPageYinDao() {

        LayoutInflater lf=getLayoutInflater().from(WelcomeActivity.this);
        v1 = lf.inflate(R.layout.lay1, null);
        v2 = lf.inflate(R.layout.lay2, null);
        v3 = lf.inflate(R.layout.lay3, null);
        v4 = lf.inflate(R.layout.lay4, null);
        btn=v4.findViewById(R.id.btn_yindao);
        viewList = new ArrayList<View>();
        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);
        viewList.add(v4);
        yindaoPage.setAdapter(new MyViewPagerAdapter(viewList));
        yindaoPage.setCurrentItem(0);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeActivity.this, LoadingActivity.class));
                finish();
            }
        });

        /**
         * ViewPage设置监听
         */

        yindaoPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                dot_list.get(currentIndex % viewList.size()).setSelected(false);
                currentIndex=position;
                dot_list.get(currentIndex%viewList.size()).setSelected(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        //第一次启动APP后储存信息
        SharedPreferences spt = getSharedPreferences("first", 0);
        SharedPreferences.Editor editor = spt.edit();
        editor.putBoolean("judgeFirst", false);
        editor.commit();
    }
}
