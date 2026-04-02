package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p15723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Character, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            String b = st.nextToken();
            char c = st.nextToken().charAt(0);

            map.put(a, c);
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            String b = st.nextToken();
            char c = st.nextToken().charAt(0);
            char cur = a;
            while(true) {
                if (map.containsKey(cur)) {
                    if (map.get(cur) == c) {
                        sb.append("T").append(System.lineSeparator());
                        break;
                    } else {
                        cur = map.get(cur);
                    }
                } else {
                    if(cur == c){
                        sb.append("T").append(System.lineSeparator());
                        break;
                    }
                    sb.append("F").append(System.lineSeparator());
                    break;
                }
            }
        }

        System.out.println(sb);

    }
}
