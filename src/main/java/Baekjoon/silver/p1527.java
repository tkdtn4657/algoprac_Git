package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1527 {

    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        //금민수는 4와 7로 이루어진 수
        //a ~ b 사이의 금민수 개수 찾기

        for(int i = a; i <= b; i++){
            if(isGeumMinsu(i)){
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean isGeumMinsu(int num) {
        if (num < 10) {
            return num == 4 || num == 7;
        }


        while (num >= 10) {
            int number = num % 10;
            num /= 10;
            if (!(number == 4 || number == 7)) {
                return false;
            }
        }

        return num == 4 || num == 7;
    }
}
