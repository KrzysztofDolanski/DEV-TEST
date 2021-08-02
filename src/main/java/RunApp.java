import task3.GraphsCounter;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunApp {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean flag = true;

        do {
            System.out.println("Type number:\n1 to run app for the list of distinct elements sorted in ascending order, plus the basic measurement information that contains the number of elements in \n" +
                    "  the source, number of distinct elements, min and max value\n2 to run app that provide all the pairs (from input) that sum up to 13\n3 to run app that give you number of graphs as output\n4 End application.");

            String i = sc.nextLine();

            Pattern pattern = Pattern.compile("[1234]{1}");
            Matcher matcher = pattern.matcher(i);
            if (matcher.matches()) {

                switch (i) {
                    case "1":
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.print("Have a nice day!");
                        break;
                }

                flag = false;
            } else System.err.println("Please enter a single number ranging from 1 to 3.\n4 for the exit");

        } while (flag);
    }
}

