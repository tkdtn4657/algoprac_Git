package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2583 {

    static boolean map[][];
    static int count = 0;

    static int n, m, k;

    static int rectangleSize = 0;
    static ArrayList<Integer> rectangleSizeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //x = 7, y = 5 행렬이 아닌 좌표임
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new boolean[m][n];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            drawRectangle(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())
                    ,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!map[i][j]){
                    count++;
                    dfs(i, j);
                    rectangleSizeList.add(rectangleSize);
                    rectangleSize = 0;
                }
            }
        }
        Collections.sort(rectangleSizeList);
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");

        for(int i = 0; i < rectangleSizeList.size(); i++){
            sb.append(rectangleSizeList.get(i) + " ");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y){
        if(x >= 0 && y >= 0 && x < m && y < n) {
            if (!map[x][y]) {
                map[x][y] = true;
                rectangleSize++;
                dfs(x + 1, y);
                dfs(x - 1, y);
                dfs(x, y + 1);
                dfs(x, y - 1);
            }
        }
    }
    static void drawRectangle(int x1, int y1, int x2, int y2){
        for(int i = y1; i < y2; i++) {
            Arrays.fill(map[i], x1, x2, true);
        }
    }
}