package com.museum.util;

import com.hankcs.hanlp.HanLP;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

/**
 * 获取摘要
 */
public class AppendToFile {
    /**
     * A方法追加文件：使用RandomAccessFile
     */
    public static void appendMethodA(String document) {
         List<String> sentenceList = HanLP.extractSummary(document, 3);
        System.out.println(sentenceList);
    }

}