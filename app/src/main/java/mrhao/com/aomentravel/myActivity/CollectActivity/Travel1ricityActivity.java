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

public class Travel1ricityActivity extends BaseActivity {

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
    @BindView(R.id.day1_beixuan1)
    LinearLayout day1Beixuan1;
    @BindView(R.id.day1_tu21)
    ImageView day1Tu21;
    @BindView(R.id.day1_beixuan2)
    LinearLayout day1Beixuan2;
    @BindView(R.id.day1_tu22)
    ImageView day1Tu22;
    @BindView(R.id.day1_zhandian3)
    LinearLayout day1Zhandian3;
    @BindView(R.id.day1_tu3)
    ImageView day1Tu3;
    @BindView(R.id.day1_zhandian4)
    LinearLayout day1Zhandian4;
    @BindView(R.id.day1_tu4)
    ImageView day1Tu4;
    @BindView(R.id.day1_beixuan3)
    LinearLayout day1Beixuan3;
    @BindView(R.id.day1_tu41)
    ImageView day1Tu41;
    @BindView(R.id.day1_zhandian5)
    LinearLayout day1Zhandian5;
    @BindView(R.id.day1_tu5)
    ImageView day1Tu5;
    @BindView(R.id.day1_zhandian6)
    LinearLayout day1Zhandian6;
    @BindView(R.id.day1_tu6)
    ImageView day1Tu6;
    @BindView(R.id.day1_beixuan4)
    LinearLayout day1Beixuan4;
    @BindView(R.id.day1_tu61)
    ImageView day1Tu61;
    @BindView(R.id.day1_zhandian7)
    LinearLayout day1Zhandian7;
    @BindView(R.id.day1_tu7)
    ImageView day1Tu7;
    @BindView(R.id.day1_zhandian8)
    LinearLayout day1Zhandian8;
    @BindView(R.id.day1_tu8)
    ImageView day1Tu8;
    @BindView(R.id.day1_zhandian9)
    LinearLayout day1Zhandian9;
    @BindView(R.id.day1_tu9)
    ImageView day1Tu9;
    @BindView(R.id.day1_zhandian10)
    LinearLayout day1Zhandian10;
    @BindView(R.id.day1_tu10)
    ImageView day1Tu10;
    @BindView(R.id.day1_zhandian11)
    LinearLayout day1Zhandian11;
    @BindView(R.id.day1_tu11)
    ImageView day1Tu11;
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
        setContentView(R.layout.activity_travel1ricity);
        ButterKnife.bind(this);
        getBaseDate();
        gobackTop();
        setClickEvent();
    }
    private void setClickEvent() {
        day1Zhandian1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4235);
            }
        });
        day1Tu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4235);
            }
        });

        day1Zhandian2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4389);
            }
        });
        day1Tu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4389);
            }
        });


        day1Beixuan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4251);
            }
        });
        day1Tu21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4251);
            }
        });


        day1Beixuan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4360);
            }
        });
        day1Tu22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4360);
            }
        });

        day1Zhandian3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { ToJingdianDetilesAct(10233); }});
        day1Tu3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { ToJingdianDetilesAct(10233); }});

        day1Zhandian4.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {
            ToJingdianDetilesAct(10236); }
        });
        day1Tu4.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {
            ToJingdianDetilesAct(10236); }
        });


        day1Beixuan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4334);
            }
        });
        day1Tu41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4334);
            }
        });


        day1Zhandian5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4244);
            }
        });
        day1Tu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4244);
            }
        });


        day1Zhandian6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4215);
            }
        });
        day1Tu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4215);
            }
        });


        day1Beixuan4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4331);
            }
        });
        day1Tu61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4331);
            }
        });



        day1Zhandian7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4219);
            }
        });
        day1Tu7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4219);
            }
        });

        day1Zhandian8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4207);
            }
        });
        day1Tu8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToJingdianDetilesAct(4207);
            }
        });

        day1Zhandian9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ToJingdianDetilesAct(4237); }
        });
        day1Tu9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ToJingdianDetilesAct(4237); }
        });

        day1Zhandian10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ToJingdianDetilesAct(4217); }});
        day1Tu10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ToJingdianDetilesAct(4217); }});

        day1Zhandian11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ToJingdianDetilesAct(4381);
            }
        });
        day1Tu11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ToJingdianDetilesAct(4381);
            }
        });


    }





    public void ToJingdianDetilesAct(int a){
        Intent hao = new Intent(Travel1ricityActivity.this, MacaoTravelDetailsActivity.class);
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

        GlideApp.with(Travel1ricityActivity.this).load("http://m.chanyouji.cn/attractions/4235.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu1);
        GlideApp.with(Travel1ricityActivity.this).load("http://m.chanyouji.cn/attractions/4389.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu2);
        GlideApp.with(Travel1ricityActivity.this).load("http://m.chanyouji.cn/attractions/4251.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu21);
        GlideApp.with(Travel1ricityActivity.this).load("http://m.chanyouji.cn/attractions/4360.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu22);
        GlideApp.with(Travel1ricityActivity.this).load("http://m.chanyouji.cn/attractions/10233.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu3);
        GlideApp.with(Travel1ricityActivity.this).load("http://m.chanyouji.cn/attractions/10236.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu4);
        GlideApp.with(Travel1ricityActivity.this).load("http://m.chanyouji.cn/attractions/4334.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu41);
        GlideApp.with(Travel1ricityActivity.this).load("http://m.chanyouji.cn/attractions/4244.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu5);
        GlideApp.with(Travel1ricityActivity.this).load("http://m.chanyouji.cn/attractions/4215.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu6);
        GlideApp.with(Travel1ricityActivity.this).load("http://m.chanyouji.cn/attractions/4331.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu61);
        GlideApp.with(Travel1ricityActivity.this).load("http://m.chanyouji.cn/attractions/4219.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu7);
        GlideApp.with(Travel1ricityActivity.this).load("http://m.chanyouji.cn/attractions/4207.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu8);
        GlideApp.with(Travel1ricityActivity.this).load("http://m.chanyouji.cn/attractions/4237.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu9);
        GlideApp.with(Travel1ricityActivity.this).load("http://m.chanyouji.cn/attractions/4217.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu10);
        GlideApp.with(Travel1ricityActivity.this).load("http://m.chanyouji.cn/attractions/4381.jpg").format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE) .override(600,360).into(day1Tu11);
        Glide.get(Travel1ricityActivity.this).clearMemory();
        new Thread(){
            @Override
            public void run() {
                super.run();
                Glide.get(Travel1ricityActivity.this).clearDiskCache();
            }
        }.start();
        relayLoad.setVisibility(View.GONE);
        titleText.setText("历史城区1日游");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }



}
