package mrhao.com.aomentravel.myActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flyco.tablayout.SegmentTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.myFragment.ChuZuCarFrg;
import mrhao.com.aomentravel.myFragment.GGJTFrg;
import mrhao.com.aomentravel.myFragment.TravelBSFrg;

public class GongGongJiaoTongActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.table_lay)
    SegmentTabLayout tableLay;
    ArrayList<Fragment> frg_list=new ArrayList<>();

    String[] title={"公共交通","旅游巴士","出租车"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gong_gong_jiao_tong);
        ButterKnife.bind(this);
        setBaseDate();
    }

    private void setBaseDate() {
        titleText.setText("交通线路");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //顶部Tablelayout导航
        frg_list.add(new  GGJTFrg());
        frg_list.add(new TravelBSFrg());
        frg_list.add(new ChuZuCarFrg());

        tableLay.setTabData(title,this,R.id.fra_continer,frg_list);

    }
}
