package mrhao.com.aomentravel.findActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.myActivity.BaseActivity;
import mrhao.com.aomentravel.myActivity.CollectActivity.TravelYoujiAct;

public class PhotoTextActivity extends BaseActivity {

    String text = "";
    @BindView(R.id.tv456456465)
    TextView tv456456465;
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_text);
        ButterKnife.bind(this);
        Bundle b = getIntent().getExtras();
        text = b.getString("wenzi");
        tv456456465.setText("\u3000\u3000" + text);
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                finish();
            }
        });
    }
}
