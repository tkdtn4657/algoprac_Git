package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p10815_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int number : b){
            int i = 0;
            int j = n-1;
            boolean flag = false;

            while(i <= j){
                int mid = (i + j)/2;

                if(a[mid] == number){
                    flag = true;
                    break;
                } else if(a[mid] > number){
                    j = mid - 1;
                } else if(a[mid] < number){
                    i = mid + 1;
                }
            }

            if (flag) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);

    }
}
