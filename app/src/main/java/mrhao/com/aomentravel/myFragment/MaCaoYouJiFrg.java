package mrhao.com.aomentravel.myFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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
import butterknife.Unbinder;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.MaCaoYouJiBean;
import mrhao.com.aomentravel.myAdapter.MyGridview_YjAd;
import mrhao.com.aomentravel.myAdapter.Recycle_YouJiAd;
import mrhao.com.aomentravel.utils.DelayedTaskUtil;
import mrhao.com.aomentravel.utils.MyGridView;
import mrhao.com.aomentravel.utils.ScreenUtils;

public class MaCaoYouJiFrg extends Fragment {
    Unbinder unbinder;
    MaCaoYouJiBean bean;
    Recycle_YouJiAd recyad;
    List<MaCaoYouJiBean.DataBean.UserActivitiesBean> list = new ArrayList<>();
    @BindView(R.id.relay_load)
    RelativeLayout relayLoad;
    DelayedTaskUtil de;
    @BindView(R.id.recy_macaoyj)
    RecyclerView recyMacaoyj;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ma_cao_you_ji_frg, container, false);
        unbinder = ButterKnife.bind(this, view);
        recyMacaoyj.setNestedScrollingEnabled(false);
        getBaseDate();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void getBaseDate() {



        Map<String, String> map = new HashMap<>();
        map.put("", "");
        OkHttpUtils.get().url("http://q.chanyouji.com/api/v1/user_activities.json?district_id=39&page=1").params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                    }
                    @Override
                    public void onResponse(String response) {
                        Gson gs = new Gson();
                        bean = gs.fromJson(response, MaCaoYouJiBean.class);
                        for (int i = 0; i < bean.getData().getUser_activities().size(); i++) {
                            list.add(bean.getData().getUser_activities().get(i));
                        }
                        LinearLayoutManager layparm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                        recyMacaoyj.setLayoutManager(layparm);
                        recyad = new Recycle_YouJiAd(getActivity(), list);
                        recyMacaoyj.setAdapter(recyad);
                        relayLoad.setVisibility(View.GONE);
                    }
                });


    }


}
