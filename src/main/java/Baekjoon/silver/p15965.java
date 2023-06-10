package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p15965 {
    static boolean[] check = new boolean[7368788];
    //에라스토로 안될거같은데
    //뭐로해야하진ㅁㅇㄹㄴㅁㅇㄹㄴㅇㅁㄹㄴㅁㅇㄹㄴㅇㅁㄻㄴㅇㄹ

    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;
        int k = Integer.parseInt(br.readLine());
        //하면서 하는 방식이 없나..?
        //k는 자연수범위가 아닌 번째 수 : count
        for (int i = 2; i <= check.length-1; i++) {
            if (!check[i]) {
                count++;
                if (count == k) {
                    bw.write(i + "");
                    break;
                }
            }
            for (int j = i; j <= check.length-1; j += i) {
                if (!check[j]) {
                    check[j] = true;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
