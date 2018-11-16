package mrhao.com.aomentravel.myActivity;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.AllJingDianDateBean;
import mrhao.com.aomentravel.myAdapter.Gv_AllJdAdapter;
import mrhao.com.aomentravel.utils.DelayedTaskUtil;
import mrhao.com.aomentravel.utils.MyGridView;

public class AllMaCaoJDActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    MyGridView gvAlljd;
    ArrayList<AllJingDianDateBean> bean = new ArrayList<>();
    List<AllJingDianDateBean> list = new ArrayList<>();
    Gv_AllJdAdapter ad;
    @BindView(R.id.pull_refresh)
    PullToRefreshLayout pullRefresh;

    DelayedTaskUtil de;
    String api = "http://jk.kingtrunk.com/index.php/Home/Index/getList/p/";

    @BindView(R.id.scroll_lay)
    ScrollView scrLay;
    @BindView(R.id.im_back_top)
    ImageView imBackTop;
    private View contentView;
    private int scrollY = 0;// 标记上次滑动位置
    @BindView(R.id.relay_load)
    RelativeLayout relayLoad;
    int currtpage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_ma_cao_jd);
        gvAlljd = findViewById(R.id.gv_alljd);
        ButterKnife.bind(this);
        setBaseDate();
        RefreshAndLoadMore();
        gobackTop();//返回顶部
    }

    private void RefreshAndLoadMore() {
        pullRefresh.setRefreshListener(new BaseRefreshListener() {

            @Override
            public void refresh() {
                list.clear();
                AddDateInList(1);
                de = new DelayedTaskUtil() {
                    @Override
                    public void onPostExecute() {
                        pullRefresh.setCanLoadMore(true);
                        pullRefresh.finishRefresh();
                        ad.notifyDataSetChanged();
                        Toast.makeText(AllMaCaoJDActivity.this, "刷新成功", Toast.LENGTH_SHORT).show();
                    }
                };
                de.delayRun(1000);
            }

            @Override
            public void loadMore() {
                if (list.size() < 163) {
                    pullRefresh.setCanLoadMore(true);
                    currtpage += 1;
                    AddDateInList(currtpage);
                    de = new DelayedTaskUtil() {
                        @Override
                        public void onPostExecute() {
                            pullRefresh.finishLoadMore();
                            ad.notifyDataSetChanged();
                        }
                    };
                    de.delayRun(1000);
                }else if(list.size()==163){
                    de = new DelayedTaskUtil() {
                        @Override
                        public void onPostExecute() {
                            pullRefresh.finishLoadMore();
                            pullRefresh.setCanLoadMore(false);
                            Toast.makeText(AllMaCaoJDActivity.this, "亲，已经加载所有景点了", Toast.LENGTH_LONG).show();
                        }
                    };
                    de.delayRun(500);

                }

            }
        });

    }

    private void AddDateInList(int aa) {
        Map<String, String> map = new HashMap<>();
        map.put("", "");
        OkHttpUtils.get().url(api + aa).params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gs = new Gson();
                        Type listtype = new TypeToken<List<AllJingDianDateBean>>() {
                        }.getType();
                        bean = gs.fromJson(response, listtype);
                        for (int i = 0; i < bean.size(); i++) {
                            list.add(bean.get(i));
                        }

                    }
                });
    }


    /**
     * 返回顶部
     */
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

    private void setBaseDate() {
        titleText.setText("澳门景点大全");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Map<String, String> map = new HashMap<>();
        map.put("", "");
        OkHttpUtils.get().url("http://jk.kingtrunk.com/index.php/Home/Index/getList/p/1").params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gs = new Gson();
                        Type listtype = new TypeToken<List<AllJingDianDateBean>>() {
                        }.getType();
                        bean = gs.fromJson(response, listtype);
                        for (int i = 0; i < bean.size(); i++) {
                            list.add(bean.get(i));
                        }
                        ad = new Gv_AllJdAdapter(AllMaCaoJDActivity.this, list);
                        gvAlljd.setAdapter(ad);
                        relayLoad.setVisibility(View.GONE);
                    }
                });


    }

}
