package mrhao.com.aomentravel.myFragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.FxWeatherBean;
import mrhao.com.aomentravel.bean.HangBanMsgBean;
import mrhao.com.aomentravel.findActivity.FindMoreHangBanAct;
import mrhao.com.aomentravel.findActivity.FindMoreTransAct;
import mrhao.com.aomentravel.utils.BaseDialogUtil;

public class NewFindFrag extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.fxtq_day)
    TextView fxtqDay;
    @BindView(R.id.fxtq_night)
    TextView fxtqNight;
    @BindView(R.id.fxtq_wendu)
    TextView fxtqWendu;
    @BindView(R.id.fxtq_air)
    TextView fxtqAir;
    @BindView(R.id.fxtq_wind)
    TextView fxtqWind;
    @BindView(R.id.fxtq_shidu)
    TextView fxtqShidu;
    @BindView(R.id.fxtq_temp)
    TextView fxtqTemp;
    @BindView(R.id.fxtq_date)
    TextView fxtqDate;
    FxWeatherBean weabean;
    @BindView(R.id.fx_jiudian)
    LinearLayout fxJiudian;
    @BindView(R.id.fx_wifi)
    LinearLayout fxWifi;
    @BindView(R.id.fx_ziyouxing)
    LinearLayout fxZiyouxing;
    @BindView(R.id.fx_gentuan)
    LinearLayout fxGentuan;
    @BindView(R.id.et_chufadi)
    EditText etChufadi;
    @BindView(R.id.btn_query_hangban)
    Button btnQueryHangban;
    HangBanMsgBean hbbean;
    @BindView(R.id.lay_noresult)
    LinearLayout layNoresult;
    @BindView(R.id.lay_result)
    LinearLayout layResult;

    @BindView(R.id.hangban_num)
    TextView hangbanNum;
    @BindView(R.id.hangban_chufatime)
    TextView hangbanChufatime;
    @BindView(R.id.hangban_chufadi)
    TextView hangbanChufadi;
    @BindView(R.id.hangban_haoshi)
    TextView hangbanHaoshi;
    @BindView(R.id.hangban_daodatime)
    TextView hangbanDaodatime;
    @BindView(R.id.hangban_mudi)
    TextView hangbanMudi;
    @BindView(R.id.hangban_hangkong)
    TextView hangbanHangkong;
    @BindView(R.id.hangban_zhundian)
    TextView hangbanZhundian;
    @BindView(R.id.fx_morehangban)
    LinearLayout fxMorehangban;
    @BindView(R.id.hangban_lookall)
    TextView hangbanLookall;
    String chufadi = "";
    @BindView(R.id.fx_moretrains)
    LinearLayout fxMoretrains;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_find, container, false);
        unbinder = ButterKnife.bind(this, view);
        getWeatherDate();
        getHangBanMsg();
        return view;
    }


    /**
     * 查询航班信息
     */
    private void getHangBanMsg() {

        btnQueryHangban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chufadi = etChufadi.getText().toString().trim();
                if (TextUtils.isEmpty(chufadi) || chufadi.equals("")) {
                    Toast.makeText(getActivity(), "请输入出发地，不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    Map<String, String> map = new HashMap<>();
                    map.put("key", "258ea60e36fdf");
                    map.put("start", chufadi);
                    map.put("end", "澳门");

                    OkHttpUtils.get().url("http://apicloud.mob.com/flight/line/query").params(map).build()
                            .execute(new StringCallback() {
                                @Override
                                public void onError(Request request, Exception e) {

                                }

                                @Override
                                public void onResponse(String response) {
                                    if (response.equals("{\"msg\":\"查询不到对应航班信息\",\"retCode\":\"23006\"}")) {
                                        layNoresult.setVisibility(View.VISIBLE);
                                        layResult.setVisibility(View.GONE);
                                    } else {
                                        Gson gs = new Gson();
                                        hbbean = gs.fromJson(response, HangBanMsgBean.class);
                                        layNoresult.setVisibility(View.GONE);
                                        layResult.setVisibility(View.VISIBLE);
                                        hangbanNum.setText("" + hbbean.getResult().size());
                                        hangbanChufatime.setText(hbbean.getResult().get(0).getPlanTime());
                                        hangbanDaodatime.setText(hbbean.getResult().get(0).getPlanArriveTime());
                                        hangbanChufadi.setText(hbbean.getResult().get(0).getFrom());
                                        hangbanMudi.setText(hbbean.getResult().get(0).getTo());
                                        hangbanHaoshi.setText(hbbean.getResult().get(0).getFlightTime());
                                        hangbanHangkong.setText(hbbean.getResult().get(0).getAirLines());
                                        hangbanZhundian.setText(hbbean.getResult().get(0).getFlightRate());


                                    }

                                }
                            });

                }

            }
        });


        //更多航班
        fxMorehangban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(getActivity(), FindMoreHangBanAct.class);
                Bundle b = new Bundle();
                b.putInt("type", 0);// 0:更多航班 ; 1:查看全部
                hao.putExtras(b);
                startActivity(hao);
            }
        });

        //查看全部航班
        hangbanLookall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent hao = new Intent(getActivity(), FindMoreHangBanAct.class);
                Bundle b = new Bundle();
                b.putInt("type", 1);// 0:更多航班 ; 1:查看全部
                b.putString("chufa", chufadi);
                hao.putExtras(b);
                startActivity(hao);
            }
        });




        //更多车次信息

        fxMoretrains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(getActivity(), FindMoreTransAct.class);
                Bundle b = new Bundle();
                b.putInt("type", 0);// 0:更多车次 ; 1:查看全部
                hao.putExtras(b);
                startActivity(hao);
            }
        });



    }


    /**
     * 获取天气数据
     */
    private void getWeatherDate() {

        Map<String, String> map = new HashMap<>();
        map.put("key", "258ea60e36fdf");
        map.put("city", "澳门");
        OkHttpUtils.get().url("http://apicloud.mob.com/v1/weather/query").params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {

                        Gson gs = new Gson();
                        weabean = gs.fromJson(response, FxWeatherBean.class);

                        fxtqDay.setText(weabean.getResult().get(0).getFuture().get(0).getDayTime());
                        fxtqNight.setText(weabean.getResult().get(0).getFuture().get(0).getNight());
                        fxtqWendu.setText(weabean.getResult().get(0).getFuture().get(0).getTemperature());
                        fxtqAir.setText(weabean.getResult().get(0).getAirCondition());
                        fxtqWind.setText(weabean.getResult().get(0).getWind());
                        fxtqShidu.setText(weabean.getResult().get(0).getHumidity());
                        fxtqTemp.setText(weabean.getResult().get(0).getTemperature());
                        fxtqDate.setText(weabean.getResult().get(0).getDate() + "\u3000" + weabean.getResult().get(0).getWeek());


                    }
                });

        final String title = "免责声明";
        final String msg = "即将离开跳转到第三方页面";
        //酒店
        fxJiudian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //普通2个选项AlertDialog
                BaseDialogUtil.normalDialog(getActivity(), title, msg, new BaseDialogUtil.ShowDialogListener() {
                    @Override
                    public void Positive() {
                        //点击确定后的事件
                        Uri uri = Uri.parse("http://m.ctrip.com/webapp/hotel/Macau59/?fr=index&allianceid=309340&autoawaken=close&ouid=&popup=close&sid=788076");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }

                    @Override
                    public void Negative() {
                    } //点击取消后的事件
                });
            }
        });


        //Wifi上网
        fxWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //普通2个选项AlertDialog
                BaseDialogUtil.normalDialog(getActivity(), title, msg, new BaseDialogUtil.ShowDialogListener() {
                    @Override
                    public void Positive() {
                        //点击确定后的事件
                        Uri uri = Uri.parse("http://m.ctrip.com/webapp/activity/wifilist?keyword=%E6%BE%B3%E9%97%A8&allianceid=309340&autoawaken=close&ouid=&popup=close&sid=788076");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }

                    @Override
                    public void Negative() {
                    } //点击取消后的事件
                });
            }
        });


        //自由行
        fxZiyouxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //普通2个选项AlertDialog
                BaseDialogUtil.normalDialog(getActivity(), title, msg, new BaseDialogUtil.ShowDialogListener() {
                    @Override
                    public void Positive() {
                        //点击确定后的事件
                        Uri uri = Uri.parse("http://m.ctrip.com/webapp/vacations/tour/list?tab=2&searchtype=diy&scity=2&salecity=2&kwd=%E6%BE%B3%E9%97%A8&allianceid=309340&autoawaken=close&popup=close&sid=788076");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }

                    @Override
                    public void Negative() {
                    } //点击取消后的事件
                });
            }
        });


        //跟团
        fxGentuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //普通2个选项AlertDialog
                BaseDialogUtil.normalDialog(getActivity(), title, msg, new BaseDialogUtil.ShowDialogListener() {
                    @Override
                    public void Positive() {
                        //点击确定后的事件
                        Uri uri = Uri.parse("http://m.ctrip.com/webapp/vacations/tour/grouptravel?kwd=%E6%BE%B3%E9%97%A8&salecity=%E6%B2%B3%E5%8C%97&allianceid=309340&autoawaken=close&ouid=&popup=close&sid=788076");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }

                    @Override
                    public void Negative() {
                    } //点击取消后的事件

                });
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
