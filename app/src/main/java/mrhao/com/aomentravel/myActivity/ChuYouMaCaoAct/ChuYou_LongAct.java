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

public class ChuYou_LongAct extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.long_im)
    ImageView longIm;
    @BindView(R.id.long_xt)
    ImageView longXt;
    @BindView(R.id.long_lay)
    LinearLayout longLay;
    String datu = "http://p4-q.mafengwo.net/s8/M00/32/19/wKgBpVUKz7iABFUrAAsKZsDTX_U38.jpeg?imageView2%2F2%2Fw%2F1360%2Fq%2F90";
    String xiaotutu = "http://m.chanyouji.cn/attractions/4273.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chu_you__long);
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
        Glide.with(this).load(datu).into(longIm);
        Glide.with(this).load(xiaotutu).into(longXt);
        longIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(ChuYou_LongAct.this, PhotoViewActivity.class);
                Bundle b = new Bundle();
                b.putString("picurl", datu);
                b.putString("wenzi", "");
                hao.putExtras(b);
                ChuYou_LongAct.this.startActivity(hao);
            }
        });


        longLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(ChuYou_LongAct.this, MacaoTravelDetailsActivity.class);
                Bundle b = new Bundle();
                b.putString("jingdianurl", "http://jk.kingtrunk.com/index.php/Home/Index/getInfo?id=4273");
                hao.putExtras(b);
                startActivity(hao);
            }
        });

    }

}
