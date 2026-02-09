package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p23747 {

    private static final int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int r;
    private static int c;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        Node[][] map = new Node[r][c];

        for(int i = 0; i < r; i++){
            String inputLine = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = new Node(inputLine.charAt(j), i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        //0부터 시작이 아니니까 -1입력
        int hr = Integer.parseInt(st.nextToken()) - 1;
        int hc = Integer.parseInt(st.nextToken()) - 1;

        int[] nowPlace = new int[]{hr, hc};

        String command = br.readLine();
        for(int i = 0; i < command.length(); i++){
            char commandEach = command.charAt(i);

            switch (commandEach){
                case 'U':
                    nowPlace[0] += -1;
                    nowPlace[1] += 0;
                    break;
                case 'D':
                    nowPlace[0] += 1;
                    nowPlace[1] += 0;
                    break;
                case 'L':
                    nowPlace[0] += 0;
                    nowPlace[1] += -1;
                    break;
                case 'R':
                    nowPlace[0] += 0;
                    nowPlace[1] += 1;
                    break;
                case 'W':
                    map[nowPlace[0]][nowPlace[1]].ward = true;
                    break;
            }
        }

        //ward를 찾아서 bfs돌린다. 같은 place찾기
        //nowplace 기준으로 상하좌우까지 밝힌다.

        boolean[][] visited = new boolean[r][c];

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j].ward){
                    bfs(map, i, j, visited);
                }
                if(i == nowPlace[0] && j == nowPlace[1]){
                    map[i][j].fillFlag = true;

                    for(int[] move : moves){
                        int dx = i + move[0];
                        int dy = j + move[1];

                        if(dx < 0 || dy < 0 || dx >= r || dy >= c) continue;

                        map[dx][dy].fillFlag = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j].fillFlag){
                    sb.append(".");
                } else {
                    sb.append("#");
                }
            }
            sb.append(System.lineSeparator());
        }
        sb.setLength(sb.length()-1);

        System.out.println(sb);

    }

    private static void bfs(Node[][] map, int i, int j, boolean[][] visited){
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[]{i, j});

        char place = map[i][j].place;


        visited[i][j] = true;
        map[i][j].fillFlag = true;

        while(!queue.isEmpty()){
            Integer[] now = queue.poll();

            for(int[] move : moves){
                int dx = move[0] + now[0];
                int dy = move[1] + now[1];

                if(dx < 0 || dy < 0 || dx >= r || dy >= c
                        || visited[dx][dy] || map[dx][dy].place != place) continue;

                visited[dx][dy] = true;
                map[dx][dy].fillFlag = true;
                queue.add(new Integer[]{dx, dy});
            }
        }

    }

    private static class Node{
        char place;
        int x;
        int y;
        boolean ward;
        boolean fillFlag = false;

        public Node(char place, int x, int y) {
            this.place = place;
            this.x = x;
            this.y = y;
            this.ward = false;
        }
    }
}
