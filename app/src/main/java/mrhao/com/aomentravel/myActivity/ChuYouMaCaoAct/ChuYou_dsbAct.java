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

public class ChuYou_dsbAct extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.dsb_im)
    ImageView dsbIm;
    @BindView(R.id.dsb_xt)
    ImageView dsbXt;
    @BindView(R.id.dsb_lay)
    LinearLayout dsbLay;
    String datu = "http://n3-q.mafengwo.net/s8/M00/F1/1E/wKgBpVWiLnaAC1-cAA21442UzLk18.jpeg?imageView2%2F2%2Fw%2F1360%2Fq%2F90";

    String xiaotutu = "http://n3-q.mafengwo.net/s8/M00/F1/1E/wKgBpVWiLnaAC1-cAA21442UzLk18.jpeg?imageView2%2F2%2Fw%2F1360%2Fq%2F90";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chu_you_dsb);
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
        Glide.with(this).load(datu).into(dsbIm);
        Glide.with(this).load(xiaotutu).into(dsbXt);
        dsbIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(ChuYou_dsbAct.this, PhotoViewActivity.class);
                Bundle b = new Bundle();
                b.putString("picurl", datu);
                b.putString("wenzi", "");
                hao.putExtras(b);
                ChuYou_dsbAct.this.startActivity(hao);
            }
        });


        dsbLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(ChuYou_dsbAct.this, MacaoTravelDetailsActivity.class);
                Bundle b = new Bundle();
                b.putString("jingdianurl", "http://jk.kingtrunk.com/index.php/Home/Index/getInfo?id=4207");
                hao.putExtras(b);
                startActivity(hao);
            }
        });

    }
}
