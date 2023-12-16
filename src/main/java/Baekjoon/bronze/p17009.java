package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p17009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int apple = 0;
        int banana = 0;

        apple += Integer.parseInt(br.readLine())*3;
        apple += Integer.parseInt(br.readLine())*2;
        apple += Integer.parseInt(br.readLine());
        banana += Integer.parseInt(br.readLine())*3;
        banana += Integer.parseInt(br.readLine())*2;
        banana += Integer.parseInt(br.readLine());

        if(apple > banana){
            System.out.println("A");
        }else if(apple < banana){
            System.out.println("B");
        }else{
            System.out.println("T");
        }
    }
}
