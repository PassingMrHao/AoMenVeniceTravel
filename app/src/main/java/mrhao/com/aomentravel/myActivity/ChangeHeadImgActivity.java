package mrhao.com.aomentravel.myActivity;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mrhao.com.aomentravel.R;

public class ChangeHeadImgActivity extends BaseActivity {

    @BindView(R.id.btn_savehead)
    Button btnSavehead;
    @BindView(R.id.img_yulan)
    ImageView imgYulan;


    SharedPreferences sp;
    int headId = R.mipmap.change_head;
    SharedPreferences.Editor ed;
    @BindView(R.id.img_head_nana)
    ImageView imgHeadNana;
    @BindView(R.id.img_head_nva)
    ImageView imgHeadNva;
    @BindView(R.id.img_head_qita_a)
    ImageView imgHeadQitaA;
    @BindView(R.id.img_head_nanb)
    ImageView imgHeadNanb;
    @BindView(R.id.img_head_nvb)
    ImageView imgHeadNvb;
    @BindView(R.id.img_head_qita_b)
    ImageView imgHeadQitaB;
    @BindView(R.id.img_head_nanc)
    ImageView imgHeadNanc;
    @BindView(R.id.img_head_nvc)
    ImageView imgHeadNvc;
    @BindView(R.id.img_head_qita_c)
    ImageView imgHeadQitaC;
    @BindView(R.id.img_head_nand)
    ImageView imgHeadNand;
    @BindView(R.id.img_head_nvd)
    ImageView imgHeadNvd;
    @BindView(R.id.img_head_qita_d)
    ImageView imgHeadQitaD;
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_head_img);
        ButterKnife.bind(this);
        titleText.setText("设置头像");
        sp = getSharedPreferences("mobuser", 0);
        ed = sp.edit();
        getSharedPreferences_PicData();
    }

    private void getSharedPreferences_PicData() {
        //当前用户选择的头像为系统推荐
        headId = sp.getInt("pic_id", R.mipmap.jj_wdl);
        imgYulan.setBackgroundResource(headId);
    }


    @OnClick({R.id.title_back, R.id.title_text,R.id.btn_savehead, R.id.img_head_nana, R.id.img_head_nva, R.id.img_head_qita_a, R.id.img_head_nanb, R.id.img_head_nvb, R.id.img_head_qita_b, R.id.img_head_nanc, R.id.img_head_nvc, R.id.img_head_qita_c, R.id.img_head_nand, R.id.img_head_nvd, R.id.img_head_qita_d})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                ed.putInt("pic_id", sp.getInt("pic_id", R.mipmap.jj_wdl));
                ed.commit();
                finish();
                break;
            case R.id.title_text:
                break;
            case R.id.btn_savehead:
                //当前用户选择的头像为系统推荐
                ed.putInt("pic_id", headId);
                ed.commit();
                finish();
                break;
            case R.id.img_head_nana:
                saveData(imgYulan, R.mipmap.nan_a);
                break;
            case R.id.img_head_nanb:
                saveData(imgYulan, R.mipmap.nan_b);
                break;
            case R.id.img_head_nanc:
                saveData(imgYulan, R.mipmap.nan_c);
                break;
            case R.id.img_head_nand:
                saveData(imgYulan, R.mipmap.nan_d);
                break;
            case R.id.img_head_nva:
                saveData(imgYulan, R.mipmap.nv_a);
                break;
            case R.id.img_head_nvb:
                saveData(imgYulan, R.mipmap.nv_b);
                break;
            case R.id.img_head_nvc:
                saveData(imgYulan, R.mipmap.nv_c);
                break;
            case R.id.img_head_nvd:
                saveData(imgYulan, R.mipmap.nv_d);
                break;
            case R.id.img_head_qita_a:
                saveData(imgYulan, R.mipmap.qita_a);
                break;
            case R.id.img_head_qita_b:
                saveData(imgYulan, R.mipmap.qita_b);
                break;
            case R.id.img_head_qita_c:
                saveData(imgYulan, R.mipmap.qita_c);
                break;
            case R.id.img_head_qita_d:
                saveData(imgYulan, R.mipmap.qita_d);
                break;
        }
    }


    public void saveData(ImageView im, int res) {
        im.setImageBitmap(null);
        im.setBackgroundResource(res);
        headId = res;
    }




}
