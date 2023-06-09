package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p1373 {
    public static void main() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        //11|001|100

        StringBuilder sb = new StringBuilder(br.readLine());
        ArrayList<String> al = new ArrayList<>();

        for(int i = sb.length(); i >= 0; i-=3){
            if(i > 2){
                al.add(String.valueOf(sb.substring(i-3, i)));
            }
            else{
                al.add(String.valueOf(sb.substring(0, i)));
            }
        }

        int result = 0;
        // 100 // 001 // 11
        sb = new StringBuilder();
        for(String eight : al){
            result = 0;
            if(eight.length() == 3){
                result = (eight.charAt(0)-'0')*4 + (eight.charAt(1)-'0')*2 + (eight.charAt(2)-'0')*1;
                sb.append(result);
            }
            if(eight.length() == 2){
                result = (eight.charAt(0)-'0')*2 + (eight.charAt(1)-'0')*1;
                sb.append(result);
            }
            if(eight.length() == 1){
                result = (eight.charAt(0)-'0')*1;
                sb.append(result);
            }

        }

        bw.write(sb.reverse().toString());
        bw.flush();
        bw.close();
    }
}