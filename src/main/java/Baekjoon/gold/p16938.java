package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p16938 {

    static int n;
    static int l;
    static int r;
    static int x;
    static int[] a;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        // n이 크기, l이 합 최소치, r이 합 최대치
        // right - left >= x가 최소와 최대 합차

        //선택한 수가 2 이상
        //sum >= l && sum <= r
        //max - min >= x


        recur(0, 1, a[0], a[0]);
        recur(0, 0, 0, Integer.MAX_VALUE);

        System.out.println(count);

    }

    private static void recur(int index, int pickCount, int sum, int min){
        //종료 조건, index가 n에 닿았을 때
        if(index+1 == n){
            return;
        }

        //픽한거 -> 픽한거,픽안한거 -> 픽한거, 픽안한거
        //픽 안한거 -> 픽한거, 픽안한거 -> 픽한거 픽안한거

        recur(index+1, pickCount, sum, min);
        if(min == Integer.MAX_VALUE){
            min = a[index+1];
        }

        int nowSum = a[index+1] + sum;

        recur(index+1, pickCount+1, nowSum, min);
        if(pickCount+1 >= 2 && nowSum >= l && nowSum <= r && a[index+1] - min >= x){
            count++;
        }

    }
}
