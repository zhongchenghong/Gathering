package com.museum.common.politics;

import com.museum.domain.Politics;
import com.museum.domain.Sensitives;

import java.util.*;

/**
 * 政治术语库初始化
 *
 * @author AlanLee
 *
 */
public class PoliticsWordInit {
    /**
     * 政治术语库
     */
    public HashMap sensitiveWordMap;

    /**
     * 初始化政治术语
     *
     * @return
     */
    public Map initKeyWord(List<Politics> sensitiveWords) {
        try {
            // 从政治术语集合对象中取出政治术语并封装到Set集合中
            Set<String> keyWordSet = new HashSet<String>();
            for (Politics s : sensitiveWords) {
                keyWordSet.add(s.getPoname().trim());
            }
            // 将政治术语库加入到HashMap中
            addSensitiveWordToHashMap(keyWordSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveWordMap;
    }

    /**
     * 封装政治术语库
     *
     * @param keyWordSet
     */
    @SuppressWarnings("rawtypes")
    private void addSensitiveWordToHashMap(Set<String> keyWordSet) {
        // 初始化HashMap对象并控制容器的大小
        sensitiveWordMap = new HashMap(keyWordSet.size());
        // 政治术语
        String key = null;
        // 用来按照相应的格式保存政治术语库数据
        Map nowMap = null;
        // 用来辅助构建政治术语库
        Map<String, String> newWorMap = null;
        // 使用一个迭代器来循环政治术语集合
        Iterator<String> iterator = keyWordSet.iterator();
        while (iterator.hasNext()) {
            key = iterator.next();
            // 等于政治术语库，HashMap对象在内存中占用的是同一个地址，所以此nowMap对象的变化，sensitiveWordMap对象也会跟着改变
            nowMap = sensitiveWordMap;
            for (int i = 0; i < key.length(); i++) {
                // 截取政治术语当中的字，在政治术语库中字为HashMap对象的Key键值
                char keyChar = key.charAt(i);

                // 判断这个字是否存在于政治术语库中
                Object wordMap = nowMap.get(keyChar);
                if (wordMap != null) {
                    nowMap = (Map) wordMap;
                } else {
                    newWorMap = new HashMap<String, String>();
                    newWorMap.put("isEnd", "0");
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }

                // 如果该字是当前政治术语的最后一个字，则标识为结尾字
                if (i == key.length() - 1) {
                    nowMap.put("isEnd", "1");
                }
            }
        }
    }
}