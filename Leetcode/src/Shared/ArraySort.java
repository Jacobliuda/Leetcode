package Shared;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jacob
 * @creator 2022/5/10-9:29
 * @description
 */
public class ArraySort {
    public void sort(int[][] nums){
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

        for (int[] num : nums) {
            System.out.println(num[0]
            + " " + num[1]);
        }
    }
    
    @Test
    public void test(){
        int[][] nums = new int[][]{{1,10}, {2,9}, {3,8}, {4,7}, {5,6}};
        sort(nums);
    }

    @Test
    public void test1(){
        String s = "hello??worl;d ?this is ? ?a";
        String[] split = s.split("\\?");
        for (String s1 : split) {
            System.out.println(s1);
        }
    }

    @Test
    public void test2() {
        Person person = new Person("Jacob", 23000, 23, "male", "middle");
        Class<? extends Person> aClass = person.getClass();
        System.out.println(aClass);
    }

}

class Person {
    private String name; // 姓名
    private int salary; // 薪资
    private int age; // 年龄
    private String sex; //性别
    private String area; // 地区

    public Person(String name, int salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Person() {
    }

    public Person(String name, int salary, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.sex = sex;
        this.area = area;
    }
}

