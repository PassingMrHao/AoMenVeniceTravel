package mrhao.com.aomentravel.findActivity;

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
import mrhao.com.aomentravel.bean.TravelNewsBean;
import mrhao.com.aomentravel.myActivity.BaseActivity;
import mrhao.com.aomentravel.myAdapter.GvGonglueAdapter;
import mrhao.com.aomentravel.utils.DelayedTaskUtil;
import mrhao.com.aomentravel.utils.MyGridView;

public class MoreGongLueActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.relay_load)
    RelativeLayout relayLoad;
    TravelNewsBean bean;
    GvGonglueAdapter ad;
    DelayedTaskUtil de;
    List<TravelNewsBean.DataBean.StrategiesBean> list = new ArrayList<>();
    String news1 = "https://api.koudaihk.com:4432/api/info/public/v1/strategies/?appId=2&categoryId=0&sortId=0&pageIndex=1";
    String news2 = "https://api.koudaihk.com:4432/api/info/public/v1/strategies/?appId=2&categoryId=0&sortId=0&pageIndex=2";
    String news3 = "https://api.koudaihk.com:4432/api/info/public/v1/strategies/?appId=2&categoryId=0&sortId=0&pageIndex=3";
    String news4 = "https://api.koudaihk.com:4432/api/info/public/v1/strategies/?appId=2&categoryId=0&sortId=0&pageIndex=4";
    String news5 = "https://api.koudaihk.com:4432/api/info/public/v1/strategies/?appId=2&categoryId=0&sortId=0&pageIndex=5";
    @BindView(R.id.linlay_jiazaidonghua)
    LinearLayout linlayJiazaidonghua;
    @BindView(R.id.linlay_jiazaigengduo)
    LinearLayout linlayJiazaigengduo;
    @BindView(R.id.scroll_lay)
    ScrollView scrLay;
    @BindView(R.id.lay_dixian)
    LinearLayout layDixian;
    private View contentView;
    private int scrollY = 0;// 标记上次滑动位置
    @BindView(R.id.im_back_top)
    ImageView imBackTop;

    MyGridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_gong_lue);
        gv = findViewById(R.id.grid_gongluelist);
        ButterKnife.bind(this);
        getBaseDate();
        gobackTop();
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
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        titleText.setText("澳门旅游指南");
        Map<String, String> map = new HashMap<>();
        map.put("", "");
        OkHttpUtils.post().url(news1).params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gs = new Gson();
                        bean = gs.fromJson(response, TravelNewsBean.class);

                        for (int i = 0; i < bean.getData().getStrategies().size(); i++) {
                            list.add(bean.getData().getStrategies().get(i));
                        }


                        ad = new GvGonglueAdapter(MoreGongLueActivity.this, list);
                        gv.setAdapter(ad);
                        ad.notifyDataSetChanged();
                        relayLoad.setVisibility(View.GONE);
                    }
                });


        /**
         * 加载更多
         */
        linlayJiazaigengduo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linlayJiazaidonghua.setVisibility(View.VISIBLE);
                linlayJiazaigengduo.setVisibility(View.GONE);

                if (list.size() < 61) {

                    if (list.size() < 21) {
                        AddDateInList(news2);
                    } else if (list.size() > 20 && list.size() < 41) {
                        AddDateInList(news3);
                    } else if (list.size() > 41 && list.size() < 61) {
                        AddDateInList(news4);
                    }

                    de = new DelayedTaskUtil() {
                        @Override
                        public void onPostExecute() {
                            ad.notifyDataSetChanged();
                            linlayJiazaidonghua.setVisibility(View.GONE);
                            linlayJiazaigengduo.setVisibility(View.VISIBLE);
                            Toast.makeText(MoreGongLueActivity.this, "更多内容获取成功", Toast.LENGTH_SHORT).show();
                        }
                    };
                    de.delayRun(2500);

                } else if (list.size() > 61) {
                    AddDateInList(news5);
                    de = new DelayedTaskUtil() {
                        @Override
                        public void onPostExecute() {
                            ad.notifyDataSetChanged();
                            linlayJiazaidonghua.setVisibility(View.GONE);
                            layDixian.setVisibility(View.VISIBLE);
                            Toast.makeText(MoreGongLueActivity.this, "更多内容获取成功", Toast.LENGTH_SHORT).show();
                        }
                    };
                    de.delayRun(2500);
                }
            }
        });


    }


    private void AddDateInList(String url) {
        Map<String, String> map = new HashMap<>();
        map.put("", "");

        OkHttpUtils.post().url(url).params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gs = new Gson();
                        bean = gs.fromJson(response, TravelNewsBean.class);

                        for (int i = 0; i < bean.getData().getStrategies().size(); i++) {
                            list.add(bean.getData().getStrategies().get(i));
                        }


                    }
                });
    }


}
