package OtherTest;

/**
 * @author Jacob
 * @creator 2022/7/21-10:27
 * @description
 */
public class StringTest {
    public static void main(String[] args) {
        String a = new String("myString");
        String b = "myString";
        String c = "my" + "String";
        String d = c;
        System.out.print(a == b);// false
        System.out.print(a == c);// false
        System.out.print(b == c);// true
        System.out.print(b == d);// true
    }
}
