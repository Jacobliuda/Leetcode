package OtherTest.AbstractInterface;

/**
 * @author Jacob
 * @creator 2022/6/30-20:26
 * @description
 */
public class Bird implements Flyable{
    @Override
    public void run() {
        System.out.println("hello from Bird");
    }

    public static void main(String[] args) {
        Flyable.run2();
        Flyable.run3();
    }
}
