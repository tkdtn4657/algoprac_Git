package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p16918 {

    private static final int[][] moves = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];

        for(int i = 0; i < r; i++){
            String inputString = br.readLine();
            for(int j = 0; j < c; j++){
                switch(inputString.charAt(j)){
                    case '.':
                        break;
                    case 'O':
                        map[i][j] = 1;
                        break;
                    default:
                }
            }
        }

        //1초 경과
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] == 1){
                    map[i][j]++;
                }
            }
        }
        if(n == 2){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++){
                sb.append("O".repeat(c));
                sb.append(System.lineSeparator());
            }
            System.out.println(sb);
            return;
        }


        //그 이후
        for(int time = 1; time < n; time++) {

            Queue<int[]> queue = new ArrayDeque<>();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] < 3){
                        map[i][j]++;
                    } else {
                        queue.add(new int[]{i, j});
                    }
                }
            }

            while(!queue.isEmpty()){
                int[] now = queue.poll();
                map[now[0]][now[1]] = 0;

                for(int[] move : moves){
                    int dx = now[0] + move[0];
                    int dy = now[1] + move[1];
                    if(dx < 0 || dy < 0 || dx >= r || dy >= c) continue;

                    map[dx][dy] = 0;

                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] == 0){
                    sb.append('.');
                } else {
                    sb.append('O');
                }
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);

    }

}
