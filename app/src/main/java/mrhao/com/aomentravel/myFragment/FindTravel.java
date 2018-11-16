package mrhao.com.aomentravel.myFragment;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.findActivity.FindFoodActivity;
import mrhao.com.aomentravel.findActivity.FindMarketActivity;
import mrhao.com.aomentravel.findActivity.FindPlayActivity;
import mrhao.com.aomentravel.findActivity.FindZheKouActivity;
import mrhao.com.aomentravel.findActivity.MacaoActivity;
import mrhao.com.aomentravel.findActivity.TuiSongSheZhiActivity;
import mrhao.com.aomentravel.findActivity.YiJianActivity;
import mrhao.com.aomentravel.myActivity.ChangeHeadImgActivity;
import mrhao.com.aomentravel.myActivity.MobLoginActivity;
import mrhao.com.aomentravel.myActivity.MyCollectActivity;
import mrhao.com.aomentravel.utils.BaseDialogUtil;
import mrhao.com.aomentravel.utils.DataCleanManagerUtil;
import mrhao.com.aomentravel.utils.DelayedTaskUtil;
import mrhao.com.aomentravel.utils.StartActivityUtil;


public class FindTravel extends Fragment {

    @BindView(R.id.im_tuichu_login)
    ImageView imTuichuLogin;
    Unbinder unbinder;
    @BindView(R.id.img_message)
    ImageView imgMessage;
    @BindView(R.id.tv_userName)
    TextView tvUserName;
    @BindView(R.id.tv_denglu)
    TextView tvDenglu;
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    @BindView(R.id.find_aomen)
    LinearLayout findAomen;
    @BindView(R.id.find_collect)
    LinearLayout findCollect;
    @BindView(R.id.find_zhekou)
    LinearLayout findZhekou;
    @BindView(R.id.find_shangchang)
    LinearLayout findShangchang;
    @BindView(R.id.find_yule)
    LinearLayout findYule;
    @BindView(R.id.find_food)
    LinearLayout findFood;
    @BindView(R.id.find_clean)
    LinearLayout findClean;
    @BindView(R.id.find_update)
    LinearLayout findUpdate;
    @BindView(R.id.find_tuisong)
    LinearLayout findTuisong;
    @BindView(R.id.find_yijian)
    LinearLayout findYijian;
    @BindView(R.id.im_user)
    ImageView imUser;
    int headId =R.mipmap.jj_wdl;
    DelayedTaskUtil de;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_find_travel, container,false);
        unbinder = ButterKnife.bind(this, view);
        setClickEvent();

        sp = getActivity().getSharedPreferences("mobuser", 0);
        if (sp.getString("username", "").equals("")) {
            tvDenglu.setVisibility(View.VISIBLE);
            tvUserName.setText("未登录");
        } else {
            tvDenglu.setVisibility(View.GONE);
            tvUserName.setText(sp.getString("username", ""));
        }

        return view;
    }

    private void setClickEvent() {

        //注册登录
        tvDenglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MobLoginActivity.class));
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
        //判断登录状态及获取登录用户名
        sp = getActivity().getSharedPreferences("mobuser", 0);
        String yonghu = sp.getString("username", "");
        if (sp.getString("username", "").equals("")) {
            tvDenglu.setVisibility(View.VISIBLE);
            tvUserName.setText("未登录");
            imUser.setBackgroundResource(headId);
        } else {
            tvDenglu.setVisibility(View.GONE);
            tvUserName.setText(sp.getString("username", ""));
            //获取头像
            headId = sp.getInt("pic_id", R.mipmap.change_head);
            imUser.setImageBitmap(null);
            imUser.setBackgroundResource(headId);
        }


    }

    @OnClick({R.id.im_user, R.id.find_aomen, R.id.find_collect, R.id.find_zhekou, R.id.find_shangchang, R.id.find_yule, R.id.find_food, R.id.find_clean, R.id.find_update, R.id.find_tuisong, R.id.find_yijian, R.id.im_tuichu_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_user:
                //更换头像
                if (sp.getString("username", "").equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    StartActivityUtil.startAct(getActivity(), ChangeHeadImgActivity.class);
                }

                break;
            case R.id.find_aomen:
                startActivity(new Intent(getActivity(), MacaoActivity.class));
                break;
            case R.id.find_collect:
                //我的收藏
                if (sp.getString("username", "").equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(getActivity(), MyCollectActivity.class));
                }
                break;
            case R.id.find_zhekou:

                startActivity(new Intent(getActivity(), FindZheKouActivity.class));

                break;
            case R.id.find_shangchang:
                startActivity(new Intent(getActivity(), FindMarketActivity.class));
                break;
            case R.id.find_yule:
                startActivity(new Intent(getActivity(), FindPlayActivity.class));
                break;
            case R.id.find_food:
                startActivity(new Intent(getActivity(), FindFoodActivity.class));
                break;
            case R.id.find_clean:
                try {
                    AlertDialog dialog = new AlertDialog.Builder(getActivity()).setTitle("提示").setMessage("是否清除当前" + DataCleanManagerUtil.getTotalCacheSize(getActivity()) + "缓存数据").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DataCleanManagerUtil.clearAllCache(getActivity());
                            dialog.dismiss();
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
                    dialog.setCanceledOnTouchOutside(false);
                } catch (Exception e) {

                }
                break;
            case R.id.find_update:
               BaseDialogUtil.waitingDialog(getActivity(), "Code:1.0.0", "检测更新中. . . . . .", new BaseDialogUtil.waitingDialogListener() {
                   @Override
                   public void waitDiaCancle(final ProgressDialog waitDialog) {
                       de=new DelayedTaskUtil() {
                           @Override
                           public void onPostExecute() {
                               waitDialog.cancel();
                               Toast.makeText(getActivity(),"当前已是最新版本",Toast.LENGTH_SHORT).show();
                           }
                       };
                       de.delayRun(3000);
                   }
               });
                break;

            case R.id.find_tuisong:
                if (sp.getString("username", "").equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent hao = new Intent(getActivity(), TuiSongSheZhiActivity.class);
                    startActivity(hao);
                }
                break;

            case R.id.find_yijian:
                if (sp.getString("username", "").equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent hao = new Intent(getActivity(), YiJianActivity.class);
                    startActivity(hao);
                }
                break;
            case R.id.im_tuichu_login:
                String title = "提示";
                String msg = "是否退出当前账户";

                //普通2个选项AlertDialog
                BaseDialogUtil.normalDialog(getActivity(), title, msg, new BaseDialogUtil.ShowDialogListener() {
                    @Override
                    public void Positive() {
                        //点击确定后的事件

                        if (sp.getString("username", "").equals("")) {
                            Toast.makeText(getActivity(), "未登录任何账号", Toast.LENGTH_SHORT).show();
                        } else {
                            ed = sp.edit();
                            ed.remove("username");
                            ed.commit();
                            sp = getActivity().getSharedPreferences("mobuser", 0);
                            String yonghu = sp.getString("username", "");
                            if (sp.getString("username", "").equals("")) {
                                tvDenglu.setVisibility(View.VISIBLE);
                                tvUserName.setText("未登录");
                                imUser.setBackgroundResource(R.mipmap.change_head);
                            } else {
                                tvDenglu.setVisibility(View.GONE);
                                tvUserName.setText(sp.getString("username", ""));

                            }
                        }
                    }


                    @Override
                    public void Negative() {
                        //点击取消后的事件


                    }
                });
                break;
        }
    }
}
