package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p11170 {
    static int count = 0; // 다른 메서드에서 사용하기 위한 count 구현

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st; // 값을 입력받은 것을 공백 기준으로 자름
        for(int i = 0; i < t; i++){ // 테스트케이스 기준으로 값을 입력받음
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            countZero(n, m);
        }
    }

    static void countZero(int n, int m){
        count = 0; // 매 테스트 케이스마다 새로운 카운트를 해야하기 때문에 값 초기화
        String temp;
        for(int i = n; i < m+1; i++){
            temp = String.valueOf(i);
            for(int j = 0; j < temp.length(); j++){
                if(temp.charAt(j)-'0' == 0){
                    count++;
                }
            }
        }
        System.out.println(count); // 해당 범위의 카운트 출력
    }
}
