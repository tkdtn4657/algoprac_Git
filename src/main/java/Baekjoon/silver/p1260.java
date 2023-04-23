package Baekjoon.silver;

import java.util.*;

public class p1260 {

    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static ArrayList<Integer> result = new ArrayList<Integer>();
    public static void main() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        int a, b;

        visited = new boolean[n+1];
        A = new ArrayList[n + 1];

        for(int i = 1; i < n + 1; i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            A[a].add(b);// 양방향 입력
            A[b].add(a);
        }

        //번호가 작은 것 순서대로 방문해야하기 때문에 정렬해야함
        for(int i = 1; i < n + 1; i++) {
            Collections.sort(A[i]);
        }

        //구현부


        DFS(v);

        System.out.print(v + " ");

        for (int i : result) {
            System.out.print(i + " ");
        } // DFS탐색순서 출력

        //BFS실행을 위해 값 초기화
        result.clear();
        visited = new boolean[n + 1];

        System.out.println(); // 줄바꿈

        BFS(v);
    }

    static void DFS(int v){
        if(visited[v]){
            result.remove(v);
            return;
        }

        visited[v] = true;

        for(int i : A[v]) {
            if (!visited[i]) {
                result.add(i);
                DFS(i);
            }
        }

    }

    static void BFS(int v){ // 책 스타일
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int now_Node = queue.poll();
            System.out.print(now_Node + " ");
            for(int i : A[now_Node]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
