package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p24444 {

    static boolean[] isVisit;
    static ArrayList<Integer>[] a;

    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int u, v;

        isVisit = new boolean[n+1];
        a = new ArrayList[n+1];

        for(int i = 1; i < n + 1; i++){
            a[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            a[u].add(v);
            a[v].add(u);
        }

        for(int i = 1; i < n + 1; i++){
            if(!a[i].isEmpty()) {
                Collections.sort(a[i]);
            }
        }

        BFS(r, n, m);

    }

    static void BFS(int r, int n, int m){ // r이 1이라고 가정했을 때
        Queue<Integer> queue = new LinkedList<>();

        int temp;
        int[] count = new int[n+1];
        int countNum = 1;

        isVisit[r] = true;
        count[r] = countNum++;
        queue.offer(r);

        while(!queue.isEmpty()){
            temp = queue.poll();
            for(int i = 0; i < a[temp].size(); i++) {
                if (!isVisit[a[temp].get(i)]) {//방문하지 않았을 때 실행
                    isVisit[a[temp].get(i)] = true;
                    count[a[temp].get(i)] = countNum++;
                    queue.offer(a[temp].get(i));
                }
            }
        }

        for(int i = 1; i < n + 1; i++){
            System.out.println(count[i]);
        }
    }
}
