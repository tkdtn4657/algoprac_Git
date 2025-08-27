package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p11054 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dpLeft = new int[n];
        int[] dpRight = new int[n];
        Arrays.fill(dpLeft, 1);
        Arrays.fill(dpRight, 1);

        //-> 작은거에서 큰거
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(a[i] > a[j]) {
                    dpLeft[i] = Integer.max(dpLeft[i], dpLeft[j] + 1);
                }
            }
        }

        //<- 작은거에서 큰거
        for(int i = n-1; i >= 0; i--){
            for(int j = n-1; j >= i; j--){
                if(a[i] > a[j]){
                    dpRight[i] = Integer.max(dpRight[i], dpRight[j] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = Integer.max(dpLeft[i] + dpRight[i], max);
        }

        System.out.println(max-1);

    }
}
