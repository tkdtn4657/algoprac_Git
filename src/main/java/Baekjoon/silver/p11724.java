package Baekjoon.silver;

import java.util.ArrayList;
import java.util.Scanner;

public class p11724 { // dfs구현
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public void main() { // dfs로 풀어보기
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 노드
        int M = sc.nextInt(); // 에지
        int u, v;
        visited = new boolean[N + 1]; // 방문검증배열
         // 각 노드별 인접리스트 저장
        A = new ArrayList[N + 1];

        for (int i = 1; i < N+1; i++) { // 초기화작업
            visited[i] = false;
        }

        for(int i = 1; i < N + 1; i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++){
            u = sc.nextInt();
            v = sc.nextInt();

            A[u].add(v); // 이번엔 양방향 에지니까 둘다 추가
            A[v].add(u);
        }

        //구현부
        int count = 0;
        for(int i = 1; i < N + 1; i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }
    static void DFS(int v){
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for(int i : A[v]){
            if(visited[i] == false){
                DFS(i);
            }
        }

//        for(int i = 0; i < A[v].size(); i++){
//            if(visited[i] == false){
//                DFS(i);
//            }
//        }
    }
}
