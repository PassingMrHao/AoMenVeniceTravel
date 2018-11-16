package mrhao.com.aomentravel.myActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.MobRegisteBean;

public class MobRegistActivity extends BaseActivity {

    @BindView(R.id.et_regist_username)
    EditText etname;
    @BindView(R.id.et_regist_psw)
    EditText etPsw;
    @BindView(R.id.btn_registe)
    Button btnRegiste;
    MobRegisteBean rebean;
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.et_regist_phone)
    EditText etRegistPhone;
    @BindView(R.id.et_regist_yzm)
    EditText etRegistYzm;
    @BindView(R.id.btn_yzm)
    Button btnYzm;

    public EventHandler eh; //事件接收器
    private TimeCount mTimeCount;//计时器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mob_regist);
        ButterKnife.bind(this);
        titleText.setText("用户注册");
        mTimeCount = new TimeCount(60000, 1000);
        setRegisterEvent();
        MessgSDKEvent();
    }

    /**
     * 短信验证码
     * 郝玉龙
     * 2018/09/12
     */
    private void MessgSDKEvent() {

        eh = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {

                if (result == SMSSDK.RESULT_COMPLETE) {//回调完成

                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {//提交验证码成功

                        if (!TextUtils.isEmpty(etname.getText().toString().trim()) && !TextUtils.isEmpty(etPsw.getText().toString().trim())&& !TextUtils.isEmpty(etRegistYzm.getText().toString().trim())&& !TextUtils.isEmpty(etRegistPhone.getText().toString().trim())) {
                            Map<String, String> map = new HashMap<>();
                            map.put("key", "258ea60e36fdf");
                            map.put("username", etname.getText().toString());
                            map.put("password", etPsw.getText().toString());
                            OkHttpUtils.get().url("http://apicloud.mob.com/user/rigister").params(map).build()
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onError(Request request, Exception e) {

                                        }

                                        @Override
                                        public void onResponse(String response) {
                                            Gson gs = new Gson();
                                            rebean = gs.fromJson(response, MobRegisteBean.class);

                                            if (rebean.getRetCode().equals("200")) {
                                                Toast.makeText(MobRegistActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                                                finish();

                                            } else {
                                                Toast.makeText(MobRegistActivity.this, rebean.getMsg(), Toast.LENGTH_SHORT).show();
                                            }


                                        }
                                    });

                        } else {
                            Toast.makeText(MobRegistActivity.this, "请将注册资料补充完整。", Toast.LENGTH_SHORT).show();
                        }


                    }else if(event == SMSSDK.EVENT_GET_VERIFICATION_CODE){//获取验证码成功

                    }else if(event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){//返回支持发送验证码的国家列表

                    }

                }else {//回调失败
                    ((Throwable)data).printStackTrace();


                }

            }
        };
        SMSSDK.registerEventHandler(eh); //注册短信回调


        btnYzm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etRegistPhone.getText().toString().trim().equals("")){
                    if (checkTel(etRegistPhone.getText().toString().trim())) {
                        SMSSDK.getVerificationCode("+86",etRegistPhone.getText().toString());//获取验证码
                        mTimeCount.start();
                    }else{
                        Toast.makeText(MobRegistActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MobRegistActivity.this, "请输入手机号码", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }



    //注册
    private void setRegisterEvent() {


        btnRegiste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etRegistPhone.getText().toString().trim().equals("")) {
                    if (checkTel(etRegistPhone.getText().toString().trim())) {
                        if (!etRegistYzm.getText().toString().trim().equals("")) {
                            SMSSDK.submitVerificationCode("+86",etRegistPhone.getText().toString().trim(),etRegistYzm.getText().toString().trim());//提交验证
                        }else{
                            Toast.makeText(MobRegistActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MobRegistActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MobRegistActivity.this, "请输入手机号码", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }

    @OnClick({R.id.title_back, R.id.title_text})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.title_text:

                break;
        }
    }



    /**
     * 正则匹配手机号码
     * @param tel
     * @return
     */
    public boolean checkTel(String tel){
        Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
        Matcher matcher = p.matcher(tel);
        return matcher.matches();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eh);
    }

    /**
     * 计时器
     */
    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            btnYzm.setClickable(false);
            btnYzm.setText(l / 1000 + "s后重新获取");
        }
        @Override
        public void onFinish() {
            btnYzm.setClickable(true);
            btnYzm.setText("获取验证码");
        }
    }
}
