package com.module_customview.weixin;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;

import com.module_customview.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyuncai on 2017/7/26.
 */

public class EmotionUtil {
    public static final String ee_1 = "/::)";
    public static final String ee_2 = "/::~";
    public static final String ee_3 = "/::B";
    public static final String ee_4 = "/::|";
    public static final String ee_5 = "/:8-)";
    public static final String ee_6 = "/::<";
    public static final String ee_7 = "/::$";
    public static final String ee_8 = "/::X";
    public static final String ee_9 = "/::Z";
    public static final String ee_10 = "/::'(";
    public static final String ee_11 = "/::-|";
    public static final String ee_12 = "/::@";
    public static final String ee_13 = "/::P";
    public static final String ee_14 = "/::D";
    public static final String ee_15 = "/::O";
    public static final String ee_16 = "/::(";
    public static final String ee_17 = "/::+";
    public static final String ee_18 = "/:--b";
    public static final String ee_19 = "/::Q";
    public static final String ee_20 = "/::T";
    public static final String ee_21 = "/:,@P";
    public static final String ee_22 = "/:,@-D";
    public static final String ee_23 = "/::d";
    public static final String ee_24 = "/:,@o";
    public static final String ee_25 = "/::g";
    public static final String ee_26 = "/:|-)";
    public static final String ee_27 = "/::!";
    public static final String ee_28 = "/::L";
    public static final String ee_29 = "/::>";
    public static final String ee_30 = "/::,@";
    public static final String ee_31 = "/:,@f";
    public static final String ee_32 = "/::-S";
    public static final String ee_33 = "/:?";
    public static final String ee_34 = "/:,@x";
    public static final String ee_35 = "/:,@@";
    public static final String ee_36 = "/::8";
    public static final String ee_37 = "/:,@!";
    public static final String ee_38 = "/:!!!";
    public static final String ee_39 = "/:xx";
    public static final String ee_40 = "/:bye";
    public static final String ee_41 = "/:wipe";
    public static final String ee_42 = "/:dig";
    public static final String ee_43 = "/:handclap";
    public static final String ee_44 = "/:&-(";
    public static final String ee_45 = "/:B-)";
    public static final String ee_46 = "/:<@";
    public static final String ee_47 = "/:@>";
    public static final String ee_48 = "/::-O";
    public static final String ee_49 = "/:>-|";
    public static final String ee_50 = "/:P-(";
    public static final String ee_51 = "/::'|";
    public static final String ee_52 = "/:X-)";
    public static final String ee_53 = "/::*";
    public static final String ee_54 = "/:@x";
    public static final String ee_55 = "/:8*";
    public static final String ee_56 = "/:pd";
    public static final String ee_57 = "/:<W>";
    public static final String ee_58 = "/:beer";
    public static final String ee_59 = "/:basketb";
    public static final String ee_60 = "/:oo";
    public static final String ee_61 = "/:coffee";
    public static final String ee_62 = "/:eat";
    public static final String ee_63 = "/:pig";
    public static final String ee_64 = "/:rose";
    public static final String ee_65 = "/:fade";
    public static final String ee_66 = "/:showlove";
    public static final String ee_67 = "/:heart";
    public static final String ee_68 = "/:break";
    public static final String ee_69 = "/:cake";
    public static final String ee_70 = "/:li";
    public static final String ee_71 = "/:bome";
    public static final String ee_72 = "/:kn";
    public static final String ee_73 = "/:footb";
    public static final String ee_74 = "/:ladybug";
    public static final String ee_75 = "/:shit";
    public static final String ee_76 = "/:moon";
    public static final String ee_77 = "/:sun";
    public static final String ee_78 = "/:gift";
    public static final String ee_79 = "/:hug";
    public static final String ee_80 = "/:strong";
    public static final String ee_81 = "/:weak";
    public static final String ee_82 = "/:share";
    public static final String ee_83 = "/:v";
    public static final String ee_84 = "/:@)";
    public static final String ee_85 = "/:jj";
    public static final String ee_86 = "/:@@";
    public static final String ee_87 = "/:bad";
    public static final String ee_88 = "/:lvu";
    public static final String ee_89 = "/:no";
    public static final String ee_90 = "/:ok";
    public static final String ee_91 = "/:love";
    public static final String ee_92 = "/:<L>";
    public static final String ee_93 = "/:jump";
    public static final String ee_94 = "/:shake";
    public static final String ee_95 = "/:<O>";
    public static final String ee_96 = "/:circle";
    public static final String ee_97 = "/:kotow";
    public static final String ee_98 = "/:turn";
    public static final String ee_99 = "/:skip";
    public static final String ee_100 = "/:oY";
    public static final String ee_101 = "/:#-0";
    public static final String ee_102 = "[街舞]";
    public static final String ee_103 = "/:kiss";
    public static final String ee_104 = "/:<&";
    public static final String ee_105 = "/:&>";
    public static final String ee_106 = "[囧]";

    private static Map<String, Integer> emotionMap;
    private static List<String> emotionList;

    public static Map<String, Integer> getEmotionMap() {
        if (emotionMap == null) {
            emotionMap = new HashMap<>();
            emotionMap.put(ee_1, R.drawable.f1);
            emotionMap.put(ee_2, R.drawable.f2);
            emotionMap.put(ee_3, R.drawable.f3);
            emotionMap.put(ee_4, R.drawable.f4);
            emotionMap.put(ee_5, R.drawable.f5);
            emotionMap.put(ee_6, R.drawable.f6);
            emotionMap.put(ee_7, R.drawable.f7);
            emotionMap.put(ee_8, R.drawable.f8);
            emotionMap.put(ee_9, R.drawable.f9);

            emotionMap.put(ee_10, R.drawable.f10);
            emotionMap.put(ee_11, R.drawable.f11);
            emotionMap.put(ee_12, R.drawable.f12);
            emotionMap.put(ee_13, R.drawable.f13);
            emotionMap.put(ee_14, R.drawable.f14);
            emotionMap.put(ee_15, R.drawable.f15);
            emotionMap.put(ee_16, R.drawable.f16);
            emotionMap.put(ee_17, R.drawable.f17);
            emotionMap.put(ee_18, R.drawable.f18);
            emotionMap.put(ee_19, R.drawable.f19);


            emotionMap.put(ee_20, R.drawable.f20);
            emotionMap.put(ee_21, R.drawable.f21);
            emotionMap.put(ee_22, R.drawable.f22);
            emotionMap.put(ee_23, R.drawable.f23);
            emotionMap.put(ee_24, R.drawable.f24);
            emotionMap.put(ee_25, R.drawable.f25);
            emotionMap.put(ee_26, R.drawable.f26);
            emotionMap.put(ee_27, R.drawable.f27);
            emotionMap.put(ee_28, R.drawable.f28);
            emotionMap.put(ee_29, R.drawable.f29);

            emotionMap.put(ee_30, R.drawable.f30);
            emotionMap.put(ee_31, R.drawable.f31);
            emotionMap.put(ee_32, R.drawable.f32);
            emotionMap.put(ee_33, R.drawable.f33);
            emotionMap.put(ee_34, R.drawable.f34);
            emotionMap.put(ee_35, R.drawable.f35);
            emotionMap.put(ee_36, R.drawable.f36);
            emotionMap.put(ee_37, R.drawable.f37);
            emotionMap.put(ee_38, R.drawable.f38);
            emotionMap.put(ee_39, R.drawable.f39);

            emotionMap.put(ee_40, R.drawable.f40);
            emotionMap.put(ee_41, R.drawable.f41);
            emotionMap.put(ee_42, R.drawable.f42);
            emotionMap.put(ee_43, R.drawable.f43);
            emotionMap.put(ee_44, R.drawable.f44);
            emotionMap.put(ee_45, R.drawable.f45);
            emotionMap.put(ee_46, R.drawable.f46);
            emotionMap.put(ee_47, R.drawable.f47);
            emotionMap.put(ee_48, R.drawable.f48);
            emotionMap.put(ee_49, R.drawable.f49);

            emotionMap.put(ee_50, R.drawable.f50);
            emotionMap.put(ee_51, R.drawable.f51);
            emotionMap.put(ee_52, R.drawable.f52);
            emotionMap.put(ee_53, R.drawable.f53);
            emotionMap.put(ee_54, R.drawable.f54);
            emotionMap.put(ee_55, R.drawable.f55);
            emotionMap.put(ee_56, R.drawable.f56);
            emotionMap.put(ee_57, R.drawable.f57);
            emotionMap.put(ee_58, R.drawable.f58);
            emotionMap.put(ee_59, R.drawable.f59);

            emotionMap.put(ee_60, R.drawable.f60);
            emotionMap.put(ee_61, R.drawable.f61);
            emotionMap.put(ee_62, R.drawable.f62);
            emotionMap.put(ee_63, R.drawable.f63);
            emotionMap.put(ee_64, R.drawable.f64);
            emotionMap.put(ee_65, R.drawable.f65);
            emotionMap.put(ee_66, R.drawable.f66);
            emotionMap.put(ee_67, R.drawable.f67);
            emotionMap.put(ee_68, R.drawable.f68);
            emotionMap.put(ee_69, R.drawable.f69);

            emotionMap.put(ee_70, R.drawable.f70);
            emotionMap.put(ee_71, R.drawable.f71);
            emotionMap.put(ee_72, R.drawable.f72);
            emotionMap.put(ee_73, R.drawable.f73);
            emotionMap.put(ee_74, R.drawable.f74);
            emotionMap.put(ee_75, R.drawable.f75);
            emotionMap.put(ee_76, R.drawable.f76);
            emotionMap.put(ee_77, R.drawable.f77);
            emotionMap.put(ee_78, R.drawable.f78);
            emotionMap.put(ee_79, R.drawable.f79);

            emotionMap.put(ee_80, R.drawable.f80);
            emotionMap.put(ee_81, R.drawable.f81);
            emotionMap.put(ee_82, R.drawable.f82);
            emotionMap.put(ee_83, R.drawable.f83);
            emotionMap.put(ee_84, R.drawable.f84);
            emotionMap.put(ee_85, R.drawable.f85);
            emotionMap.put(ee_86, R.drawable.f86);
            emotionMap.put(ee_87, R.drawable.f87);
            emotionMap.put(ee_88, R.drawable.f88);
            emotionMap.put(ee_89, R.drawable.f89);

            emotionMap.put(ee_90, R.drawable.f90);
            emotionMap.put(ee_91, R.drawable.f91);
            emotionMap.put(ee_92, R.drawable.f92);
            emotionMap.put(ee_93, R.drawable.f93);
            emotionMap.put(ee_94, R.drawable.f94);
            emotionMap.put(ee_95, R.drawable.f95);
            emotionMap.put(ee_96, R.drawable.f96);
            emotionMap.put(ee_97, R.drawable.f97);
            emotionMap.put(ee_98, R.drawable.f98);
            emotionMap.put(ee_99, R.drawable.f99);

            emotionMap.put(ee_100, R.drawable.f100);
            emotionMap.put(ee_101, R.drawable.f101);
            emotionMap.put(ee_102, R.drawable.f102);
            emotionMap.put(ee_103, R.drawable.f103);
            emotionMap.put(ee_104, R.drawable.f104);
            emotionMap.put(ee_105, R.drawable.f105);
            emotionMap.put(ee_106, R.drawable.f106);
        }

        return emotionMap;
    }

    public static List<String> getEmotionList() {
        if (emotionList == null) {
            emotionList = new ArrayList<>();
            emotionList.add(ee_1);
            emotionList.add(ee_2);
            emotionList.add(ee_3);
            emotionList.add(ee_4);
            emotionList.add(ee_5);
            emotionList.add(ee_6);
            emotionList.add(ee_7);
            emotionList.add(ee_8);
            emotionList.add(ee_9);

            emotionList.add(ee_10);
            emotionList.add(ee_11);
            emotionList.add(ee_12);
            emotionList.add(ee_13);
            emotionList.add(ee_14);
            emotionList.add(ee_15);
            emotionList.add(ee_16);
            emotionList.add(ee_17);
            emotionList.add(ee_18);
            emotionList.add(ee_19);

            emotionList.add(ee_20);
            emotionList.add(ee_21);
            emotionList.add(ee_22);
            emotionList.add(ee_23);
            emotionList.add(ee_24);
            emotionList.add(ee_25);
            emotionList.add(ee_26);
            emotionList.add(ee_27);
            emotionList.add(ee_28);
            emotionList.add(ee_29);

            emotionList.add(ee_30);
            emotionList.add(ee_31);
            emotionList.add(ee_32);
            emotionList.add(ee_33);
            emotionList.add(ee_34);
            emotionList.add(ee_35);
            emotionList.add(ee_36);
            emotionList.add(ee_37);
            emotionList.add(ee_38);
            emotionList.add(ee_39);

            emotionList.add(ee_40);
            emotionList.add(ee_41);
            emotionList.add(ee_42);
            emotionList.add(ee_43);
            emotionList.add(ee_44);
            emotionList.add(ee_45);
            emotionList.add(ee_46);
            emotionList.add(ee_47);
            emotionList.add(ee_48);
            emotionList.add(ee_49);

            emotionList.add(ee_50);
            emotionList.add(ee_51);
            emotionList.add(ee_52);
            emotionList.add(ee_53);
            emotionList.add(ee_54);
            emotionList.add(ee_55);
            emotionList.add(ee_56);
            emotionList.add(ee_57);
            emotionList.add(ee_58);
            emotionList.add(ee_59);

            emotionList.add(ee_60);
            emotionList.add(ee_61);
            emotionList.add(ee_62);
            emotionList.add(ee_63);
            emotionList.add(ee_64);
            emotionList.add(ee_65);
            emotionList.add(ee_66);
            emotionList.add(ee_67);
            emotionList.add(ee_68);
            emotionList.add(ee_69);

            emotionList.add(ee_70);
            emotionList.add(ee_71);
            emotionList.add(ee_72);
            emotionList.add(ee_73);
            emotionList.add(ee_74);
            emotionList.add(ee_75);
            emotionList.add(ee_76);
            emotionList.add(ee_77);
            emotionList.add(ee_78);
            emotionList.add(ee_79);

            emotionList.add(ee_80);
            emotionList.add(ee_81);
            emotionList.add(ee_82);
            emotionList.add(ee_83);
            emotionList.add(ee_84);
            emotionList.add(ee_85);
            emotionList.add(ee_86);
            emotionList.add(ee_87);
            emotionList.add(ee_88);
            emotionList.add(ee_89);

            emotionList.add(ee_90);
            emotionList.add(ee_91);
            emotionList.add(ee_92);
            emotionList.add(ee_93);
            emotionList.add(ee_94);
            emotionList.add(ee_95);
            emotionList.add(ee_96);
            emotionList.add(ee_97);
            emotionList.add(ee_98);
            emotionList.add(ee_99);

            emotionList.add(ee_100);
            emotionList.add(ee_101);
            emotionList.add(ee_102);
            emotionList.add(ee_103);
            emotionList.add(ee_104);
            emotionList.add(ee_105);
            emotionList.add(ee_106);

        }
        return emotionList;
    }

    public static boolean containsEmotion(String str) {
        boolean contains = false;

        if (TextUtils.isEmpty(str)) {
            return contains;
        }

        for (String s : getEmotionMap().keySet()) {
            if (str.contains(s)) {
                contains = true;
                return contains;
            }
        }

        return contains;
    }

    public static SpannableString getExpressionString(Context context, String str, int textSize) {

//        str = "af/:--bad/::-|/::B/::'(faffff/:,@o/:,@o/:,@o/:,@o/:,@o/:,@o";
        SpannableString spannableString = new SpannableString(str);

        List<String> emotionList = getEmotionList();
        for (String s : emotionList) {
            if (str.contains(s)) {

                System.out.println("-----------------<<<>>>--------------------s=" + s);
                int fromIndex = 0;
                while (fromIndex < str.length()) {

                    int indexOf = str.indexOf(s, fromIndex);
                    if (indexOf < 0) {
                        System.out.println("-----------------<<<>>>--------------------没找到该表情=" + s);
                        break;
                    }
                    fromIndex = indexOf + s.length();

                    int startIndex = indexOf;
                    int endIndex = startIndex + s.length();

                    System.out.println("-----------------<<<>>>--------------------startIndex=" + startIndex);
                    System.out.println("-----------------<<<>>>--------------------endIndex=" + endIndex);

                    if (getEmotionMap() == null || !getEmotionMap().containsKey(s) || getEmotionMap().get(s) == null) {
                        continue;
                    }
                    Drawable drawable = ContextCompat.getDrawable(context, getEmotionMap().get(s));
                    if (drawable == null) {
                        continue;
                    }

                    drawable.setBounds(0, 0, textSize, textSize);
                    ImageSpan imageSpan = new ImageSpan(drawable);
                    spannableString.setSpan(imageSpan, startIndex, endIndex,
                            Spannable.SPAN_INCLUSIVE_EXCLUSIVE);


                }

            }
        }


        return spannableString;
    }

}
