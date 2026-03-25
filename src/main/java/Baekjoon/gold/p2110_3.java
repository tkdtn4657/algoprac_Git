package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2110_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        for(int i = 0 ; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(a);

        int left = 1;
        int right = a[n - 1] - a[0];
        int mid = left + (right-left) / 2;

        //mid : 좌표 거리인데 공유기를 기준으로 c개 이상 만족하면 성공
        //해당 문제는 c개 이상 만족하는 것 중 최대 거리를 뽑는거기 때문에 upperBound

        int max = Integer.MIN_VALUE;
        while(left <= right){
            mid = left + (right - left) / 2;

            long lastC = a[0];
            long count = 1;
            for(int i = 1; i < n; i++){
                if(a[i] - lastC >= mid){
                    lastC = a[i];
                    count++;
                }
            }

            if(count >= c){
                max = Integer.max(max, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        System.out.println(max);

    }
}
