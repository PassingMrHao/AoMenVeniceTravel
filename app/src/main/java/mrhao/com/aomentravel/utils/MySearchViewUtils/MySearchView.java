package mrhao.com.aomentravel.utils.MySearchViewUtils;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.SearchDateBean;
import mrhao.com.aomentravel.myAdapter.RecyResultAd;


public class MySearchView extends LinearLayout {

    /**
     * 初始化成员变量
     */
    private Context context;

    //搜索结果展示
    RecyclerView recyResult;
    RecyResultAd Ad;
    SearchDateBean searchbean = new SearchDateBean();
    SearchDateBean searchbean2 = new SearchDateBean();
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10;


    // 搜索框组件
    private EditText et_search; // 输入框搜索按键
    private TextView tv_clear;  // 删除搜索记录按键
    private LinearLayout search_block; // 搜索框布局
    private Button btn_sousuo; // 搜索按钮
    private LinearLayout linhis; // 搜索历史
    private RelativeLayout laynores;// 无搜索结果


    // ListView列表 & 适配器
    private SearchListView listView;
    private BaseAdapter adapter;

    // 数据库变量
    // 用于存放历史搜索记录
    private RecordSQLiteOpenHelper helper;
    private SQLiteDatabase db;

    // 回调接口
    private ICallBack mCallBack;// 搜索按键回调接口


    // 自定义属性设置
    // 1. 搜索字体属性设置：大小、颜色 & 默认提示
    private Float textSizeSearch;
    private int textColorSearch;
    private String textHintSearch;

    // 2. 搜索框设置：高度 & 颜色
    private int searchBlockHeight;
    private int searchBlockColor;

    /**
     * 构造函数
     * 作用：对搜索框进行初始化
     */
    public MySearchView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public MySearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initAttrs(context, attrs); // ->>关注a
        init();// ->>关注b
    }

    public MySearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initAttrs(context, attrs);
        init();
    }

    /**
     * 关注a
     * 作用：初始化自定义属性
     */
    private void initAttrs(Context context, AttributeSet attrs) {

        // 控件资源名称
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Search_View);

        // 搜索框字体大小（dp）
        textSizeSearch = typedArray.getDimension(R.styleable.Search_View_textSizeSearch, 20);

        // 搜索框字体颜色（使用十六进制代码，如#333、#8e8e8e）
        int defaultColor = context.getResources().getColor(R.color.colorText); // 默认颜色 = 灰色
        textColorSearch = typedArray.getColor(R.styleable.Search_View_textColorSearch, defaultColor);

        // 搜索框提示内容（String）
        textHintSearch = typedArray.getString(R.styleable.Search_View_textHintSearch);

        // 搜索框高度
        searchBlockHeight = typedArray.getInteger(R.styleable.Search_View_searchBlockHeight, 150);

        // 搜索框颜色
        int defaultColor2 = context.getResources().getColor(R.color.colorDefault); // 默认颜色 = 白色
        searchBlockColor = typedArray.getColor(R.styleable.Search_View_searchBlockColor, defaultColor2);

        // 释放资源
        typedArray.recycle();
    }


    /**
     * 关注b
     * 作用：初始化搜索框
     */
    private void init() {

        // 1. 添加数据进搜索库，初始化UI组件->>关注c
        AddDate();
        initView();

        // 2. 实例化数据库SQLiteOpenHelper子类对象
        helper = new RecordSQLiteOpenHelper(context);

        // 3. 第1次进入时查询所有的历史搜索记录
        queryData("");


        /**
         * "清空搜索历史"按钮
         */
        tv_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 清空数据库->>关注2
                deleteData();
                // 模糊搜索空字符 = 显示所有的搜索历史（此时是没有搜索记录的）
                queryData("");
            }
        });


        /**
         * 监听输入键盘更换后的搜索按键
         * 调用时刻：点击键盘上的搜索键时
         */
        btn_sousuo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. 点击搜索按键后，根据输入的搜索字段进行查询
                // 注：由于此处需求会根据自身情况不同而不同，所以具体逻辑由开发者自己实现，此处仅留出接口

                searchbean2.getList().clear();
                searchbean2.getImglist().clear();
                searchbean2.getDesclist().clear();
                searchbean2.getTravelId().clear();
                String sss = et_search.getText().toString().trim();
                boolean issame = false;
                for (int p = 0; p < searchbean.getList().size(); p++) {
                    if (searchbean.getList().get(p).equals(sss)) {
                        issame = true;
                        searchbean2.getList().add(searchbean.getList().get(p));
                        searchbean2.getImglist().add(searchbean.getImglist().get(p));
                        searchbean2.getDesclist().add(searchbean.getDesclist().get(p));
                        searchbean2.getTravelId().add(searchbean.getTravelId().get(p));
                    }
                }
                if (issame == false) {

                    char c;
                    for (int i = 0; i < sss.length(); i++) {
                        c = sss.charAt(i);
                        for (int j = 0; j < searchbean.getList().size(); j++) {
                            if (searchbean.getList().get(j).contains(c + "")) {
                                searchbean2.getList().add(searchbean.getList().get(j));
                                searchbean2.getImglist().add(searchbean.getImglist().get(j));
                                searchbean2.getDesclist().add(searchbean.getDesclist().get(j));
                                searchbean2.getTravelId().add(searchbean.getTravelId().get(j));
                            }
                        }
                    }

                    LinkedHashSet<String> set = new LinkedHashSet<>(searchbean2.getList().size());
                    LinkedHashSet<String> set2 = new LinkedHashSet<>(searchbean2.getImglist().size());
                    LinkedHashSet<String> set3 = new LinkedHashSet<>(searchbean2.getDesclist().size());
                    LinkedHashSet<Integer> set4 = new LinkedHashSet<>(searchbean2.getTravelId().size());
                    set.addAll(searchbean2.getList());
                    set2.addAll(searchbean2.getImglist());
                    set3.addAll(searchbean2.getDesclist());
                    set4.addAll(searchbean2.getTravelId());
                    searchbean2.getList().clear();
                    searchbean2.getImglist().clear();
                    searchbean2.getDesclist().clear();
                    searchbean2.getTravelId().clear();

                    searchbean2.getList().addAll(set);
                    searchbean2.getImglist().addAll(set2);
                    searchbean2.getDesclist().addAll(set3);
                    searchbean2.getTravelId().addAll(set4);
                    if (searchbean2.getList().size() == 0) {
                        laynores.setVisibility(VISIBLE);
                    } else {
                        laynores.setVisibility(GONE);
                    }
                    recyResult.setLayoutManager(new LinearLayoutManager(context));
                    Ad = new RecyResultAd(context, searchbean2);
                    recyResult.setAdapter(Ad);


                } else if (issame == true) {

                    if (searchbean2.getList().size() == 0) {
                        laynores.setVisibility(VISIBLE);
                    } else {
                        laynores.setVisibility(GONE);
                    }
                    recyResult.setLayoutManager(new LinearLayoutManager(context));
                    Ad = new RecyResultAd(context, searchbean2);
                    recyResult.setAdapter(Ad);
                }

                if (et_search.getText().toString().trim().equals("")) {
                    Toast.makeText(context, "搜索内容为空，请输入要搜索的景点", Toast.LENGTH_SHORT).show();
                }
                if (!(mCallBack == null) && TextUtils.isEmpty(et_search.getText().toString()) && (!et_search.getText().toString().trim().equals(""))) {
                    //搜索事件监听
                    mCallBack.SearchAciton(et_search.getText().toString());

                }
//                    Toast.makeText(context, "需要搜索的是" + et_search.getText(), Toast.LENGTH_SHORT).show();

                // 2. 点击搜索键后，对该搜索字段在数据库是否存在进行检查（查询）->> 关注1

                boolean hasData = hasData(et_search.getText().toString().trim());
                // 3. 若存在，则不保存；若不存在，则将该搜索字段保存（插入）到数据库，并作为历史搜索记录
                if (!hasData) {
                    if (!et_search.getText().toString().trim().equals("")) {
                        insertData(et_search.getText().toString().trim());
                        queryData("");
                    }

                }


            }
        });


        /**
         * 监听输入键盘更换后的搜索按键
         * 调用时刻：点击键盘上的搜索键时
         */
        et_search.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {


                    searchbean2.getList().clear();
                    searchbean2.getImglist().clear();
                    searchbean2.getDesclist().clear();
                    searchbean2.getTravelId().clear();
                    String sss = et_search.getText().toString().trim();
                    boolean issame = false;
                    for (int p = 0; p < searchbean.getList().size(); p++) {
                        if (searchbean.getList().get(p).equals(sss)) {
                            issame = true;
                            searchbean2.getList().add(searchbean.getList().get(p));
                            searchbean2.getImglist().add(searchbean.getImglist().get(p));
                            searchbean2.getDesclist().add(searchbean.getDesclist().get(p));
                            searchbean2.getTravelId().add(searchbean.getTravelId().get(p));
                        }
                    }
                    if (issame == false) {

                        char c;
                        for (int i = 0; i < sss.length(); i++) {
                            c = sss.charAt(i);
                            for (int j = 0; j < searchbean.getList().size(); j++) {
                                if (searchbean.getList().get(j).contains(c + "")) {
                                    searchbean2.getList().add(searchbean.getList().get(j));
                                    searchbean2.getImglist().add(searchbean.getImglist().get(j));
                                    searchbean2.getDesclist().add(searchbean.getDesclist().get(j));
                                    searchbean2.getTravelId().add(searchbean.getTravelId().get(j));
                                }
                            }
                        }

                        LinkedHashSet<String> set = new LinkedHashSet<>(searchbean2.getList().size());
                        LinkedHashSet<String> set2 = new LinkedHashSet<>(searchbean2.getImglist().size());
                        LinkedHashSet<String> set3 = new LinkedHashSet<>(searchbean2.getDesclist().size());
                        LinkedHashSet<Integer> set4 = new LinkedHashSet<>(searchbean2.getTravelId().size());
                        set.addAll(searchbean2.getList());
                        set2.addAll(searchbean2.getImglist());
                        set3.addAll(searchbean2.getDesclist());
                        set4.addAll(searchbean2.getTravelId());
                        searchbean2.getList().clear();
                        searchbean2.getImglist().clear();
                        searchbean2.getDesclist().clear();
                        searchbean2.getTravelId().clear();
                        searchbean2.getList().addAll(set);
                        searchbean2.getImglist().addAll(set2);
                        searchbean2.getDesclist().addAll(set3);
                        searchbean2.getTravelId().addAll(set4);
                        if (searchbean2.getList().size() == 0) {
                            laynores.setVisibility(VISIBLE);
                        } else {
                            laynores.setVisibility(GONE);
                        }
                        recyResult.setLayoutManager(new LinearLayoutManager(context));
                        Ad = new RecyResultAd(context, searchbean2);
                        recyResult.setAdapter(Ad);


                    } else if (issame == true) {

                        if (searchbean2.getList().size() == 0) {
                            laynores.setVisibility(VISIBLE);
                        } else {
                            laynores.setVisibility(GONE);
                        }
                        recyResult.setLayoutManager(new LinearLayoutManager(context));
                        Ad = new RecyResultAd(context, searchbean2);
                        recyResult.setAdapter(Ad);
                    }

                    if (et_search.getText().toString().trim().equals("")) {
                        Toast.makeText(context, "搜索内容为空，请输入要搜索的景点", Toast.LENGTH_SHORT).show();
                    }
                    if (!(mCallBack == null) && TextUtils.isEmpty(et_search.getText().toString()) && (!et_search.getText().toString().trim().equals(""))) {
                        //搜索事件监听
                        mCallBack.SearchAciton(et_search.getText().toString());

                    }
//                    Toast.makeText(context, "需要搜索的是" + et_search.getText(), Toast.LENGTH_SHORT).show();

                    // 2. 点击搜索键后，对该搜索字段在数据库是否存在进行检查（查询）->> 关注1

                    boolean hasData = hasData(et_search.getText().toString().trim());
                    // 3. 若存在，则不保存；若不存在，则将该搜索字段保存（插入）到数据库，并作为历史搜索记录
                    if (!hasData) {
                        if (!et_search.getText().toString().trim().equals("")) {
                            insertData(et_search.getText().toString().trim());
                            queryData("");
                        }

                    }

                }
                return false;
            }
        });


        /**
         * 搜索框的文本变化实时监听
         */
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (TextUtils.isEmpty(et_search.getText().toString().trim())) {
                    searchbean2.getList().clear();
                    searchbean2.getImglist().clear();
                    searchbean2.getDesclist().clear();
                    Ad.notifyDataSetChanged();
                } else {

                }
            }

            // 输入文本后调用该方法
            @Override
            public void afterTextChanged(Editable s) {
                // 每次输入后，模糊查询数据库 & 显示
                // 注：若搜索框为空,则模糊搜索空字符 = 显示所有的搜索历史
                String tempName = et_search.getText().toString();
                queryData(tempName); // ->>关注1

            }
        });

        /**
         * 搜索记录列表（ListView）监听
         * 即当用户点击搜索历史里的字段后,会直接将结果当作搜索字段进行搜索
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // 获取用户点击列表里的文字,并自动填充到搜索框内
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                String name = textView.getText().toString();
                et_search.setText(name);

            }
        });
    }


    //添加数据进搜索库
    private void AddDate() {
        String[] jd_title = {
                "大三巴牌坊", "威尼斯人", "葡京娱乐场", "议事亭前地", "官也街", "澳门国际机场", "大炮台", "玫瑰圣母堂", "妈阁庙及其前地", "澳门旅游塔",//page=1
                "澳门博物馆", "民政总署大楼", "渔人码头", "银河赌场", "金沙城中心", "龙环葡韵", "新濠天地", "外港客运码头", "氹仔岛", "永利澳门度假村",//page=2
                "圣老楞佐堂", "主教座堂及前地", "玛嘉烈蛋挞", "金莲花广场", "黄枝记", "亚美打利庇卢大马路", "黑沙海滩", "岗顶剧院", "钜记手信", "大三巴哪吒庙",//page=3
                "仁慈堂博物馆", "亚婆井前地", "郑家大屋", "恋爱巷", "旧城墙遗址", "岗顶前地", "圣安东尼堂", "路环岛", "邮政局博物馆", "澳门特别行政区政府总部",//page=4
                "何东图书馆", "安德鲁饼店(威尼斯人)", "福隆新街", "新八佰伴", "圣若瑟修院及圣堂", "水舞间", "圣奥斯定教堂", "港务局大楼", "澳门美高梅", "大利来记咖啡室",//page=5
                "十月初五日街", "澳门友谊大桥", "诚昌饭店", "澳门科学馆", "莫义记", "卢家大屋", "澳门大学", "耶稣会纪念广场", "白鸽巢前地", "嘉谟圣母教堂",//page=6
                "安德鲁饼店", "板樟堂街及其前地", "南湾湖", "大赛车博物馆", "蕃茄屋葡式美食", "添发碗仔翅", "地堡街", "小飞象葡国餐厅", "盛记白粥", "海事博物馆",//page=7
                "手信博物馆", "妈阁街", "东望洋炮台和灯塔", "主教山", "圣方济各教堂", "东方基金会会址", "氹仔临时客运码头", "恒友（大堂店）", "公鸡葡国餐厅", "加思栏花园",//page=8
                "澳门佳作", "基督教公墓", "8餐厅", "潘荣记", "木偶葡国餐厅", "卖草地街", "葡萄酒博物馆", "星际酒店", "安德鲁花园咖啡", "营地大街",//page=9
                "艺术博物馆", "四季酒店DFS免税店", "三街会馆", "晃记饼家", "紫逸轩", "祥记面家", "新口岸葡国餐厅", "雅憩花园餐厅", "文化会馆", "大龙凤茶楼",//page=10
                "草堆街", "熊猫葡国餐厅", "果栏街", "陈胜记", "xin鲜", "礼记雪糕", "金龙酒店", "天巢法国餐厅", "永利轩", "新好利咖啡室",//page=11
                "九如坊葡萄牙餐厅", "陶陶居海鲜酒家", "沙度娜", "番茄屋", "鳳城珠記麵食專家", "龙华茶楼", "陆军俱乐部", "国华戏院商场", "澳门新桥永乐戏院", "回力娱乐城",//page=12
                "同益百花魁果子厂", "晶记饼家", "京花轩", "达荣鱼翅汤面", "船屋葡国餐厅", "海湾餐厅", "翅客", "Restaurante ESCADA", "九如坊", "南记煲仔饭",//page=13
                "远来饼家", "南洋小食", "张姐记", "发嫂养生磨房", "沛記咖啡室", "三元粥品专家", "新爽爽美食", "椿记", "光辉捞面", "波尔图",//page=14
                "雅香粉麵咖啡", "法兰度葡国餐厅", "阿露娜印度咖喱咖啡屋", "濠江志记美食店", "澳门旅游学院", "安东尼奥餐厅", "丹桂轩", "石歧佬", "西班牙烤鸡", "荣记豆腐面",//page=15
                "南洋粿條麵食店", "唐人街沾記泰式小廚", "成群小食", "柳家庄美食坊", "金马轮", "最香饼家", "绿宝酒廊", "奥斯卡酒吧", "MP3酒吧", "富都夜总会",//page=16
                "保健牛奶公司", "新鸿发咖啡", "鴻彬記小食店"//page=17
        };
        String[] jd_pic = {
                pc(4207), pc(4203), pc(4274), pc(4215), pc(4240), pc(155278), pc(4237), pc(4219), pc(4235), pc(4205),//page=1
                pc(4217), pc(4244), pc(13530), pc(4323), pc(4437), pc(4273), pc(4253), pc(4399), pc(13532), pc(155701),//page=2
                pc(10233), pc(10237), "http://m.chanyouji.cn/restaurants/311.jpg", pc(4416), "http://m.chanyouji.cn/attractions/restaurant.jpg", pc(4309), pc(10231), pc(10236), "http://m.chanyouji.cn/restaurants/312.jpg", pc(4321),//page=3
                pc(4331), pc(4360), pc(4251), pc(155225), pc(4296), pc(156008), pc(4381), pc(4214), pc(4246), pc(4333),//page=4
                pc(4334), "http://m.chanyouji.cn/restaurants/314.jpg", pc(4249), pc(158552), pc(156006), pc(4201), pc(10235), pc(4389), pc(162876), "http://m.chanyouji.cn/restaurants/309.jpg",//page=5
                pc(155995),"http://img8.zol.com.cn/bbs/upload/17392/17391672.jpg", "http://m.chanyouji.cn/restaurants/328.jpg", pc(4212), "http://m.chanyouji.cn/restaurants/317.jpg", pc(4268), pc(4294), pc(155984), pc(4300), pc(13533),//page=6
                pc(165250), pc(4262), pc(4439), pc(4213), "http://m.chanyouji.cn/attractions/restaurant.jpg", "http://m.chanyouji.cn/attractions/restaurant.jpg", pc(155223), pc(165254), pc(165256), pc(4238),//page=7
                pc(155996), pc(155997), pc(4211), pc(4271), pc(157373), pc(10241), pc(165706), "http://m.chanyouji.cn/restaurants/313.jpg", "http://m.chanyouji.cn/restaurants/321.jpg", pc(155999),//page=8
                pc(161732), pc(10242), "http://m.chanyouji.cn/restaurants/304.jpg", "http://m.chanyouji.cn/restaurants/315.jpg", "http://m.chanyouji.cn/restaurants/320.jpg", pc(156005), pc(4266), pc(165431), "http://m.chanyouji.cn/restaurants/316.jpg", pc(156002),//page=9
                pc(4270), pc(165563), pc(4310), pc(165692), "http://m.chanyouji.cn/restaurants/306.jpg", "http://m.chanyouji.cn/restaurants/310.jpg", pc(165456), "http://m.chanyouji.cn/restaurants/318.jpg", pc(155986), pc(165462),//page=10
                pc(155991), "http://m.chanyouji.cn/restaurants/326.jpg", pc(156004), pc(165232), pc(165236), pc(165274), "http://m.chanyouji.cn/attractions/165433-1.jpg", "http://m.chanyouji.cn/restaurants/302.jpg", "http://m.chanyouji.cn/restaurants/305.jpg", pc(165454),//page=11
                "http://m.chanyouji.cn/restaurants/325.jpg", pc(165463), pc(165466), pc(165217), pc(165475), pc(165228), pc(165237), pc(165852), "http://m.chanyouji.cn/attractions/restaurant.jpg", pc(165432),//page=12
                pc(165690), pc(165691), "http://m.chanyouji.cn/restaurants/303.jpg", "http://m.chanyouji.cn/restaurants/307.jpg", pc(165455), pc(165457), "http://m.chanyouji.cn/restaurants/319.jpg", pc(165458), pc(165459), pc(165460),//page=13
                pc(165461), pc(165464), pc(165465), pc(165467), pc(165468), pc(165469), pc(165470), pc(165471), pc(165473), pc(165218),//page=14
                pc(165474), pc(165220), pc(165229), pc(165231), pc(165238), pc(165242), pc(165262), pc(165263), pc(165267), pc(165272),//page=15
                pc(165278), pc(165280), pc(165282), pc(165284), "http://m.chanyouji.cn/attractions/restaurant.jpg", pc(165564), pc(165565), pc(165566), pc(165567), pc(165568),//page=16
                pc(165853), pc(165854), "http://m.chanyouji.cn/attractions/restaurant.jpg"//page=17

        };
        String[] jd_desc = {
                "位于炮台山下，是澳门最具代表性的“澳门八景”之一，为1580年殖民时期竣工的圣保禄大教堂的前壁。教堂的其他部分毁于两次火灾，只剩下了今天的大三巴牌坊。", "一个集酒吧、饮食、购物、住宿、娱乐于一体的度假村。这里大得足以容纳90架波音747客机，其规模更超越美国拉斯维加斯。其中包括3000多间豪华套房、30多家特色餐馆和600多家知名店铺。", "澳门最具规模，也是最老牌的博彩娱乐场，不过分为老葡京和新葡京，2间挨在一起遥遥相对。新葡京现在是澳门排名第三的赌场，场内设有多种博彩方式，不设入场券，可自由进入，但21岁以下不准进入。", "俗称“喷水池”，是澳门的4大广场之一，2005年作为澳门历史城区的部分，被列入世界文化遗产名录内。", "长约115米，宽约5米，是澳门首个行人专用区，也是著名的食街之一。街内不仅餐厅食肆林立，还有不少鸡仔饼、虾酱等特产饼食的手信店。", "澳门境内的唯一国际机场，航线以中国大陆、台湾和东南亚国家为主。", "大炮台坐落在大三巴牌坊侧，是澳门主要古迹之一。本建于公元1616年，为保护圣保禄教堂内的教师而兴建，并防范海盗，后转为军事设施区，是中国现存最古老的西式炮台建筑群之一。。", "是天主教教士初到澳门时设立，迄今已有400多年的历史。供奉的花地玛圣母，是葡萄牙人崇拜的神，圣堂内色彩缤纷，天花板上布满图案，彩色玻璃形状不一，油画和基督雕像尤其有名。", "澳门最著名的古迹之一，距今已有500多年历史。妈阁庙门前是澳门海岸线，是当地渔民作为上岸补给、歇息和祈福的地方。", "澳门著名的标志性建筑，总高度338米，是全球第10位的独立式观光塔，也是世界高塔联盟的成员之一。塔顶外围，只有1.8米宽，全程不设扶手。",//page=1

                "澳门博物馆坐落在大炮台山，是一个综合性博物馆，专门展示澳门历史和多元文化。", "原为一座中式亭楼建筑的议事厅，经多次重修，具明显的南欧建筑特色。为明朝政府宣读政府命令和作为中葡官员会面的场所，后成为葡萄牙人在澳门地方的政治心脏。", "邻近港澳码头，占地超过111，500平方米，集娱乐、购物、饮食、酒店、游艇码头及会展设施于一体。此处特色店铺林立，更有兰桂坊式的、欧式的餐厅酒吧。", "银河娱乐集团旗下的“澳门银河”综合度假城，是澳门近两年来开业（2011年）最大规模的综合休闲度假村之一。", "2012年4月11日才正式投入运作，中心包含零售、娱乐休闲、餐饮和住宿，酒店包括：康莱德酒店、假日酒店和喜来登酒店共5800间酒店房，100间品牌名店的购物中心和10万平方英尺的会议展览场地。", "全称是龙环葡韵住宅式博物馆，位于氹仔岛，是以海边马路的五幢葡萄牙式住宅为主的博物馆。而整个龙环葡韵景区包括龙环葡韵住宅式博物馆、嘉模教堂、氹仔图书馆、氹仔市政花园和十字花园。", "整个新濠天地设有3家高级酒店：皇冠度假城、HardRock和澳门君悦酒店。娱乐场设有550张赌桌和1350台角子机，设计较年轻，主要吸纳年轻一代的顾客。", "简称“外港码头”，俗称“港澳码头”或“新港澳码头”，位于澳门本岛海港前地，是澳门其中一个出入境口岸。有往返香港上环、尖沙咀、屯门、香港国际机场、中国广州南沙港、深圳福永及蛇口的客运航线。码头天台并设有直升机停机坪，提供往来港澳的直升机服务，航程大约为15分钟。", "氹仔位于澳门半岛南方约2.5公里处，西面与珠海市德小横琴岛隔海相望，人口7000多人。", "永利澳门度假村是亚洲首间拉斯维加斯式度假村，内设有酒店、赌场、名店街和会议中心等设施。度假村设置600间豪华客房，以及城中独一无二的音乐表演湖。中庭展示一棵前所未见的黄金吉祥树，配合揉合中国十二生肖与西方十二星座之雕塑最为有名。",//page=2

                "澳门最古老的三座教堂之一，又名风顺堂，教堂所在地是昔日的高尚住宅区。从天花板垂下的数个华丽的枝型大吊灯，这是教堂引以为傲的装饰。", "位于大堂前地，原本是一栋小型木造的建筑，始建于1567年，历史悠久，一直是澳门天主教的中枢。此景点在2005年7月列入世界遗产，成为中国第31处世界遗产。", "是安德鲁蛋挞的安德鲁先生老婆开的店，排队请赶早。隔壁店还有新鲜水果切块和果汁，性价比超高。", "澳门回归祖国的第一天，由中国国务院赠送的大型铸铜贴金雕塑“盛世莲花”。莲花是澳门特别行政区的区花，三层红色的基座寓意澳门三岛，是香港金紫荆广场的同类景点。", "开业逾半个世纪的面店，一直沿用竹升打面法，面质爽口弹牙，配上颗粒分明的虾籽，入口甘香、口感特别。曾在葡萄牙总统面前表演。", "是澳门中区的一条重要马路，全长620米，又称“新马路”。沿途经过多个景点如民政总署大楼和议事亭前地等世界文化遗产及十月初五街等手信街，是游客必到之处。", "黑沙海滩位于路环岛的东面，原名“大环”，是一片天然海滩，多当地人来这进行水上运动和观星，且被评为澳门的八景之一。", "位于岗顶前地的古老剧院，被认定为中国第一所西式剧院，2005年随澳门历史城区一并列入世界文化遗产名录。", "短短10年的经营，就是本地最大的糕饼店，也是最大的手信店。其实在澳门香港，在最繁华的景点、街道附近都能看到钜记饼家，甚至一条街两间铺。", "澳门现存两座哪吒庙之一，被视为中西文化和谐相处的象征，2005年成为澳门历史城区的一部份。",//page=3

                "仁慈堂博物馆所在的仁慈堂大楼始建于18世纪，在1905年才改建为现时模样。在2005年，以澳门历史城区的部分被列入世界文化遗产的名录内。", "位于澳门西望洋山北面的广场，由于周围的古旧建筑，故列为澳门建筑、历史和文化文物区。2005年，随澳门历史城区一并列入世界文化遗产名录内。", "葡国期称为文华大屋，为中国近代思想家郑观应的故居，与卢家大屋同属岭南风格民宅。", "沿大三巴牌坊右边走下去，有一条甚少人经过的小横巷，全长约50米，至今已有80年的历史。它已被划为行人专用区，是澳门的知名景点，曾在影视作品中多次出现，也是拍婚纱的好地点。", "大三巴和哪吒庙后的一道黄土墙，是澳门旧城城墙幸存的一部份，2005年作为澳门历史城区的一部分，被列入世界文化遗产名录内。", "岗顶前地古称磨盘山，虽然叫山，其实并不大。这块区域之所以有名是因为不少知名景点都坐落在这里，比如岗顶剧院、圣奥斯丁教堂、圣若瑟修道院和何东图书馆。", "澳门第一间小教堂，与圣老楞佐教堂、主教座堂合称为三大最古教堂。教堂内供奉的是圣安东尼，是葡萄牙人比较熟识的圣徒。", "路环岛，顾名思义是一条马路环绕着一个小岛，是澳门的一个离岛。", "位于新马路议事厅前地，具葡萄牙特色，是著名的地标。", "是澳门地标性的官方建筑物，其前身为澳门总督府，葡澳时期曾为澳门总督办公的地方。",//page=4

                "澳门最大的图书馆，楼高三层，是一座集历史、文化、建筑艺术于一体的楼宇。曾被香港富商何东爵士购入用作别墅并定居，是典型的花园式豪华住宅。于2005年，随澳门历史城区一并列入世界文化遗产名录内。", "要说最好吃的澳门葡挞，安德鲁绝对可以算是一家,它也是全澳门第一家葡式蛋挞店。他家出品的蛋挞皮酥脆，色泽诱人，挞心嫩滑，对葡式蛋挞的“声名远扬”功不可没，千里迢迢赶来的人络绎不绝。", "福隆新街是澳门半岛中区一条古老的街道，历史约有几百年。这里曾经是澳门博彩业的发祥地之一，但娼妓业最为有名，人称“花街”，也是迄今保存最完整的中国青楼建筑群。", "新八佰伴原为日本八佰伴(Yaohan)的澳门分店，1992年于友谊大马路开幕，成为全澳唯一的百货公司。新八佰伴也是澳门最受欢迎的大型购物商场，与“英皇”同一座建筑大楼，在关闸或者港澳码头换乘“英皇”的免费巴士下车就到。", "位于澳门岗顶前地的教堂，是中国罕见的巴洛克风格的建筑，2005年随澳门历史城区一并列入世界文化遗产名录。", "位于新濠天地，据说是总投资超过20亿港元的全球最大水上表演，经过了5年筹划和2年排练才得以和观众见面。", "澳门最古老的教堂之一，初建时用棕榈树叶作顶，风吹时似龙须飘飘，故昔日称龙须庙，后改成龙嵩庙，2005年作为澳门历史城区的部分被列入世界文化遗产名录内。", "位于妈阁山边，原为澳门港务局和水警稽查队的办公地点，现为政府部门的办公大楼，2005年随澳门历史城区一并列入世界文化遗产名录。", "澳门美高梅酒店位于澳门外港新填海区B区B2街区A地段，大堂天花的大型人工吹制玻璃花卉装饰令人惊艳，洋溢浓厚欧陆式建筑风格，正中的外墙乃参照里斯本的中央车站的设计，绝对是大型宴会的最佳场地。", "最有名的便是“猪扒包”，面包外脆内软，娇嫩可口。而且每日限量300个，下午才开卖。",//page=5

                "十月初五街，名称来自葡国的节日名，它是一条典形的澳门街道，位于澳门的政治中心地带，过去曾是澳门一条繁盛、有名的街道。", "连接澳门本岛与氹仔岛之间的跨海大桥，是三座大桥之中最靠东的一座，也是澳门三条大桥中最长的，总长3900米，又被称为“新澳氹大桥”。大桥直连拱北口岸与澳门国际机场，大部分前往机场搭机的游客都会经过。", "以水蟹粥闻名，网评甚好，当然也是人气高朋座无虚席，不过价格也是有点小贵，大约150澳门币一小份，不过需要提前问清的是一斤是否16两。", "澳门科学馆是澳门特别行政区政府投资及兴建的，金额达澳门币3.37多亿元，并且由建筑师贝聿铭设计。", "最有名的便是“榴莲雪糕”，即便是不爱榴莲，也可一试。再加上大菜糕和木槺布丁，可称“三样法宝”。", "大堂巷的卢家大屋，是澳门著名商人卢华绍家族的旧宅，内部融合了中西方装饰材料和手法，随澳门历史城区一并列入世界文化遗产名录。", "1981年成立的私立东亚大学，是澳门第一所现代大学，也是唯一的公立综合性大学。成立初年，大多学生来自香港，教学语言也以英文为主。", "耶稣会纪念广场，就是大三巴牌坊前的宽大的阶梯及连接了大三巴街、大三巴巷、大三巴右巷的斜坡街道构成。由于地处旅游热门地，又常有活动庆典，因此人头攒动，十分热闹。", "白鸽巢前地，是澳门圣安多尼堂区的广场，位于澳门半岛西北面，旧城区的北端。2005年开始，随澳门历史城区之一部份而被列入世界文化遗产名录内，为入选的8个古老广场之一。", "嘉谟圣母堂建于1885年，为方便凼仔教徒的宗教活动而建，是凼仔唯一的天主教堂。由于具有浓郁的欧陆风格，不仅成为澳门本地人举行婚礼的好去处，也成了旅游观光的热门地。",//page=6

                "安德鲁饼店是澳门一家著名的饼店，由英国人安德鲁（Andrew Stow）于1989年9月15日成立。澳门特别行政区政府将店主安德鲁评为澳门招牌蛋挞的创始人，饼店始创亚洲葡式蛋挞，亦有售卖欧式糕饼面包。", "板樟堂街除了鼎鼎有名的圣母玫瑰堂外，两旁还有很多典型的中式建筑。这些中式建筑昔日曾经是附近居民的住所，现已改建为特式商店，成为澳门旅游业的重要一环。", "筑堤而成，并非天然湖泊，故又称南湾人工湖，也是澳门境内最大的人工湖。", "为庆祝澳门格兰披治大赛40周年而兴建的博物馆，主要介绍澳门格兰披治大赛。大赛车博物馆位置于新口岸的旅游活动中心之内，与葡萄酒博物馆相邻。", "葡式餐厅，位置较偏僻，但是口味正宗、性价比极高，人均不到100元。招牌菜是咖喱崩沙牛腩以及薯丝马介休。", "碗仔翅的外型像鱼翅， 其實是一款以粉絲, 雞絲, 蛋絲等製成像翅的形狀， \"以假亂真\"的一款街頭平民美食。口感幼滑，風味很好，而且價錢不貴。", "位于氹仔岛上，是澳门著名的美食街，不远处就是龙环葡韵，环境非常舒服，是澳门相当有代表性的景点之一。", "澳门本地“小有名气”的餐厅。一楼贩卖糖果、酒之类的手信，二楼为餐厅，装潢简洁而不失温馨，店标小飞象很是讨人喜欢。出品全是经典葡国菜，炭烤牛肋骨肉嫩却入味，烤得恰到好处。", "盛记白粥，白粥很香滑，豆腐花很香很醇、入口即溶。咸肉粽形状和金字塔一样，糯米粒粒分明，淋上酱油，形象非常诱人，咬下去糯米不会太粘也不会太软，加上里面的猪肉很足料，太美味了。", "澳门历史最悠久的一间博物馆，对面就是妈阁庙。博物馆主要介绍各种海事活动，比如说南部的捕鱼方法、传统的渔船，以及葡国和中国的海事历史。",//page=7

                "澳门的钜记饼家于2009年筹设的一所有关手信纪念品的博物馆。", "是澳门半岛南部一个古老居住街，因妈阁庙得名。", "澳门八景之一，位于澳门半岛的最高点，是中国沿海地区的第一座灯塔，也是中国现存最古老的西式炮台建筑群之一。", "位于澳门半岛最高之一的西望洋山上，是一座向航海者保护神祈祷的小教堂。", "建于1938年，设计采取澳门主要教堂的巴洛克风格，外墙以奶白色为主，配以椭圆形的窗户和钟楼。", "东方基金会会址，现为澳门历史城区一部份，原是澳门葡国富商的别墅，后租给英国东印度公司，之后又改作贾梅士博物院，现为东方基金会会址。", "氹仔客运码头，又称北安码头。位于澳门氹仔新填海区，码头扩建后，预算提供来往澳门至香港、珠三角地区之高速客轮服务；同时码头天台亦设置直升机停机坪，提供来往港澳的直升机航班。", "澳门恒友鱼蛋先生是一家很不错的小吃店，供应品种较多，有全澳门最火的咖喱鱼蛋，在大三巴附近，常常看到本地人大排长龙。环境一般，服务员很热情。", "老字号的葡国餐馆，店铺装饰很有特色都是公鸡。葡国菜的招牌菜网评都不错，就是葡国鸡据说要等较久。", "历史悠久，是澳门首座极具欧陆风情的花园，位于葡京酒店附近的加思栏兵营前，又称南湾公园。",//page=8

                "澳门本地原创设计品牌，结合了多位本地艺术家的创意，发行深具本土特色的多元化商品。在本地的创作中择优取良，设计并制作出一系列的创意产品。", "澳门第一座基督教新教坟场，墓冢数十座，埋葬的多是来华的英国商人，鸦片战争在华身亡的英国将领和基督教传教教士。", "米其林2星，以精致、名贵的中菜为卖点，装修由擅长在设计中加中国元素的陈幼坚主持大局，而点心更是以造型别致闻名。", "澳门老字号，卖金钱饼的小吃店，采用纯手工制作工艺，使得每一块金钱饼的颜色都金黄金黄，蛋香浓郁，口感酥脆。除了即买即吃，还可以购买包装好的金钱饼带走，包装风格走七十年代复古路线。", "木偶餐厅毗邻威尼斯人酒店，在2009年才重建为一座仿消防局博物馆的欧式餐厅，餐厅主打地道正宗的葡国料理。", "卖草地街也是较有名的一条购物街，在板樟堂街转白马行前，左边沿路就是卖草地街。不长的街道上有数家独具特色的小店，出售首饰、衣物等，而一些冷饮店前更是大排长队。", "葡萄酒博物馆与大赛车博物馆一样，位于新口岸旅游活动中心，于1995年开放，主要介绍葡萄酒的场所。", "澳门星际酒店坐落于澳门核心博彩娱乐区——友谊大马路，楼高39层，是银河娱乐集团旗下首开星级娱乐酒店项目。豪华客房和套房，可俯瞰本澳的优美景色。", "安德鲁咖啡有两家，座位位置都比较窄，但人气超旺。一般西餐随便选，比如三文鱼、奶茶、葡挞等等，味道都很正。", "营地大街时澳门最古老的一条街道，曾是军队的扎营之地，后作为商业街道，和关前街、草堆街组成繁华的商业街区。",//page=9

                "澳门唯一一所艺术博物馆，馆内收藏中国书画、印章，西洋绘画，陶瓷，铜器等具收藏及研究价值之艺术品及文物，曾多次举行艺术品展览。", "DFS四季店聚集了众多海内外世界品牌，有时会有低至7折的优惠。共分为3个区域：时尚世界、奢华世界和美容世界。", "在澳门议事厅前地附近，虽然是关帝庙，但曾是澳门早期的商人会馆。", "晃記是澳門馳名的老餅店, 每次經過都會看到長長的人龍。店裡有多款著名的糕餅, 像肉切酥, 老婆餅等, 其中最受歡迎的是曾在電視節目裡被知名食家介紹過的肉切酥。", "连续3年米其林2星，作为米其林3星龙景轩的姐妹店紫逸轩，水准也不差啦！这里位置不多，建议提前预定。", "以手打竹升面起家，至今已有50多年的历史，被评为米其林三星小店。虾子捞面料足味美，不带虾腥，就连向来挑剔的著名美食家蔡澜先生也对这家的虾子面赞不绝口。。不过菜品都是小份装，除主食外，食量大的游客可能要点些小菜才能吃饱。", "已经营业多年的新口岸葡国餐厅，外表看来并不似已有十多年历史，餐厅每年都会进行翻新，店内的装饰挂画亦会不定期更换。葡国菜做得很“正”，在澳门来讲名列前茅，很多当地人光顾。", "就在老城区的教堂边，它家的马介休炒饭相当不错，量大味道一级棒。而且在电影《游龙戏凤》中也有出镜哟！", "文化会馆原为大型老当铺德成按，2002年文化局斥资百万，把部分修复成文化会馆，旨在保存及推广澳门的独特文化遗产。", "從大三巴前往大龍鳳茶樓大約需要15分鐘. 這間茶樓的最大特色是提供粵曲表演, 在下午特別時段光顧, 可以邊欣賞曲藝邊吃美味點心. 它是澳門現存的少有舊式茶樓之一。",//page=10

                "草堆街，曾与十月初五日街、营地大街、新马路构成澳门半岛最繁盛的商业街区。这里不仅有不少布匹成衣店，也是电器商店最集中的地方。", "氹仔岛上早期开办的葡国餐厅，堪称老字号。地方虽然不大，但环境不错。", "紧邻大三巴的果栏街是很有特色的一条小街，它连带附近的营地大街、草堆街、十月初五街等在内，是各种中国传统店铺的集中地。", "陈胜记是舌尖上的中国介绍的，澳门陈皮鸭必须尝一尝，况且还是2014新晋平民米其林，一直保持着自己的节奏和品质。陈胜记以传统粤菜和海鲜菜式出名，必尝的招牌菜陈皮鸭每天限量供应，入味又酥软，令人难忘。", "xin鲜作为火锅店成为2014又一家新晋米其林还真比较难得。店名就是xin鲜，意思为店里的食材全是最新鲜的。除了价格实惠的火锅自助之外，喜欢波士顿龙虾和日本和牛的朋友还可以点精选套餐，锅底有七种口味，午市还有烧味和点心。", "礼记雪糕冰饮专家是开了几十年的老店，整体的外貌和装潢还都是上世纪八九十年代的样子，三文治雪糕和雪糕砖是招牌，可以在这里体验老澳门的味道。", "澳门金龙酒店是一家国际四星级标准的豪华大酒店，邻近港澳码头、新八佰伴百货、回力娱乐场、金莲花广场、金沙赌场及将来主要旅游点渔人码头，娱乐优闲一应俱全，交通便利，人流众多而集中。", "位于澳门的天巢法国餐厅是澳门唯一的米其林三星餐厅，也是全澳门最高的餐厅，将澳门美景尽收眼底。这里的料理有创意却又不失经典，服务优质、还有超过8000种餐酒选择。", "米其林2星，供应不少失传的粤菜，装修充满艺术色彩，招牌菜有：雪影餐包、鲍鱼鸡粒酥……相比食物，网评服务态度要好过同样米其林2星的8餐厅。", "招牌蛋白燕窝挞，燕窝加入蛋挞中，清晰可见，味道清香又足料。可以堂食，亦可以外卖。",//page=11

                "以葡国菜闻名，据闻是前澳督府的御膳，招牌菜之一“烩马介休舌”，味道相当独特，而蔡澜更是推荐“木槺布丁”。", "陶陶居海鲜酒家是澳门有近70年历史的老店，早茶非常不错，点心精致味道正，很多澳门人也喜欢来这里早茶。", "有澳門最好的木糠布甸之美譽，提供多款價格廉宜的木糠布甸", "番茄屋，是传说澳门最便宜的正宗葡国餐厅，物美价廉，是家老店，各类葡式焗饭，量足且味赞。虽位置偏僻，藏于斜坡之上，却从开业至今都一直深受本地人欢迎。对于只吃味道不求情调的游客来说，蕃茄屋是个不错的选择。", "珠記是澳門的老字號, 很受本地居民和遊客歡迎, 最重要的是它的食物既美味, 又不會太貴, 著名的麵食都只是18元一碗。", "龙华茶楼Lung Wah Tea House是传统的广州茶楼，室内装饰充满了怀旧感，据说是澳门最后一家老式茶楼，茶水要自己倒、没有空调，老板居然还用算盘算账。食材新鲜，建议在早中午时间去品尝。", "格调很高的葡国菜，有dressing code，所有服务生都用英语，标准正餐的体验，专业的摆盘，餐具都很地道精致，按照上菜的顺序，会上不同的餐具，桌椅、装饰、服务都透着老派的讲究。", "国华戏院商场门口的香蕉糕是澳门特有的美食，又香价格又便宜，千万不可错过", "就是在永樂戲院門外有个無名攤檔，专卖碗仔翅. 這攤檔由一位老伯伯經營, 已有很多年歷史了, 澳門本來沒有這款美食, 全靠這位伯伯把它引入, 所以這個攤檔可說是澳門碗仔翅的始創! 碗仔翅以雞湯作湯底, 再加上雞肉, 粉絲, 雞蛋等, 口感幼滑, 風味很好", "回力的外观做的很像北京的水立方，2楼可以看限制级表演，有艳舞，同性，特技，以及现场爱情动作片。最后妹妹会来收小费，可以动手动脚。这种级别的表演目前澳门只有两家赌场还有，另外一家是金龙娱乐城的十八摸。",//page=12

                "同益百花魁果子廠是一間百年老字號涼果品牌，由1900年開業，是澳門涼果行中之翹楚。每粒蟠桃果都是由人手包装，多了一份人情味。想尝试怀旧凉果，可试试极受欢迎的王母蟠桃、白米醋、陈皮。", "晶記是澳門的老牌餅家, 他們的雞仔餅又咸又香又好吃, 風味和口感都是一流, 十分推介。", "永利酒店请来刘国柱大师和他的七位徒弟演绎中国北方美馔，除了鲁菜及川菜等经典名菜外，京花轩还带来清朝的官府菜—谭家菜。", "汤底材料用上了老鸡、火腿、猪骨、胡椒粒和陈皮熬制。", "很火爆的葡国菜餐厅。环境装修颇有几分异国情调。挂了葡萄牙国旗，走道上的门和大门都仿照船上的门装饰的圆拱门，比较矮， 外加桌子也排的很满，很有在船上小屋里吃饭的感觉。", "澳门海湾餐厅在澳门人心中的地位，有如香港的半岛般崇高。多少澳门高官，以此作为用膳场所。今天，虽然它的收费和服务对象都大众化了，但仍不减其尊贵的格调和一流的服务水准。", "福隆新街已被各种鱼翅店占领，旅游团也是扎堆在此。一定要走到清平街，找到这家老店。鱼翅加上白胡椒和醋，不贵又好吃。", "Restaurant ESCADA位于半岛新马路的大堂街，是家布置装潢非常有情调的葡国菜餐厅，柠檬炒蚬和焗鸭饭是这里的招牌餐点，连蔡澜都直呼好吃，餐厅也因此经常爆满。", "店主是首位澳督府华人御厨，曾为澳门总督厨房服务26年，深知葡国菜的精髓;其为历届总督烹制过美味佳肴，屡屡受到美食家的好评;坊间被人称为“葡督御厨”。", "黃昏六點以後才會營業. 這個攤檔已有四十年歷史了, 他們的煲仔飯在澳門非常出名, 很多人都特意前來試試. 煲仔飯採用瓦煲和碳爐煲製, 非常有風味!",//page=13

                "它的前身是遠來茶樓, 已有很多年歷史, 是老店中的名牌, 出品的糕餅品質向來都有保證, 很多澳門人嫁娶時都會光顧。", "南洋小食有多款色彩繽紛, 看得令人垂涎三尺的印尼糕點, 有些還是其他店舖少有出售的. 每一件糕點6元, 以份量來說並不大, 不算便宜, 但勝在有特色又好吃。", "張姐記是一間很有特色的食店, 他們的小吃很有家鄉風味, 而且價錢合理, 兩個人去吃下午茶, 點兩件點心, 一碗粥或甜品, 也不用二十元, 便已吃得很滿足了。", "所有糊類糖水都是即席在店裡的石磨磨出來的, 真材實料, 糕點不會太甜, 味道天然, 能吃出材料的鮮味, 有益健康。", "蛋糕很香, 配合合桃(核桃) , 口感非常好, 特別在新鮮出爐吃時更是香味四溢, 很贊。", "澳門有不少粥店, 三元是很多人都推薦必吃的知名老店, 位於福隆新街, 離新馬路很近。", "爽爽最著名的是肉丸和肉餅, 最大賣店是自制肉丸, 另外, 它的肉餅包也很有特色, 是在其他食店較少能吃到的。", "椿記售賣的以粥品為主, 價錢合理味道又好, 很受居民歡迎, 很多人都喜歡去吃晚飯或夜宵, 他們著名的美食有: 拆魚粥, 蘿蔔糕, 魚片粥, 各式腸粉等", "光輝以麵食著名, 它的撈麵(用醬油拌的麵)和湯麵都十分有水準, 平時一位難求. 推介他們的豬扒撈麵, 豬扒煎得很香, 配上獨特的醬汁, 撈起來十分好吃。", "波尔图，一家味道正宗的葡國餐廳, 位於氹仔的地堡街, 交通方便, 可以在官也街遊玩完後來這裡享用午飯或晚飯. 價錢合理, 菜式選擇亦多。",//page=14

                "雅香本身是間出名的食店, 很多旅遊書都介紹過了. 店裡貼滿了曾光顧的知名客人的照片, 連前香港特首曾蔭權也曾光顧呢! 他們售賣的是緬甸美食。", "在澳門的葡國餐廳中，法蘭度是出了名味道超正宗的，雖然位於較偏遠的黑沙海灘，但很多遊客都特意遠道而來。 其中必試的是燒乳豬，一般來說一個菜式約90-100多澳門幣，消費不便宜。", "Aruna's Indian Curry & Cafe House据说是澳门最正宗的印度餐厅之一，虽然名字叫咖啡屋，但提供的是印度菜，老外同事强烈推荐，餐厅装修比较简单，菜品选择不多，但却是正宗北印度家常菜，菜量很实在，味道很特别，适合重口略重的吃货。", "餐厅很小，简单装修，标准的街坊小店，人情味很浓，食物很让人惊艳。菜式应该属于粤菜，口味清鲜。", "澳门旅游学院自己的教学餐厅，厨师是专业级别的，服务非常好。菜式是澳门美食和葡国菜，吃完饭还可以在校园里兜一圈，是远离澳门赌场喧嚣，悠闲一日的好选择。", "安东尼奥是米其林年年推荐的，香港人去的很多。店内环境充满葡萄牙情调。餐厅推荐菜有：蜜糖橄榄油烤山羊芝士(口味非常特别)、招牌鸭肉焗饭等，配菜的澳门面包非常好吃。酒的品种很多，一杯葡萄酒大概是80-100澳门币。", "澳门星际酒店的丹桂轩，以明亮气派的白色大理石打造大厅，装潢融合中西风格，处处充满高雅的氛围，以传统粤菜为主，另提供粤式点心和巧手小菜，食材直接由内地进口。", "石歧佬是大三巴附近有当地人常去的茶餐厅，店的特色是份量多味道正价格不贵，人均50多港币，位于十月初五街上。", "西班牙烤鸡，由纯正的西班牙厨师操刀，店家为求做到贴近当地的口味， 就连烤鸡的烤炉，也特意从西班牙订购回来,除了烤鸡，也提供例如西班牙海鲜饭、西班牙薄饼及意粉，还有沙律及面包等。", "荣记豆腐面在官也街附近，招牌是豆腐面，豆腐本身真是超级嫩滑、入口即化，汤底也很好，基本是二三十元一份。",//page=15

                "南洋粿條麵食店位於下環，是來到澳門不可錯過的美食之一。豬雜粿條和生牛肉肉丸稞條是店裏招牌，外面總是有很多人在等位子，老闆娘相當有個性，服務態度並不好。", "唐人街沾記泰式小厨选址住宅区，光顾的主要是本地人，厨师伙计清一色泰国人，煮法跟足传统，香料亦从泰国入口，味道正宗。只是在烹饪上，稍微减轻辣度，使其更适合中国人的口味。價錢相對便宜，值得一試。", "“成群小食”在三盏灯圆地(旁边的路是圆形的中间有个空地)，不起眼的小店，却是澳门著名的缅甸风味小吃店。里面的鱼汤河粉和椰汁鸡面堪称一绝，店铺在comebuy奶茶店旁边。", "想来点烧烤，必须来柳家庄美食坊，烧烤味道实在是太好了。推荐孜然羊柳串，洋葱肥牛卷，英式咸牛肉船，蒜蓉包，炭烧三文魚皮，盐烧翠玉瓜。。", "金马轮是在议事厅前地附近转角处的一家老牌茶餐厅， 光荣榜茶餐厅之一。餐厅很小，所以常常需要等位。地道的茶餐厅水准，镇店的三宝，猪扒包、丝袜奶茶和酥皮蛋挞值得细细品味。其中尤以猪扒包最著名。", "最香饼家是澳门其中一家老字号饼家，铺面装修一般，但到现在仍坚持手工做饼", "绿宝酒廊(Green Spot)位于新世界帝濠酒店，由香港著名歌手玛利亚打理，每晚都有南非和古巴乐队驻唱，氛围很好。", "假日酒店奥斯卡酒吧晚上有菲律宾籍的乐队驻唱，演出时间是晚上9点到次日凌晨2点。晚上5点到9点间更有happy hour，酒水半价以及免费的特色小吃。", "MP3酒吧除了很棒的音乐和酒水以外，最大的卖点就是每晚都有火爆的钢管舞演出，DANCER除了亚洲脸，也有很多欧洲美女。舞台在酒吧的中心，圆桌和卡座围绕舞台摆放，每晚都有很多老外来此娱乐，人气很旺。", "富都夜总会是澳门排名第一的夜总会，价格也最贵，这里的公关小姐大部分都是内地过去的，而不是澳门当地人，服务态度在澳门算一流的。",//page=16

                "保健牛奶公司做的姜汁撞奶姜味浓郁、奶汁顺滑，仿佛在口中融化一般，价格又便宜。", "新鴻發的豬扒包煎得很香, 不會很油膩, 而麵包也烘得火候適中, 香香脆脆十分好吃。", "澳门最出名的牛杂店，這裡的汁料比其他店舖的遠遠惹味, 買一碗香噴噴的牛雜, 包括了牛肺、牛蒡、牛肚及牛腸等, 用料豐富, 牛雜都燜得很柔軟又入味, 實在是非常讚!"//page=17

        };

        int[] jd_Id = {

                4207, 4203, 4274, 4215, 4240, 155278, 4237, 4219, 4235, 4205, //page1
                4217, 4244, 13530, 4323, 4437, 4273, 4253, 4399, 13532, 155701, //page2
                10233, 10237, 160330, 4416, 161745, 4309, 10231, 10236, 160331, 4321, //page3
                4331, 4360, 4251, 155225, 4296, 156008, 4381, 4214, 4246, 4333, //page4
                4334, 160333, 4249, 158552, 156006, 4201, 10235, 4389, 162876, 160328, //page5
                155995, 161735, 160345, 4212, 160336, 4268, 4294, 155984, 4300, 13533, //page6
                165250, 4262, 4439, 4213, 161691, 164554, 155223, 165254, 165256, 4238, //page7
                155996, 155997, 4211, 4271, 157373, 10241, 165706, 160332, 160340, 155999, //page8
                161732, 10242, 160323, 160334, 160339, 156005, 4266, 165431, 160335, 156002, //page9
                4270, 165563, 4310, 165692, 160325, 160329, 165456, 160337, 155986, 165462, //page10
                155991, 160344, 156004, 165232, 165236, 165274, 165433, 160321, 160324, 165454, //page11
                160343, 165463, 165466, 165217, 165475, 165228, 165237, 165852, 10244, 165432, //page12
                165690, 165691, 160322, 160326, 165455, 165457, 160338, 165458, 165459, 165460, //page13
                165461, 165464, 165465, 165467, 165468, 165469, 165470, 165471, 165473, 165218, //page14
                165474, 165220, 165229, 165231, 165238, 165242, 165262, 165263, 165267, 165272, //page15
                165278, 165280, 165282, 165284, 165287, 165564, 165565, 165566, 165567, 165568, //page16
                165853, 165854, 165856 //page17
        };


        for (int i = 0; i < jd_title.length; i++) {
            searchbean.getList().add(jd_title[i]);
            searchbean.getImglist().add(jd_pic[i]);
            searchbean.getDesclist().add(jd_desc[i]);
            searchbean.getTravelId().add(jd_Id[i]);
        }
    }


    public String pc(int a) {
        return "http://m.chanyouji.cn/attractions/" + a + ".jpg";
//        return "http://m.chanyouji.cn/attractions/10236.jpg";
    }


    /**
     * 关注c：绑定搜索框xml视图
     */
    private void initView() {

        // 1. 绑定R.layout.search_layout作为搜索框的xml文件
        LayoutInflater.from(context).inflate(R.layout.mysearch_layout, this);

        // 2. 绑定搜索框EditText
        et_search = (EditText) findViewById(R.id.et_search);
        et_search.setTextSize(textSizeSearch);
        et_search.setTextColor(textColorSearch);
        et_search.setHint(textHintSearch);

        // 3. 搜索框背景颜色
        search_block = (LinearLayout) findViewById(R.id.search_block);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) search_block.getLayoutParams();
        params.height = searchBlockHeight;
        search_block.setBackgroundColor(searchBlockColor);
        search_block.setLayoutParams(params);

        // 4. 历史搜索记录 = ListView显示
        listView = (SearchListView) findViewById(R.id.listView);

        // 5. 删除历史搜索记录 按钮
        tv_clear = (TextView) findViewById(R.id.tv_clear);
        tv_clear.setVisibility(INVISIBLE);
        // 6. 搜索按钮
        btn_sousuo = (Button) findViewById(R.id.btn_sousuo);
        // 7. 搜索结果展示
        recyResult = (RecyclerView) findViewById(R.id.recy_result);
        recyResult.setNestedScrollingEnabled(false);
        // 8. 搜索历史
        linhis = (LinearLayout) findViewById(R.id.lin_history);
        linhis.setVisibility(INVISIBLE);
        // 9.无任何搜索结果
        laynores = (RelativeLayout) findViewById(R.id.relay_noresult);
        //10.热门搜索
        tv1 = (TextView) findViewById(R.id.tv_hot1);
        tv2 = (TextView) findViewById(R.id.tv_hot2);
        tv3 = (TextView) findViewById(R.id.tv_hot3);
        tv4 = (TextView) findViewById(R.id.tv_hot4);
        tv5 = (TextView) findViewById(R.id.tv_hot5);
        tv6 = (TextView) findViewById(R.id.tv_hot6);
        tv7 = (TextView) findViewById(R.id.tv_hot7);
        tv8 = (TextView) findViewById(R.id.tv_hot8);
        tv9 = (TextView) findViewById(R.id.tv_hot9);
        tv10 = (TextView) findViewById(R.id.tv_hot10);
        HotSearchText(tv1, "大三巴牌坊");
        HotSearchText(tv2, "澳门博物馆");
        HotSearchText(tv3, "妈阁庙");
        HotSearchText(tv4, "大炮台");
        HotSearchText(tv5, "澳门旅游塔");
        HotSearchText(tv6, "龙环葡韵");
        HotSearchText(tv7, "渔人码头");
        HotSearchText(tv8, "恋爱巷");
        HotSearchText(tv9, "官也街");
        HotSearchText(tv10, "新濠天地");


    }

    /**
     * 关注1
     * 模糊查询数据 & 显示到ListView列表上
     */
    private void queryData(String tempName) {

        // 1. 模糊搜索
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name like '%" + tempName + "%' order by id desc ", null);
        // 2. 创建adapter适配器对象 & 装入模糊搜索的结果
        adapter = new SimpleCursorAdapter(context, android.R.layout.simple_list_item_1, cursor, new String[]{"name"},
                new int[]{android.R.id.text1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        // 3. 设置适配器
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        System.out.println(cursor.getCount());
        // 当输入框为空 & 数据库中有搜索记录时，显示 "删除搜索记录"按钮
        if (tempName.equals("") && cursor.getCount() != 0) {
            tv_clear.setVisibility(VISIBLE);
            linhis.setVisibility(VISIBLE);
        } else {
            tv_clear.setVisibility(INVISIBLE);
            linhis.setVisibility(INVISIBLE);
        }
        ;

    }

    /**
     * 关注2：清空数据库
     */
    private void deleteData() {

        db = helper.getWritableDatabase();
        db.execSQL("delete from records");
        db.close();
        tv_clear.setVisibility(INVISIBLE);
        linhis.setVisibility(INVISIBLE);
    }

    /**
     * 关注3
     * 检查数据库中是否已经有该搜索记录
     */
    private boolean hasData(String tempName) {
        // 从数据库中Record表里找到name=tempName的id
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name =?", new String[]{tempName});
        //  判断是否有下一个
        return cursor.moveToNext();
    }

    /**
     * 关注4
     * 插入数据到数据库，即写入搜索字段到历史搜索记录
     */
    private void insertData(String tempName) {
        db = helper.getWritableDatabase();
        db.execSQL("insert into records(name) values('" + tempName + "')");
        db.close();
    }

    /**
     * 点击键盘中搜索键后的操作，用于接口回调
     */
    public void setOnClickSearch(ICallBack mCallBack) {
        this.mCallBack = mCallBack;

    }

    /**
     * 点击热门搜索关键字填充进搜索框
     */
    public void HotSearchText(TextView tv, final String hotname) {
        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                et_search.setText(hotname);
            }
        });
    }

}
