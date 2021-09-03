package com.museum.common.politics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 政治术语过滤工具类
 *
 * @author AlanLee
 *
 */
public class PoliticswordEngine
{
    /**
     * 政治术语库
     */
    public static Map sensitiveWordMap = null;

    /**
     * 只过滤最小政治术语
     */
    public static int minMatchTYpe = 1;

    /**
     * 过滤所有政治术语
     */
    public static int maxMatchType = 2;

    /**
     * 敏感词库政治术语数量
     *
     * @return
     */
    public static int getWordSize()
    {
        if (PoliticswordEngine.sensitiveWordMap == null)
        {
            return 0;
        }
        return PoliticswordEngine.sensitiveWordMap.size();
    }

    /**
     * 是否包含政治术语
     *
     * @param txt
     * @param matchType
     * @return
     */
    public static boolean isContaintSensitiveWord(String txt, int matchType)
    {
        boolean flag = false;
        for (int i = 0; i < txt.length(); i++)
        {
            int matchFlag = checkSensitiveWord(txt, i, matchType);
            if (matchFlag > 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 获取政治术语内容
     *
     * @param txt
     * @param matchType
     * @return 政治术语内容
     */
    public static List<String> getSensitiveWord(String txt, int matchType)
    {
        List<String> sensitiveWordList = new ArrayList<>();

        for (int i = 0; i < txt.length(); i++)
        {
            int length = checkSensitiveWord(txt, i, matchType);
            if (length > 0)
            {
                // 将检测出的政治术语词保存到集合中
                sensitiveWordList.add(txt.substring(i, i + length));
                i = i + length - 1;
            }
        }

        return sensitiveWordList;
    }

    /**
     * 替换政治术语
     *
     * @param txt
     * @param matchType
     * @param replaceChar
     * @return
     */
    public static String replaceSensitiveWord(String txt, int matchType, String replaceChar)
    {
        String resultTxt = txt;
        List<String> set = getSensitiveWord(txt, matchType);
        Iterator<String> iterator = set.iterator();
        String word = null;
        String replaceString = null;
        while (iterator.hasNext())
        {
            word = iterator.next();
            replaceString = getReplaceChars(replaceChar, word.length());
            resultTxt = resultTxt.replaceAll(word, replaceString);
        }

        return resultTxt;
    }

    /**
     * 替换政治术语
     *
     * @param replaceChar
     * @param length
     * @return
     */
    private static String getReplaceChars(String replaceChar, int length)
    {
        String resultReplace = replaceChar;
        for (int i = 1; i < length; i++)
        {
            resultReplace += replaceChar;
        }

        return resultReplace;
    }

    /**
     * 检查敏政治术语数量
     *
     * @param txt
     * @param beginIndex
     * @param matchType
     * @return
     */
    public static int checkSensitiveWord(String txt, int beginIndex, int matchType)
    {
        boolean flag = false;
        // 记录政治术语数量
        int matchFlag = 0;
        char word = 0;
        Map nowMap = PoliticswordEngine.sensitiveWordMap;
        for (int i = beginIndex; i < txt.length(); i++)
        {
            word = txt.charAt(i);
            // 判断该字是否存在于政治术语库中
            nowMap = (Map) nowMap.get(word);
            if (nowMap != null)
            {
                matchFlag++;
                // 判断是否是政治术语的结尾字，如果是结尾字则判断是否继续检测
                if ("1".equals(nowMap.get("isEnd")))
                {
                    flag = true;
                    // 判断过滤类型，如果是小过滤则跳出循环，否则继续循环
                    if (PoliticswordEngine.minMatchTYpe == matchType)
                    {
                        break;
                    }
                }
            }
            else
            {
                break;
            }
        }
        if (!flag)
        {
            matchFlag = 0;
        }
        return matchFlag;
    }

}