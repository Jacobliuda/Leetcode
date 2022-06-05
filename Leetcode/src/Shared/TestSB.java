package Shared;

/**
 * @author Jacob
 * @creator 2022/3/27-16:24
 */
public class TestSB {
    public static void main(String[] args){
        StringBuilder builder = new StringBuilder("ssss");
        System.out.println("builder容量:" + builder.capacity() + ";" + "builder字符串长度:" + builder.length());

        //添加的字符串长度为 14
        builder.append("aaaabbbbccccdd");
        System.out.println("builder容量:" + builder.capacity() + ";" + "builder字符串长度:" + builder.length());

        //添加的字符串长度为 16
        builder.append("aaaabbbbccccdddd");
        System.out.println("builder容量:" + builder.capacity() + ";" + "builder字符串长度:" + builder.length());

        //添加的字符串长度为 60
        builder.append("aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffff");
        System.out.println("builder容量:" + builder.capacity() + ";" + "builder字符串长度:" + builder.length());
    }
}
