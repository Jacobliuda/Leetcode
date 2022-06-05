package Shared;

import java.util.ArrayList;

/**
 * @author Jacob
 * @creator 2022/5/15-12:09
 * @description
 */
public class StreamTest {
    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("Tom", 8900, "male", "New York"));
        personList.add(new Person("Jack", 7000, "male", "Washington"));
        personList.add(new Person("Lily", 7800, "female", "Washington"));
        personList.add(new Person("Anni", 8200, "female", "New York"));
        personList.add(new Person("Owen", 9500, "male", "New York"));
        personList.add(new Person("Alisa", 7900, "female", "New York"));

        personList.stream().filter(person -> person.getSalary() > 9000).forEach(System.out::println);
    }
}

