package mrhao.com.aomentravel.findActivity;

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
import mrhao.com.aomentravel.myActivity.BaseActivity;
import mrhao.com.aomentravel.myFragment.ChuZuCarFrg;
import mrhao.com.aomentravel.myFragment.GGJTFrg;
import mrhao.com.aomentravel.myFragment.MacaoHistory;
import mrhao.com.aomentravel.myFragment.MacaoJingJi;
import mrhao.com.aomentravel.myFragment.MacaoTrans;
import mrhao.com.aomentravel.myFragment.TravelBSFrg;

public class MacaoActivity extends BaseActivity {


    @BindView(R.id.konw_macaotab)
    SegmentTabLayout konwMacaotab;
    ArrayList<Fragment> frg_list = new ArrayList<>();

    String[] title = {"历史地理", "政治经济", "文化"};
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macao);
        ButterKnife.bind(this);
        setBaseDate();
    }

    private void setBaseDate() {
        titleText.setText("澳门城市百科");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //顶部Tablelayout导航
        frg_list.add(new MacaoHistory());
        frg_list.add(new MacaoJingJi());
        frg_list.add(new MacaoTrans());

        konwMacaotab.setTabData(title, this, R.id.continner_macao, frg_list);
    }
}
