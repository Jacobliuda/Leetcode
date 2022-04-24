package ComprehensiveTest;

import java.util.*;

/**
 * @author Jacob
 * @creator 2022/4/9-16:17
 * @description
 */
class Solder implements Comparable{
    int height;
    String name;

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public Solder(int height){
        this.height = height;
    }


    @Override
    public int compareTo(Object o) {
        Solder s2 = (Solder)o;

        if(this.getHeight() != s2.getHeight()){
            if(this.height < s2.height)
                return -1;
            else
                return 1;
        }
//            return this.getHeight() - s2.getHeight();
        else
            return this.getName().compareTo(s2.getName());
    }
}

public class Meituan0409_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
//        ArrayList<Solder> solderArray = new ArrayList<>();
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        Solder[] solders = new Solder[n];
        for(int i = 0; i < n; i++){
            solders[i] = new Solder(Integer.parseInt(s1[i]));
        }
        String[] s2 = sc.nextLine().split(" ");
        for(int i = 0; i < n; i++){
            solders[i].setName(s2[i]);
        }
        Arrays.sort(solders);
        for(int i = 0; i < solders.length; i++){
            System.out.print(solders[i].getName());
            if(i!=solders.length-1)
                System.out.print(" ");
        }
    }
}
