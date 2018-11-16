package mrhao.com.aomentravel.myActivity.CollectActivity;

import android.content.Intent;
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
import mrhao.com.aomentravel.utils.GlideApp;

public class Travel1ribwgActivity extends BaseActivity {

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
    @BindView(R.id.scroll_lay)
    ScrollView scrLay;
    @BindView(R.id.im_back_top)
    ImageView imBackTop;
    @BindView(R.id.relay_load)
    RelativeLayout relayLoad;

    private View contentView;
    private int scrollY = 0;// 标记上次滑动位置

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel1ribwg);
        ButterKnife.bind(this);
        getBaseDate();
        gobackTop();
        setClickEvent();
    }

    private void setClickEvent() {
        day1Zhandian1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4238);
            }
        });
        day1Tu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4238);
            }
        });

        day1Zhandian2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4331);
            }
        });
        day1Tu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4331);
            }
        });


        day1Zhandian3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4217);
            }
        });
        day1Tu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4217);
            }
        });

        day1Zhandian4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4213);
            }
        });
        day1Tu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4213);
            }
        });


        day1Zhandian5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4266);
            }
        });
        day1Tu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4266);
            }
        });


        day1Zhandian6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4270);
            }
        });
        day1Tu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4270);
            }
        });

    }


    public void ToJingdianDetilesAct(int a) {
        Intent hao = new Intent(Travel1ribwgActivity.this, MacaoTravelDetailsActivity.class);
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

        GlideApp.with(Travel1ribwgActivity.this).load("http://m.chanyouji.cn/attractions/4238.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu1);
        GlideApp.with(Travel1ribwgActivity.this).load("http://m.chanyouji.cn/attractions/4331.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu2);
        GlideApp.with(Travel1ribwgActivity.this).load("http://m.chanyouji.cn/attractions/4217.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu3);
        GlideApp.with(Travel1ribwgActivity.this).load("http://m.chanyouji.cn/attractions/4213.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu4);
        GlideApp.with(Travel1ribwgActivity.this).load("http://m.chanyouji.cn/attractions/4266.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu5);
        GlideApp.with(Travel1ribwgActivity.this).load("http://m.chanyouji.cn/attractions/4270.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu6);
        Glide.get(Travel1ribwgActivity.this).clearMemory();
        new Thread(){
            @Override
            public void run() {
                super.run();
                Glide.get(Travel1ribwgActivity.this).clearDiskCache();
            }
        }.start();
        relayLoad.setVisibility(View.GONE);
        titleText.setText("博物馆1日游");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
