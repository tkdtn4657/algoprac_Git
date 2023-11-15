package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p18352_distance {
    static int n, m, k, x;
    static ArrayList<Integer>[] al;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        al = new ArrayList[n + 1];
        distance = new int[n + 1];
        Arrays.fill(distance, -1);

        for (int i = 0; i <= n; i++) {
            al[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            al[a].add(b);
        }

        //BFS 시작
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        distance[x] = 0;

        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int node : al[now]){
                if(distance[node] == -1){
                    distance[node] = distance[now]+1;
                    queue.add(node);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
//        Arrays.sort(distance);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int count = 0;
        for(int num = 1; num < distance.length; num++){
            if(distance[num] == k) {
                priorityQueue.add(num);
                count++;
            }
        }
        if(count == 0){
            System.out.println(-1);
            return;
        }

        for(int num : priorityQueue){
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }
}
