package Baekjoon.gold;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * 정신 멀쩡할 때 복습해야함
 * 에라토스테네스의 체 형식으로 풀었고 거의 정답코드 참조해서 해결했음
 * 주말복습필
 */
public class p1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] pow = new boolean[(int) (max - min + 1)];

        long num;
        int count = 0;
        for (long i = 2; i * i <= max; i++) {
            long powNum = i * i;
            long startIndex = min / powNum;
            if (min % powNum != 0) {
                startIndex++;
            }
            for (long j = startIndex; powNum * j <= max; j++) {
                pow[(int) (powNum * j - min)] = true;
            }
        }

        for (boolean check : pow) {
            if (!check) {
                count++;
            }
        }

        System.out.println(count);

    }
}
