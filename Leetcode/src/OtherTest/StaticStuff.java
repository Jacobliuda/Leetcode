package OtherTest;

/**
 * @author Jacob
 * @creator 2022/7/18-17:01
 * @description
 */
public class StaticStuff {
    static int x=10;
    static {
        x+=5;
    }
    public static void main(String args[]){
        System.out.println("x=" + x);
    }
    static { x/=3;}
}
