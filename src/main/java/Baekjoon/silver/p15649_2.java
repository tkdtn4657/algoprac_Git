package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p15649_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> al = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            al.add(i);
        }

        StringBuilder sb = new StringBuilder();
        boolean[] check = new boolean[n+1];
        recur(al, m, 0, "", check, sb);

        System.out.println(sb);
    }

    public static void recur(ArrayList<Integer> al, int m, int count, String s, boolean[] check, StringBuilder sb){
        if(count == m){
            sb.append(s).append("\n");
        }

        for(int i = 0; i < al.size(); i++){
            int number = al.get(i);
            if(check[number]){
                continue;
            }
            check[number] = true;
            if(count == 0){
                recur(al, m, count + 1, String.valueOf(number), check, sb);
            } else {
                recur(al, m, count + 1, s + " " + number, check, sb);
            }
            check[number] = false;

        }
    }
}
