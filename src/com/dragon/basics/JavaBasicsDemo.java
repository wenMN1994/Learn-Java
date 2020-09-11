package com.dragon.basics;

import java.io.File;
import java.util.Collection;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2020/7/23 17:39
 * @description：
 * @modified By：
 * @version: $
 */
public class JavaBasicsDemo {
    public static void main(String[] args) {
        /**
         * == 比较的是变量(栈)内存中存放的对象的(堆)内存地址，用来判断两个对象的地址是否相同，即是否是
         * 指相同一个对象。比较的是真正意义上的指针操作。
         * 1、比较的是操作符两端的操作数是否是同一个对象。
         * 2、两边的操作数必须是同一类型的（可以是父子类之间）才能编译通过。
         * 3、比较的是地址，如果是具体的阿拉伯数字的比较，值相等则为true，如：
         * int a=10 与 long b=10L 与 double c=10.0都是相同的（为true），因为他们都指向地址为10的堆。
         *
         * equals用来比较的是两个对象的内容是否相等，由于所有的类都是继承自java.lang.Object类的，所以
         * 适用于所有对象，如果没有对该方法进行覆盖的话，调用的仍然是Object类中的方法，而Object中的
         * equals方法返回的却是==的判断。
         *
         * 总结：所有比较是否相等时，都是用equals 并且在对常量相比较时，把常量写在前面，因为使用object的
         * equals object可能为null 则空指针
         * 在阿里的代码规范中只使用equals ，阿里插件默认会识别，并可以快速修改，推荐安装阿里插件来排
         * 查老代码使用“==”，替换成equals
         */
//        String x = "string";
//        String y = "string";
//        String z = new String("string");
//        System.out.println(x==y); //true
//        System.out.println(x==z); //false
//        System.out.println(x.equals(y)); //true
//        System.out.println(x.equals(z)); //true

        /**
         * 每new一个对象都要重新开辟一个内存空间
         * 所有的类都是继承自java.lang.Object类的，所以
         * 适用于所有对象，如果没有对该方法进行覆盖的话，调用的仍然是Object类中的方法，而Object中的
         * equals方法返回的却是==的判断。
         */
//        Cat cat1 = new Cat("老王");
//        Cat cat2 = new Cat("老王");
//        System.out.println(cat1.equals(cat2)); //false

        /**
         * equals本质上就是==，只不过String和Integer等重写了equals方法，把它变成了值比较
         */
//        String s1 = new String("张三");
//        String s2 = new String("张三");
//        System.out.println(s1.equals(s2)); //true

        /**
         * 两个对象的hashCode()相同，equals不一定为true
         */
//        String str1 = "通话";
//        String str2 = "重地";
//        System.out.println(String.format("str1: %d | str2: %d", str1.hashCode(), str2.hashCode()));
//        System.out.println(str1.equals(str2)); //false

        /**
         * String是只读字符串，它并不是基本数据类型，而是一个对象。从底层源码来看是一个final类型的字符数组，
         * 所引用的字符串不能被改变，一经定义，无法再增删改。每次对String的操作都会生成新的String对象
         * private final char value[];
         *
         *
         */
//        String string = new String();
//        StringBuffer stringBuffer = new StringBuffer();
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuffer.append("+1");
//        stringBuilder.append(1);

        String s1 = new String("123456789");
        System.out.println("返回指定索引处的字符:"+s1.charAt(5));
        System.out.println("返回指定字符的索引"+s1.indexOf("6"));
        System.out.println("返回指定字符的索引"+s1.replace("1","0"));


        /**
         * 详细过程分析（可参考JVM虚拟机规范关于JVM指令部分）:
         * 〇此方法被调用时test01方法被压入java栈内存中的栈帧（栈帧中可存在局部变量表、
         * 	 操作数栈、动态链接、方法出口等）;
         * 〇i++和++i二者的区别是：i++先赋值后自增,++i是先自增后赋值.
         * ①在局部变量表中定义变量i=1;
         * ---------------------------------------------------------
         * ②i = i++;拆解为jvm虚拟机指令来讲，即：
         * ---------------------------------------------------------
         * 	1.把局部变量i的值压入操作数栈
         * 		局部变量表		操作数栈
         * 		int i=1		1
         * 	2.i局部变量自增1
         *		局部变量表		操作数栈
         * 		int i=2		1
         * 	3.把操作数栈中的值赋值给局部变量i
         *		局部变量表		操作数栈
         * 		int i=1
         *  从上面的分析可以看出,在运算过程中局部变量i确实是有变为2过，但是在赋值时又被操作数栈中
         *  之前压入栈中的值给覆盖了,所以最终局部变量i的结果还是1.
         *  ---------------------------------------------------------
         * ③int j = i++;拆解为jvm虚拟机指令来讲，即：
         * 	1.把局部变量i的值压入操作数栈
         * 		局部变量表		操作数栈
         * 		int i=1		1
         * 		int j
         * 	2.i局部变量自增1
         *		局部变量表		操作数栈
         * 		int i=2		1
         * 		int j
         * 	3.把操作数栈中的值赋值给局部变量j
         *		局部变量表		操作数栈
         * 		int i=2
         * 		int j=1
         * 	从上面的分析可以知道,这次操作数栈的值没有赋值给i而是赋值给了新的变量j,所以i=2;j=1;
         *  ---------------------------------------------------------
         * ④int k = i + ++i * i++;拆解为jvm虚拟机指令来讲，即：
         * 	(个人理解虽然是先算乘除再加减,但是得先有数才能运算,所以先从左至右把操作数压入栈)
         * 	1.把局部变量i的值压入操作数栈(i)
         * 		局部变量表		操作数栈
         * 		int i=2		2
         * 		int j=1
         * 		int k
         * 	2.局部变量i先自增1,然后再把局部变量i压入栈(++i)
         *		局部变量表		操作数栈
         * 		int i=3		3
         * 		int j=1		2
         * 		int k
         * 	3.把局部变量i的值先压入操作数栈,然后局部变量自增1(i++)
         *		局部变量表		操作数栈
         * 		int i=4		3
         * 		int j=1		3
         * 		int k		2
         * 	4.操作数栈中的前两个数(从栈顶开始)取出求乘积运算,然后再把临时结果压入栈
         *		局部变量表		操作数栈
         * 		int i=4		9
         * 		int j=1		2
         * 		int k
         * 	5.再把操作数栈中的两个数取出求和再赋值给k
         *		局部变量表		操作数栈
         * 		int i=4
         * 		int j=1
         * 		int k=11
         * 总结：
         * 	1）"="赋值运算最后计算
         * 	2）"="赋值运算右边的规则是：从左至右加载变量值依次压入操作数栈
         * 	3）实际先算哪个,看运算符的优先级
         * 	4）自增、自减操作都是直接修改变量的值,不经过操作数栈
         * 	5）最后的赋值之前,临时结果也是存储在操作数栈中
         */
//        int i = 1;//①
//        i = i++;//②
//        int j = i++;//③
//        int k = i + ++i * i++;//④
//        System.out.println("i = "+ i);
//        System.out.println("j = "+ j);
//        System.out.println("k = "+ k);

//        File file = new File("");

        /**
         *
         */
//        Integer i1 = 100;
//        Integer i2 = 100;
//        Integer i3 = 200;
//        Integer i4 = 200;
//        System.out.println(i1==i2);
//        System.out.println(i3==i4);

        /**
         *
         */
//        Double i1 = 100.0;
//        Double i2 = 100.0;
//        Double i3 = 200.0;
//        Double i4 = 200.0;
//        System.out.println(i1==i2);
//        System.out.println(i3==i4);

    }
}

class Cat {
    public Cat(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

