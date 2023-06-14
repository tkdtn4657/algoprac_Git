package Baekjoon.bronze;

import java.util.*;
import java.io.*;

public class p2702 {
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int[] eachCase = new int[2];
        StringTokenizer st;
        int gcdInt = 0;
        int lcmInt = 0;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            eachCase[0] = Integer.parseInt(st.nextToken());
            eachCase[1] = Integer.parseInt(st.nextToken());


            gcdInt = gcd(eachCase[0], eachCase[1]);
            lcmInt = eachCase[0] * eachCase[1] /gcdInt;

            bw.write(lcmInt + " " + gcdInt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int gcd(int a, int b) {
        if (b == 0) { // a % b== 0 -> return b로도 됨
            return a;
        }

        return gcd(b, a % b);

    }
}
