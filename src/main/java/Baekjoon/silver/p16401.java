package Baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 다시한번 정리를 하자.
 * m명에게 줄 길이를 정할건데, 어떻게 정할거야?
 * 길이가 가장 긴거로
 * 첫번째 위치는 가장 긴거 - m명위치
 * ex) 3 10 -> index = 7 -< 최소길이
 * 하지만, 4 3 처럼 범위 벗어날 때 -> 45
 * 나눠줄수없으면 0출력
 * 처음에
 * 45 / 4
 * 11 -> 가능하면 오른쪽 가능하지않으면 왼쪽 이분탐색
 * 누적합으로 값을 저장
 */
public class p16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long maxLength = 0;
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] += Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int left = 0;
        int right = a[n-1];

        long center = (left + right) / 2;
        while (left <= right) {
            int count = 0;
            for(int i = 0; i < n; i++){
                count += a[i] / center;
            }

            if(count >= m){
                if(maxLength < center) {
                    maxLength = center;
                }

                left = (int) (center + 1);
            }else{
                right = (int) (center - 1);
            }

            center = (left + right) / 2;
        }
        System.out.println(maxLength);
    }
}
