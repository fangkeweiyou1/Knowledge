package javastudy;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.commonlibs.utils.LogUtils;
import com.module_customview.R;
import com.module_customview.base.BaseActivity;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/6/28.
 * 学习正则表达式
 * 学习Regex
 */
@RouterMap({"activity://regex"})
public class RegexActivity extends BaseActivity {
    private static final String TAG = "<<<>>>RegexActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regex);


//        String content = "file:我是第1个png   lalalalal file:我是第2个png  lalalalalala  file:我是第3个png  lalalalfile:我是第4个png";
////        String reg = "file:[^>]+png?";
//        String reg = "file.*?png";
//        Pattern pattern = Pattern.compile(reg);
//        Matcher matcher = pattern.matcher(content);
//        int i = matcher.groupCount();
//        LogUtils.i(TAG, "i=" + i);
//        while (matcher.find()) {
//            String group = matcher.group();
//            LogUtils.i(TAG, "group=" + group);
//        }

//        String content = "[555]8888[44[9999][6666]333][222000000";
//        String content = "\"activity://cmessage/detail?json={\\\"canForward\\\":\\\"F\\\",\\\"dig=est\\\"\\:\"如果?你觉得chanel、爱马仕太大牌离咱们太远，那就看看以下这些稍亲民的快时尚品牌，他们有很多地方是值得参考滴～今天就来聊聊H&M ZARA GAP 优衣库这些品牌店铺的陈列都有什么特点。\\\",\\\"faceUrl\\\":\\\"prod/2017-07-05/6FF389FD2324FB5EA7641D5A125CEEE2/11[1].jpg\\\",\\\"linkUrl\\\":\\\"http://h5.sotemall.com/h5-server/app/message?msgId=212\\\",\\\"msgTitle\\\":\\\"[保密]看H&M,ZARA,优衣库的店铺陈列，小细节 大学问\\\",\\\"pageTitle\\\":\\\"看H&M,ZARA,优衣库的店铺陈列，小细节 大学问\\\",\\\"shareUrl\\\":\\\"http://h5.sotemall.com/h5-server/app/message?msgId=212\\\"}&msgTag=零售学堂\"";
//        String reg = "\\{.*?\\}";
////        String reg = "\\[[^>]+\\]";
//        Pattern pattern = Pattern.compile(reg);
//        Matcher matcher = pattern.matcher(content);
//        String params1 = "";//匹配{}的参数,譬如 content="{12}3{45}6{7}" 那么 params1={12},{45},{7}
//        String params2 = "";//将params替换处理之后的参数
//        while (matcher.find()) {
////            String group = matcher.group();
////            LogUtils.i(TAG, "group=" + group);
////            System.out.println("<<<>>>group="+group);
//
//            params1 = matcher.group();
//            LogUtils.i(TAG, "需要替换的参数=" + params1);
//            params2 = params1.replaceAll("\\&", "||||");
//            params2 = params2.replaceAll("\\=", "----");
//            params2 = params2.replaceAll("\\?", "####");
//            LogUtils.i(TAG, "替换之后的参数=" + params2);
//        }

//        String content = "12||||21";
//        content = content.replaceAll("\\|\\|\\|\\|", "\\*");
//        LogUtils.i(TAG, "content=" + content);

//        String content = "12----21";
//        content = content.replaceAll("----", "\\*");
//        LogUtils.i(TAG, "content=" + content);

        String content = "12####21";
        content = content.replaceAll("####", "\\*");
        LogUtils.i(TAG, "content=" + content);
    }
}
