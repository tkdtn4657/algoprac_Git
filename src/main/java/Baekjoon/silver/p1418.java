package Baekjoon.silver;

import java.util.*;
import java.io.*;

import static java.lang.Math.sqrt;

public class p1418 {
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] a = new int[n+1];
        ArrayList<Integer> maxArray = new ArrayList<Integer>();
        //int i = 2;
        for(int i = 0; i <= n; i++) {
            a[i] = i;
        } // 1 2 3 4 5 6 7 8 9 10

        //1은 무조건 됨
        for(int i = 2; i <= n; i++){
            int soinsu = a[i];
            for(int j = 2; j <= soinsu; j++) {//sqrt(soinsu)?
                while(soinsu % j == 0) {
                    maxArray.add(j);
                    soinsu /= j;
                }
                a[i] = Collections.max(maxArray);
                maxArray = new ArrayList<>();
                maxArray.add(1);
            }
        }
        int count = 0;
        for(int i = 1; i < a.length; i++) {
            if(a[i] <= k){
                count++;
            }
        }
        System.out.println(count);
    }
}