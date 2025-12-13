package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p3055 {

    static boolean[][] visited;
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Node[][] map = new Node[r][c];
        visited = new boolean[r][c];

        Integer[] dochiPlace = new Integer[3];
        ArrayList<Integer[]> waterPlace = new ArrayList<>();
        for(int i = 0; i < r; i++){
            String inputLine = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = new Node(' ', 0);
                map[i][j].c = inputLine.charAt(j);
                if(map[i][j].c == 'S') {
                    dochiPlace = new Integer[]{i, j, 0};
                } else if(map[i][j].c == '*'){
                    waterPlace.add(new Integer[]{i, j, 0});
                }
            }
        }

        Queue<Integer[]> queue = new ArrayDeque<>(waterPlace);

        //물부터
        while(!queue.isEmpty()){
            Integer[] nowPlace = queue.poll();

            for(int[] move : moves){
                int dx = nowPlace[0] + move[0];
                int dy = nowPlace[1] + move[1];
                int distance = nowPlace[2] + 1;

                if(dx < 0 || dx >= r || dy < 0 || dy >= c) continue;

                if(!visited[dx][dy]){
                    visited[dx][dy] = true;
                    if(map[dx][dy].c == '.'){
                        map[dx][dy].c = '*';
                        map[dx][dy].distance = distance;
                        queue.add(new Integer[]{dx, dy, distance});
                    }
                }
            }
        }

        visited = new boolean[r][c];
        queue.add(dochiPlace);
        int resultDistance = 0;

        queueEnd:
        while(!queue.isEmpty()){
            Integer[] nowPlace = queue.poll();

            for(int[] move : moves){
                int dx = nowPlace[0] + move[0];
                int dy = nowPlace[1] + move[1];
                int distance = nowPlace[2] + 1;

                if(dx < 0 || dx >= r || dy < 0 || dy >= c) continue;

                if(!visited[dx][dy]){
                    visited[dx][dy] = true;
                    if(map[dx][dy].c == '.' || (map[dx][dy].c == '*' && map[dx][dy].distance > distance)){
                        map[dx][dy].c = 'S';
                        map[dx][dy].distance = distance;
                        queue.add(new Integer[]{dx, dy, distance});
                    } else if(map[dx][dy].c == 'D'){
                        resultDistance = distance;
                        break queueEnd;
                    }
                }
            }
        }

        if(resultDistance == 0){
            System.out.println("KAKTUS");
        } else {
            System.out.println(resultDistance);
        }

    }

    private static class Node{

        char c;
        int distance;
        Node(char c, int distance){
            this.c = c;
            this.distance = distance;
        }
    }
}
