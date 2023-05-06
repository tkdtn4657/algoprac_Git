package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p1991 {

    static ArrayList[] a;

    public static void main() throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int n = Integer.parseInt(br.readLine());
        String temp;

        a = new ArrayList[n];

        char one;
        char two;
        char three;

        int index;

        for(int i = 0; i < n; i++){//이진트리 초기화
            a[i] = new ArrayList<Character>(2);
            //a[i].add(i+65);
        }




        for(int i = 0; i < n; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            one = st.nextToken().charAt(0); //와 이거 charAt생각도못했다......
            two = st.nextToken().charAt(0);
            three = st.nextToken().charAt(0);


            //index = a[i].indexOf(one);
            if(two != '.') {
                a[one-65].add(one - 65, two);
            }
            if(three != '.') {
                a[one-65].add(one - 65, three);
            }

        }


        for(int i = 0; i < n; i++){
            System.out.println(a[i]);
        }
        //논리문제로 입력도 제대로 못한듯 일단 실패...
    }

}
