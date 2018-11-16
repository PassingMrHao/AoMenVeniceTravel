package mrhao.com.aomentravel.findActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.myActivity.BaseActivity;

public class YinXiangPhotoActivity extends BaseActivity {

    @BindView(R.id.photo_yinxiang)
    PhotoView photoYinxiang;
    String url = "";
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yin_xiang_photo);
        ButterKnife.bind(this);
        Bundle b = getIntent().getExtras();
        url = b.getString("yinxiangpic");
        titleText.setText("图片详情");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Glide.with(this).load(url).into(photoYinxiang);
    }
}
