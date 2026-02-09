package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p13901 {

    private static final int BLOCK = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int bRow = Integer.parseInt(st.nextToken());
            int bCol = Integer.parseInt(st.nextToken());

            map[bRow][bCol] = BLOCK;
        }

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());

        Queue<Integer> direction = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            direction.add(Integer.parseInt(st.nextToken()));
        }

        boolean[][] visited = new boolean[r][c];
        visited[sr][sc] = true;

        int fail = 0;

        while (true) {
            int nowDirection = direction.peek();
            int[] dxDy = getDirection(nowDirection);

            int nx = sr + dxDy[0];
            int ny = sc + dxDy[1];

            if (nx < 0 || ny < 0 || nx >= r || ny >= c ||
                    visited[nx][ny] || map[nx][ny] == BLOCK) {
                direction.add(direction.poll());
                fail++;
                if (fail == 4) break;
            } else {
                sr = nx;
                sc = ny;
                visited[sr][sc] = true;
                fail = 0;
            }
        }

        System.out.println(sr + " " + sc);
    }

    static int[] getDirection(int direction) {
        switch (direction) {
            case 1: return new int[]{-1, 0};
            case 2: return new int[]{1, 0};
            case 3: return new int[]{0, -1};
            case 4: return new int[]{0, 1};
        }
        return null;
    }
}
