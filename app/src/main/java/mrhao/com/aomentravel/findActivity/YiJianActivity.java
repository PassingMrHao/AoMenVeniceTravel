package mrhao.com.aomentravel.findActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.myActivity.BaseActivity;

public class YiJianActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.et_yijian)
    EditText etYijian;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.btn_yijian)
    Button btnYijian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yi_jian);
        ButterKnife.bind(this);
        setBaseDate();
    }

    private void setBaseDate() {
        titleText.setText("意见反馈");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnYijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(etYijian.getText().toString().trim())) {
                    Toast.makeText(YiJianActivity.this, "已提交，感谢您的宝贵意见", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(YiJianActivity.this, "您未输入任何信息和建议", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}
