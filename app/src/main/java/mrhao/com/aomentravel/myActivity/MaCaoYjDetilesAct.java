package mrhao.com.aomentravel.myActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.MaCaoYouJiBean;
import mrhao.com.aomentravel.myAdapter.MyGvYJDetilesAdapter;
import mrhao.com.aomentravel.utils.CircleTransform;
import mrhao.com.aomentravel.utils.GlideApp;
import mrhao.com.aomentravel.utils.MyGridView;

public class MaCaoYjDetilesAct extends BaseActivity {
    List<MaCaoYouJiBean.DataBean.UserActivitiesBean> list = new ArrayList<>();
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.macaoyj_img)
    ImageView macaoyjImg;
    @BindView(R.id.macaoyj_user)
    TextView macaoyjUser;
    @BindView(R.id.macaoyj_desc)
    TextView macaoyjDesc;
    @BindView(R.id.mygv_yjdetiles_)
    MyGridView mygvYjdetiles;
    @BindView(R.id.macaoyj_title)
    TextView macaoyjTitle;
    MyGvYJDetilesAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_cao_yj_detiles);
        ButterKnife.bind(this);
        list = (List<MaCaoYouJiBean.DataBean.UserActivitiesBean>) getIntent().getSerializableExtra("macaoyj");

        setBaseDate();
    }

    private void setBaseDate() {

        titleText.setText("游记详情");
        macaoyjTitle.setText(list.get(0).getTopic());
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        GlideApp.with(MaCaoYjDetilesAct.this).load(list.get(0).getUser().getPhoto_url()).format(DecodeFormat.PREFER_RGB_565).override(88, 88).diskCacheStrategy(DiskCacheStrategy.RESOURCE).transform(new CircleTransform(MaCaoYjDetilesAct.this)).into(macaoyjImg);
        macaoyjUser.setText(list.get(0).getUser().getName());
        macaoyjDesc.setText("\u3000\u3000" + list.get(0).getDescription());
        ad = new MyGvYJDetilesAdapter(MaCaoYjDetilesAct.this, list);
        mygvYjdetiles.setAdapter(ad);

    }
}
