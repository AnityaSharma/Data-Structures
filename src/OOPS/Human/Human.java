package OOPS.Human;

public class Human {
    int age;
    String name;
    int salary;
    Boolean married;
    static long population;
    public Human(int age, String name, int salary, Boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        Human.population += 1;
    }
}
