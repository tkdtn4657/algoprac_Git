package Baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class p19532 {
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] a = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = -999; i < 1000; i++){
            for(int j = -999; j < 1000; j++){
                if(a[0]*i + a[1]*j == a[2] && a[3]*i + a[4]*j == a[5]){
                        bw.write(i + " " + j);
                        break;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
