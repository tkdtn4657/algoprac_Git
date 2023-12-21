package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p9024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n, k;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);

            //-7 -4 -3 -2 0 1 2 5 9 12
            //center를 k로 잡고 투포인터 해결?
            //서로 다른 정수가 주어지기 때문에 하나 발견하면 바로 이동할 수 있음
            int left = 0;
            int right = n - 1;
            int min = Integer.MAX_VALUE;
            int minCount = 0;
            while (left < right) {
                int sum = a[left]+a[right];
                int abs = Math.abs(sum - k);

                if (abs == min) {
                    minCount++;
                }
                if (abs < min) {
                    min = abs;
                    minCount = 1;
                }

                if(sum < k){
                    left++;
                }else{
                    right--;
                }
            }
            sb.append(minCount).append("\n");
        }
        System.out.println(sb);
    }
}
