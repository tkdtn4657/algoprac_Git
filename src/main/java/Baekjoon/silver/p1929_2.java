package Baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 에라토스테네스의 체를 사용 -> 미리채워넣기 vs 채우는 도중에 값을 넣기
 * 이번엔 채우는 도중에 값을 넣기 채용
 * 이유는? 내가 이해하기 편하기 때문
 * 미리채워넣는거는 범위를 미리 지정해야하는데 생각해야할게 조금 더 있다(n의 범위, eratos[1]의 값 처리 등)
 */
public class p1929_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] eratos = new boolean[n + 1];
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (!eratos[i]) {
                eratos[i] = true;
                al.add(i);
                for (int j = i; j <= n; j += i) {
                    if (!eratos[j]) {
                        eratos[j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int primeNum : al) {
            if (primeNum >= m && primeNum <= n) {
                sb.append(primeNum).append("\n");
            }
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);

    }
}
