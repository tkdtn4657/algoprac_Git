package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class p1038 {

    static Stack<Long> st = new Stack<>();
    static ArrayList<Long> al = new ArrayList<>();

    static int count = 0;
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        if(n <= 10){
            if(n == 0){
                System.out.println(0);
                return;
            }
            System.out.println(n);
            return;
        }
        recur(10);
        List<Long> list = al.stream().sorted().collect(Collectors.toList());

        long result = -1;
        if(list.size() > n){
            result = list.get(n);
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
