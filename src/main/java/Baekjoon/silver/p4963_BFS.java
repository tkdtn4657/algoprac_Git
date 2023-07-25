package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p4963_BFS {

    //이번 조건은 대각도 포함해야함
    static final int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static final int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

    static boolean[][] check;
    static int[][] map;
    static int w, h;
    static int count = 0;


    public static void main(String[] args) throws IOException { //섬의 갯수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()); // 첫값 입력
        while ((w = Integer.parseInt(st.nextToken())) != 0 && (h = Integer.parseInt(st.nextToken())) != 0) { // 값 입력받기
            map = new int[h][w];
            check = new boolean[h][w];
            count = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) { // 전체 맵에서 구분되어 있는 상태로 check가 안되어있을 때 돌림 + 섬의 개수를 구하는거니까 count체크
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !check[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
            st = new StringTokenizer(br.readLine());
        }

        System.out.println(sb);
    }

    static void bfs(int i, int j) { //BFS는 특별하게 다른 BFS랑 다른 부분은 없음
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        check[i][j] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int k = 0; k < dx.length; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 0 && y >= 0 && x < h && y < w){
                    if(map[x][y] != 0 && !check[x][y]){
                        check[x][y] = true;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
