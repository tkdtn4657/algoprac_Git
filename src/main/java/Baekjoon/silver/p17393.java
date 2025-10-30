package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p17393 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] ink = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            ink[i] = Long.parseLong(st.nextToken());
        }

        long[] jeomdo = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i= 0; i < n; i++){
            jeomdo[i] = Long.parseLong(st.nextToken());
        }

        long[] result = new long[n];
        //마지막은 필요없으니 n-1
        for(int i = 0; i < n-1; i++){
            int left = i+1;
            int right = n-1;
            int mid = 0;
            long nowInk = ink[i];
            while(left <= right){
                mid = (left+right) / 2;
                if(jeomdo[mid] <= nowInk){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            result[i] = right - i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);

    }
}
