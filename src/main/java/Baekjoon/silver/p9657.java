package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p9657 {
    public static void main(String[] args) throws IOException{
        //1, 3, 4
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
//        boolean dp [] = new boolean[n+1];
        //false가 상근이 true가 창영이 승리
        //0은 상관없고, 1일때조건넣고, 인덱스에러 안뜨게 조심
        //1일 때 상근이승리, 2일 떄 창영이 승리, 3일 때 상근이 승리, 4일때 상근이 승리,
        //5일 때 상근이 승리, 6일 때 상근이 승리, 7일 때 창영이 승리 8일때 창영이 승리
        //5일 때 1, 3, 4의 선택지가 있는데 1:창영이, 3:상근이 4:창영 상근이가 3을 뽑겠지
        //6일 때 1, 3, 4의 선택지가 있는데 1:상 창 상 -> 창 3: 창 4 : 상 ||||상
        //7일 때 1, 3, 4 1:창 3: 창 4: 창
        //8일 때 1, 3, 4 1:상 3: 상 4: 상
        //9일 떄 1, 3, 4 1:상 3 상 4 상
        //상 상 창 상 상 상 상 창 상 ||
        if(n % 7 == 2 || n % 7 == 0){
            System.out.println("CY");
        }
        else{
            System.out.println("SK");
        }
    }
}
