package Baekjoon.Compatition.UtilCupChapter2;

import java.io.*;
import java.util.*;

public class p1079_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] todoPage = new int[n];
        int[] doPage = new int[n];

        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            todoPage[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            doPage[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            if(todoPage[i] <= doPage[i]) count++;
        }

        System.out.println(count);
    }
}
