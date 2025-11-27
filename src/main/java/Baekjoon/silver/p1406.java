package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = s.length();
        int m = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int cursor = n;
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            switch (c){
                case 'L':
                    if(cursor <= 0) continue;
                    cursor--;
                    break;
                case 'D':
                    if(cursor >= sb.length()) continue;
                    cursor++;
                    break;
                case 'B':
                    if(cursor <= 0) continue;
                    if(cursor >= sb.length()) {
                        sb.setLength(sb.length()-1);
                        cursor--;
                        break;
                    }
                    sb.deleteCharAt(cursor-1);
                    cursor--;
                    break;
                case'P':
                    char nextC = st.nextToken().charAt(0);
                    sb.append(" ");
                    sb.insert(cursor, nextC);
                    cursor++;
                    sb.setLength(sb.length()-1);
                    break;
            }
        }

        System.out.println(sb);

    }
}
