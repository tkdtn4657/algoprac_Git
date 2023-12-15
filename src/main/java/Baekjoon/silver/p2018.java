package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2018 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = i+1;
        }

        //누적합을 구해두고 ? 누적합이 왜필요?
        //투포인터로 값 찾기?

        int left = 0;
        int right = 0;
        int sum = a[0];
        int count = 1;
        // 4가 있어
        //4를 만드는 방법
        //1, 3 | 4
        //1, 3

        while(right < n-1 && left < n-1){
//            if(left == right){
//                right++;
//                continue;
//            }

            if(sum == n && right < n-1){
                right++;
                sum += a[right];
                count++;
                continue;
            }

            if(sum > n){
                sum -= a[left];
                left++;
                continue;
            }

            if(sum < n && right < n-1){
                right++;
                sum += a[right];
                continue;
            }

        }

        System.out.println(count);

    }
}
