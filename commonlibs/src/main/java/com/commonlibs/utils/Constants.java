package com.commonlibs.utils;

public class Constants {
    /**
     * LEVEL_ALL:打开应用程序里面所有输入的日志 7
     * LEVEL_OFF:关闭应用程序里面所有输入的日志 0
     */
    public static final int  DEBUGLEVEL   = LogUtils.LEVEL_ALL;
    public static final long PROTOCOLTIME = 5 * 60 * 1000;//5分钟

    public static final class URLS {
        public static final String BASEURL    = "http://188.188.2.100:8080/GooglePlayServer/";
        public static final String IMGBASEURL = BASEURL + "image?name=";
        //http://localhost:8080/GooglePlayServer/download
        public static final String DOWNLOADURL = BASEURL + "download?";
    }
}
