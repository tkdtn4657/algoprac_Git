package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p28438 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

//        int[][] a = new int[n][m];
        int[] row = new int[m];
        int[] col = new int[n];

        int mode;
        int line;
        int v;

        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine(), " ");
            mode = Integer.parseInt(st.nextToken());
            line = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            if(mode == 1){
                //1일때는 row
                col[line-1] += v;
            }else{
                //2일때는 col

                row[line-1] += v;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sb.append(col[i] + row[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
