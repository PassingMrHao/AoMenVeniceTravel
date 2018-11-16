package mrhao.com.aomentravel.myActivity.ChuYouMaCaoAct;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.findActivity.PhotoViewActivity;
import mrhao.com.aomentravel.myActivity.BaseActivity;
import mrhao.com.aomentravel.myActivity.MacaoTravelDetailsActivity;

public class ChuYou_pujingAct extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.pujing_im)
    ImageView pujingIm;
    @BindView(R.id.pujing_xt)
    ImageView pujingXt;
    @BindView(R.id.pujing_lay)
    LinearLayout pujingLay;
    String datu = "http://b2-q.mafengwo.net/s7/M00/5A/6E/wKgB6lSU7piAAu_EAApZZV7jukU70.jpeg?imageView2%2F2%2Fw%2F1360%2Fq%2F90";
    String xiaotutu = "http://m.chanyouji.cn/attractions/4274.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chu_you_pujing);
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
        Glide.with(this).load(datu).into(pujingIm);
        Glide.with(this).load(xiaotutu).into(pujingXt);
        pujingIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(ChuYou_pujingAct.this, PhotoViewActivity.class);
                Bundle b = new Bundle();
                b.putString("picurl", datu);
                b.putString("wenzi", "");
                hao.putExtras(b);
                ChuYou_pujingAct.this.startActivity(hao);
            }
        });


        pujingLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(ChuYou_pujingAct.this, MacaoTravelDetailsActivity.class);
                Bundle b = new Bundle();
                b.putString("jingdianurl", "http://jk.kingtrunk.com/index.php/Home/Index/getInfo?id=4274");
                hao.putExtras(b);
                startActivity(hao);
            }
        });

    }

}
