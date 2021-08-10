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

        int a = 1;
        List<Set<String>> list = new ArrayList<>();

        while (count > 0) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            if (s1.length < 2) {
                System.err.println("Please, first type number of graphs and than type two integers as an graph. Try again");
                countGraphs();
            }
            while (a > 0) {
                list.add(Set.of(s1[0], s1[1]));
                a--;
            }

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).contains(s1[0]) || list.get(i).contains(s1[1])) {
                    Set<String> set = new HashSet<>();
                    for (String s2 : list.get(i)) {
                        set.add(s2);
                    }
                    set.add(s1[0]);
                    set.add(s1[1]);
                    list.set(i,set);
                }
            }
            count--;
        }


        for (int i = 0; i < list.size() - 1; i++) {
            for (int i1 = i + 1; i1 < list.size(); i1++) {
                if (list.get(i) != null || list.get(i1) != null) {
                    if (Collections.disjoint(list.get(i), list.get(i1))) ;
                    list.get(i).addAll(list.get(i1));
                    list.get(i1).clear();
                }
            }
        }

        int result = 0;


        for (Set<String> set : list) {
            if (set!=null){
                result++;
            }
        }

        sc.close();
        return result;
    }
}


