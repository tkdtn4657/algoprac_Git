package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p16564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] a = new long[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        //모든 팀 캐릭터의 레벨을 K이하로 사용해서 레벨업 시키기
        //lower Bound
        long left = 0;
        long right = Integer.MAX_VALUE;
        long mid = (left + right) / 2;
        while(left <= right){
            long count = k;
            for(int i = 0; i < n; i++){
                if(mid - a[i] > 0){
                    count -= mid - a[i];
                    if(count < 0) break;
                }
            }
            if(count < 0){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }

        System.out.println(right);

    }
}
