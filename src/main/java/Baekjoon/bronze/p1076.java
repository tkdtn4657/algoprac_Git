package Baekjoon.bronze;

import java.util.*;
import java.io.*;

public class p1076 {
    static ArrayList <String> colorList =
            new ArrayList<>(Arrays.asList("black","brown","red","orange","yellow","green","blue","violet","grey","white"));
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        long one = colorList.indexOf(br.readLine())*10;
        long two = colorList.indexOf(br.readLine());
        long mul = colorList.indexOf(br.readLine());

        long result = one + two;
        while(mul-->0){
            result *=10;
        }

        bw.write(result +"");
        bw.flush();
        bw.close();
        br.close();

    }
}

