package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p12865 {

    static ArrayList<Bag> al = new ArrayList<>();
    static int n;
    static int k;
    static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            al.add(new Bag(w, v));
        }

        recur(0, 0, 0, 0);

        System.out.println(maxValue);

    }

    private static void recur(int index, int value, int weight, int count){
        if(index >= n){
            if(weight > k || count == 0){
                return;
            }

            maxValue = Integer.max(maxValue, value);
            return;
        }

        recur(index + 1, value, weight, count);
        recur(index + 1, value + al.get(index).v, weight + al.get(index).w, count + 1);
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
