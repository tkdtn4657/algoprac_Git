package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p16236 {

    static int[][] moves = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        visited = new boolean[n][n];

        BabyShark babyShark = new BabyShark(0, 0);;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    babyShark = new BabyShark(i, j);
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int sumCount = 0;
        map[babyShark.x][babyShark.y] = 0;
        while(true) {
            visited = new boolean[n][n];
            queue.clear();

            queue.add(new int[]{babyShark.x, babyShark.y, 0});
            visited[babyShark.x][babyShark.y] = true;

            int bestDist = Integer.MAX_VALUE;
            int bestX = -1;
            int bestY = -1;

            while (!queue.isEmpty()) {
                int[] nowPlace = queue.poll();

                if (nowPlace[2] > bestDist) break;

                for (int[] move : moves) {
                    int dx = nowPlace[0] + move[0];
                    int dy = nowPlace[1] + move[1];
                    int distance = nowPlace[2] + 1;

                    if (dx < 0 || dy < 0 || dx >= n || dy >= n) continue;
                    if (visited[dx][dy]) continue;

                    if (map[dx][dy] <= babyShark.size) {
                        visited[dx][dy] = true;

                        if (map[dx][dy] != 0 && map[dx][dy] < babyShark.size) {
                            // 최단거리 갱신 or 같은 거리면 위/왼 비교
                            if (distance < bestDist) {
                                bestDist = distance;
                                bestX = dx;
                                bestY = dy;
                            } else if (distance == bestDist) {
                                if (dx < bestX || (dx == bestX && dy < bestY)) {
                                    bestX = dx;
                                    bestY = dy;
                                }
                            }
                        }

                        // 계속 BFS 확장
                        queue.add(new int[]{dx, dy, distance});
                    }
                }
            }

            if (bestDist == Integer.MAX_VALUE) break;

            babyShark.moveAndEat(bestX, bestY, map);
            sumCount += bestDist;
        }

        System.out.println(sumCount);

    }

    private static class BabyShark{

        int size = 2;
        int eatFish = 0;
        int x;
        int y;
        BabyShark(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void moveAndEat(int x, int y, int[][] map){
            map[x][y] = 0;
            this.x = x;
            this.y = y;
            eatFish++;
            if(eatFish == size){
                size++;
                eatFish = 0;
            }
        }

    }
}
