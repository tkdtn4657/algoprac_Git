package Baekjoon.Compatition;

import java.io.*;
import java.util.*;

public class p1093_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] father = br.readLine().split(" ");
        String[] mother = br.readLine().split(" ");

        Set<String> color = new TreeSet<>();

        color.add(father[0]);
        color.add(father[1]);
        color.add(mother[0]);
        color.add(mother[1]);

//        Collections.sort(color);

        StringBuilder sb = new StringBuilder();
        for(String s : color){
            for(String s2 : color) {
                sb.append(s).append(" ").append(s2).append("\n");
            }
        }
        System.out.println(sb);

    }
}
