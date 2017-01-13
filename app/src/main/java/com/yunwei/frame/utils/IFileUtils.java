package com.yunwei.frame.utils;

import android.os.Environment;

import java.io.File;
import java.util.UUID;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.utils
 * @Description:文件工具类
 * @date 2017/1/10 11:42
 */

public class IFileUtils {

    /*文件根目录*/
    public static final String FILE_ROOT_DIRECTORY = "Yunwei";
    /*项目根目录*/
    public static final String PROJECT_ROOT_DIRECTORY = "Base";
    /*图片文件夹*/
    public static final String IMAGE_DEIRECTORY = "image";
    /*缓存文件夹*/
    public static final String IMAGE_CATCH_DIR = "catch";
    /*下载目录*/
    public static final String DOWNLOAD_DIR = "download";

    /**
     * 获取SD卡根目录
     *
     * @return
     */
    public static String getSDROOT() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    /**
     * 图片缓存地址
     *
     * @return
     */
    public static String getImageCatchDir() {
        String path = getSDROOT() + File.separator + FILE_ROOT_DIRECTORY + File.separator + PROJECT_ROOT_DIRECTORY + File.separator + IMAGE_CATCH_DIR + File.separator + UUID.randomUUID().toString() + ".png";
        File file = new File(path);
        if (!file.exists()) {
            File filePath = file.getParentFile();
            filePath.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /**
     * 下载目录
     *
     * @return
     */
    public static String getDownloadDir() {
        return getSDROOT() + File.separator + FILE_ROOT_DIRECTORY + File.separator + PROJECT_ROOT_DIRECTORY + File.separator + DOWNLOAD_DIR;
    }
}
