package OtherTest;

/**
 * @author Jacob
 * @creator 2022/9/4-9:45
 * @description
 */
public class Cat extends Animal{

    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.live();
        cat.speak();
        System.out.println(cat.age);
        System.out.println(cat.name);
//        System.out.println(cat.sname);
//        cat.eat();.
    }

    public Cat() {
    }

    public Cat(String name) {
        super(name);
    }

//    @Override
    public void speak(){
        System.out.println("This is Cat");
    }

    public void eat(){
        System.out.println("Cats eat fishes");
    }

}
