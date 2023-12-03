package Baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 나무 m미터가 필요
 * 절단기의 높이를 이분탐색의 요소
 * 범위가 20억 => long범위로 잡아야할듯? 마지막에 실험해보자
 *
 * 4 7
 * 20 15 10 17
 *
 * 13 8 3 10
 *
 * 나무를 아껴서 가장 최소의 m만 챙겨야하기 때문에!!! 절단기 설정 높이는 높아야 하는 것
 * 가장 높은 것을 기준으로 이분탐색
 *
 * 이 테스트케이스에서는 20이 가장 높다
 * ->
 * 이분탐색의 범위를 1 ~ 20까지로 정함
 * 중간부터 시작해서 쭉 돌려
 * 만약에 범위안에 갯수가 맞다면 10
 * 틀리면 왼쪽으로 가야겠지 => 이 높이에선 최소나무길이가 안맞기때문
 * 맞으면 오른쪽으로 가야겠지 => 가장 조금 나무를 잘라야하니까
 */

public class p2805 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        int right = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            right = Integer.max(right, a[i]);
        }

        int left = 1;
        int height = 0;
        while(left <= right){
            int count = 0;
            int center = (left + right) / 2;
            //나무 윗동을 center값 기준으로 자르기
            for(int i = 0; i < n;i++){
                if(a[i] >= center){
                    count += a[i] - center;
                }
            }

            if(count >= m){
                height = center;
                left = center + 1;
            }else{
                right = center -1;
            }

        }

        System.out.println(height);

    }
}
