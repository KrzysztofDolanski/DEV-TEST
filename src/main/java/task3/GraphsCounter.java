package task3;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class GraphsCounter {

    public static int countGraphs() {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<String>();
        int count = 0;
        try {
            count = sc.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Type only number. Try again");
            countGraphs();
        }
        sc.nextLine();
        int result = count;
        while (count > 0) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            if (s1.length < 2) {
                System.err.println("Please, first type number of graphs and than type two integers as an graph. Try again");
                countGraphs();
            }
            if (set.contains(s1[0]) || set.contains(s1[1])) {
                result--;
            }
            set.add(s1[0]);
            set.add(s1[1]);
            count--;
        }
        sc.close();
        return result;
    }
}
