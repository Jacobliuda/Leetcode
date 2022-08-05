package Shared;

/**
 * @author Jacob
 * @creator 2022/6/23-14:59
 * @description
 */
public class SingletonTest {
    private static SingletonTest instance;

    private SingletonTest() {

    }

    public static SingletonTest getInstance() {
        if(instance == null){
             instance = new SingletonTest();
        }
        return instance;
    }

    public static void test(){
        System.out.println("helloworld");
    }

    public static void main(String[] args) {
        SingletonTest instance = getInstance();
    }
}
