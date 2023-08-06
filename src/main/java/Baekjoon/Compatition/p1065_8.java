package Baekjoon.Compatition;

import java.io.*;
import java.util.*;

public class p1065_8 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][m];

        int mode;
        int line;
        int v;
        StringBuilder sb;
        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            mode = Integer.parseInt(st.nextToken());
            line = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            if(mode == 1){
                //1일때는 row
                for(int j = 0; j < m; j++) {
                    a[line-1][j] += v;
                }
            }else if(mode == 2){
                //2일때는 col
                for(int j = 0; j < n; j++) {
                    a[j][line-1] += v;
                }
            }
        }

        sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sb.append(a[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
