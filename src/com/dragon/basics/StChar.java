package com.dragon.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2020/9/14 22:02
 * @description：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。要求利用循环，使用Map存储数据
 * @modified By：
 * @version: $
 */
public class StChar {

    public static Map<Integer,Integer> countChar(String str){
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        // 请补充完整本段落代码①
        //英文字母
        String E1 = "[a-zA-Z]";
        //数字
        String E2 = "[0-9]";
        //空格
        String E3 = "\\s";
        int countLetter = 0;
        int countNumber = 0;
        int countSpace = 0;
        int countOther = 0;
        //将字符串转化为字符数组
        char[] array_Char = str.toCharArray();
        //汉字只能作为字符串处理
        String[] array_String = new String[array_Char.length];
        for(int i=0;i<array_Char.length;i++) {
            array_String[i] = String.valueOf(array_Char[i]);
        }
        //遍历字符串数组中的元素
        for(String s:array_String){
            if(s.matches(E1)) {
                countLetter++;
            } else if(s.matches(E2)) {
                countNumber++;
            } else if(s.matches(E3)) {
                countSpace++;
            } else {
                countOther++;
            }
        }
        m.put(1,countLetter);
        m.put(2,countNumber);
        m.put(3,countSpace);
        m.put(4,countOther);
        return m;
    }

    public static void main(String[] args) {
        // 请补充完整本段落代码②
        System.out.print("请输入一串字符：");
        Scanner scan = new Scanner(System.in);
        // 将一行字符转化为字符串
        String str = scan.nextLine();
        scan.close();
        Map<Integer, Integer> m = countChar(str);
        // 请补充完整本段落代码③
        for (Integer integer : m.keySet()) {
            if(1==integer) {
                System.out.println("输入的字母个数："+m.get(integer));
            } else if(2==integer) {
                System.out.println("输入的数字个数："+m.get(integer));
            } else if(3==integer) {
                System.out.println("输入的空格个数："+m.get(integer));
            } else if(4==integer) {
                System.out.println("输入的其它字符个数："+m.get(integer));
            }
        }
    }
}
