package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1940 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int left = 0;
        int right = n-1;
        int count = 0;
        //left가 작은거  right가 큰거
        //1, 2, 3, 4, 5, 7
        while(left < right){
            if(left == right){
                right++;
                continue;
            }
            if(a[left] + a[right] == m){
                count++;
                right--;
                left++;
                continue;
            }
            if(a[left] + a[right] > m){
                right--;
                continue;
            }
            if(a[left] + a[right] < m){
                left++;
                continue;
            }
        }
        System.out.println(count);
    }
}
