package OtherTest.AbstractInterface;

/**
 * @author Jacob
 * @creator 2022/6/30-19:52
 * @description
 */
public interface Flyable {
    int a = 1;

    void run();

    static void run2() {
        System.out.println("static method from interface Flyable");
    }

    static void run3() {
        System.out.println("default method from interface Flyable");
    }
}
