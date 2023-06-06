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
        //a[0] = a | a[1] = b | a[2] = c | a[3] = d | a[4] = e | a[5] = f
        bw.write((a[2]*a[4] - a[1]*a[5])/(a[0]*a[4] - a[1]*a[3]) + " "
                + (a[2]*a[3] - a[0]*a[5])/(a[1]*a[3] - a[0]*a[4]));

        //ae -bd 이게 0이 아니면 해를 구할 수 있음 또 이게 분모가 됨bd - ae
        //cd - fa, ce - fb 이 두개 그니까 x와 y의 답을 찾는 과정
        //ca - fb, cd - fe

        //ce - bf, cd - af 분자
        //ae - bd, bd - ae 분모


        bw.flush();
        bw.close();
        br.close();
    }
}
