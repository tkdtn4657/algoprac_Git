package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2667_BFS {
    static int[][] move = {{0,1}, {0,-1}, {1, 0}, {-1,0}};
    static char[][] map;
    static boolean[][] visited;
    static int depth;
    static int n;
    static List<Integer> answerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && map[i][j] == '1') {
                    bfs(i, j);
                }
            }
        }

        Collections.sort(answerList);
        StringBuilder sb= new StringBuilder();
        sb.append(answerList.size()).append("\n");
        for(int num : answerList){
            sb.append(num).append("\n");
        }
        System.out.println(sb);

    }

    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        depth = 1;

        while(!queue.isEmpty()){
            int[] xy = queue.poll();
            for(int[] moving : move){
                int nowX = xy[0] + moving[0];
                int nowY = xy[1] + moving[1];
                if(nowX >= 0 && nowY >= 0 && nowX < n && nowY < n &&
                        !visited[nowX][nowY] && map[nowX][nowY] == '1'){
                    visited[nowX][nowY] = true;
                    depth++;
                    queue.add(new int[]{nowX, nowY});
                }
            }
        }

        answerList.add(depth);
    }
}
