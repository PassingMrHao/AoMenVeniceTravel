package mrhao.com.aomentravel.myActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import mrhao.com.aomentravel.bean.MobChangePswBean;

public class MobFindPswActivity extends BaseActivity {

    MobChangePswBean pswbean;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_oldPsw)
    EditText etOldPsw;
    @BindView(R.id.et_newPsw)
    EditText etNewPsw;
    @BindView(R.id.btn_update_psw)
    Button btnUpdatePsw;
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mob_find_psw);
        ButterKnife.bind(this);
        setClickEvent();
    }

    private void setClickEvent() {
        titleText.setText("修改密码");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @OnClick(R.id.btn_update_psw)
    public void onViewClicked() {
        btnUpdatePsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> map = new HashMap<>();
                map.put("key", "258ea60e36fdf");
                map.put("username", etUsername.getText().toString().trim());
                map.put("oldPassword", etOldPsw.getText().toString().trim());
                map.put("newPassword", etNewPsw.getText().toString().trim());
                OkHttpUtils.get().url("http://apicloud.mob.com/user/password/change").params(map).build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Request request, Exception e) {

                            }

                            @Override
                            public void onResponse(String response) {
                                Gson gs = new Gson();
                                pswbean = gs.fromJson(response, MobChangePswBean.class);
                                if (pswbean.getRetCode().equals("200")) {
                                    Toast.makeText(MobFindPswActivity.this, "密码修改成功！", Toast.LENGTH_SHORT).show();
                                    finish();

                                } else {
                                    Toast.makeText(MobFindPswActivity.this, pswbean.getMsg(), Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });
    }
}
