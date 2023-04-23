package Baekjoon.silver;

import java.util.ArrayList;
import java.util.Scanner;

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
            A[i] = new ArrayList<>(n + 1);
        }

        for(int i = 0; i < m; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            A[a].add(b);// 양방향 입력
            A[b].add(a);
        }

        //구현부


        DFS(v);
//        5 5 3
//        5 4
//        5 2
//        1 2
//        3 4
//        3 1

        //DFS가 이상하게 동작하는듯?
        // result : 3 1 2 5 4가 나와야하는데
        // output : 3 4 5 2 1이 나옴

        System.out.println(); // 줄바꿈

        for(int i = 1; i < n + 1; i++){ // BFS실행

        }

    }

    static void DFS(int v){
        if(visited[v]){
            result.remove(v);
            return;
        }

        visited[v] = true;

        for(int i : A[v]) {
            if (!visited[i]) {
                DFS(i);
                result.add(i);
            }

        }

        for (int i : result) {
            System.out.println(i);
        }
    }

    static void BFS(){

    }
}
