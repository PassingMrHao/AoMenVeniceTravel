package mrhao.com.aomentravel.myFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.myActivity.AllMaCaoJDActivity;
import mrhao.com.aomentravel.myActivity.ChuYouMaCaoAct.ChuYou_LongAct;
import mrhao.com.aomentravel.myActivity.ChuYouMaCaoAct.ChuYou_dsbAct;
import mrhao.com.aomentravel.myActivity.ChuYouMaCaoAct.ChuYou_guanyejieAct;
import mrhao.com.aomentravel.myActivity.ChuYouMaCaoAct.ChuYou_mgmAct;
import mrhao.com.aomentravel.myActivity.ChuYouMaCaoAct.ChuYou_pujingAct;
import mrhao.com.aomentravel.myActivity.ChuYouMaCaoAct.ChuYou_shuiwujianAct;
import mrhao.com.aomentravel.myActivity.ChuYouMaCaoAct.ChuYou_wnsAct;
import mrhao.com.aomentravel.myActivity.MacaoSearchActivity;
import mrhao.com.aomentravel.myActivity.MacaoTravelDetailsActivity;
import mrhao.com.aomentravel.myAdapter.ChuYouMacaoAdapter;
import mrhao.com.aomentravel.myAdapter.MaCaoJingDian10Ad;
import mrhao.com.aomentravel.utils.GlideApp;


public class NewTravelFragment extends Fragment {


    /**
     * 澳门8景用图
     * <p>
     * 澳门友谊大桥   http://img8.zol.com.cn/bbs/upload/17392/17391672.jpg
     * 妈阁庙： http://m.chanyouji.cn/attractions/4235.jpg
     * 大三巴： http://n3-q.mafengwo.net/s8/M00/F1/1E/wKgBpVWiLnaAC1-cAA21442UzLk18.jpeg?imageView2%2F2%2Fw%2F1360%2Fq%2F90
     * 东望洋炮台：  http://m.chanyouji.cn/attractions/4211.jpg
     * 龙环葡韵：   http://m.chanyouji.cn/attractions/4273.jpg
     * 黑沙海滩： https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539248071738&di=f2effe0d8e6d85178d1f5c711575e8ea&imgtype=0&src=http%3A%2F%2Fimg8.3lian.com%2Fychatu%2Fa%2F11%2F530670.jpg
     */


    Unbinder unbinder;
    @BindView(R.id.linlay_search)
    LinearLayout linlaySearch;
    @BindView(R.id.aomenjingdian_10)
    RecyclerView aomenjingdian10;


    MaCaoJingDian10Ad ad;
    List<String> list_name = new ArrayList<>();
    List<String> list_tupian = new ArrayList<>();
    List<Integer> list_picnum = new ArrayList<>();
    List<Integer> list_youjinum = new ArrayList<>();
    List<Integer> list_travelId = new ArrayList<>();
    String[] jdname = {"大三巴牌坊", "妈阁庙", "澳门旅游塔", "大炮台", "官也街", "龙环葡韵", "威尼斯人", "新濠天地", "黑沙海滩", "岗顶剧院"};
    String[] jdpic = {
            "http://n3-q.mafengwo.net/s8/M00/F1/1E/wKgBpVWiLnaAC1-cAA21442UzLk18.jpeg?imageView2%2F2%2Fw%2F1360%2Fq%2F90",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539248919446&di=3f48adda882718d523c1d31dfa56def8&imgtype=0&src=http%3A%2F%2Fupload.ldnews.cn%2F2017%2F0420%2F1492677650898.jpeg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539247197492&di=29f13b4e268308b43525a2090b03ba87&imgtype=0&src=http%3A%2F%2Fmmbiz.qpic.cn%2Fmmbiz_png%2FKbhjnNHDAox80BNRw1IIurnFzALWQQO03wOSgv2ygqwJMiakoEXUlUicOB6ToVMtSBu9SfjiaVxdtsD2vTZWcPkVw%2F0.png%3F",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539247248230&di=c6f34bfec3fa3594afac13798e43a587&imgtype=0&src=http%3A%2F%2Fimg1.qunarzz.com%2Ftravel%2Fpoi%2F1409%2F17%2F582b026b6801bd68ffffffffc8d65eac.jpg_r_480x360x95_49655447.jpg",
            "http://b2-q.mafengwo.net/s8/M00/F8/97/wKgBpVWdHteANC1wAA1yNjf3-eQ88.jpeg?imageView2%2F2%2Fw%2F1360%2Fq%2F90",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539249005626&di=92edfbfb86ace47c23dc165411270d23&imgtype=0&src=http%3A%2F%2Fimg762.ph.126.net%2FpSwAUDd9aQRwA-BVfgZiXA%3D%3D%2F4881057571139743839.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539247742203&di=c4b82a19bac32d13421eb45f985c3e3f&imgtype=0&src=http%3A%2F%2Fmedia.china-sss.com%2Fpics%2F71d403e5-4fb7-44e7-b331-1fb5881384c4_201405151325_500_350.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539247878658&di=a3f68510485c3bc8c89680590e01f446&imgtype=0&src=http%3A%2F%2Fimg0.bimg.126.net%2Fphoto%2FFhZTkXKxxEkZMClYD4-26A%3D%3D%2F5746593124525394949.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539248071738&di=f2effe0d8e6d85178d1f5c711575e8ea&imgtype=0&src=http%3A%2F%2Fimg8.3lian.com%2Fychatu%2Fa%2F11%2F530670.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539248462778&di=3cffbfd70b6fa5ece141f0b7d3f8b9f3&imgtype=0&src=http%3A%2F%2Fdimg01.c-ctrip.com%2Fimages%2Ffd%2Ftg%2Fg3%2FM05%2F98%2F84%2FCggYGlaiKZSAGwNBAATZCcPRVcM432_R_1024_10000.jpg"
    };

    int[] picnum = {2862, 402, 568, 629, 1172, 491, 4517, 356, 172, 118};
    int[] youjinum = {441, 85, 80, 126, 145, 61, 436, 54, 27, 27};
    int[] travelsId = {4207, 4235, 4205, 4237, 4240, 4273, 4203, 4253, 10231, 10236};
    @BindView(R.id.bajing_mgm)
    ImageView bajingMgm;
    @BindView(R.id.bajing_dasanba)
    ImageView bajingDasanba;
    @BindView(R.id.bajing_dwy)
    ImageView bajingDwy;
    @BindView(R.id.bajing_long)
    ImageView bajingLong;
    @BindView(R.id.bajing_heisha)
    ImageView bajingHeisha;
    boolean bj1, bj2, bj3, bj4, bj5, bj6, bj7, bj8;
    @BindView(R.id.frabajing1)
    FrameLayout frabajing1;
    @BindView(R.id.laybajing1)
    LinearLayout laybajing1;
    @BindView(R.id.frabajing2)
    FrameLayout frabajing2;
    @BindView(R.id.laybajing2)
    LinearLayout laybajing2;
    @BindView(R.id.frabajing3)
    FrameLayout frabajing3;
    @BindView(R.id.laybajing3)
    LinearLayout laybajing3;
    @BindView(R.id.frabajing4)
    FrameLayout frabajing4;
    @BindView(R.id.laybajing4)
    LinearLayout laybajing4;
    @BindView(R.id.frabajing5)
    FrameLayout frabajing5;
    @BindView(R.id.laybajing5)
    LinearLayout laybajing5;
    @BindView(R.id.frabajing6)
    FrameLayout frabajing6;
    @BindView(R.id.laybajing6)
    LinearLayout laybajing6;
    @BindView(R.id.frabajing7)
    FrameLayout frabajing7;
    @BindView(R.id.laybajing7)
    LinearLayout laybajing7;
    @BindView(R.id.frabajing8)
    FrameLayout frabajing8;
    @BindView(R.id.laybajing8)
    LinearLayout laybajing8;
    @BindView(R.id.layxg_mgm)
    LinearLayout layxgMgm;
    @BindView(R.id.layxg_dasanba)
    LinearLayout layxgDasanba;
    @BindView(R.id.layxg_dwy)
    LinearLayout layxgDwy;
    @BindView(R.id.layxg_long)
    LinearLayout layxgLong;
    @BindView(R.id.layxg_heisha)
    LinearLayout layxgHeisha;

    @BindView(R.id.chuyoumacao)
    RecyclerView chuyoumacao;
    List<String> pic_title = new ArrayList<>();
    List<String> pic_url = new ArrayList<>();
    List<Class> actlist = new ArrayList<>();
    ChuYouMacaoAdapter chuyouAd;

    String[] chuyoutitle = {"妈阁庙", "大三巴牌坊", "葡京娱乐场", "官也街", "龙环葡韵", "威尼斯人", "新濠天地-水舞间表演"};
    String[] chuyoupic = {
            "http://p4-q.mafengwo.net/s7/M00/90/B6/wKgB6lS25-yAPiE6AAZ0JUIP5bk14.jpeg?imageView2%2F2%2Fw%2F1360%2Fq%2F90",
            "http://n3-q.mafengwo.net/s8/M00/F1/1E/wKgBpVWiLnaAC1-cAA21442UzLk18.jpeg?imageView2%2F2%2Fw%2F1360%2Fq%2F90",
            "http://b2-q.mafengwo.net/s7/M00/5A/6E/wKgB6lSU7piAAu_EAApZZV7jukU70.jpeg?imageView2%2F2%2Fw%2F1360%2Fq%2F90",
            "http://b2-q.mafengwo.net/s8/M00/F8/97/wKgBpVWdHteANC1wAA1yNjf3-eQ88.jpeg?imageView2%2F2%2Fw%2F1360%2Fq%2F90",
            "http://p4-q.mafengwo.net/s8/M00/32/19/wKgBpVUKz7iABFUrAAsKZsDTX_U38.jpeg?imageView2%2F2%2Fw%2F1360%2Fq%2F90",
            "http://n2-q.mafengwo.net/s7/M00/74/9B/wKgB6lSVCB6AOR9SAA9TBa40Fsg07.jpeg?imageView2%2F2%2Fw%2F1360%2Fq%2F90",
            "https://pic1.qyer.com/album/user/2294/94/Q0tcRhMDY0k/index?imageMogr2/auto-orient/thumbnail/1360x/format/webp"
    };
    Class[] chuyouact = {ChuYou_mgmAct.class, ChuYou_dsbAct.class, ChuYou_pujingAct.class, ChuYou_guanyejieAct.class, ChuYou_LongAct.class, ChuYou_wnsAct.class, ChuYou_shuiwujianAct.class};
    @BindView(R.id.linlay_alljingdian)
    LinearLayout linlayAlljingdian;
    @BindView(R.id.bajing_yyq)
    ImageView bajingYyq;
    @BindView(R.id.layxg_yyq)
    LinearLayout layxgYyq;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_travel, container, false);
        unbinder = ButterKnife.bind(this, view);
        setBaseClickEvent();
        return view;

    }

    private void setBaseClickEvent() {

        //澳门所有景点
        linlayAlljingdian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AllMaCaoJDActivity.class));
            }
        });


        //初游澳门必去景点

        LinearLayoutManager linlayman2 = new LinearLayoutManager(getActivity());
        linlayman2.setOrientation(LinearLayoutManager.HORIZONTAL);
        chuyoumacao.setLayoutManager(linlayman2);
        AddDateToChuYouMacao();
        chuyouAd = new ChuYouMacaoAdapter(getActivity(), pic_title, pic_url, actlist);
        chuyoumacao.setAdapter(chuyouAd);


        GlideApp.with(getActivity()).load("http://img8.zol.com.cn/bbs/upload/17392/17391672.jpg").override(600,360).into(bajingYyq);
        GlideApp.with(getActivity()).load("http://m.chanyouji.cn/attractions/4235.jpg").override(600,360).into(bajingMgm);
        GlideApp.with(getActivity()).load("http://n3-q.mafengwo.net/s8/M00/F1/1E/wKgBpVWiLnaAC1-cAA21442UzLk18.jpeg?imageView2%2F2%2Fw%2F1360%2Fq%2F90").override(600,360).into(bajingDasanba);
        GlideApp.with(getActivity()).load("http://m.chanyouji.cn/attractions/4211.jpg").override(600,360).into(bajingDwy);
        GlideApp.with(getActivity()).load("http://m.chanyouji.cn/attractions/4273.jpg").override(600,360).into(bajingLong);
        GlideApp.with(getActivity()).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539248071738&di=f2effe0d8e6d85178d1f5c711575e8ea&imgtype=0&src=http%3A%2F%2Fimg8.3lian.com%2Fychatu%2Fa%2F11%2F530670.jpg").override(600,360).into(bajingHeisha);
        bj1 = false;
        bj2 = false;
        bj3 = false;
        bj4 = false;
        bj5 = false;
        bj6 = false;
        bj7 = false;
        bj8 = false;

        frabajing1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bj1 == false) {
                    bj1 = true;
                    laybajing1.setVisibility(View.VISIBLE);
                } else if (bj1 == true) {
                    bj1 = false;
                    laybajing1.setVisibility(View.GONE);
                }
            }
        });


        frabajing2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bj2 == false) {
                    bj2 = true;
                    laybajing2.setVisibility(View.VISIBLE);
                } else if (bj2 == true) {
                    bj2 = false;
                    laybajing2.setVisibility(View.GONE);
                }
            }
        });

        frabajing3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bj3 == false) {
                    bj3 = true;
                    laybajing3.setVisibility(View.VISIBLE);
                } else if (bj3 == true) {
                    bj3 = false;
                    laybajing3.setVisibility(View.GONE);
                }

            }
        });

        frabajing4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bj4 == false) {
                    bj4 = true;
                    laybajing4.setVisibility(View.VISIBLE);
                } else if (bj4 == true) {
                    bj4 = false;
                    laybajing4.setVisibility(View.GONE);
                }

            }
        });

        frabajing5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bj5 == false) {
                    bj5 = true;
                    laybajing5.setVisibility(View.VISIBLE);
                } else if (bj5 == true) {
                    bj5 = false;
                    laybajing5.setVisibility(View.GONE);
                }

            }
        });

        frabajing6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bj6 == false) {
                    bj6 = true;
                    laybajing6.setVisibility(View.VISIBLE);
                } else if (bj6 == true) {
                    bj6 = false;
                    laybajing6.setVisibility(View.GONE);
                }

            }
        });

        frabajing7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bj7 == false) {
                    bj7 = true;
                    laybajing7.setVisibility(View.VISIBLE);
                } else if (bj7 == true) {
                    bj7 = false;
                    laybajing7.setVisibility(View.GONE);
                }

            }
        });

        frabajing8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bj8 == false) {
                    bj8 = true;
                    laybajing8.setVisibility(View.VISIBLE);
                } else if (bj8 == true) {
                    bj8 = false;
                    laybajing8.setVisibility(View.GONE);
                }

            }
        });


        layxgMgm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(getActivity(), MacaoTravelDetailsActivity.class);
                Bundle b = new Bundle();
                b.putString("jingdianurl", "http://jk.kingtrunk.com/index.php/Home/Index/getInfo?id=4235");
                hao.putExtras(b);
                startActivity(hao);
            }
        });

        layxgDasanba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(getActivity(), MacaoTravelDetailsActivity.class);
                Bundle b = new Bundle();
                b.putString("jingdianurl", "http://jk.kingtrunk.com/index.php/Home/Index/getInfo?id=4207");
                hao.putExtras(b);
                startActivity(hao);
            }
        });

        layxgDwy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(getActivity(), MacaoTravelDetailsActivity.class);
                Bundle b = new Bundle();
                b.putString("jingdianurl", "http://jk.kingtrunk.com/index.php/Home/Index/getInfo?id=4211");
                hao.putExtras(b);
                startActivity(hao);
            }
        });

        layxgLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(getActivity(), MacaoTravelDetailsActivity.class);
                Bundle b = new Bundle();
                b.putString("jingdianurl", "http://jk.kingtrunk.com/index.php/Home/Index/getInfo?id=4273");
                hao.putExtras(b);
                startActivity(hao);
            }
        });

        layxgHeisha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(getActivity(), MacaoTravelDetailsActivity.class);
                Bundle b = new Bundle();
                b.putString("jingdianurl", "http://jk.kingtrunk.com/index.php/Home/Index/getInfo?id=10231");
                hao.putExtras(b);
                startActivity(hao);
            }
        });
        layxgYyq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(getActivity(), MacaoTravelDetailsActivity.class);
                Bundle b = new Bundle();
                b.putString("jingdianurl", "http://jk.kingtrunk.com/index.php/Home/Index/getInfo?id=161735");
                hao.putExtras(b);
                startActivity(hao);
            }
        });


        linlaySearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MacaoSearchActivity.class));
            }
        });


        LinearLayoutManager linlayman = new LinearLayoutManager(getActivity());
        linlayman.setOrientation(LinearLayoutManager.HORIZONTAL);
        aomenjingdian10.setLayoutManager(linlayman);
        AddDateToTenJingDian();
        ad = new MaCaoJingDian10Ad(getActivity(), list_name, list_tupian, list_picnum, list_youjinum, list_travelId);
        aomenjingdian10.setAdapter(ad);

    }

    private void AddDateToChuYouMacao() {
        for (int i = 0; i < chuyoutitle.length; i++) {
            pic_title.add(chuyoutitle[i]);
        }
        for (int i = 0; i < chuyoupic.length; i++) {
            pic_url.add(chuyoupic[i]);
        }
        for (int i = 0; i < chuyouact.length; i++) {
            actlist.add(chuyouact[i]);
        }

    }


    private void AddDateToTenJingDian() {
        for (int i = 0; i < jdname.length; i++) {
            list_name.add(jdname[i]);
        }
        for (int i = 0; i < jdpic.length; i++) {
            list_tupian.add(jdpic[i]);
        }

        for (int i = 0; i < picnum.length; i++) {
            list_picnum.add(picnum[i]);
        }

        for (int i = 0; i < youjinum.length; i++) {
            list_youjinum.add(youjinum[i]);
        }
        for (int i = 0; i < travelsId.length; i++) {
            list_travelId.add(travelsId[i]);
        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
