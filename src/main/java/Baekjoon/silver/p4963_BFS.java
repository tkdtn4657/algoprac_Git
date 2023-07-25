package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p4963_BFS {

    static final int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static final int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

    static boolean[][] check;
    static int[][] map;
    static int w, h;
    static int count = 0;
    static ArrayList<Integer> countList = new ArrayList<>();

    public static void main(String[] args) throws IOException { //섬의 갯수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while ((w = Integer.parseInt(st.nextToken())) != 0 && (h = Integer.parseInt(st.nextToken())) != 0) {
            map = new int[h][w];
            check = new boolean[h][w];
            count = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !check[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            countList.add(count);
            st = new StringTokenizer(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for(int count : countList){
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int i, int j) {
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
