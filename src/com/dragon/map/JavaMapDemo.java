package com.dragon.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2020/7/31 16:44
 * @description：Map
 * @modified By：
 * @version: $
 */
public class JavaMapDemo {
    public static void main(String[] args) {
        Map<Object, Object> hashMap = new HashMap<>();
        Map<Object, Object> treeMap = new TreeMap<>();
        Map<Object, Object> hashtable = new Hashtable<>();
        Map<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
    }
}
