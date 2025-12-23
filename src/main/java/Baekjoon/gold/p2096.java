package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] maxMemory = new int[3];
        int[] minMemory = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){
            int num = Integer.parseInt(st.nextToken());
            maxMemory[i] = num;
            minMemory[i] = num;
        }

        //최초 선택
        for(int i = 1; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int prevMaxFirst = maxMemory[0];
            int prevMaxSecond = maxMemory[1];
            int prevMaxThird = maxMemory[2];
            int prevMinFirst = minMemory[0];
            int prevMinSecond = minMemory[1];
            int prevMinThird = minMemory[2];

            //0
            maxMemory[0] = Integer.max(prevMaxFirst, prevMaxSecond) + a;
            minMemory[0] = Integer.min(prevMinFirst, prevMinSecond) + a;

            //1
            maxMemory[1] = Integer.max(prevMaxFirst, Integer.max(prevMaxSecond, prevMaxThird)) + b;
            minMemory[1] = Integer.min(prevMinFirst, Integer.min(prevMinSecond, prevMinThird)) + b;

            //2
            maxMemory[2] = Integer.max(prevMaxSecond, prevMaxThird) + c;
            minMemory[2] = Integer.min(prevMinSecond, prevMinThird) + c;

        }

        System.out.println(Integer.max(maxMemory[0], Integer.max(maxMemory[1], maxMemory[2])) + " "
        + Integer.min(minMemory[0], Integer.min(minMemory[1], minMemory[2])));


    }
}
