package Baekjoon.Compatition.seonrinFirst;

import java.io.*;
import java.util.*;

public class p1134_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[k];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for( int num : a){
            sb.append(getGrade(num*100/n)).append(" ");
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    static int getGrade(int number){
        if(number <= 4){
            return 1;
        }else if(number <= 11){
            return 2;
        }else if(number <= 23){
            return 3;
        }else if(number <= 40){
            return 4;
        }else if(number <= 60){
            return 5;
        }else if(number <= 77){
            return 6;
        }else if(number <= 89){
            return 7;
        }else if(number <= 96){
            return 8;
        }else if(number <= 100){
            return 9;
        }
        return 0;
    }
}
