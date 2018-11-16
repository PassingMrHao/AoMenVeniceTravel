package mrhao.com.aomentravel.myFragment;


import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.zhengsr.viewpagerlib.anim.MzTransformer;
import com.zhengsr.viewpagerlib.bean.PageBean;
import com.zhengsr.viewpagerlib.callback.PageHelperListener;
import com.zhengsr.viewpagerlib.indicator.ZoomIndicator;
import com.zhengsr.viewpagerlib.view.BannerViewPager;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.LoopBean;
import mrhao.com.aomentravel.bean.TravelJingDianBean;
import mrhao.com.aomentravel.myAdapter.Grid_travelAd;
import mrhao.com.aomentravel.utils.DelayedTaskUtil;
import mrhao.com.aomentravel.utils.MyGridView;


public class TravelFrg extends Fragment {

    MyGridView mygd;
    Unbinder unbinder;
    TravelJingDianBean bean;
    Grid_travelAd ad;
    List<TravelJingDianBean.DataBean.ScenicSpotsBean> list = new ArrayList<>();

    String api1 = "https://api.koudaihk.com:4432/api/info/public/v1/scenicSpots/?appId=2&categoryId=0&sortId=0&pageIndex=1";
    String api2 = "https://api.koudaihk.com:4432/api/info/public/v1/scenicSpots/?appId=2&categoryId=0&sortId=0&pageIndex=2";
    String api3 = "https://api.koudaihk.com:4432/api/info/public/v1/scenicSpots/?appId=2&categoryId=0&sortId=0&pageIndex=3";
    String api4 = "https://api.koudaihk.com:4432/api/info/public/v1/scenicSpots/?appId=2&categoryId=0&sortId=0&pageIndex=4";
    String api5 = "https://api.koudaihk.com:4432/api/info/public/v1/scenicSpots/?appId=2&categoryId=0&sortId=0&pageIndex=5";
    String api6 = "https://api.koudaihk.com:4432/api/info/public/v1/scenicSpots/?appId=2&categoryId=0&sortId=0&pageIndex=6";
    @BindView(R.id.relay_load)
    RelativeLayout relayLoad;
    @BindView(R.id.linlay_jiazaigengduo)
    LinearLayout linlayJiazaigengduo;
    @BindView(R.id.im_back_top)
    ImageView imBackTop;
    @BindView(R.id.scr_lay)
    ScrollView scrLay;
    @BindView(R.id.linlay_jiazaidonghua)
    LinearLayout linlayJiazaidonghua;
    @BindView(R.id.lay_dixian)
    LinearLayout layDixian;
    @BindView(R.id.base_Banner)
    BannerViewPager baseBanner;
    @BindView(R.id.base_idtor)
    ZoomIndicator baseIdtor;
    private View contentView;
    private int scrollY = 0;// 标记上次滑动位置
    DelayedTaskUtil de;

    private static final String[] TEXT = {"妈祖文化村", "澳门威尼斯酒店", "澳门葡人小区", "赌场夜景"};
    Integer[] RESURL = {R.mipmap.macao_mazucun, R.mipmap.macao_venis, R.mipmap.macao_lvbieshu, R.mipmap.macao_duchang};


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_travel_frg, container, false);
        mygd = view.findViewById(R.id.mygridview);
        unbinder = ButterKnife.bind(this, view);
        setBannerPicture();
        gobackTop();
        setBaseDate();
        LoadMore();
        return view;


    }

    private void setBannerPicture() {

        //配置数据
        List<LoopBean> loopBeens = new ArrayList<>();
        for (int i = 0; i < TEXT.length; i++) {
            LoopBean bean = new LoopBean();
            bean.res = RESURL[i];
            bean.text = TEXT[i];
            loopBeens.add(bean);
        }

        //配置pagerbean，这里主要是为了viewpager的指示器的作用，注意记得写上泛型
        baseBanner.setPageTransformer(false, new MzTransformer());
        PageBean bean = new PageBean.Builder<LoopBean>()
                .setDataObjects(loopBeens)
                .setIndicator(baseIdtor)
                .builder();
        baseBanner.setPageListener(bean, R.layout.loop_layout, new PageHelperListener() {
            @Override
            public void getItemView(View view, Object data) {

                ImageView im = view.findViewById(R.id.loop_icon);
                LoopBean bean = (LoopBean) data;
                //ImageView直接加载本地图片
                im.setImageResource(bean.res);
                TextView textView = view.findViewById(R.id.loop_text);
                textView.setText(bean.text);
            }
        });

    }

    /**
     * 加载更多
     */
    private void LoadMore() {
        linlayJiazaigengduo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //加载第二页
                if (list.size() < 21) {
                    linlayJiazaidonghua.setVisibility(View.VISIBLE);
                    AddDateInList(api1);
                    de = new DelayedTaskUtil() {
                        @Override
                        public void onPostExecute() {
                            ad.notifyDataSetChanged();
                            linlayJiazaidonghua.setVisibility(View.GONE);
                            Toast.makeText(getActivity(), "更多景点加载完成", Toast.LENGTH_SHORT).show();
                        }
                    };
                    de.delayRun(2500);
                }

                //加载第三页
                if (list.size() > 21 && list.size() < 41) {
                    linlayJiazaidonghua.setVisibility(View.VISIBLE);
                    AddDateInList(api3);
                    de = new DelayedTaskUtil() {
                        @Override
                        public void onPostExecute() {
                            ad.notifyDataSetChanged();
                            linlayJiazaidonghua.setVisibility(View.GONE);
                            Toast.makeText(getActivity(), "更多景点加载完成", Toast.LENGTH_SHORT).show();
                        }
                    };
                    de.delayRun(2500);
                }

                //加载第四页
                if (list.size() > 41 && list.size() < 61) {
                    linlayJiazaidonghua.setVisibility(View.VISIBLE);
                    AddDateInList(api4);
                    de = new DelayedTaskUtil() {
                        @Override
                        public void onPostExecute() {
                            ad.notifyDataSetChanged();
                            linlayJiazaidonghua.setVisibility(View.GONE);
                            Toast.makeText(getActivity(), "更多景点加载完成", Toast.LENGTH_SHORT).show();
                        }
                    };
                    de.delayRun(2500);
                }


                //加载第五页
                if (list.size() > 61 && list.size() < 81) {
                    linlayJiazaidonghua.setVisibility(View.VISIBLE);
                    AddDateInList(api5);
                    de = new DelayedTaskUtil() {
                        @Override
                        public void onPostExecute() {
                            ad.notifyDataSetChanged();
                            linlayJiazaidonghua.setVisibility(View.GONE);
                            Toast.makeText(getActivity(), "更多景点加载完成", Toast.LENGTH_SHORT).show();
                        }
                    };
                    de.delayRun(2500);
                }


                //加载第六页
                if (list.size() > 81 && list.size() < 101) {
                    linlayJiazaidonghua.setVisibility(View.VISIBLE);
                    AddDateInList(api6);
                    de = new DelayedTaskUtil() {
                        @Override
                        public void onPostExecute() {
                            ad.notifyDataSetChanged();
                            linlayJiazaidonghua.setVisibility(View.GONE);
                            linlayJiazaigengduo.setVisibility(View.GONE);
                            layDixian.setVisibility(View.VISIBLE);
                            Toast.makeText(getActivity(), "更多景点加载完成", Toast.LENGTH_SHORT).show();
                        }
                    };
                    de.delayRun(2500);
                }


            }
        });

    }

    /**
     * 返回文章顶部
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
                        bean = gs.fromJson(response, TravelJingDianBean.class);
                        for (int i = 0; i < bean.getData().getScenicSpots().size(); i++) {
                            list.add(bean.getData().getScenicSpots().get(i));
                        }


                    }
                });

    }

    private void setBaseDate() {
        Map<String, String> map = new HashMap<>();
        map.put("", "");
        OkHttpUtils.post().url(api2).params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gs = new Gson();
                        bean = gs.fromJson(response, TravelJingDianBean.class);
                        for (int i = 0; i < bean.getData().getScenicSpots().size(); i++) {
                            list.add(bean.getData().getScenicSpots().get(i));
                        }
                        ad = new Grid_travelAd(getActivity(), list);
                        mygd.setAdapter(ad);
                        relayLoad.setVisibility(View.GONE);
                    }
                });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
