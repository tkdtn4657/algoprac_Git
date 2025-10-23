package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p16953 {
    static int result = Integer.MAX_VALUE;
    static int a;
    static int b;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        //2를 곱한다
        //1을 수의 가장 오른쪽에 추가한다
        if(a == b){
            System.out.println(1);
        }

        recur(a*2, 1);
        recur(Long.parseLong(a+"1"), 1);

        //연산 최솟값 + 1 이거나 -1
        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(result+1);
        }
    }

    static void recur(long number, int count){
        if(number > b){
            return;
        } else if(number == b){
            result = Integer.min(result, count);
            return;
        }

        recur(number * 2, count + 1);
        recur(Long.parseLong(number+"1"), count + 1);
    }

}
