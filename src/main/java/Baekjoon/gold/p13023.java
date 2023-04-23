package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p13023 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int isDepthFive = 0;

    public void main() throws IOException { // depth 5까지 들어가는지 확인하면됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int a, b;

        A = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            A[a].add(b); // 그래도 양방향은 달아야하나보네?
            A[b].add(a);
        }

        //구현부

        for (int i = 0; i < n; i++) {
            DFS(i, 1);
            if (isDepthFive == 1) {
                break;
            }
        }

        System.out.println(isDepthFive);
    }

    static void DFS(int n, int depth) {
        if (depth == 5 || isDepthFive == 1) {
            isDepthFive = 1;
            return;
        }

        visited[n] = true;

        for (int i = 0; i < A[n].size(); i++) {
            if (!visited[A[n].get(i)]) {
                DFS(A[n].get(i), depth + 1);
            }
        }

        visited[n] = false;

    }
}
