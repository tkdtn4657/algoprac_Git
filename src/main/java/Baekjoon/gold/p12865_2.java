package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p12865_2 {

    static ArrayList<Bag> al = new ArrayList<>();
    static int n;
    static int k;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[n][100001];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            al.add(new Bag(w, v));
        }

        recur(0, 0);

        System.out.println(dp[0][0]);

    }

    private static int recur(int index, int weight){
        if( weight > k) return -99999;
        if( index == n) return -0;
        if( dp[index][weight] != -1) return dp[index][weight];

        dp[index][weight] = Integer.max(recur(index + 1, weight), recur(index + 1, weight + al.get(index).w) + al.get(index).v);

        return dp[index][weight];
    }

    private static class Bag {
        int w;
        int v;

        private Bag(int w, int v){
            this.w = w;
            this.v = v;
        }
    }
}
