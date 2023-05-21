package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p2798{

    public static void main() throws IOException{
        //21이 넘으면 안됨 카드의 합을 최대한 크게

        //변형규칙 블랙잭
        //딜러는 N장의 카드를 모두 보이게 바닥에 놓음
        //딜러는 숫자 M을 외친다.

        // 즉 여기서 말하는 규칙은 N의 카드장수의 합이 M을 넘으면 안됨.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] ia = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < ia.length; i++){
            ia[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ia);
        int temp = 0;
        int max = 0;
        int EndGame = 0;
        while(EndGame != 1) {
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    for(int g = 0; g < n; g++){
                        if(i != j && i != g && j != g) {
                            temp = ia[i] + ia[j] + ia[g];
                            if(max < temp && temp <= m){
                                max = temp;
                            }
                        }
                        if(i == n-1 && j == n-1 && g == n-1){
                            EndGame = 1;
                        }
                        if(max == m){
                            EndGame = 1;
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}