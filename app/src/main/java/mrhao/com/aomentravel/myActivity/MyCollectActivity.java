package mrhao.com.aomentravel.myActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.myActivity.CollectActivity.FoodActivity;
import mrhao.com.aomentravel.myActivity.CollectActivity.GouWuActivity;
import mrhao.com.aomentravel.myActivity.CollectActivity.JingDianActivity;
import mrhao.com.aomentravel.myActivity.CollectActivity.YuLeActivity;
import mrhao.com.aomentravel.myActivity.CollectActivity.ZheKouActivity;
import mrhao.com.aomentravel.myActivity.CollectActivity.ZiXunActivity;

public class MyCollectActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.lay_collect_zixun)
    LinearLayout layCollectZixun;
    @BindView(R.id.lay_collect_jingdian)
    LinearLayout layCollectJingdian;
    @BindView(R.id.lay_collect_zhekou)
    LinearLayout layCollectZhekou;
    @BindView(R.id.lay_collect_gouwu)
    LinearLayout layCollectGouwu;
    @BindView(R.id.lay_collect_yule)
    LinearLayout layCollectYule;
    @BindView(R.id.lay_collect_food)
    LinearLayout layCollectFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collect);
        ButterKnife.bind(this);
        setBaseDate();
    }

    private void setBaseDate() {
        titleText.setText("我的收藏");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @OnClick({R.id.lay_collect_zixun, R.id.lay_collect_jingdian, R.id.lay_collect_zhekou, R.id.lay_collect_gouwu, R.id.lay_collect_yule, R.id.lay_collect_food})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lay_collect_zixun:
                startActivity(new Intent(MyCollectActivity.this, ZiXunActivity.class));
                break;
            case R.id.lay_collect_jingdian:
                startActivity(new Intent(MyCollectActivity.this, JingDianActivity.class));
                break;
            case R.id.lay_collect_zhekou:
                startActivity(new Intent(MyCollectActivity.this, ZheKouActivity.class));
                break;
            case R.id.lay_collect_gouwu:
                startActivity(new Intent(MyCollectActivity.this, GouWuActivity.class));
                break;
            case R.id.lay_collect_yule:
                startActivity(new Intent(MyCollectActivity.this, YuLeActivity.class));
                break;
            case R.id.lay_collect_food:
                startActivity(new Intent(MyCollectActivity.this, FoodActivity.class));
                break;

        }
    }
}
