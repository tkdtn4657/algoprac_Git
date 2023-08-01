package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2644_BFS {

    static boolean[] check;
    static ArrayList<Integer>[] al;
    static int n, m, start, target;

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

        bfs(start, target);

    }

    //null을 이용해 깊이를 구분한다.
    //상당히 중요한 스킬일 것 같음
    static void bfs(int start, int target) {
        int count = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        q.add(null);
        check[start] = true;

        while (!q.isEmpty()) {
            Integer now = q.poll();

            if(now == null) {
                if(!q.isEmpty()) {
                    q.add(null);
                    count++; // count가 제대로 안먹힘
                }
            }else {
                for (int y : al[now]) {
                    if (!check[y]) {
                        check[y] = true;
                        if (y == target) { // bfs깊이에 따라서 체크 후 해당 깊이 출력
                            System.out.println(count + 1);
                            return;
                        }
                        q.add(y);
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
