package mrhao.com.aomentravel.myActivity.CollectActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
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
import mrhao.com.aomentravel.bean.TravelTuiJian1Bean;
import mrhao.com.aomentravel.myActivity.BaseActivity;
import mrhao.com.aomentravel.myActivity.MacaoTravelDetailsActivity;
import mrhao.com.aomentravel.utils.DelayedTaskUtil;
import mrhao.com.aomentravel.utils.GlideApp;
import mrhao.com.aomentravel.utils.ImageCompressionUtil;

public class Travel2rimacaoActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.day1_zhandian1)
    LinearLayout day1Zhandian1;
    @BindView(R.id.day1_tu1)
    ImageView day1Tu1;
    @BindView(R.id.day1_zhandian2)
    LinearLayout day1Zhandian2;
    @BindView(R.id.day1_tu2)
    ImageView day1Tu2;
    @BindView(R.id.day1_zhandian3)
    LinearLayout day1Zhandian3;
    @BindView(R.id.day1_tu3)
    ImageView day1Tu3;
    @BindView(R.id.day1_zhandian4)
    LinearLayout day1Zhandian4;
    @BindView(R.id.day1_tu4)
    ImageView day1Tu4;
    @BindView(R.id.day1_zhandian5)
    LinearLayout day1Zhandian5;
    @BindView(R.id.day1_tu5)
    ImageView day1Tu5;
    @BindView(R.id.day1_zhandian6)
    LinearLayout day1Zhandian6;
    @BindView(R.id.day1_tu6)
    ImageView day1Tu6;
    @BindView(R.id.day1_zhandian7)
    LinearLayout day1Zhandian7;
    @BindView(R.id.day1_tu7)
    ImageView day1Tu7;
    @BindView(R.id.day2_zhandian1)
    LinearLayout day2Zhandian1;
    @BindView(R.id.day2_tu1)
    ImageView day2Tu1;
    @BindView(R.id.day2_zhandian2)
    LinearLayout day2Zhandian2;
    @BindView(R.id.day2_tu2)
    ImageView day2Tu2;
    @BindView(R.id.day2_zhandian3)
    LinearLayout day2Zhandian3;
    @BindView(R.id.day2_tu3)
    ImageView day2Tu3;
    @BindView(R.id.day2_zhandian4)
    LinearLayout day2Zhandian4;
    @BindView(R.id.day2_tu4)
    ImageView day2Tu4;
    @BindView(R.id.relay_load)
    RelativeLayout relayLoad;

    @BindView(R.id.scroll_lay)
    ScrollView scrLay;
    @BindView(R.id.im_back_top)
    ImageView imBackTop;
    private View contentView;
    private int scrollY = 0;// 标记上次滑动位置

    Bitmap bm1=null;
    Bitmap bm2=null;
    Bitmap bm3=null;
    Bitmap bm4=null;
    Bitmap bm5=null;
    Bitmap bm6=null;
    Bitmap bm7=null;
    Bitmap bm8=null;
    Bitmap bm9=null;
    Bitmap bm10=null;
    Bitmap bm11=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel2rimacao);
        ButterKnife.bind(this);
        getBaseDate();
        gobackTop();//返回顶部
        setClickEvent();
    }

    private void setClickEvent() {
        day1Zhandian1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4207);
            }
        });
        day1Tu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4207);
            }
        });

        day1Zhandian2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4237);
            }
        });
        day1Tu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4237);
            }
        });

        day1Zhandian3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4219);
            }
        });
        day1Tu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4219);
            }
        });

        day1Zhandian4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4215);
            }
        });
        day1Tu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4215);
            }
        });

        day1Zhandian5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4205);
            }
        });
        day1Tu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4205);
            }
        });

        day1Zhandian6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4253);
            }
        });
        day1Tu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4253);
            }
        });

        day1Zhandian7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4203);
            }
        });
        day1Tu7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4203);
            }
        });

        day2Zhandian1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4214);
            }
        });
        day2Tu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4214);
            }
        });

        day2Zhandian2.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {
            ToJingdianDetilesAct(157373);
            }});
        day2Tu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(157373);
            }
        });

        day2Zhandian3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4240);
            }
        });
        day2Tu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4240);
            }
        });

        day2Zhandian4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4273);
            }
        });
        day2Tu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4273);
            }
        });


    }


    public void ToJingdianDetilesAct(int a) {
        Intent hao = new Intent(Travel2rimacaoActivity.this, MacaoTravelDetailsActivity.class);
        Bundle b = new Bundle();
        b.putInt("jingdianId", a);
        b.putString("jingdianurl","http://jk.kingtrunk.com/index.php/Home/Index/getInfo?id=" + a);
        hao.putExtras(b);
        startActivity(hao);
    }

    private void gobackTop() {

        if (contentView == null) {
            contentView = scrLay.getChildAt(0);
        }
        scrLay.setOnTouchListener(new View.OnTouchListener() {
            private int lastY = 0;
            private int touchEventId = -9983761;
            Handler handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    View scroll = (View) msg.obj;
                    if (msg.what == touchEventId) {
                        if (lastY == scroll.getScrollY()) {
                            handleStop(scroll);
                        } else {
                            handler.sendMessageDelayed(handler.obtainMessage(touchEventId, scroll), 5);
                            lastY = scroll.getScrollY();
                        }
                    }
                }
            };

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    handler.sendMessageDelayed(handler.obtainMessage(touchEventId, view), 5);
                }
                return false;
            }

            private void handleStop(Object view) {
                ScrollView scroll = (ScrollView) view;
                scrollY = scroll.getScrollY();
                judgeBottom();
            }

            private void judgeBottom() {
                if (contentView != null && contentView.getMeasuredHeight() <= scrLay.getScrollY() + scrLay.getHeight()) {
                    imBackTop.setVisibility(View.VISIBLE);
                } else if (scrLay.getScrollY() <= 88) {
                    imBackTop.setVisibility(View.GONE);
                } else if (scrLay.getScrollY() > 88) {
                    imBackTop.setVisibility(View.VISIBLE);
                }
            }
        });


        imBackTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scrLay.post(new Runnable() {
                    @Override
                    public void run() {
                        scrLay.fullScroll(ScrollView.FOCUS_UP);
                    }
                });
                imBackTop.setVisibility(View.GONE);
            }
        });
    }

    private void getBaseDate() {

        GlideApp.with(Travel2rimacaoActivity.this).load("http://m.chanyouji.cn/attractions/4207.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .into(day1Tu1);
        GlideApp.with(Travel2rimacaoActivity.this).load("http://m.chanyouji.cn/attractions/4237.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .into(day1Tu2);
        GlideApp.with(Travel2rimacaoActivity.this).load("http://m.chanyouji.cn/attractions/4219.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .into(day1Tu3);
        GlideApp.with(Travel2rimacaoActivity.this).load("http://m.chanyouji.cn/attractions/4215.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .into(day1Tu4);
        GlideApp.with(Travel2rimacaoActivity.this).load("http://m.chanyouji.cn/attractions/4205.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .into(day1Tu5);
        GlideApp.with(Travel2rimacaoActivity.this).load("http://m.chanyouji.cn/attractions/4253.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .into(day1Tu6);
        GlideApp.with(Travel2rimacaoActivity.this).load("http://m.chanyouji.cn/attractions/4203.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .into(day1Tu7);
        GlideApp.with(Travel2rimacaoActivity.this).load("http://m.chanyouji.cn/attractions/4214.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .into(day2Tu1);
        GlideApp.with(Travel2rimacaoActivity.this).load("http://m.chanyouji.cn/attractions/157373.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .into(day2Tu2);
        GlideApp.with(Travel2rimacaoActivity.this).load("http://m.chanyouji.cn/attractions/4240.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .into(day2Tu3);
        GlideApp.with(Travel2rimacaoActivity.this).load("http://m.chanyouji.cn/attractions/4273.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .into(day2Tu4);
        Glide.get(Travel2rimacaoActivity.this).clearMemory();
        new Thread(){
            @Override
            public void run() {
                super.run();
                Glide.get(Travel2rimacaoActivity.this).clearDiskCache();
            }
        }.start();
        relayLoad.setVisibility(View.GONE);

        titleText.setText("澳门经典2日游");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }




}
