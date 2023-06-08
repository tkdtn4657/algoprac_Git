package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p19564 {
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(br.readLine());
        char c;
        int cInt;
        int count = 0;
        int deleteLength = 1;
        //97 -> 122
        while(sb.length() != 0){
            deleteLength = 1;
            for(int i = 0; i < deleteLength && i <sb.length()-1; i++) {
                if (sb.charAt(i) < sb.charAt(i+1)) {
                    deleteLength++;
                }
            }
            sb.delete(0, deleteLength);
            count++;
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
