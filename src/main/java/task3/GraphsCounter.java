package task3;

import java.util.*;

public class GraphsCounter {


    public static int countGraphs() {

        Scanner sc = new Scanner(System.in);

        int count = 0;

        try {
            count = sc.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Type only number. Try again");
            countGraphs();
        }
        sc.nextLine();

        List<Set<Integer>> list = new ArrayList<>();

        int a = 1;
        int result = count + 1;

        while (count > 0) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            if (s1.length < 2) {
                System.err.println("Please, first type number of graphs and than type two integers as an graph. Try again");
                countGraphs();
            }

            while (a > 0) {
                list.add(Set.of(Integer.valueOf(s1[0]), Integer.valueOf(s1[1])));
                a--;
            }

            boolean flag = true;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).contains(Integer.parseInt(s1[0])) || list.get(i).contains(Integer.parseInt(s1[1]))) {
                    Set<Integer> set1 = new HashSet<>();
                    for (int j : list.get(i)) {
                        set1.add(j);
                    }
                    set1.add(Integer.parseInt(s1[0]));
                    set1.add(Integer.parseInt(s1[1]));
                    list.set(i, set1);
                    result--;
                    flag = false;
                    break;
                }
            }
            if (flag)
                list.add(Set.of(Integer.parseInt(s1[0]), Integer.parseInt(s1[1])));
            count--;
        }


        for (int i = 0; i < list.size() - 1; i++) {
            for (int i1 = i + 1; i1 < list.size(); i1++) {
                for (Integer integer : list.get(i1)) {
                if (list.get(i).contains(integer))
                    result--;
                    break;
                }
            }
        }


        sc.close();
        return result;
    }
}


