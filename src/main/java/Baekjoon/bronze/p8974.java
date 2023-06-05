package Baekjoon.bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p8974 {
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int index = 1;
        int[] result = new int[1001];
        for (int i = 0; index < 1001; i++) {
            for (int j = 0; j < i; j++) {
                if (index < 1001) {
                    result[index] = i;
                    index++;
                } else {
                    break;
                }
            }
        }

        int sum = 0;
        for(int i = a; i <= b; i++){
            sum += result[i];
        }
        bw.write(sum + " ");

        bw.flush();
        bw.close();
        br.close();

    }
}
