package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2636 {

    static int[][] moves = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static int a;
    static int b;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int[][] map = new int[a][b];
        visited = new boolean[a][b];
        //모두 녹아서 없어지는 시간과
        //종료 직전의 치즈조각 수 저장 및 출력

        for(int i = 0; i < a; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < b; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        Queue<int[]> queue = new LinkedList<>();

        int count = 2;
        while(count < 100) {
            queue.add(new int[]{0, 0});
            visited = new boolean[a][b];
            while (!queue.isEmpty()) {
                int[] nowNode = queue.poll();
                int x = nowNode[0];
                int y = nowNode[1];
                if (visited[x][y]) continue;
                visited[x][y] = true;
                int nodeValue = map[x][y];
                if(nodeValue >= count) continue;
                for (int[] move : moves) {
                    int dx = x + move[0];
                    int dy = y + move[1];

                    if (dx < 0 || dy < 0 || dx >= a || dy >= b) continue;

                    //현재 위치가 공기, 이동할 위치가 치즈일 때
                    if (map[dx][dy] == 1 && nodeValue != 1 && nodeValue < count) {
                        map[dx][dy] = count;
                    } else {
                        queue.add(new int[]{dx, dy});
                    }

                }
            }
            count++;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                max = Integer.max(map[i][j], max);
            }
        }

        int result = 0;
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                if(map[i][j] == max) result++;
            }
        }

        System.out.println(max - 1);
        System.out.println(result);



    }

}
