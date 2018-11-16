package mrhao.com.aomentravel.findActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

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
import mrhao.com.aomentravel.bean.FindFoodBean;
import mrhao.com.aomentravel.myActivity.BaseActivity;
import mrhao.com.aomentravel.myAdapter.FindFoodAd;
import mrhao.com.aomentravel.utils.DelayedTaskUtil;
import mrhao.com.aomentravel.utils.MyGridView;

public class FindFoodActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;

    @BindView(R.id.relay_load)
    RelativeLayout relayLoad;
    FindFoodBean bean;
    FindFoodAd ad;
    List<FindFoodBean.DataBean.RestaurantsBean> list = new ArrayList<>();
    DelayedTaskUtil de;


    String api1 = "https://api.koudaihk.com:4432/api/info/public/v1/restaurants/?categoryId=0&sortId=0&pageIndex=1&appId=2";
    String api2 = "https://api.koudaihk.com:4432/api/info/public/v1/restaurants/?categoryId=0&sortId=0&pageIndex=2&appId=2";
    String api3 = "https://api.koudaihk.com:4432/api/info/public/v1/restaurants/?categoryId=0&sortId=0&pageIndex=3&appId=2";
    String api4 = "https://api.koudaihk.com:4432/api/info/public/v1/restaurants/?categoryId=0&sortId=0&pageIndex=4&appId=2";
    String api5 = "https://api.koudaihk.com:4432/api/info/public/v1/restaurants/?categoryId=0&sortId=0&pageIndex=5&appId=2";
    String api6 = "https://api.koudaihk.com:4432/api/info/public/v1/restaurants/?categoryId=0&sortId=0&pageIndex=6&appId=2";
    String api7 = "https://api.koudaihk.com:4432/api/info/public/v1/restaurants/?categoryId=0&sortId=0&pageIndex=7&appId=2";
    String api8 = "https://api.koudaihk.com:4432/api/info/public/v1/restaurants/?categoryId=0&sortId=0&pageIndex=8&appId=2";
    String api9 = "https://api.koudaihk.com:4432/api/info/public/v1/restaurants/?categoryId=0&sortId=0&pageIndex=9&appId=2";
    String api10 = "https://api.koudaihk.com:4432/api/info/public/v1/restaurants/?categoryId=0&sortId=0&pageIndex=10&appId=2";
    String api11 = "https://api.koudaihk.com:4432/api/info/public/v1/restaurants/?categoryId=0&sortId=0&pageIndex=11&appId=2";
    String api12 = "https://api.koudaihk.com:4432/api/info/public/v1/restaurants/?categoryId=0&sortId=0&pageIndex=12&appId=2";
    String api13 = "https://api.koudaihk.com:4432/api/info/public/v1/restaurants/?categoryId=0&sortId=0&pageIndex=13&appId=2";
    @BindView(R.id.linlay_jiazaidonghua)
    LinearLayout linlayJiazaidonghua;
    @BindView(R.id.linlay_jiazaigengduo)
    LinearLayout linlayJiazaigengduo;
    @BindView(R.id.lay_dixian)
    LinearLayout layDixian;
    MyGridView gridFoods;
    @BindView(R.id.im_back_top)
    ImageView imBackTop;
    @BindView(R.id.scroll_lay)
    ScrollView scrLay;
    private View contentView;
    private int scrollY = 0;// 标记上次滑动位置

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_food);
        ButterKnife.bind(this);
        gridFoods = findViewById(R.id.grid_foods);
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
        titleText.setText("美食餐饮");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Map<String, String> map = new HashMap<>();
        map.put("", "");

        OkHttpUtils.post().url(api1).params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {

                        Gson gs = new Gson();
                        bean = gs.fromJson(response, FindFoodBean.class);
                        for (int i = 0; i < bean.getData().getRestaurants().size(); i++) {
                            list.add(bean.getData().getRestaurants().get(i));
                        }
                        ad = new FindFoodAd(FindFoodActivity.this, list);
                        gridFoods.setAdapter(ad);
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


                if (list.size() < 240) {


                    if (list.size() < 40) {
                        AddDateInList(api2);
                    } else if (list.size() >= 40 && list.size() < 60) {
                        AddDateInList(api3);
                    } else if (list.size() >= 60 && list.size() < 80) {
                        AddDateInList(api4);
                    } else if (list.size() >= 80 && list.size() < 100) {
                        AddDateInList(api5);
                    } else if (list.size() >= 100 && list.size() < 120) {
                        AddDateInList(api6);
                    } else if (list.size() >= 120 && list.size() < 140) {
                        AddDateInList(api7);
                    } else if (list.size() >= 140 && list.size() < 160) {
                        AddDateInList(api8);
                    } else if (list.size() >= 160 && list.size() < 180) {
                        AddDateInList(api9);
                    } else if (list.size() >= 180 && list.size() < 200) {
                        AddDateInList(api10);
                    } else if (list.size() >= 200 && list.size() < 220) {
                        AddDateInList(api11);
                    } else if (list.size() >= 220 && list.size() < 240) {
                        AddDateInList(api12);
                    }

                    de = new DelayedTaskUtil() {
                        @Override
                        public void onPostExecute() {
                            linlayJiazaidonghua.setVisibility(View.GONE);
                            linlayJiazaigengduo.setVisibility(View.VISIBLE);
                            ad.notifyDataSetChanged();

                        }
                    };
                    de.delayRun(2000);
                } else if (list.size() >= 240) {
                    AddDateInList(api13);

                    linlayJiazaigengduo.setVisibility(View.GONE);
                    de = new DelayedTaskUtil() {
                        @Override
                        public void onPostExecute() {
                            linlayJiazaidonghua.setVisibility(View.GONE);
                            layDixian.setVisibility(View.VISIBLE);
                            ad.notifyDataSetChanged();

                        }
                    };
                    de.delayRun(2000);

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
                        bean = gs.fromJson(response, FindFoodBean.class);
                        for (int i = 0; i < bean.getData().getRestaurants().size(); i++) {
                            list.add(bean.getData().getRestaurants().get(i));
                        }
                    }
                });
    }


}
