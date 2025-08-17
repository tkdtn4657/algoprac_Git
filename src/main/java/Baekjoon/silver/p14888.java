package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p14888 {

    static int[] a;
    static int n;
    static int[] operators;
    static int maxNum = Integer.MIN_VALUE;
    static int minNum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        /**
         * index
         * 0 : +
         * 1 : -
         * 2 : *
         * 3 : /
         * 순서로 입력됨
         * */
        operators = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        backtrack(1, a[0]);

        System.out.println(maxNum);
        System.out.println(minNum);

    }

    private static void backtrack(int depth, int sum){
        if(depth == n){
            maxNum = Integer.max(maxNum, sum);
            minNum = Integer.min(minNum, sum);
            return;
        }

        for(int j = 0; j < 4; j++){
            if(operators[j] > 0){
                operators[j]--;
                switch (j){
                    case 0 :
                        backtrack(depth+1, sum + a[depth]);
                        break;
                    case 1 :
                        backtrack(depth+1, sum - a[depth]);
                        break;
                    case 2 :
                        backtrack(depth+1, sum * a[depth]);
                        break;
                    case 3 :
                        backtrack(depth+1, sum / a[depth]);
                        break;
                }
                operators[j]++;
            }
        }

    }
}
