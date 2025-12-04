package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p4179 {

    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] jihunXY = new int[2];
        Node[][] map = new Node[r][c];
        for(int i = 0; i < r; i++){
            String inputLine = br.readLine();
            for(int j = 0; j < c; j++){
                char charData = inputLine.charAt(j);
                if(charData == 'J') jihunXY = new int[]{i, j};
                map[i][j] = new Node(1, charData);
            }
        }

        //가장자리로 지훈이가 가면 탈출
        //불과 지훈이는 매번 상하좌우로 퍼트림
        //최초 1이고, 이동할 때마다 1씩증가
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j].value == 'F' && map[i][j].count == 1){
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] nowNode = queue.poll();
            int nowX = nowNode[0];
            int nowY = nowNode[1];

            for(int[] nextXY : moves){
                int dx = nowX + nextXY[0];
                int dy = nowY + nextXY[1];
                if(dx >= r || dy < 0|| dy >= c || dx < 0) continue;
                if(map[dx][dy].value == '.'){
                    map[dx][dy].value = 'F';
                    map[dx][dy].count = map[nowX][nowY].count+1;
                    queue.add(new int[]{dx, dy});
                }
            }
        }

        //불을 먼저 처리해두고 하는거는 어떨까요?
        //이후에 1부터 이동하는데 불을 만났을 때 count와 동일하거나 낮은곳에서 이동

        //불을 먼저 해두고, 지훈이가 이동할 때 해당 위치가 (jNow + 1) < F 상태여야 해

        queue.add(jihunXY);
        while(!queue.isEmpty()){
            int[] nowNode = queue.poll();
            int nowX = nowNode[0];
            int nowY = nowNode[1];

            for(int[] nextXY : moves){
                int dx = nowX + nextXY[0];
                int dy = nowY + nextXY[1];
                if(dx >= r || dy < 0|| dy >= c || dx < 0) continue;
                if(map[dx][dy].value == '.'){

                    map[dx][dy].value = 'J';
                    map[dx][dy].count = map[nowX][nowY].count+1;
                    queue.add(new int[]{dx, dy});
                } else if(map[dx][dy].value == 'F' && map[dx][dy].count > map[nowX][nowY].count + 1){
                    map[dx][dy].value = 'J';
                    map[dx][dy].count = map[nowX][nowY].count+1;
                    queue.add(new int[]{dx, dy});
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < r; i++){
            int firstLine = 0;
            int lastLine = c-1;

            if(map[i][firstLine].value == 'J'){
                min = Integer.min(min, map[i][firstLine].count);
            }
            if(map[i][lastLine].value == 'J'){
                min = Integer.min(min, map[i][lastLine].count);
            }
        }

        for(int i = 0; i < c; i++){
            int firstLine = 0;
            int lastLine = r-1;
            if(map[firstLine][i].value == 'J'){
                min = Integer.min(min, map[firstLine][i].count);
            }
            if(map[lastLine][i].value == 'J'){
                min = Integer.min(min, map[lastLine][i].count);
            }
        }

        if(min == Integer.MAX_VALUE){
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(min);
        }

    }

    private static class Node{
        int count;
        char value;

        Node(int count, char value){
            this.count = count;
            this.value = value;
        }

    }
}
