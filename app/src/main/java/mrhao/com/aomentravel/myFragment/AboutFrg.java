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
import butterknife.Unbinder;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.findActivity.TuiSongSheZhiActivity;
import mrhao.com.aomentravel.findActivity.WoDeAboutActivity;
import mrhao.com.aomentravel.findActivity.WoDeMsgActivity;
import mrhao.com.aomentravel.findActivity.YiJianActivity;
import mrhao.com.aomentravel.myActivity.ChangeHeadImgActivity;
import mrhao.com.aomentravel.myActivity.MobLoginActivity;
import mrhao.com.aomentravel.myActivity.MyCollectActivity;
import mrhao.com.aomentravel.utils.BaseDialogUtil;
import mrhao.com.aomentravel.utils.DataCleanManagerUtil;
import mrhao.com.aomentravel.utils.DelayedTaskUtil;
import mrhao.com.aomentravel.utils.StartActivityUtil;

public class AboutFrg extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.wode_collect)
    LinearLayout wodeCollect;
    @BindView(R.id.wode_clean)
    LinearLayout wodeClean;
    @BindView(R.id.wode_update)
    LinearLayout wodeUpdate;
    @BindView(R.id.wode_yijian)
    LinearLayout wodeYijian;
    @BindView(R.id.wode_tuisong)
    LinearLayout wodeTuisong;
    @BindView(R.id.wode_about)
    LinearLayout wodeAbout;
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    @BindView(R.id.wode_name)
    TextView wodeName;
    @BindView(R.id.wode_denglu)
    TextView wodeDenglu;
    DelayedTaskUtil de;
    @BindView(R.id.wode_tcdl)
    ImageView wodeTcdl;
    @BindView(R.id.wode_user)
    ImageView imUser;
    int headId = R.mipmap.jj_wdl;
    @BindView(R.id.wode_msg)
    ImageView wodeMsg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_frg, container, false);
        unbinder = ButterKnife.bind(this, view);
        setMenuClickEvent();
        return view;

    }

    private void setMenuClickEvent() {

        //我的信息
        wodeMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sp.getString("username", "").equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    StartActivityUtil.startAct(getActivity(), WoDeMsgActivity.class);
                }

            }
        });

        //更换用户头像
        imUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //更换头像
                if (sp.getString("username", "").equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    StartActivityUtil.startAct(getActivity(), ChangeHeadImgActivity.class);

                }

            }
        });


        //退出登录

        wodeTcdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
                            if (sp.getString("username", "").equals("")) {
                                wodeDenglu.setVisibility(View.VISIBLE);
                                wodeName.setVisibility(View.GONE);
                                ed.putInt("pic_id", sp.getInt("pic_id", R.mipmap.jj_wdl));
                                ed.commit();
                                imUser.setBackgroundResource(R.mipmap.jj_wdl);
                            } else {
                                wodeDenglu.setVisibility(View.GONE);
                                wodeName.setVisibility(View.VISIBLE);
                                wodeName.setText(sp.getString("username", ""));
                            }
                        }
                    }

                    @Override
                    public void Negative() {
                        //点击取消后的事件
                    }


                });
            }
        });

        //个人收藏
        wodeCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sp.getString("username", "").equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    getActivity().startActivity(new Intent(getActivity(), MyCollectActivity.class));
                }
            }
        });


        //清理缓存
        wodeClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    AlertDialog dialog = new AlertDialog.Builder(getActivity()).setTitle("提示").setMessage("是否清除当前" + DataCleanManagerUtil.getTotalCacheSize(getActivity()) + "缓存数据").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DataCleanManagerUtil.clearAllCache(getActivity());
                            dialog.dismiss();
                            Toast.makeText(getActivity(), "清理完成", Toast.LENGTH_SHORT).show();
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
            }
        });


        //检查更新
        wodeUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseDialogUtil.waitingDialog(getActivity(), "Code:1.0.0", "检测更新中. . . . . .", new BaseDialogUtil.waitingDialogListener() {
                    @Override
                    public void waitDiaCancle(final ProgressDialog waitDialog) {
                        de = new DelayedTaskUtil() {
                            @Override
                            public void onPostExecute() {
                                waitDialog.cancel();
                                Toast.makeText(getActivity(), "当前已是最新版本", Toast.LENGTH_SHORT).show();
                            }
                        };
                        de.delayRun(1580);
                    }
                });
            }
        });


        //意见反馈
        wodeYijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sp.getString("username", "").equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent hao = new Intent(getActivity(), YiJianActivity.class);
                    startActivity(hao);
                }
            }
        });


        //推送设置
        wodeTuisong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(getActivity(), TuiSongSheZhiActivity.class);
                startActivity(hao);
            }
        });


        //关于我们
        wodeAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartActivityUtil.startAct(getActivity(), WoDeAboutActivity.class);
            }
        });

        //
        wodeDenglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), MobLoginActivity.class));
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

        sp = getActivity().getSharedPreferences("mobuser", 0);
        if (sp.getString("username", "").equals("")) {
            wodeDenglu.setVisibility(View.VISIBLE);
            wodeName.setVisibility(View.GONE);
            imUser.setBackgroundResource(R.mipmap.jj_wdl);
        } else {
            wodeDenglu.setVisibility(View.GONE);
            wodeName.setVisibility(View.VISIBLE);
            wodeName.setText(sp.getString("username", ""));
            //获取头像
            headId = sp.getInt("pic_id", R.mipmap.jj_wdl);
            imUser.setImageBitmap(null);
            imUser.setBackgroundResource(headId);
        }

    }
}
