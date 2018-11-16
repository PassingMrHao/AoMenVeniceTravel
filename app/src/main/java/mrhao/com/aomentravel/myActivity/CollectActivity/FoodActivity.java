package mrhao.com.aomentravel.myActivity.CollectActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import mrhao.com.aomentravel.bean.CollectListBean;
import mrhao.com.aomentravel.myActivity.BaseActivity;
import mrhao.com.aomentravel.myAdapter.Gird_CollectAdapter;
import mrhao.com.aomentravel.utils.BaseDialogUtil;

public class FoodActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.gv_foodlist)
    GridView gvFoodlist;
    @BindView(R.id.relay_load)
    RelativeLayout relayLoad;
    SharedPreferences sp;
    CollectListBean bean;
    List<CollectListBean.DataBean> list = new ArrayList<>();
    Gird_CollectAdapter ad;
    @BindView(R.id.relay_nocollect)
    RelativeLayout relayNocollect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        ButterKnife.bind(this);
        sp = getSharedPreferences("mobuser", 0);
        setBaseDate();
    }

    private void setBaseDate() {
        titleText.setText("收藏列表(美食餐饮)");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Map<String, String> map = new HashMap<>();
        map.put("userid", sp.getString("username", ""));

        OkHttpUtils.post().url("http://jk.kingtrunk.com/index.php/Home/show/getarticle").params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gs = new Gson();
                        bean = gs.fromJson(response, CollectListBean.class);

                        for (int i = 0; i < bean.getData().size(); i++) {
                            if (bean.getData().get(i).getType().equals("美食餐饮")) {
                                list.add(bean.getData().get(i));
                            }
                        }

                        if (list.size() == 0) {
                            relayNocollect.setVisibility(View.VISIBLE);
                        }else if(list.size() > 0){
                            relayNocollect.setVisibility(View.GONE);
                        }

                        ad = new Gird_CollectAdapter(FoodActivity.this, list, new Gird_CollectAdapter.Cancle() {
                            @Override
                            public void quxiao(final String title) {
                                BaseDialogUtil.normalDialog(FoodActivity.this, "取消", "是否取消本收藏", new BaseDialogUtil.ShowDialogListener() {
                                    @Override
                                    public void Positive() {
                                        Map<String, String> mapa = new HashMap<>();
                                        mapa.put("userid", sp.getString("username", ""));
                                        mapa.put("type", "美食餐饮");
                                        mapa.put("title", title);
                                        OkHttpUtils.post().url("http://jk.kingtrunk.com/index.php/Home/show/qx_collect").params(mapa).build()
                                                .execute(new StringCallback() {
                                                    @Override
                                                    public void onError(Request request, Exception e) {
                                                    }

                                                    @Override
                                                    public void onResponse(String response) {
                                                        QueryCollectList();
                                                    }
                                                });
                                    }

                                    @Override
                                    public void Negative() {
                                    }
                                });
                            }
                        });
                        gvFoodlist.setAdapter(ad);
                        relayLoad.setVisibility(View.GONE);
                    }
                });

    }

    public void QueryCollectList() {
        Map<String, String> map = new HashMap<>();
        map.put("userid", sp.getString("username", ""));
        OkHttpUtils.post().url("http://jk.kingtrunk.com/index.php/Home/show/getarticle").params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gs = new Gson();
                        bean = gs.fromJson(response, CollectListBean.class);
                        list.clear();
                        for (int i = 0; i < bean.getData().size(); i++) {
                            if (bean.getData().get(i).getType().equals("美食餐饮")) {
                                list.add(bean.getData().get(i));
                            }
                        }

                        if (list.size() == 0) {
                            relayNocollect.setVisibility(View.VISIBLE);
                        }else if(list.size() > 0){
                            relayNocollect.setVisibility(View.GONE);
                        }
                        ad.notifyDataSetChanged();
                    }
                });
    }

}

