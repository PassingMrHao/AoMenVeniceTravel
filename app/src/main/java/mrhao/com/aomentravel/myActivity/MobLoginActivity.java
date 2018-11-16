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

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.MobLoginBean;
import mrhao.com.aomentravel.utils.StartActivityUtil;

public class MobLoginActivity extends BaseActivity {


    @BindView(R.id.et_zhanghao)
    EditText etZhanghao;
    @BindView(R.id.et_psw)
    EditText etPsw;
    @BindView(R.id.tv_regist)
    TextView tvRegist;
    @BindView(R.id.tv_findpsw)
    TextView tvFindpsw;
    @BindView(R.id.btn_login)
    Button btnLogin;
    MobLoginBean logbean;
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mob_login);
        ButterKnife.bind(this);
        titleText.setText("用户登录");
        sp = getSharedPreferences("mobuser", 0);
        ed = sp.edit();
    }

    @OnClick({R.id.tv_regist, R.id.tv_findpsw, R.id.btn_login,R.id.title_back, R.id.title_text})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.title_text:

                break;
            case R.id.tv_regist:
                //注册账号
                StartActivityUtil.startAct(MobLoginActivity.this, MobRegistActivity.class);
                break;
            case R.id.tv_findpsw:
                //修改密码
                StartActivityUtil.startAct(MobLoginActivity.this, MobFindPswActivity.class);

                break;
            case R.id.btn_login:
                //登录
                if (!TextUtils.isEmpty(etZhanghao.getText().toString().trim()) && !TextUtils.isEmpty(etPsw.getText().toString().trim())) {
                    Map<String, String> map = new HashMap<>();
                    map.put("key", "258ea60e36fdf");
                    map.put("username", etZhanghao.getText().toString().trim());
                    map.put("password", etPsw.getText().toString().trim());

                    OkHttpUtils.get().url("http://apicloud.mob.com/user/login").params(map).build()
                            .execute(new StringCallback() {
                                @Override
                                public void onError(Request request, Exception e) {

                                }

                                @Override
                                public void onResponse(String response) {

                                    Gson gs = new Gson();
                                    logbean = gs.fromJson(response, MobLoginBean.class);

                                    if (logbean.getRetCode().equals("200")) {

                                        ed.putString("username", etZhanghao.getText().toString().trim());
                                        ed.putString("password", etPsw.getText().toString().trim());
                                        ed.commit();
                                        Toast.makeText(MobLoginActivity.this, "登陆成功！", Toast.LENGTH_SHORT).show();
                                        finish();

                                    } else {
                                        Toast.makeText(MobLoginActivity.this, logbean.getMsg(), Toast.LENGTH_SHORT).show();
                                    }

                                }

                            });

                } else {

                    Toast.makeText(MobLoginActivity.this, "账号/密码不能为空！", Toast.LENGTH_SHORT).show();

                }

                break;

        }
    }


}
