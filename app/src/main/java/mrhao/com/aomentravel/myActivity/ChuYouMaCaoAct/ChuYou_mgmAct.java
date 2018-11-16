package mrhao.com.aomentravel.myActivity.ChuYouMaCaoAct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.findActivity.PhotoViewActivity;
import mrhao.com.aomentravel.myActivity.BaseActivity;
import mrhao.com.aomentravel.myActivity.CollectActivity.Travel2rimacaoActivity;
import mrhao.com.aomentravel.myActivity.MacaoTravelDetailsActivity;

public class ChuYou_mgmAct extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.mgm_im)
    ImageView mgmIm;
    @BindView(R.id.mgm_xt)
    ImageView mgmXt;
    @BindView(R.id.mgm_lay)
    LinearLayout mgmLay;


    String datu = "http://p4-q.mafengwo.net/s7/M00/90/B6/wKgB6lS25-yAPiE6AAZ0JUIP5bk14.jpeg?imageView2%2F2%2Fw%2F1360%2Fq%2F90";
    String xiaotutu = "http://m.chanyouji.cn/attractions/4235.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chu_you_mgm);
        ButterKnife.bind(this);
        setBaseDate();
    }

    private void setBaseDate() {

        titleText.setText("初游澳门推荐景点");

        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Glide.with(this).load(datu).into(mgmIm);
        Glide.with(this).load(xiaotutu).into(mgmXt);
        mgmIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(ChuYou_mgmAct.this, PhotoViewActivity.class);
                Bundle b = new Bundle();
                b.putString("picurl", datu);
                b.putString("wenzi", "");
                hao.putExtras(b);
                ChuYou_mgmAct.this.startActivity(hao);
            }
        });


        mgmLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent hao = new Intent(ChuYou_mgmAct.this, MacaoTravelDetailsActivity.class);
                Bundle b = new Bundle();
                b.putString("jingdianurl", "http://jk.kingtrunk.com/index.php/Home/Index/getInfo?id=4235");
                hao.putExtras(b);
                startActivity(hao);


            }
        });

    }
}
