package task2;

import java.util.*;

public class FindPairs {

    private static final int TARGET = 13;

    public static void ofPairSum13() {

        Map<String, Integer> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");

        createMapOfDistinctNumbersEncounter(map, s);

        int size = map.size();

        List<Integer> list = createListFromKeySet(map);
        Collections.sort(list);

        for (int i = 0; i < size; i++) {
            Integer s1 = list.stream().findFirst().orElseThrow();

            try {
                int find = TARGET - s1;
                String component = String.valueOf(find);
                if (s1 >= Integer.parseInt(component)) {
                    break;
                }
                if (map.containsKey(component)) {
                    Integer a = map.get(String.valueOf(s1));
                    Integer b = map.get(component);
                    int times = (int) Math.pow(a, b);
                    printNum(s1, component, times);
                }
                list.remove(list.stream().findFirst().orElseThrow());
            } catch (NumberFormatException e) {
                System.err.println("Type only numbers. Try again.");
                ofPairSum13();
            }
        }
        sc.close();
    }

    private static List<Integer> createListFromKeySet(Map<String, Integer> map) {
        Set<String> setUnsorted = map.keySet();
        List<Integer> list = new ArrayList<>();
        for (String s1 : setUnsorted) {
            list.add(Integer.parseInt(s1));
        }
        return list;
    }

    private static void createMapOfDistinctNumbersEncounter(Map<String, Integer> map, String[] s) {
        for (String s1 : s) {
            if (map.containsKey(s1)) {
                map.put(s1, map.get(s1) + 1);
            } else {
                map.put(s1, 1);
            }
        }
    }

    private static void printNum(Integer s1, String component, int n) {
        while (n > 0) {
            System.out.println(s1 + " " + component);
            --n;
        }
    }
}
