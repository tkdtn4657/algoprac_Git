package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p11689 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long result = n;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) { // 이게 되면 해당 i는 소인수라는뜻
                result = result - result / i;

                //해당 소인수를 n에서 전체 제거
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        //n이 1보다 크면 n이 마지막 소인수일것이다. 때문에 result에 연산한번더
        if (n > 1) {
            result = result - result / n;
        }
        System.out.println(result);

    }
}
