package mrhao.com.aomentravel.findActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.chrisbanes.photoview.PhotoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.myActivity.BaseActivity;
import mrhao.com.aomentravel.utils.GlideApp;

public class PhotoViewActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.pic_photo)
    PhotoView picPhoto;
    @BindView(R.id.pic_tv)
    TextView picTv;
    String url = "";
    String tv = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        ButterKnife.bind(this);
        Bundle b = getIntent().getExtras();
        url = b.getString("picurl");
        tv = b.getString("wenzi");
        ButterKnife.bind(this);
        setXiangCe();
    }

    private void setXiangCe() {
        titleText.setText("图片详情");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

        picTv.setText("\u3000\u3000"+tv);
        GlideApp.with(this).load(url).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(picPhoto);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Glide.get(PhotoViewActivity.this).clearMemory();
        new Thread(){
            @Override
            public void run() {
                super.run();
                Glide.get(PhotoViewActivity.this).clearDiskCache();
            }
        }.start();

    }
}
