package Baekjoon.gold;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class p1174 {

    static Stack<Long> st = new Stack<>();
    static ArrayList<Long> al = new ArrayList<>();

    static int count = 0;
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        /*
         0, 1, 2, 3, 4, 5, 6, 7, 8, 9
         10 | 20, 21 | 30, 31, 32 | 40, 41, 42, 43 | 50, 51, 52, 53, 54 |
         60, 61, 62, 63, 64, 65 | 70, 71, 72, 73, 74, 75, 76 |
         80, 81, 82, 83, 84, 85, 86, 87 | 90, 91, 92, 93, 94, 95, 96, 97, 98 |
         210 |320, 321, 310 | 410, 420, 421, 430, 431, 432
         */

        //9 -> 8 7 6 5 4 3 2 1 0
        //8 -> 7 6 5 4 3 2 1 0
        //7 -> 6 5 4 3 2 1 0
        //6 -> 5 4 3 2 1 0
        //5 -> 4 3 2 1 0
        //4 -> 3 2 1 0
        //3 -> 2 1 0
        //2 -> 1 0
        //1 -> 0

        // 10 20 21 30 31 32
        //9876543210 까지가 최대 수
        //재귀에서 자릿수(depth)를 받아서 depth 범위만큼 foreach돈다.
        //기본적으로 for문 돌 때 자기보다 낮은 수에 대해서만 수행
        //재귀 안에서 count가 같으면 return - count는 static으로 갖고있기에 종료가능
        //for문이 다 돌면 재귀호출 시행

        if(n <= 10){
            System.out.println(n-1);
            return;
        }
        recur(10);
        List<Long> list = al.stream().sorted().collect(Collectors.toList());

        long result = -1;
        if(list.size() >= n){
            result = list.get(n-1);
        }

        System.out.println(result);
    }

    private static void recur(long nowNum){
        for(long i = 0; i < nowNum; i++){
            count++;
            st.push(i);
            st.forEach(sb::append);
            al.add(Long.valueOf(sb.toString()));
            sb.setLength(0);
            recur(i);
            st.pop();
        }
    }
}
