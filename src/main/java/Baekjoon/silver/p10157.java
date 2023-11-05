package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p10157 {

    //상 우 하 좌
    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static int x;
    static int y;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> mode = new LinkedList<>();
        for (int[] modeParts : move) {
            mode.add(modeParts);
        }
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
//        int[][] dome = new int[x][y];
        int[] pointer = {0, 0};
        int count = 1;
        visited = new boolean[x][y];
        if (x * y < k) {
            System.out.println(0);
            return;
        }

        //1일때도 체크한번만 해주자
        //x y
        //1
        if (k == 1) {
            System.out.println(1);
        }
        visited[0][0] = true;

        while (true) {
            int[] temp = mode.peek();
            int[] moveXY = {temp[0], temp[1]};
            if (movePossible(pointer[0] + moveXY[0], pointer[1] + moveXY[1])) {
                pointer[0] += moveXY[0];
                pointer[1] += moveXY[1];
                visited[pointer[0]][pointer[1]] = true;
                count++;
                if (count == k) {
                    System.out.printf("%d %d", pointer[1] + 1, pointer[0] + 1);
                    return;
                }
                if (count == x * y) {
                    System.out.printf("%d %d", pointer[1] + 1, pointer[0] + 1);
                    return;
                }

            } else {
                mode.add(mode.poll());
            }
        }
    }

    static boolean movePossible(int moveX, int moveY) {
        return x > moveX && y > moveY && moveX >= 0 && moveY >= 0 && !visited[moveX][moveY];
    }
}
