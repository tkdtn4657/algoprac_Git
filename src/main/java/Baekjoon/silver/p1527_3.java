package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1527_3 {

    static int count = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        recur(4);
        recur(7);

        //미리 리스트를 쭉 뽑아 10억까지
        //리스트를 뽑은 후에 특정 시점 기준으로 이후 값 필터
        count = Math.toIntExact(list.stream().filter(num -> num >= a).filter(num -> num <= b).count());

        System.out.println(count);

    }

    static void recur(int num){
        if(num <= 100_000_000){
            list.add(num);
            recur(num * 10 + 4);
            recur(num * 10 + 7);
        } else {
            list.add(num);
        }
    }
}
