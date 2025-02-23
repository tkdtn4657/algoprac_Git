package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p14501_2 {

    static int n;
    static ArrayList<SangDam> al = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int useDay = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            al.add(new SangDam(useDay, cost));
        }

        recur(0, 0, 0);

        System.out.println(max);
    }

    private static void recur(int index, int money, int count){
        if(index == n){
            if(count == 0){
                return;
            }
            max = Integer.max(money, max);
            return;
        }
        if(index > n){
            return;
        }

        recur(index + 1, money, count + 1);
        recur(index + al.get(index).useDay, money + al.get(index).cost, count + 1);

    }

    private static class SangDam{
        int useDay;
        int cost;

        SangDam(int useDay, int cost){
            this.useDay = useDay;
            this.cost = cost;
        }
    }
}
