package Baekjoon.silver;

import java.util.*;
import java.io.*;


public class p1418 {
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>(n+1);


        for(int i = 0; i <= n; i++) {
            a[i] = i;
            hs.put(i, 0);
        } // 1 2 3 4 5 6 7 8 9 10
        //1은 무조건 됨
        for(int i = 2; i <= n; i++){
            int soinsu = a[i];
            for(int j = 2; j <= soinsu; j++) {//sqrt(soinsu)?
                while(soinsu % j == 0) {
                    soinsu /= j;
                    hs.put(i, j);//하다보면 맥스
                }
            }
        }
        int count = 0;
        for(int i = 1; i < a.length; i++) {
            if(hs.get(i) <= k){
                count++;
            }
        }
        System.out.println(count);
    }
}

/* //다른사람풀이 속도겁나빠름..
* import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[100001];
        for(int i = 2; i <= n; i++) {
            if(arr[i] != 0)
                continue;
            for(int j = i; j <= n; j += i) {
                arr[j] = i;
            }
        }
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(arr[i] <= k)
                cnt++;
        }
        System.out.println(cnt);
    }
}
*
*
* */