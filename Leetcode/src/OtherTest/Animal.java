package OtherTest;

/**
 * @author Jacob
 * @creator 2022/9/4-9:42
 * @description
 */
public class Animal {

    protected int age;
    String name;
    private int sname;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public void speak(){
        System.out.println("This is Animal");
    }

    public void live(){
        System.out.println("Animal live");
    }
}
