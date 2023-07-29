package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1920 {

    static int[] aN;
    static boolean flag = false;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        aN = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            aN[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(aN);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i <m; i++){
            int start = 0;
            int center = aN.length/2;
            int end = aN.length-1;
            flag = false;
            binarySearch(Integer.parseInt(st.nextToken()), start, center, end);

            if(flag) {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);

    }
    static void binarySearch(int searchNum, int start, int center, int end){
        if(start > end){
            flag = true;
            return;
        }
        if(searchNum == aN[center]){
            sb.append(1).append("\n");
            return;
        }else if(searchNum > aN[center]){
            start = center+1;
            center = (start + end) /2;
            binarySearch(searchNum, start, center, end);
        }else if(searchNum < aN[center]){
            end = center -1;
            center = (start + end)/2;
            binarySearch(searchNum, start, center, end);
        }
    }
}
