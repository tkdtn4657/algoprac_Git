package Baekjoon.bronze;

import java.util.*;
import java.io.*;

public class p3447 {
    public static void main() throws IOException {
        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        String s = "";
        String temp = "";
        while(sc.hasNextLine()){
            s = sc.nextLine();//br.readLine();
            temp = s.replace("BUG", "");

            while(temp.contains("BUG")){
                temp = temp.replace("BUG", "");
            }

            if(!temp.contains("BUG")){
                System.out.println(temp);
            }
        }

//        while (true) {
//            sb = new StringBuilder(br.readLine());
//            //s
//            int index = 0;
//            int length = sb.length();
//
//            while (index < length - 2 && index != length && !sb.equals("")) {
//                if (sb.charAt(index) == 'B') {
//                    if (sb.charAt(index + 1) == 'U') {
//                        if (sb.charAt(index + 2) == 'G') {
//                            sb.replace(index, index + 3, "");
//                            length = sb.length();
//                            index = 0;
//                            continue;
//                        }
//                    }
//                }
//                index++;
//            }
//            if (!sb.equals("")) {
//                System.out.println(sb.toString());
//            }
//        }
    }
}