package com.example.mycommon.config;

import android.os.Environment;

public class Constants {
    /**
     * SD卡路径
     **/
    public static final String SDCARD_PATH = Environment
            .getExternalStorageDirectory().getAbsolutePath() + "/programexample/";

    /**
     * 数据库名称
     */
    public static final String DB_NAME = "ProgrammingExample.db";

    /**
     * 图片名称
     */
    public static String fileName = "temp.png";

    /**
     * 图片名称
     */
    public static String currentUserId = "GreenDao";

    /**
     * 预览图
     */
    public final static String previewPath = Constants.SDCARD_PATH + "images/";
    public final static String uploadPath = Constants.SDCARD_PATH + "upload/";

}
