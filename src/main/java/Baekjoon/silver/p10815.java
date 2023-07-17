package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> is = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            is.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            if(is.contains(Integer.parseInt(st.nextToken()))){
                sb.append(1);
            }else{
                sb.append(0);
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
