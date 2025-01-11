package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arrayMap = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arrayMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] prefixSumArray = new int[n+1][n+1];

        prefixSumArray[1][1] = arrayMap[1][1];

        //누적합 배열 만드는 과정 - 행
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                prefixSumArray[i][j] = prefixSumArray[i][j-1] + arrayMap[i][j];
            }
        }

        //누적합 배열 만드는 과정 - 열
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                prefixSumArray[i][j] = prefixSumArray[i-1][j] + prefixSumArray[i][j];
            }
        }
        //2차원 누적합 배열 완성
        //누적합 배열 확인
//        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= n; j++){
//                System.out.print(prefixSumArray[i][j] + " ");
//            }
//            System.out.println();
//        }


        StringBuilder sb = new StringBuilder();
        //범위 바로 바깥의 수를 빼고, 겹친 부분의 대각선 부분은 더해줌 => 두번 들어갔기 때문에
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int num = prefixSumArray[x2][y2] - prefixSumArray[x2][y1-1] - prefixSumArray[x1-1][y2] + prefixSumArray[x1 - 1][y1 - 1];

            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }
}
