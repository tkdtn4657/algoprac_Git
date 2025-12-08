package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2529 {

    static String max = "0";
    static String min = "9999999999";
    static char[] chars;
    static boolean[] visited = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        chars = new char[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            chars[i] = st.nextToken().charAt(0);
        }

        recur(0, n, new StringBuilder(), null);

        System.out.println(max);
        System.out.println(min);

    }

    private static void recur(int index, int n, StringBuilder sb, Integer prev){
        if(index == n){
            if(Long.parseLong(sb.toString()) > Long.parseLong(max)){
                max = sb.toString();
            }
            if(Long.parseLong(sb.toString()) < Long.parseLong(min)){
                if(Long.parseLong(sb.toString()) == 10) {
                    int aa = 0;
                }
                min = sb.toString();
            }

            return;
        }

        sb = new StringBuilder(sb);
        for(int i = 0; i < 10; i++){
            if(!visited[i]) {
                StringBuilder newString = new StringBuilder(sb);
                visited[i] = true;


                if (prev == null) {
                    newString.append(i);

                    int newPrev = i;
                    recur(index, n, newString, newPrev);
                } else {
                    switch (chars[index]){
                        case '>' :
                            if(prev > i){
                                newString.append(i);
                                int newPrev = i;
                                recur(index + 1, n, newString, newPrev);
                            } else {
                                visited[i] = false;
                                continue;
                            }
                            break;
                        case '<' :
                            if(prev < i){
                                newString.append(i);
                                int newPrev = i;
                                recur(index + 1, n, newString, newPrev);
                            } else {
                                visited[i] = false;
                                continue;
                            }
                            break;
                    }

                }


                visited[i] = false;
            }
        }

    }


}
