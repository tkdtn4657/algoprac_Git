package Programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class p42746 {

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
//        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));

    }


    public static String solution(int[] numbers) {
        String[] stringNumbers = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(stringNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a1 = Integer.parseInt(o1+o2);
                int a2 = Integer.parseInt(o2+o1);

                return a2 - a1;

            }
        });


        StringBuilder sb = new StringBuilder();
        for (String num : stringNumbers) {
            if(sb.length() != 0 && sb.charAt(0) == '0'){
                return sb.toString();
            }
            sb.append(num);
        }

        return sb.toString();
    }
}
