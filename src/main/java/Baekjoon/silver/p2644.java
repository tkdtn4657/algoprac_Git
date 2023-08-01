package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2644 {

    static boolean[] check;
    static ArrayList<Integer>[] al;
    static int n, m, start, target;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        al = new ArrayList[n + 1];
        check = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            al[i] = new ArrayList<>();
        }

        int x, y;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            al[x].add(y);
            al[y].add(x);
        }
        check[start] = true;
        dfs(start, 0);
        if (!flag) {
            System.out.println(-1);
        }

    }

    static void dfs(int n, int count) { //7 3
        if (n == target) { //도착하면 flag 변경 후 종료
            flag = true;
            System.out.println(count);
            return;
        } else if (flag) { //이미 찾았으면 더이상 dfs를 돌 필요 없음
            return;
        } else {
            for (int a : al[n]) {
                if (!check[a]) {
                    check[a] = true;
                    dfs(a, count + 1);
                }
            }
        }
    }
}
