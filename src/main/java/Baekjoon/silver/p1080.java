package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][m];
        int[][] b = new int[n][m];

        for(int i = 0; i < n; i++){
            String inputLine = br.readLine();
            for(int j = 0; j < m; j++){
                a[i][j] = Character.getNumericValue(inputLine.charAt(j));
            }
        }

        for(int i = 0; i < n; i++){
            String inputLine = br.readLine();
            for(int j = 0; j < m; j++){
                b[i][j] = Character.getNumericValue(inputLine.charAt(j));
            }
        }

        int count = 0;
        for(int i = 1; i < n-1; i++){
            for(int j = 1; j < m-1; j++){
                if(checkAndTransfer(i, j, a, b)){
                    count++;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] != b[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);

    }

    private static boolean checkAndTransfer(int x, int y, int[][] map, int[][] target){
        if(map[x-1][y-1] != target[x-1][y-1]){
            map[x-1][y-1] = Math.abs(map[x-1][y-1] - 1);
            map[x-1][y] = Math.abs(map[x-1][y] - 1);
            map[x][y-1] = Math.abs(map[x][y-1] - 1);
            map[x][y] = Math.abs(map[x][y] - 1);
            map[x-1][y+1] = Math.abs(map[x-1][y+1] - 1);
            map[x][y+1] = Math.abs(map[x][y+1] - 1);
            map[x+1][y-1] = Math.abs(map[x+1][y-1] - 1);
            map[x+1][y] = Math.abs(map[x+1][y] - 1);
            map[x+1][y+1] = Math.abs(map[x+1][y+1] - 1);
            return true;
        }
        return false;
    }

}
