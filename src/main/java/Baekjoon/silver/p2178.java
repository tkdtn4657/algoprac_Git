package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p2178 {


    static int[] dx = {0, 1, 0, -1}; // 이 두개의 검증코드가 꼭 필요한가?
    static int[] dy = {1, 0, -1, 0};
    static int[][] miro;
    static boolean[][] visited;
    static int n, m;

    public void main() throws IOException {
        //처음에 스캐너로 할라다가
        //int long 전부 자릿수문제로 실패 -> 결국 br string으로 해결
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        miro = new int[n][m];
        visited = new boolean[n][m];
        String temp;

        for(int i = 0; i < n; i++){
            temp = br.readLine();
            for(int j = 0; j < m; j++) {
                miro[i][j] = Integer.parseInt(temp.substring(j, j+1));
            }
        }

//        for(int i = 0; i < n; i++){ 데이터 잘 받았는지 확인용
//            for(int j = 0; j < m; j++) {
//                System.out.print(miro[i][j]);
//            }
//            System.out.println();
//        }

        //구현부

        BFS(0, 0);

        System.out.println(miro[n-1][m-1]);


    }

    static void BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<int[]>();

        queue.add(new int[] {i, j}); //이 두개는 세트
        visited[i][j] = true;

        while(!queue.isEmpty()){
            int now[] = queue.poll();
            for(int k = 0; k < 4; k++){ // 좌표 유효성 검사코드
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 0 && y >= 0 && x < n && y < m){
                    if(miro[x][y] != 0 && !visited[x][y]){
                        visited[x][y] = true;
                        miro[x][y] = miro[now[0]][now[1]] + 1;
                        queue.add(new int[] { x, y});
                    }
                }
            }
        }
    }
}
