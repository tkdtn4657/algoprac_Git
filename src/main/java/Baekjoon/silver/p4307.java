package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p4307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int test = 0; test < t; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = Integer.parseInt(br.readLine());
            }

            //빠른거는 이분탐색 방식으로 찾을 수 있을 것 같음
            //근데 느린거는...

            Arrays.sort(a);

            //빠른거
            int min = 0;
            for(int i = 0; i < n; i++){
                min = Integer.max(min, Integer.min(a[i], length - a[i]));
            }

            sb.append(min).append(" ");



            //느린거
            //오름차순으로 정렬 된 배열을
            //2, 6, 7
            //첫번째 인덱스 기준으로 끝까지 확인,
            //마지막 인덱스 기준으로 0까지 확인
            //두 길이를 비교해서 가장 느린 것 보내기

            int firstValue = a[0];
            int lastValue = a[a.length-1];

            int maxTime = Math.max(length - firstValue, lastValue);

            sb.append(maxTime).append(System.lineSeparator());

        }

        sb.setLength(sb.length()-1);

        System.out.println(sb);

    }
}
