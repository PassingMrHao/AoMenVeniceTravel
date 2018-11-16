package mrhao.com.aomentravel.findActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.myActivity.BaseActivity;

public class TuiSongSheZhiActivity extends BaseActivity {

    @BindView(R.id.about_kefu_tuisong)
    TextView aboutKefuTuisong;
    @BindView(R.id.sw_kefu_kaiguan)
    Switch swKefuKaiguan;
    @BindView(R.id.about_youhui_tuisong)
    TextView aboutYouhuiTuisong;
    @BindView(R.id.sw_youhui_kaiguan)
    Switch swYouhuiKaiguan;
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tui_song_she_zhi);
        ButterKnife.bind(this);
        setBaseDate();

    }

    private void setBaseDate() {
        titleText.setText("推送设置");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        swKefuKaiguan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(TuiSongSheZhiActivity.this, "设置成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TuiSongSheZhiActivity.this, "您取消了接收系统消息提示", Toast.LENGTH_SHORT).show();
                }

            }
        });

        swYouhuiKaiguan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(TuiSongSheZhiActivity.this, "设置成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TuiSongSheZhiActivity.this, "您关闭了推送通知", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
