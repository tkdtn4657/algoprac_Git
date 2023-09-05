package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1822 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b  = new ArrayList<>();

        TreeSet<Integer> sortTree = new TreeSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            sortTree.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int check = Integer.parseInt(st.nextToken());
            if(sortTree.contains(check)){
                sortTree.remove(check);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sortTree.size()).append("\n");
        for(int num : sortTree){
            sb.append(num).append(" ");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
