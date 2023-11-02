package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p3047 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] charArray = br.readLine().toCharArray();

        int[] a = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        Arrays.sort(a);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length; i++){
            switch (charArray[i]){
                case 'A' :
                    sb.append(a[0]).append(" ");
                    break;
                case 'B' :
                    sb.append(a[1]).append(" ");
                    break;
                case 'C' :
                    sb.append(a[2]).append(" ");
                    break;
            }
        }

        sb.setLength(sb.length()-1);

        System.out.println(sb);
    }
}
