package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int p1, p2;
        p1 = 0;
        p2 = x-1;
        int maxCount = 1;
        int maxSum = 0;
        int sum = 0;

        for(int i = 0; i < x; i++){
            sum += a[i];
            maxSum = sum;
        }

        while(p1 < n-1 && p2 < n-1){
            sum -= a[p1];
            p1++;
            p2++;
            sum += a[p2];

            if(maxSum < sum){
                maxSum = sum;
                maxCount = 1;
            } else if(maxSum == sum) {
                maxCount++;
            }

        }

        StringBuilder sb = new StringBuilder();
        if(maxSum < 1) {
            sb.append("SAD");
        } else {
            sb.append(maxSum).append("\n");
            sb.append(maxCount).append("\n");
        }

        System.out.println(sb);


    }
}
