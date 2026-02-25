package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p20926 {
    static int w;
    static int h;
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Floor[][] map;
    static int[][] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        Integer[] arrivedXy = new Integer[2];
        Integer[] startXy = new Integer[2];

        map = new Floor[h][w];

        for (int i = 0; i < h; i++) {
            String inputLine = br.readLine();
            for (int j = 0; j < w; j++) {
                char c = inputLine.charAt(j);

                if (c == 'E' || c == 'T' || c == 'R' || c == 'H') {
                    if (c == 'E') {
                        arrivedXy[0] = i;
                        arrivedXy[1] = j;
                    } else if (c == 'T') {
                        startXy[0] = i;
                        startXy[1] = j;
                    }
                    map[i][j] = new Floor(0, c);
                } else {
                    // 숫자 칸
                    map[i][j] = new Floor(c - '0', 'I');
                }
            }
        }

        dist = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(dist[i], INF);
        }

        dijkstra(startXy[0], startXy[1]);

        int answer = dist[arrivedXy[0]][arrivedXy[1]];
        System.out.println(answer == INF ? -1 : answer);
    }

    private static void dijkstra(int startX, int startY) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));

        dist[startX][startY] = 0;
        pq.add(new Node(startX, startY, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            // 이미 더 짧은 거리로 방문한 적 있으면 스킵
            if (now.distance > dist[now.x][now.y]) continue;

            // E에 도착한 상태를 뽑았다면 최단거리 확정
            if (map[now.x][now.y].blockCategory == 'E') return;

            for (int[] move : moves) {
                MoveResult result = slide(now.x, now.y, move);

                if (!result.canMove) continue;

                int nextDistance = now.distance + result.spendTime;
                if (dist[result.x][result.y] > nextDistance) {
                    dist[result.x][result.y] = nextDistance;
                    pq.add(new Node(result.x, result.y, nextDistance));
                }
            }
        }
    }

    /**
     * (x, y)에서 move 방향으로 미끄러졌을 때의 결과를 반환
     * - 절벽(맵 밖)으로 떨어지면 실패
     * - H(구멍) 만나면 실패
     * - R(바위) 만나면 직전 칸에서 멈춤
     * - E(출구) 만나면 즉시 도착
     * - 숫자칸(I), T는 계속 미끄러짐
     */
    private static MoveResult slide(int x, int y, int[] move) {
        int nx = x;
        int ny = y;
        int sumTime = 0;

        while (true) {
            int dx = nx + move[0];
            int dy = ny + move[1];

            // 맵 밖으로 나가면 절벽 => 실패
            if (dx < 0 || dy < 0 || dx >= h || dy >= w) {
                return MoveResult.fail();
            }

            Floor nextFloor = map[dx][dy];

            // 구멍 => 실패
            if (nextFloor.blockCategory == 'H') {
                return MoveResult.fail();
            }

            // 바위 => 직전 칸(nx, ny)에서 멈춤
            if (nextFloor.blockCategory == 'R') {
                // 바로 옆이 R이면 실제로 이동 못한 것 => 무효
                if (nx == x && ny == y) {
                    return MoveResult.fail();
                }
                return MoveResult.success(nx, ny, sumTime);
            }

            // 출구 => 즉시 종료 (E칸 비용은 0)
            if (nextFloor.blockCategory == 'E') {
                return MoveResult.success(dx, dy, sumTime);
            }

            // 숫자칸(I) 또는 시작점(T) => 계속 이동
            nx = dx;
            ny = dy;

            // T는 비용 0, 숫자칸(I)은 비용 추가
            sumTime += map[nx][ny].spendTime;
        }
    }

    private static class Floor {
        int spendTime;
        // E, T, I, R, H
        char blockCategory;

        public Floor(int spendTime, char blockCategory) {
            this.spendTime = spendTime;
            this.blockCategory = blockCategory;
        }
    }

    private static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private static class MoveResult {
        boolean canMove;
        int x;
        int y;
        int spendTime;

        public MoveResult(boolean canMove, int x, int y, int spendTime) {
            this.canMove = canMove;
            this.x = x;
            this.y = y;
            this.spendTime = spendTime;
        }

        public static MoveResult fail() {
            return new MoveResult(false, -1, -1, 0);
        }

        public static MoveResult success(int x, int y, int spendTime) {
            return new MoveResult(true, x, y, spendTime);
        }
    }
}