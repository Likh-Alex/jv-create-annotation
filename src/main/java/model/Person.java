package model;

public class Person {
    private String name;
    private int age;
    private Bet bet;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='"
                + name + '\''
                + ", age=" + age
                + '}';
    }
}
