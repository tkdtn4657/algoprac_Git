package Baekjoon.silver;

import java.util.*;
import java.io.*;

public class p11637 {
    public static void main() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int a[] = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = Integer.parseInt(br.readLine());
            }
            int max = 0;
            int maxIndex = 0;
            for(int i = 0; i < n; i++){
                if(max < a[i]){
                    max = a[i];
                    maxIndex = i;
                }
            }
            sb.append(winCase(a, max, maxIndex));
        }
        System.out.println(sb);

    }

    static String winCase(int[] a, int max, int maxIndex){
        int result = 0;

        for(int i = 0; i < a.length; i++){
            if(a[i] == max&& maxIndex != i){
                return "no winner\n";
            }
        }
        for(int i = 0; i < a.length; i++){
            result += a[i];
        }
        if(result/2 < max){//과반수
            return "majority winner " + (maxIndex+1) +"\n";
        }else if(result/2 >= max){
            return "minority winner " + (maxIndex+1) +"\n";
        }
        return "";
    }
}
