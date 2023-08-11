package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1325 {

    static ArrayList<Integer>[] al;
    static int check[];
    static int n, m;
    static int maxCount = 0;
    static int answer[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        al = new ArrayList[n + 1];
        check = new int[n + 1];
        answer = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            al[i] = new ArrayList<>();
        }

        //단방향에 엣지방향을 반대로 생각해야함 b -> a
        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());

            al[a].add(b);
        }


        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(check, -1);//체크배열초기화
            bfs(i);
        }

        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            max = Integer.max(answer[i], max);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            if (max == answer[i]) {
                if (i == n) {
                    sb.append(i);
                } else {
                    sb.append(i).append(" ");
                }
            }
        }


        System.out.println(sb);

    }

    static void bfs(int start) {
        check[start]++;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int count = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int num : al[now]) {
                if (check[num] == -1) {
                    check[num] = check[now] + 1;
                    q.add(num);
                    answer[num]++;
                }
            }
        }
    }
}
