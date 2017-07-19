package com.module_customview.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.commonlibs.utils.LogUtils;
import com.commonlibs.utils.ToastUtils;
import com.google.gson.Gson;
import com.module_customview.R;
import com.module_customview.base.BaseActivity;
import com.module_customview.dialog.ShowPickerDialog;
import com.module_customview.model.CardBean;
import com.module_customview.model.JsonBean;
import com.module_customview.model.ProvinceBean;
import com.module_customview.utils.GetJsonDataUtil;

import org.json.JSONArray;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/7/17.
 * 测试picker
 */
@RouterMap({"activity://picker"})
public class PickerActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_showpicker;//弹出picker
    private TextView tv_showpickerindialog;//在dialog弹出picker
    private TimePickerView pvCustomTime;
    private TimePickerView pvTime;
    private OptionsPickerView pvOptions, pvCustomOptions, pvNoLinkOptions;
    private ShowPickerDialog pickerDialog;
    private Button btn_Time, btn_Options, btn_CustomOptions, btn_CustomTime, btn_no_linkage, btn_to_Fragment;

    private ArrayList<ProvinceBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<CardBean> cardItem = new ArrayList<>();

    private ArrayList<String> food = new ArrayList<>();
    private ArrayList<String> clothes = new ArrayList<>();
    private ArrayList<String> computer = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_picker);

        tv_showpicker = (TextView) findViewById(R.id.tv_showpicker);
        tv_showpickerindialog = (TextView) findViewById(R.id.tv_showpickerindialog);

        btn_Time = (Button) findViewById(R.id.btn_Time);
        btn_Options = (Button) findViewById(R.id.btn_Options);
        btn_CustomOptions = (Button) findViewById(R.id.btn_CustomOptions);
        btn_CustomTime = (Button) findViewById(R.id.btn_CustomTime);
        btn_no_linkage = (Button) findViewById(R.id.btn_no_linkage);
        btn_to_Fragment = (Button) findViewById(R.id.btn_fragment);

        btn_Time.setOnClickListener(this);
        btn_Options.setOnClickListener(this);
        btn_CustomOptions.setOnClickListener(this);
        btn_CustomTime.setOnClickListener(this);
        btn_no_linkage.setOnClickListener(this);
        btn_to_Fragment.setOnClickListener(this);
        findViewById(R.id.btn_data).setOnClickListener(this);
        findViewById(R.id.btn_show).setOnClickListener(this);


        tv_showpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPicker();
            }
        });

        tv_showpickerindialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPickerInDialog();
            }
        });


        initTimePicker();
        initOptionData();
        initOptionPicker();
        initCustomOptionPicker();
//        initCustomTimePicker();
    }

    private void showPicker() {
        /**
         * @description
         *
         * 注意事项：
         * 1.自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针.
         * 具体可参考demo 里面的两个自定义layout布局。
         * 2.因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
         * setRangDate方法控制起始终止时间(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
         */
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(2000, 0, 1);
        Calendar endDate = Calendar.getInstance();
//        endDate.set(2027, 2, 28);
        //时间选择器 ，自定义布局
        pvCustomTime = null;
        if (pvCustomTime == null) {
            pvCustomTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {//选中事件回调
                }
            })
                /*.setType(TimePickerView.Type.ALL)//default is all
                .setCancelText("Cancel")
                .setSubmitText("Sure")
                .setContentSize(18)
                .setTitleSize(20)
                .setTitleText("Title")
                .setTitleColor(Color.BLACK)
               /*.setDividerColor(Color.WHITE)//设置分割线的颜色
                .setTextColorCenter(Color.LTGRAY)//设置选中项的颜色
                .setLineSpacingMultiplier(1.6f)//设置两横线之间的间隔倍数
                .setTitleBgColor(Color.DKGRAY)//标题背景颜色 Night mode
                .setBgColor(Color.BLACK)//滚轮背景颜色 Night mode
                .setSubmitColor(Color.WHITE)
                .setCancelColor(Color.WHITE)*/
               /*.gravity(Gravity.RIGHT)// default is center*/
                    .setDate(selectedDate)
                    .setRangDate(startDate, endDate)//注释后默认时间1900-2100年
                    .setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {

                        @Override
                        public void customLayout(View v) {
                            final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                            TextView ivCancel = (TextView) v.findViewById(R.id.iv_cancel);
                            tvSubmit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    pvCustomTime.returnData();
                                    pvCustomTime.dismiss();
                                }
                            });
                            ivCancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    pvCustomTime.dismiss();
                                }
                            });
                        }
                    })
                    .setType(new boolean[]{true, true, true, false, false, false})
                    .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                .setDividerColor(Color.RED)
//                    .setDecorView(frame)
                    .isCyclic(true)
                    .setOutSideCancelable(true)
                    .build();
        }
        pvCustomTime.show();


    }

    private void showPickerInDialog() {
        if (pickerDialog == null)
            pickerDialog = new ShowPickerDialog(this);
        pickerDialog.show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_Time) {
            if (pvTime != null) {
                pvTime.show(v);
            }
        } else if (v.getId() == R.id.btn_Options) {
            if (pvOptions != null) {
                pvOptions.show();
            }
        } else if (v.getId() == R.id.btn_CustomOptions) {
            LogUtils.i(TAG, "1");
            if (pvCustomOptions != null) {
                LogUtils.i(TAG, "2");
                pvCustomOptions.show();
            }
        } else if (v.getId() == R.id.btn_CustomTime) {
            showPicker();
        } else if (v.getId() == R.id.btn_no_linkage) {//不联动数据选择器
        }


        if (v.getId() == R.id.btn_data) {
            mHandler.sendEmptyMessage(MSG_LOAD_DATA);
        } else if (v.getId() == R.id.btn_show) {
            if (isLoaded) {
                ShowPickerView();
            } else {
//                Toast.makeText(JsonDataActivity.this,"数据暂未解析成功，请等待",Toast.LENGTH_SHORT).show();
                ToastUtils.showToast("数据暂未解析成功，请等待");
            }
        }
    }

    private void initTimePicker() {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(2013, 0, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2019, 11, 28);
        //时间选择器
        pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null

                /*btn_Time.setText(getTime(date));*/
                Button btn = (Button) v;
                btn.setText(getTime(date));
            }
        })
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(new boolean[]{false, false, false, true, true, false})
                .setLabel("", "", "", "点", "分", "")
                .isCenterLabel(false)
                .setDividerColor(Color.DKGRAY)
                .setContentSize(21)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setBackgroundId(0x00FFFFFF) //设置外部遮罩颜色
                .setDecorView(null)
                .build();
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    private void initOptionData() {

        /**
         * 注意：如果是添加JavaBean实体数据，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */

        getCardData();
        getNoLinkData();

        //选项1
        options1Items.add(new ProvinceBean(0, "广东", "描述部分", "其他数据"));
        options1Items.add(new ProvinceBean(1, "湖南", "描述部分", "其他数据"));
        options1Items.add(new ProvinceBean(2, "广西", "描述部分", "其他数据"));

        //选项2
        ArrayList<String> options2Items_01 = new ArrayList<>();
        options2Items_01.add("广州");
        options2Items_01.add("佛山");
        options2Items_01.add("东莞");
        options2Items_01.add("珠海");
        ArrayList<String> options2Items_02 = new ArrayList<>();
        options2Items_02.add("长沙");
        options2Items_02.add("岳阳");
        options2Items_02.add("株洲");
        options2Items_02.add("衡阳");
        ArrayList<String> options2Items_03 = new ArrayList<>();
        options2Items_03.add("桂林");
        options2Items_03.add("玉林");
        options2Items.add(options2Items_01);
        options2Items.add(options2Items_02);
        options2Items.add(options2Items_03);

        /*--------数据源添加完毕---------*/
    }

    private void getCardData() {
        for (int i = 0; i < 5; i++) {
            cardItem.add(new CardBean(i, "No.ABC12345 " + i));
        }

        for (int i = 0; i < cardItem.size(); i++) {
            if (cardItem.get(i).getCardNo().length() > 6) {
                String str_item = cardItem.get(i).getCardNo().substring(0, 6) + "...";
                cardItem.get(i).setCardNo(str_item);
            }
        }
    }

    private void getNoLinkData() {
        food.add("KFC");
        food.add("MacDonald");
        food.add("Pizza hut");

        clothes.add("Nike");
        clothes.add("Adidas");
        clothes.add("Anima");

        computer.add("ASUS");
        computer.add("Lenovo");
        computer.add("Apple");
        computer.add("HP");
    }

    private void initOptionPicker() {//条件选择器初始化

        /**
         * 注意 ：如果是三级联动的数据(省市区等)，请参照 JsonDataActivity 类里面的写法。
         */

        pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1).getPickerViewText()
                        + options2Items.get(options1).get(options2)
                       /* + options3Items.get(options1).get(options2).get(options3).getPickerViewText()*/;
                btn_Options.setText(tx);
            }
        })
                .setTitleText("城市选择")
                .setContentTextSize(20)//设置滚轮文字大小
                .setDividerColor(Color.GREEN)//设置分割线的颜色
                .setSelectOptions(0, 1)//默认选中项
                .setBgColor(Color.BLACK)
                .setTitleBgColor(Color.DKGRAY)
                .setTitleColor(Color.LTGRAY)
                .setCancelColor(Color.YELLOW)
                .setSubmitColor(Color.YELLOW)
                .setTextColorCenter(Color.LTGRAY)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setLabels("省", "市", "区")
                .setBackgroundId(0x66000000) //设置外部遮罩颜色
                .build();

        //pvOptions.setSelectOptions(1,1);
        /*pvOptions.setPicker(options1Items);//一级选择器*/
        pvOptions.setPicker(options1Items, options2Items);//二级选择器
        /*pvOptions.setPicker(options1Items, options2Items,options3Items);//三级选择器*/
    }

    private void initCustomOptionPicker() {//条件选择器初始化，自定义布局
        /**
         * @description
         *
         * 注意事项：
         * 自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针。
         * 具体可参考demo 里面的两个自定义layout布局。
         */
        pvCustomOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = cardItem.get(options1).getPickerViewText();
                btn_CustomOptions.setText(tx);
            }
        })
                .setLayoutRes(R.layout.pickerview_custom_options, new CustomListener() {
                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        final TextView tvAdd = (TextView) v.findViewById(R.id.tv_add);
                        ImageView ivCancel = (ImageView) v.findViewById(R.id.iv_cancel);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomOptions.returnData();
                                pvCustomOptions.dismiss();
                            }
                        });

                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomOptions.dismiss();
                            }
                        });

                        tvAdd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                getCardData();
                                pvCustomOptions.setPicker(cardItem);
                            }
                        });

                    }
                })
                .isDialog(true)
                .build();

        pvCustomOptions.setPicker(cardItem);//添加数据

    }

    private void initCustomTimePicker() {

        /**
         * @description
         *
         * 注意事项：
         * 1.自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针.
         * 具体可参考demo 里面的两个自定义layout布局。
         * 2.因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
         * setRangDate方法控制起始终止时间(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
         */
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(2014, 1, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2027, 2, 28);
        //时间选择器 ，自定义布局
        pvCustomTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                btn_CustomTime.setText(getTime(date));
            }
        })
                /*.setType(TimePickerView.Type.ALL)//default is all
                .setCancelText("Cancel")
                .setSubmitText("Sure")
                .setContentSize(18)
                .setTitleSize(20)
                .setTitleText("Title")
                .setTitleColor(Color.BLACK)
               /*.setDividerColor(Color.WHITE)//设置分割线的颜色
                .setTextColorCenter(Color.LTGRAY)//设置选中项的颜色
                .setLineSpacingMultiplier(1.6f)//设置两横线之间的间隔倍数
                .setTitleBgColor(Color.DKGRAY)//标题背景颜色 Night mode
                .setBgColor(Color.BLACK)//滚轮背景颜色 Night mode
                .setSubmitColor(Color.WHITE)
                .setCancelColor(Color.WHITE)*/
               /*.gravity(Gravity.RIGHT)// default is center*/
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {

                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        ImageView ivCancel = (ImageView) v.findViewById(R.id.iv_cancel);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.returnData();
                                pvCustomTime.dismiss();
                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.dismiss();
                            }
                        });
                    }
                })
                .setType(new boolean[]{true, true, true, false, false, false})
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setDividerColor(Color.RED)
                .build();

    }

    private ArrayList<JsonBean> options1ItemsJSON = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2ItemsJSON = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3ItemsJSON = new ArrayList<>();
    private Thread thread;
    private static final int MSG_LOAD_DATA = 0x0001;
    private static final int MSG_LOAD_SUCCESS = 0x0002;
    private static final int MSG_LOAD_FAILED = 0x0003;

    private boolean isLoaded = false;


    private void ShowPickerView() {// 弹出选择器

        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = options1ItemsJSON.get(options1).getPickerViewText() +
                        options2ItemsJSON.get(options1).get(options2) +
                        options3ItemsJSON.get(options1).get(options2).get(options3);

            }
        })

                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .setOutSideCancelable(false)// default is true
                .build();

        /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        pvOptions.setPicker(options1ItemsJSON, options2ItemsJSON, options3ItemsJSON);//三级选择器
        pvOptions.show();
    }

    private void initJsonData() {//解析数据

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        String JsonData = new GetJsonDataUtil().getJson(this, "province.json");//获取assets目录下的json文件数据

        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1ItemsJSON = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市

                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    City_AreaList.add("");
                } else {

                    for (int d = 0; d < jsonBean.get(i).getCityList().get(c).getArea().size(); d++) {//该城市对应地区所有数据
                        String AreaName = jsonBean.get(i).getCityList().get(c).getArea().get(d);

                        City_AreaList.add(AreaName);//添加该城市所有地区数据
                    }
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2ItemsJSON.add(CityList);

            /**
             * 添加地区数据
             */
            options3ItemsJSON.add(Province_AreaList);
        }

        mHandler.sendEmptyMessage(MSG_LOAD_SUCCESS);

    }


    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mHandler.sendEmptyMessage(MSG_LOAD_FAILED);
        }
        return detail;
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_LOAD_DATA:
                    if (thread == null) {//如果已创建就不再重新创建子线程了

//                        Toast.makeText(JsonDataActivity.this,"开始解析数据",Toast.LENGTH_SHORT).show();
                        ToastUtils.showToast("开始解析数据");
                        thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                // 写子线程中的操作,解析省市区数据
                                initJsonData();
                            }
                        });
                        thread.start();
                    }
                    break;

                case MSG_LOAD_SUCCESS:
//                    Toast.makeText(JsonDataActivity.this,"解析数据成功",Toast.LENGTH_SHORT).show();
                    ToastUtils.showToast("解析数据成功");
                    isLoaded = true;
                    break;

                case MSG_LOAD_FAILED:
//                    Toast.makeText(JsonDataActivity.this,"解析数据失败",Toast.LENGTH_SHORT).show();
                    ToastUtils.showToast("解析数据失败");
                    break;

            }
        }
    };
}
