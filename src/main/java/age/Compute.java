package age;

import java.util.List;
import java.util.OptionalDouble;

public class Compute {

    public static void main(String[] args) {

        Person p01 = new Person("Michel", 45);
        Person p02 = new Person("Sam", 32);
        Person p03 = new Person("Michou", 20);
        Person p04 = new Person("Billy", 5);

        List<Person> people = List.of(p01, p02, p03, p04);

        // version sans optional (exception si filter renvoie un stream vide)
        double average =
                people.stream()
                        .mapToInt(Person::getAge)
                        .filter(age -> age > 20)
                        .average()
                        .orElseThrow();

        // version avec optional (optional vide si filter renvoie un stream vide)
        OptionalDouble optionalAverage =
                people.stream()
                        .mapToInt(Person::getAge)
                        .filter(age -> age > 20)
                        .average();

        System.out.println("Average = " + average);
        System.out.println("Optional Average = " + (optionalAverage.isPresent() ? optionalAverage.getAsDouble() : "N/A"));
    }

}