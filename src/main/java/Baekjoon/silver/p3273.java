package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p3273 {
    public static void main(String[] args) throws IOException {

        /**
         * 인트 배열을 받아와서 오름차순 정렬 후 투포인터 탐색
         *
         * 서로 다른 두 수를 골라서 x 크기에 일치하는지 확인하는 문제
         * 서로 다른 두 수는 배열에서 각 포인터 배열을 꺼내와서 체크
         *
         * ex)
         * n = 5
         * x = 4
         * 1 2 3 4 5
         * ^       ^
         *
         * 합친 값이 x보다 작으면 좌측 포인터를, x보다 크면 우측 포인터를 이동
         * 합친 값이 정확히 일치하면? 좌측 포인터, 우측 포인터 모두 이동
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(a);

        int i = 0;
        int j = a.length-1;
        int ijSum;
        int correctCount = 0;
        while(i < j) {
            ijSum = a[i] + a[j];

            if(x == ijSum){
                correctCount++;
                i++;
                j--;
            } else if (x > ijSum){
                i++;
            } else if (x < ijSum){
                j--;
            }
        }

        System.out.println(correctCount);
    }
}
