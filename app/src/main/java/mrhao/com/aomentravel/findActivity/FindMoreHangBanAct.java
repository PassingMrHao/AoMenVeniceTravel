package mrhao.com.aomentravel.findActivity;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.HangBanMsgBean;
import mrhao.com.aomentravel.myActivity.BaseActivity;
import mrhao.com.aomentravel.myAdapter.RecyHangBanAdapter;

public class FindMoreHangBanAct extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.recy_feijipiao)
    RecyclerView recyFeijipiao;
    HangBanMsgBean bean;
    @BindView(R.id.morehb_chufadi)
    EditText morehbChufadi;
    @BindView(R.id.morehb_daodadi)
    EditText morehbDaodadi;
    @BindView(R.id.morehb_query)
    Button morehbQuery;
    TextView num;
    LinearLayout layres, laynores;

    RecyHangBanAdapter ad;
    List<HangBanMsgBean.ResultBean> list = new ArrayList<>();
    int type = 0;
    Bundle b;

    ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_find_more_hang_ban);

        b = getIntent().getExtras();
        type = b.getInt("type");

        num = this.findViewById(R.id.morehb__num);
        im = this.findViewById(R.id.im_zhuanhuan);
        layres = this.findViewById(R.id.morehb_haveres);
        laynores = this.findViewById(R.id.morehb_nores);
        ButterKnife.bind(this);
        recyFeijipiao.setNestedScrollingEnabled(false);
        setBaseDate();
        if (type == 1) {

            getAllHangBanMsg();
        }

    }


    private void setBaseDate() {

        //出发地和目的地转换

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String zhuanstr1=morehbChufadi.getText().toString().trim();
                String zhuanstr2=morehbDaodadi.getText().toString().trim();
                //旋转动画
                ObjectAnimator animator = ObjectAnimator.ofFloat(im, "rotation", 0f, 360f);//0f-360f 下个度数大于上个度数，顺时针旋转；下个度数小于上个度数，逆时针旋转。
                animator.setDuration(588);
                animator.start();

                morehbDaodadi.setText(zhuanstr1);
                morehbChufadi.setText(zhuanstr2);




            }
        });


        recyFeijipiao.setLayoutManager(new LinearLayoutManager(FindMoreHangBanAct.this));
        ad = new RecyHangBanAdapter(FindMoreHangBanAct.this, list);
        recyFeijipiao.setAdapter(ad);
        titleText.setText("航班信息查询");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        morehbQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aa = morehbChufadi.getText().toString().trim();
                String bb = morehbDaodadi.getText().toString().trim();
                if (TextUtils.isEmpty(aa) || TextUtils.isEmpty(aa) || aa.equals("") || bb.equals("")) {

                    Toast.makeText(FindMoreHangBanAct.this, "出发地和目的地均不能为空", Toast.LENGTH_SHORT).show();

                } else {

                    Map<String, String> map = new HashMap<>();
                    map.put("key", "258ea60e36fdf");
                    map.put("start", aa);
                    map.put("end", bb);
                    OkHttpUtils.get().url("http://apicloud.mob.com/flight/line/query").params(map).build()
                            .execute(new StringCallback() {

                                @Override
                                public void onError(Request request, Exception e) {

                                }

                                @Override
                                public void onResponse(String response) {
                                    Gson gs = new Gson();
                                    bean = gs.fromJson(response, HangBanMsgBean.class);
                                    if (bean.getMsg().equals("success")) {

                                        layres.setVisibility(View.VISIBLE);
                                        laynores.setVisibility(View.GONE);
                                        list.clear();
                                        for (int i = 0; i < bean.getResult().size(); i++) {
                                            list.add(bean.getResult().get(i));
                                        }

                                        ad.notifyDataSetChanged();
                                        num.setText("" + list.size());

                                    } else {

                                        layres.setVisibility(View.GONE);
                                        laynores.setVisibility(View.VISIBLE);

                                    }
                                }
                            });
                }
            }
        });


    }


    public void getAllHangBanMsg() {


        morehbChufadi.setText(b.getString("chufa"));
        morehbDaodadi.setText("澳门");
        Map<String, String> map = new HashMap<>();
        map.put("key", "258ea60e36fdf");
        map.put("start", b.getString("chufa"));
        map.put("end", "澳门");
        OkHttpUtils.get().url("http://apicloud.mob.com/flight/line/query").params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                    }

                    @Override
                    public void onResponse(String response) {

                        Gson gs = new Gson();
                        bean = gs.fromJson(response, HangBanMsgBean.class);
                        if (bean.getMsg().equals("success")) {
                            layres.setVisibility(View.VISIBLE);
                            laynores.setVisibility(View.GONE);
                            list.clear();
                            for (int i = 0; i < bean.getResult().size(); i++) {
                                list.add(bean.getResult().get(i));
                            }
                            ad.notifyDataSetChanged();
                            num.setText("" + list.size());
                        } else {
                            layres.setVisibility(View.GONE);
                            laynores.setVisibility(View.VISIBLE);
                        }

                    }

                });
    }
}
