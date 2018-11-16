package mrhao.com.aomentravel.myActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.utils.GlideApp;

public class TravelPreActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.im_tu1)
    ImageView imTu1;
    @BindView(R.id.im_tu2)
    ImageView imTu2;
    @BindView(R.id.im_tu3)
    ImageView imTu3;
    @BindView(R.id.im_tu4)
    ImageView imTu4;
    @BindView(R.id.im_tu5)
    ImageView imTu5;
    @BindView(R.id.im_tu6)
    ImageView imTu6;
    @BindView(R.id.im_tu7)
    ImageView imTu7;
    @BindView(R.id.im_tu8)
    ImageView imTu8;
    @BindView(R.id.im_tu9)
    ImageView imTu9;
    @BindView(R.id.im_tu10)
    ImageView imTu10;
    @BindView(R.id.im_tu11)
    ImageView imTu11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_pre);
        ButterKnife.bind(this);
        setBaseDate();
    }

    private void setBaseDate() {
        titleText.setText("行前准备");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Glide.with(this).load("http://t11.baidu.com/it/u=757202389,4254163878&fm=173&app=25&f=JPEG?w=640&h=387&s=D69115C554AD5F0FF08569530300C0B3").into(imTu1);
        Glide.with(this).load("http://t10.baidu.com/it/u=1171590726,1224391406&fm=173&app=25&f=JPEG?w=640&h=640&s=13FA5F951E5447D882A46DFE0300802E").into(imTu2);
        Glide.with(this).load("http://t11.baidu.com/it/u=579496180,1539801508&fm=173&app=25&f=JPEG?w=640&h=393&s=FDCA7A239A3273AFDA1D00DF0100C0A0").into(imTu3);
        Glide.with(this).load("http://t12.baidu.com/it/u=2963387753,3790836898&fm=173&app=25&f=JPEG?w=640&h=383&s=62BB37C750F24B921A14F17B0300E01A").into(imTu4);
        Glide.with(this).load("http://t10.baidu.com/it/u=2976511890,3269091763&fm=173&app=25&f=JPEG?w=640&h=640&s=7129B157160A7AEC343C9CE00300E031").into(imTu5);
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535623917301&di=cbcf36dc687b3c522688e314d9dba402&imgtype=0&src=http%3A%2F%2Fimg.kj-cy.cn%2Fuploads%2Flitimg%2F20160401%2F1459472601188522.jpg").into(imTu6);
        Glide.with(this).load("http://t10.baidu.com/it/u=478382928,3051118281&fm=173&app=25&f=JPEG?w=640&h=360&s=F9A99955745181C200B9B52703007068").into(imTu7);
        Glide.with(this).load("http://t10.baidu.com/it/u=984586293,452577154&fm=173&app=25&f=JPEG?w=640&h=406&s=AA43CF14461B7DCE10454C450300F0B2").into(imTu8);
        Glide.with(this).load("http://t10.baidu.com/it/u=3973435629,3916940925&fm=173&app=25&f=JPEG?w=640&h=400&s=31184C32D3C66743166CADCD0300F0A1").into(imTu9);
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535624010416&di=c64bdbd3e11050e110fb2d0a4e10f27b&imgtype=0&src=http%3A%2F%2Ffile32.mafengwo.net%2FM00%2F5E%2F7B%2FwKgBs1Zzwq6ATnebAASnnOdeyEA22.jpeg").into(imTu10);
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535624049045&di=bcc06b011e94d557782ef075c7968010&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F015189564fd11e32f87512f6fa5979.jpg").into(imTu11);

    }
}
