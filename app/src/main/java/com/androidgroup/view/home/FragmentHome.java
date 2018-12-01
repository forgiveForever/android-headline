package com.androidgroup.view.home;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidgroup.entity.NewInfo;
import com.androidgroup.NewsAdapter;
import com.androidgroup.R;
import com.androidgroup.database.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2018/10/18.
 */

public class FragmentHome extends Fragment{
    private MyDatabaseHelper myDatabaseHelper;
    private List<NewInfo> newsList=new ArrayList<>();
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_tab, container, false);
        myDatabaseHelper=new MyDatabaseHelper(getActivity());
        if(savedInstanceState==null){//第一次初始化

            init();//插入数据
        }
        readData();
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView_home);//传入数据到recyclerView组件
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        NewsAdapter newsAdapter=new NewsAdapter(newsList);
        recyclerView.setAdapter(newsAdapter);
        newsAdapter.setOnItemClickListener(new NewsAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent=new Intent(getActivity(),ActivityArticle.class);//传值给ActivityArticle
                Bundle bd=new Bundle();//通过bundle传值给ActivityArticle
                //bd.putInt("id",newsList.get(position).getId());
                bd.putString("article",newsList.get(position).getArticle());
                bd.putString("title",newsList.get(position).getTitle());
                bd.putString("author",newsList.get(position).getAuthor());
                bd.putString("pic",newsList.get(position).getPicSource());
                //intent.putExtra("news",(Serializable)newsList.get(position));//传对象
                intent.putExtras(bd);
                getActivity().startActivity(intent);
               // newsList.get(position);//传id到ActivityArticle进行查询
            }

            @Override
            public void onLongClick(int position) {

            }
        });
        return view;
    }

    //查询数据库
    public void readData(){
        String sql="select * from News";
        SQLiteDatabase db=myDatabaseHelper.getReadableDatabase();  //连接数据库，没有则创建
        Cursor cursor=db.rawQuery(sql,new String[]{});
        while(cursor.moveToNext()){
            String pic=cursor.getString(cursor.getColumnIndex("pic"));
            String title=cursor.getString(cursor.getColumnIndex("title"));
            String author=cursor.getString(cursor.getColumnIndex("author"));
            String comment=cursor.getString(cursor.getColumnIndex("comment"));
            String article=cursor.getString(cursor.getColumnIndex("article"));
            //int type=cursor.getInt(cursor.getColumnIndex("type"));
            NewInfo news=new NewInfo(title,pic,author,comment,article);//实例化NewInfo类并赋值
            newsList.add(news);
        }
        cursor.close();
    }

    //向news表中插入数据
    public void insertData(String title,String pic,String author,String comment,String article){
        SQLiteDatabase db=myDatabaseHelper.getWritableDatabase();//连接数据库，没有则创建
        ContentValues values=new ContentValues();//
        values.put("title",title);
        values.put("pic",pic);
        values.put("author",author);
        values.put("comment",comment);
        values.put("article",article);
        //values.put("type",type);
        db.insert("News",null,values);
        values.clear();
    }
    public void init(){
        insertData("台铁事故已致18死187伤 两位大陆籍旅客受伤","http://p9.pstatp.com/large/pgc-image/R77Wn8e2hKCkA6","人民日报","331评论",
                "截至22日清晨5时，台湾火车出轨事故已致18人死亡、187人受伤（全列车旅客366人）。根据台湾卫生主管部门整理伤者名单，两位大陆籍旅客受伤，其中44岁姚姓女乘客重伤。\n"+
                        "\n" +
                        "【新闻多一点】台铁列车事故：8节车厢全部出轨\n" +
                        "\n" +
                        "中国新闻网综合报道，台铁普悠玛列车21日下午发生出轨翻覆事故，列车8节车厢全部出轨。事发时许多人都在睡觉，根本来不及反应。目前事故原因正在调查中。\n" +
                        "\n" +
                        "事发前有多次异常急刹 8节车厢全部出轨\n" +
                        "\n" +
                        "据了解，21日下午4时50分，由新北树林开往台东的6432次普悠玛列车在宜兰新马车站附近的东正线发生出轨事故，列车8节车厢全部出轨，其中3节车厢翻覆最严重，分别为5、7、8节车厢。而整列车的车厢因受到严重挤压，呈现W形，画面触目惊心。\n" +
                        "\n" +
                        "目击现场的旅客表示，列车在还未到宜兰前，就曾有多次紧急刹车情况，没想到后来发生出轨翻覆事故。");
        insertData("揭秘甘肃原省委书记王三运家族腐败内幕","http://p3.pstatp.com/large/pgc-image/1540984816779b6cdd72b22","中国新闻周刊","255评论",
                "他只喝茅台，爱戴名表，讲话动情爱用排比句，喜欢唱歌是个“麦霸”，常说空话热衷形式主义，如今他以另一种形象黯然谢幕。\n" +
                        "\n" +
                        "10月11日，郑州市中级人民法院一审开庭审理了全国人大教育科学文化卫生委员会原副主任委员、甘肃原省委书记王三运受贿一案。检方指控其在1993年至2017年，为相关单位和个人在入股银行、工程承揽和职务晋升等事项上提供帮助，直接或通过特定关系人，非法收受上述单位和个人给予的财物，共计折合人民币6685万余元。\n" +
                        "\n" +
                        "中央纪委电视专题片《巡视利剑》中披露了王三运家族腐败细节。王三运出镜说，“我儿子和我两个外甥，他们到甘肃来搞什么业务，搞什么承揽工程。我那两个外甥，对我们家的帮助都非常大，经常给我们出钱装修房子，还给我们在贵阳买房子，这样实际上把这个关系就搞成一个相互利用关系了。”\n" +
                        "\n" +
                        "专题片披露，王三运先后担任过贵州、四川、安徽、福建四省的省委副书记，不少在这些地区和他联系密切的老板，在他任职甘肃省委书记后“尾随而来”，王三运也利用职权为他们在获取项目、通过审批等事项上提供帮助。\n" +
                        "\n" +
                        "“他们到甘肃来投资以后，也故意在炫耀跟我的关系好到什么程度。大家都知道这些人来自何方，跟我熟不熟悉，一看就知道。他们即便不找我，他们在那儿去找别的人，实际上也是利用我的影响，这样变花样想办法塞私货把这些问题解决。”王三运说。\n" +
                        "\n" +
                        "这些人依仗着这位父辈、亲友、故交的影响力，同样构建了一张张浸润着权力且错综复杂的利益网。");
        insertData("因果报应！特朗普的制裁大棒，这回打着了自己","http://p3.pstatp.com/large/pgc-image/R75LeXpAX8ZoLo.jpg","中国经济网新媒体","108评论",
                "出来混，总是要还的。最近，让特朗普头疼的事情着实不少。\n" +
                        "\n" +
                        "美国国内，美联储9月份货币政策会议纪要17日公布，明确表明美联储将继续加息进程，当日道琼斯指数以下跌90点结束交易，白宫和美联储继续上演互撕戏码。\n" +
                        "\n" +
                        "国际方面，中东重要盟友沙特深陷记者“失踪”案，霸屏全球媒体头条，涉嫌杀的还是为美国做事的《华盛顿邮报》专栏作者，制裁or不制裁，这是个问题。\n" +
                        "\n" +
                        "纵观全局，特朗普现在的处境，说白了都是自己“作”出来的。一言不合就制裁，没承想，大家都是记仇的。\n" +
                        "\n" +
                        "委内瑞拉16日宣布，将排除美元，采用人民币和欧元等货币开展外汇交易和结算。2017年以来，美国以“民主和人权”问题为由不断扩大对委经济和金融制裁。受此影响，与委政府和国内企业相关的美元账号交易受到严格限制，这使本就饱受通胀压力的委内瑞拉经济雪上加霜。面对越来越严厉的制裁，委内瑞拉终于奋起反抗，彻底抛弃了美元，以实际行动反击美国，维护国内金融和外汇交易稳定。");
        insertData("笑翻你!超搞笑的动态图","http://img.mp.sohu.com/upload/20170529/d988a3d940ce40fa98ebb7fd9d822fe2.png","当时我就震惊了","618评论",
                "爆笑笑话：小时候和爸爸一起去河里洗澡，开始我是不敢下水的，老爸说有他在没事，老爸在前面试着水的深浅，我小心翼翼的紧跟其后。突然脚下一滑，我立马抱着老爸的大腿，老爸用力一甩，把我甩了好远，河水喝的饱饱的。老爸把我捞起之后，拍着胸脯说：你他妈的吓死我了，我以为有水鬼拉我腿呢。\n" +
                        "\n" +
                        "爆笑笑话：我有个同学磊哥，外号毒舌。上学的时候，课上老师让磊哥准备个成语故事分享，极不情愿的磊哥于是讲了一个，《画蛇添足》：“从前有几个人得到了一壶酒，但是就不够分，于是有人提议比赛画蛇，谁先画好酒就归谁，大家都同意了。没想到提议的那个人最先把蛇画好，他见众人没有画好，仰天大笑，便提起酒壶给蛇画上了四肢，却因此输掉了比赛。下面有请发现蜥蜴物种的诺贝尔生物学奖获得者发表获奖感言......”我们：“。。。。”\n" +
                        "\n" +
                        "爆笑笑话：有一次在外面吃饭，刚在坐我旁边的是一对父女。她老爸把女儿喂好之后，女儿说要喝奶茶，她老爸就去买了。这个时候，我只看到小妹妹在她爸爸的碗里狂加辣椒。一直念叨着：“让你一直喂我，撑死了都！一定要辣死你。\n" +
                        "\n" +
                        "爆笑笑话：路过公园，一个角落摆摊看相的叫住我：“小姑娘面带财运，很快会有几十万出现在你面前！”我才不信，笑笑就走了，结果我刚出公园门口，就看到一辆运钞车开过……哇塞，大家说我要不要回去找他！！？");
        insertData("论文被导师当众撕毁，却获诺奖——一个天才少年，倒霉青年，彪悍中年的逗比终生","https://whb.cn/u/cms/www/201810/21145825ujj8.jpg","文汇网","108评论",
                "我们对夜空中神秘星体的许多了解，都要感谢一位伟大的天体物理学家——钱德拉塞卡，今天正是他诞辰 108 周年的日子。\n" +
                        "\n" +
                        "钱德拉塞卡破解了恒星的命运轨迹，自己的学术生涯却十分坎坷，其中最大的打击正是来自他曾经信任的导师。\n" +
                        "\n" +
                        "1921 年夏天， 在地中海缓缓前行的客轮上，船上一位印度学者对海水魅人的蓝色产生了好奇，在甲板上支起了简易的光学仪器，想要看清海水深沉蓝色的秘密。这个秘密，就是我们熟知的拉曼效应（Raman scattering），那位印度学者就是著名的物理学家钱德拉塞卡拉·拉曼（Sir Chandrasekhara Raman）。因为对光的散射和拉曼效应的贡献，钱德拉塞卡·拉曼在 1930 年获得了诺贝尔物理学奖，这是亚洲科学家第一次收获这项荣誉。\n" +
                        "\n" +
                        "就在颁奖的同一年，他 19 岁的侄子也曾在甲板上思考着天地间的奥秘。同船的人都沉浸在美酒佳肴和歌舞升平之中，这位少年坐在甲板上凝望着满天繁星，思考着它们的前世今生和最终的进化命运。静谧星空下，他初步计算出一个结果：当质量大于太阳质量的 1.44 倍，恒星的最终归宿将不会是当时主流观点认为的白矮星。\n" +
                        "\n" +
                        "这个恒星质量极限，就是著名的钱德拉塞卡极限（Chandrasekhar Limit），而这个 19 岁就得出诺奖级理论的少年，就是苏布拉马尼扬·钱德拉塞卡（Subrahmanyan Chandrasekhar），著名的印度裔美国籍物理学家和天体物理学家。\n" +
                        "\n" +
                        "只是相比他的叔父，钱德拉塞卡的诺奖之路走得异常曲折");
        insertData("生态环境部通报：丽江政府弄虚作假，致高尔夫球场侵占自然保护区","https://t1.huanqiu.cn/df9aedd12d5b0989dcbaad61f415274d.jpg","生态环境部","111评论","2018年6月20日，中央第六环境保护督察组在下沉丽江时发现，由于丽江市及其国土、林业等部门监管失察，高尔夫球场清理不严不实，致使丽江古城湖畔国际高尔夫球场长期侵占拉市海高原湿地省级自然保护区。");
        insertData("生态环境部通报：丽江政府弄虚作假，致高尔夫球场侵占自然保护区","https://t1.huanqiu.cn/df9aedd12d5b0989dcbaad61f415274d.jpg","生态环境部","111评论","2018年6月20日，中央第六环境保护督察组在下沉丽江时发现，由于丽江市及其国土、林业等部门监管失察，高尔夫球场清理不严不实，致使丽江古城湖畔国际高尔夫球场长期侵占拉市海高原湿地省级自然保护区。");
        insertData("生态环境部通报：丽江政府弄虚作假，致高尔夫球场侵占自然保护区","https://t1.huanqiu.cn/df9aedd12d5b0989dcbaad61f415274d.jpg","生态环境部","111评论","2018年6月20日，中央第六环境保护督察组在下沉丽江时发现，由于丽江市及其国土、林业等部门监管失察，高尔夫球场清理不严不实，致使丽江古城湖畔国际高尔夫球场长期侵占拉市海高原湿地省级自然保护区。");
        insertData("生态环境部通报：丽江政府弄虚作假，致高尔夫球场侵占自然保护区","https://t1.huanqiu.cn/df9aedd12d5b0989dcbaad61f415274d.jpg","生态环境部","111评论","2018年6月20日，中央第六环境保护督察组在下沉丽江时发现，由于丽江市及其国土、林业等部门监管失察，高尔夫球场清理不严不实，致使丽江古城湖畔国际高尔夫球场长期侵占拉市海高原湿地省级自然保护区。");
        insertData("生态环境部通报：丽江政府弄虚作假，致高尔夫球场侵占自然保护区","https://t1.huanqiu.cn/df9aedd12d5b0989dcbaad61f415274d.jpg","生态环境部","111评论","2018年6月20日，中央第六环境保护督察组在下沉丽江时发现，由于丽江市及其国土、林业等部门监管失察，高尔夫球场清理不严不实，致使丽江古城湖畔国际高尔夫球场长期侵占拉市海高原湿地省级自然保护区。");
        insertData("生态环境部通报：丽江政府弄虚作假，致高尔夫球场侵占自然保护区","https://t1.huanqiu.cn/df9aedd12d5b0989dcbaad61f415274d.jpg","生态环境部","111评论","2018年6月20日，中央第六环境保护督察组在下沉丽江时发现，由于丽江市及其国土、林业等部门监管失察，高尔夫球场清理不严不实，致使丽江古城湖畔国际高尔夫球场长期侵占拉市海高原湿地省级自然保护区。");
        insertData("生态环境部通报：丽江政府弄虚作假，致高尔夫球场侵占自然保护区","https://t1.huanqiu.cn/df9aedd12d5b0989dcbaad61f415274d.jpg","生态环境部","111评论","2018年6月20日，中央第六环境保护督察组在下沉丽江时发现，由于丽江市及其国土、林业等部门监管失察，高尔夫球场清理不严不实，致使丽江古城湖畔国际高尔夫球场长期侵占拉市海高原湿地省级自然保护区。");

    }

    //登陆返回
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    //获取FragmentHome实例
    public static Fragment newsInstance(){
        Fragment fragment=new FragmentHome();
        return fragment;
    }

}
