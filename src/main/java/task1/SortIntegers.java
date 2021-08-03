package task1;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class SortIntegers {

    public static void sort() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] numbers = s.split(" ");
        Set<Integer> set = new TreeSet<>();

        for (String s2 : numbers) {
            try {
                set.add(Integer.parseInt(s2));
            } catch (NumberFormatException e) {
                System.err.println("Type only numbers. Try again.");
                sort();
            }
        }

        int max = 0;
        int min = Integer.MAX_VALUE;

        for (Integer integer : set) {
            System.out.print(integer + " ");
            if (integer > max)
                max = integer;
            if (integer < min)
                min = integer;
        }
        System.out.println("\ncount: " + numbers.length + "\ndistinct: " + set.size() + "\nmin: " + min + "\nmax: " + max);
        sc.close();
    }
}
