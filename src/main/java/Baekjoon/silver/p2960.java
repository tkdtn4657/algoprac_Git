package Baekjoon.silver;

import java.util.*;
import java.io.*;

public class p2960 {
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[n + 1];
        int count = 0;
        //7 3 3은 무시하고 에라스토테네스의 체를 해보면
        //2~7까지 모든 정수를 적고
        //
        //1은 무조건
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                if (check[j] == false) {
                    check[j] = true;
                    count++;
                    if (count == k) {
                        System.out.println(j);
                        return;
                    }
                }
            }
        }
    }
}
