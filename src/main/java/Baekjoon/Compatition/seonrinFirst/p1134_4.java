package Baekjoon.Compatition.seonrinFirst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1134_4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int inputNum = n;
        for(int i = 0; i < n; i++){
            a[i] = inputNum--;
        }

        int temp = a[a.length-1];
        a[a.length-1] = a[a.length-2];
        a[a.length-2] = temp;

        StringBuilder sb = new StringBuilder();
        for(int num : a) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);


    }
}
