package OtherTest.AbstractInterface;

/**
 * @author Jacob
 * @creator 2022/6/30-20:05
 * @description
 */
public class RealExample extends AbstractExample{
    @Override
    public void fun() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        AbstractExample abstractExample = new AbstractExample() {
            @Override
            public void fun() {
                
            }
        };


    }
}
