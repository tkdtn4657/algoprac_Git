package Programmers.lv0;

import java.util.*;

public class p181936 {
    public static void main(String[] args) {
        System.out.println(solution(55, 10, 5));

    }

    public static int solution(int number, int n, int m) {
        List<Integer> list = Arrays.asList(n, m);


        if(list.stream()
                .allMatch((result) -> number % result == 0)
        ){
            return 1;
        }
        else return 0;
    }
}
