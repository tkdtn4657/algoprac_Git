package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p13702 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        //주전자
        int n = Integer.parseInt(st.nextToken());
        //사람 수
        int k = Integer.parseInt(st.nextToken());

        long[] a = new long[n];
        //막걸리 주전자
        for(int i = 0; i < n; i++){
            a[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(a);

        long maxML = 0;
        long left = 1;
        long right = a[n-1];

        while(left <= right){
            long center = (left+right) / 2;
            long count = 0;
            for(int i = 0; i < n; i++){
                count += a[i] / center;
            }

            if(count >= k){
                maxML = center;
                left = center+1;
            }else{
                right = center-1;
            }
        }
        System.out.println(maxML);
    }
}
