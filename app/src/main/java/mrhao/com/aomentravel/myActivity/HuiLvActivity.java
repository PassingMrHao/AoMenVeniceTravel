package mrhao.com.aomentravel.myActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.HuiLv_Weather_PhoneBean;

public class HuiLvActivity extends BaseActivity {


    @BindView(R.id.tv_aomenbi)
    TextView tvAomenbi;
    @BindView(R.id.tv_gangbi)
    TextView tvGangbi;
    @BindView(R.id.et_rmb)
    EditText etRmb;

    @BindView(R.id.btn_huansuan)
    Button btnHuansuan;
    @BindView(R.id.tv_gengxintime)
    TextView tvGengxintime;
    HuiLv_Weather_PhoneBean bean;

    double ga, gb;
    @BindView(R.id.huansuan_aomenbi)
    TextView huansuanAomenbi;
    @BindView(R.id.huansuan_gangbi)
    TextView huansuanGangbi;

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hui_lv);
        ButterKnife.bind(this);
        setClickEvent();
    }

    private void setClickEvent() {
        titleText.setText("货币汇率");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        Map<String, String> map = new HashMap<>();
        map.put("", "");

        OkHttpUtils.post().url("https://api.koudaihk.com:4432/api/info/public/v1/toolbox?toolType=8").params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {

                        Gson gs = new Gson();
                        bean = gs.fromJson(response, HuiLv_Weather_PhoneBean.class);

                        tvGengxintime.setText(bean.getData().getExchangeRate().getDate());
                        tvAomenbi.setText(bean.getData().getExchangeRate().getCNYToMOPRateValue() + "");
                        tvGangbi.setText(bean.getData().getExchangeRate().getCNYToHKDRateValue() + "");

                        ga = bean.getData().getExchangeRate().getCNYToMOPRateValue();//澳门币
                        gb = bean.getData().getExchangeRate().getCNYToHKDRateValue();//港币

                    }
                });

        btnHuansuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!TextUtils.isEmpty(etRmb.getText().toString())) {
                    DecimalFormat df = new DecimalFormat("#.00");
                    double de = Double.parseDouble(etRmb.getText().toString());
                    huansuanAomenbi.setText("" + df.format(de * ga));
                    huansuanGangbi.setText("" + df.format(de * gb));
                } else {

                    Toast.makeText(HuiLvActivity.this, "输入的金额不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
