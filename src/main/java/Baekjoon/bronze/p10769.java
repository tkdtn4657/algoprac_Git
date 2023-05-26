package Baekjoon.bronze;

import java.util.*;
import java.io.*;
public class p10769 {
    public static void main()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        int happyCount = 0;
        int sadCount = 0;
        int index = 0;
        while(true){
            if(s.contains(":-)")) {
                s = s.replaceFirst(":-\\)","");
                happyCount++;
            }
            else if(s.contains(":-(")){
                s = s.replaceFirst(":-\\(","");
                sadCount++;
            }
            else{

                if(happyCount > sadCount){
                    System.out.println("happy");
                }else if(happyCount < sadCount){
                    System.out.println("sad");
                }
                else if(happyCount == sadCount && happyCount > 0 && sadCount > 0){
                    System.out.println("unsure");
                }else{
                    System.out.println("none");
                }
                return;
            }

        }

    }

}
