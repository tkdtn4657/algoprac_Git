package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1590_bs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][3];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
            a[i][2] = Integer.parseInt(st.nextToken());
        }

        long min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int s = a[i][0];
            int l = a[i][1];
            int c = a[i][2]-1;
            //버스가 영진이와 만날 수 없을 때
            if(s + (l * (c)) < t) continue;
            int left = 0;
            int right = c;
            int mid = (left + right) / 2;
            while(left < right){
                //t > time
                //한쪽을 +하거나 -해줘야 하는데 이걸 lowerbound 이분탐색 또는 higerbound라고 함?
                if(s + (l * mid) < t){
                    left = mid + 1;
                } else {
                    right = mid;
                }
                mid = (left + right) / 2;
            }
            min = Long.min(min, (s + left*l)-t);

        }

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}
