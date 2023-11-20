package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int maxLevel = -1;
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);

            int index = a.length - 1;
            int count = 1;
            //양수 : true, 음수 : false
            boolean flag = true;
            final int middle = (a.length - 1) / 2;
            int[] temp = new int[a.length];
            temp[middle] = a[index--];
            while (index > -1) {
                if (flag) {
                    temp[middle + count] = a[index--];
                    flag = false;
                } else {
                    temp[middle - count] = a[index--];
                    flag = true;
                    count++;
                }
            }
            int tempNum = temp[0];
            int levelAbs;
            for (int i = 1; i < n; i++) {
                if (tempNum > temp[i]) {
                    levelAbs = Math.abs(tempNum - temp[i]);
                } else {
                    levelAbs = Math.abs(temp[i] - tempNum);
                }

                if (levelAbs > maxLevel) {
                    maxLevel = levelAbs;
                }

                tempNum = temp[i];
            }

            //범위벗어난 첫값과 끝값 한번 더 계산
            if (tempNum > temp[0]) {
                levelAbs = Math.abs(tempNum - temp[0]);
            } else {
                levelAbs = Math.abs(temp[0] - tempNum);
            }
            if (levelAbs > maxLevel) {
                maxLevel = levelAbs;
            }

            sb.append(maxLevel).append("\n");
        }

        System.out.println(sb);

    }
}
