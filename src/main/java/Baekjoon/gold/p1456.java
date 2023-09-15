package Baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 에라토스테네스로 10의 14승의 제곱근인 10의 7승까지의 배열을 만들어서 채워둠
 * 이후 해당 테네스에서 소수를 ArrayList에 추가
 * 해당 ArrayList를 가지고 소수의 n제곱일 때 a 이상, b이하인 수를 찾아서 카운트
 * 값 입력과 범위를 long으로 채워야함을 잊으면 안됨.
 */
public class p1456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        boolean[] eratos = new boolean[10000001];
        ArrayList<Integer> al = new ArrayList<>();

        //에라토스 채우기
        for (int i = 2; i <= eratos.length - 1; i++) {
            if (eratos[i]) {
                continue;
            }

            eratos[i] = true;
            al.add(i);

            for (int j = i + i; j <= eratos.length-1; j += i) {
                if (!eratos[j]) {
                    eratos[j] = true;
                }
            }
        }
        //소수를 먼저 다 구했음 소수는 al 안에 있음

        int count = 0;
        for (int i = 0; i < al.size(); i++) {
            //al의 n제곱을 다 해봐야함
            long num = al.get(i);
            for (int j = 2; Math.pow(num, j) <= b; j++) {
                if (Math.pow(num, j) >= a) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
