package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p15656 {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            array[i] = num;
        }

        Arrays.sort(array);
        recur(0, "");

        System.out.println(sb);

    }

    private static void recur(int count, String s){
        if(count == m){
            sb.append(s).append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(count == 0){
                recur(count + 1, String.valueOf(array[i]));
            } else {
                recur(count + 1, s + " " + array[i]);
            }
        }
    }
}
