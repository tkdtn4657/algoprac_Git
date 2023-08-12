package Baekjoon.Compatition;

import java.io.*;
import java.util.*;

public class p985_1 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        //만렙1 구만2
        for(int i = 0; i < n; i++) {
            if (300 == a[i]){ b[i] = 1;}
            else if(300> a[i] && a[i] >=275) {b[i] = 2;}
                else if(275> a[i] && a[i] >= 250){b[i] = 3;

            }
                else {
                    b[i] = 4;
            }

        }

        for(int i = 0; i < n; i++){
            if(i == n-1){
                System.out.println(b[i]);
            }else {
                System.out.print(b[i] + " ");
            }
        }

    }
}
