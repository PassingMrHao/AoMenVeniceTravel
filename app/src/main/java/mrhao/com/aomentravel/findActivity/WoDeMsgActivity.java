package mrhao.com.aomentravel.findActivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.flyco.tablayout.SegmentTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.myActivity.BaseActivity;
import mrhao.com.aomentravel.myFragment.MsgTSFrg;
import mrhao.com.aomentravel.myFragment.MsgXTFrg;
import mrhao.com.aomentravel.utils.DelayedTaskUtil;

public class WoDeMsgActivity extends BaseActivity {
    @BindView(R.id.tabLayout_1)
    SegmentTabLayout tabLayout1;
    @BindView(R.id.continner_msg)
    FrameLayout continnerMsg;
    @BindView(R.id.msg_goback)
    ImageView msgGoback;
    @BindView(R.id.relay_load)
    RelativeLayout relayLoad;
    private String[] mTitles = {"系统消息", "历史推送"};
    ArrayList<Fragment> frg_list = new ArrayList<>();

    DelayedTaskUtil de;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wo_de_msg);
        ButterKnife.bind(this);
        frg_list.add(new MsgXTFrg());
        frg_list.add(new MsgTSFrg());
        tabLayout1.setTabData(mTitles, this, R.id.continner_msg, frg_list);
        tabLayout1.setCurrentTab(0);
        msgGoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        de=new DelayedTaskUtil() {
            @Override
            public void onPostExecute() {
                relayLoad.setVisibility(View.GONE);
            }
        };
        de.delayRun(580);
    }

}
