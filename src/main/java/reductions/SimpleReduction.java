package reductions;

import java.util.List;

public class SimpleReduction {

    public static void main(String[] args) {

        List<Integer> ints = List.of(1, 2, 3, 4);

        int product = ints.stream().reduce(1, (int1, int2) -> int1 * int2);

        System.out.println("Product = " + product);
    }

}
