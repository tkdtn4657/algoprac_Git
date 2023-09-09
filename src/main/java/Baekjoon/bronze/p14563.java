package Baekjoon.bronze;

import java.util.*;
import java.io.*;

public class p14563{
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[t];

        for(int i=0;i<t;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<t; i++){
            int sum = 0;
            for(int j=1;j<arr[i];j++){
                if(arr[i]%j==0) sum+=j;
            }
            if(arr[i]==sum) System.out.println("Perfect");
            else if (arr[i] < sum) System.out.println("Abundant");
            else System.out.println("Deficient");
        }
    }
}