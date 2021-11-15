package age;

import java.util.List;

public class Compute {

    public static void main(String[] args) {

        Person p01 = new Person("Michel", 45);
        Person p02 = new Person("Sam", 32);
        Person p03 = new Person("Michou", 20);
        Person p04 = new Person("Billy", 5);

        List<Person> people = List.of(p01, p02, p03, p04);

        int sum = 0;
        int count = 0;

        for (Person person: people) {
            if (person.getAge() > 20) {
                count++;
                sum += person.getAge();
            }
        }

        double average = 0d;
        if (count > 0) {
            average = sum / count;
        }

        System.out.println("Average = " + average);
    }

}