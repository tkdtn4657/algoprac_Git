package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2251_bfs {
    static boolean[][] visited;
    static Set<Integer> result = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        final int[] waterBox = new int[3];
        for (int i = 0; i < 3; i++) {
            waterBox[i] = Integer.parseInt(st.nextToken());
        }
        //8 9 10
        visited = new boolean[waterBox[0] + 1][waterBox[1] + 1];
        Queue<int[]> q = new LinkedList<>();
        int[] waterStatus;
        int[] waterStatusTemp;
        //queue에 물통의 상태를 저장하기
        q.add(new int[]{0, 0, waterBox[2]});
        while (!q.isEmpty()) {
            waterStatus = q.poll();

            if (visited[waterStatus[0]][waterStatus[1]]) {
                continue;
            }

            if (waterStatus[0] == 0) {
                result.add(waterStatus[2]);
            }
            visited[waterStatus[0]][waterStatus[1]] = true;

            if (waterStatus[0] > 0) {
                waterStatusTemp = Arrays.copyOf(waterStatus, waterStatus.length);
                int aToB = Integer.min(waterStatusTemp[0], waterBox[1] - waterStatusTemp[1]);
                waterStatusTemp[0] -= aToB;
                waterStatusTemp[1] += aToB;
                q.add(waterStatusTemp);
                waterStatusTemp = Arrays.copyOf(waterStatus, waterStatus.length);
                int aToC = Integer.min(waterStatusTemp[0], waterBox[2] - waterStatusTemp[2]);
                waterStatusTemp[0] -= aToC;
                waterStatusTemp[2] += aToC;
                q.add(waterStatusTemp);
            }
            if (waterStatus[1] > 0) {
                waterStatusTemp = Arrays.copyOf(waterStatus, waterStatus.length);
                int bToA = Integer.min(waterStatusTemp[1], waterBox[0] - waterStatusTemp[0]);
                waterStatusTemp[1] -= bToA;
                waterStatusTemp[0] += bToA;
                q.add(waterStatusTemp);
                waterStatusTemp = Arrays.copyOf(waterStatus, waterStatus.length);
                int bToC = Integer.min(waterStatusTemp[1], waterBox[2] - waterStatusTemp[2]);
                waterStatusTemp[1] -= bToC;
                waterStatusTemp[2] += bToC;
                q.add(waterStatusTemp);
            }
            if (waterStatus[2] > 0) {
                waterStatusTemp = Arrays.copyOf(waterStatus, waterStatus.length);
                //8 0 2
                int cToA = Integer.min(waterStatusTemp[2], waterBox[0] - waterStatusTemp[0]);
                waterStatusTemp[2] -= cToA;
                waterStatusTemp[0] += cToA;
                q.add(waterStatusTemp);
                waterStatusTemp = Arrays.copyOf(waterStatus, waterStatus.length);
                int cToB = Integer.min(waterStatusTemp[2], waterBox[1] - waterStatusTemp[1]);
                waterStatusTemp[2] -= cToB;
                waterStatusTemp[1] += cToB;
                q.add(waterStatusTemp);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
