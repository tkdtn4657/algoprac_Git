package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p14497 {

    static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int junanX = Integer.parseInt(st.nextToken())-1;
        int junanY = Integer.parseInt(st.nextToken())-1;
        int targetX = Integer.parseInt(st.nextToken())-1;
        int targetY = Integer.parseInt(st.nextToken())-1;

        char[][] map = new char[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String inputLine = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = inputLine.charAt(j);
            }
        }
        
        //2가지 방법으로 돌아야하는 것 같음
        //상하좌우를 다 도는데, 방향에 0이 있으면 해당 방향 기준으로 상하좌우를 또 확인해서 큐에 넣음
        //1을 발견할 때만 거리를 늘리면 됨 그 외에는 전부 bfs


        //그 방법 아니면 다익스트라로 돌아라 라는 뜻 같음

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(o1 -> o1[2]));
        pq.add(new Integer[]{junanX, junanY, 0});
        visited[junanX][junanY] = true;

        int result = 0;
        whileEnd:
        while(!pq.isEmpty()){
            Integer[] now = pq.poll();

            for(int[] move : moves){
                int dx = move[0] + now[0];
                int dy = move[1] + now[1];

                if(dx < 0 || dy < 0 || dx >= n || dy >= m || visited[dx][dy]) continue;
                visited[dx][dy] = true;
                if(map[dx][dy] == '#') {
                    result = now[2] + 1;
                    break whileEnd;
                }
                if(map[dx][dy] == '1'){
                    pq.add(new Integer[]{dx, dy, now[2]+1});
                } else {
                    pq.add(new Integer[]{dx, dy, now[2]});
                }
                
            }

        }
        
        System.out.println(result);

    }
}
