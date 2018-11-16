package mrhao.com.aomentravel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.bean.MainBottomData;
import mrhao.com.aomentravel.myActivity.BaseActivity;
import mrhao.com.aomentravel.myAdapter.MainBottomAdapter;
import mrhao.com.aomentravel.myFragment.AboutFrg;
import mrhao.com.aomentravel.myFragment.MaCaoYouJiFrg;
import mrhao.com.aomentravel.myFragment.NewFindFrag;
import mrhao.com.aomentravel.myFragment.NewTravelFragment;
import mrhao.com.aomentravel.myFragment.TravelNewsFrg;

public class MainActivity extends BaseActivity {

    @BindView(R.id.recy_bottom)
    RecyclerView recyBottom;
    @BindView(R.id.fly_continer)
    FrameLayout flyContiner;

    public List<MainBottomData> bottomList = new ArrayList<>();
    public MainBottomAdapter adapter;
    public int oldPage = 0;
    public List<Fragment> fragmentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initBottomData();
        initFragment();
        setView();
    }


    private void initBottomData() {

        MainBottomData data1 = new MainBottomData("攻略", R.mipmap.news_gray, R.mipmap.news_color);
        data1.setSelected(true);
        MainBottomData data2 = new MainBottomData("景点", R.mipmap.reqiqiu_gray, R.mipmap.reqiqiu_color);
        MainBottomData dataz = new MainBottomData("游记", R.mipmap.ymyouji_gray, R.mipmap.ymyouji_color);
        MainBottomData data3 = new MainBottomData("发现", R.mipmap.find_gray, R.mipmap.find_color);
        MainBottomData data4 = new MainBottomData("我的", R.mipmap.wode_gray, R.mipmap.wode_color);
        bottomList.add(data1);
        bottomList.add(data2);
        bottomList.add(dataz);
        bottomList.add(data3);
        bottomList.add(data4);

    }


    private void initFragment() {
        fragmentList.add(new TravelNewsFrg());
        fragmentList.add(new NewTravelFragment());
        fragmentList.add(new MaCaoYouJiFrg());
        fragmentList.add(new NewFindFrag());
        fragmentList.add(new AboutFrg());

    }


    private void setView() {
        getSupportFragmentManager().beginTransaction().add(R.id.fly_continer, fragmentList.get(0)).show(fragmentList.get(0)).commit();
        adapter = new MainBottomAdapter(this, bottomList);
        GridLayoutManager manager = new GridLayoutManager(this, 5);
        recyBottom.setAdapter(adapter);
        recyBottom.setLayoutManager(manager);
        adapter.setClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (oldPage != i)
                    changePage(i);
            }
        });
    }


    public void changePage(int pagePosition) {

        FragmentTransaction bt = getSupportFragmentManager().beginTransaction();
        bt.hide(fragmentList.get(oldPage));
        if (fragmentList.get(pagePosition).isAdded()) {
            bt.show(fragmentList.get(pagePosition)).commit();
        } else {
            bt.add(R.id.fly_continer, fragmentList.get(pagePosition)).show(fragmentList.get(pagePosition)).commit();
        }
        oldPage = pagePosition;

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        Glide.get(MainActivity.this).clearMemory();
        new Thread() {
            @Override
            public void run() {
                super.run();
                Glide.get(MainActivity.this).clearDiskCache();
            }
        }.start();
    }
}
