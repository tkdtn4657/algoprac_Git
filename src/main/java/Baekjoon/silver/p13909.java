package Baekjoon.silver;

import java.io.*;

public class p13909 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 0;

        for(int i = 2; i*i <= n; i++){
            result++;
        }

        System.out.println(result+1);
    }
}

//public class p13909 {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//
//        boolean[] a = new boolean[n+1];
//
//        int count = 0;
//        //1의배수를 스킵하고 false가 열린거 -> 초기화때 닫힌걸 열었다치자
//        for(int i = 1; i <= n; i++){
//            for(int j = i; j <= n; j+=i){
//                a[j] = !a[j];
//            }
//        }
//
//        for(int i = 1; i <= n; i++){
//            if(a[i]){
//                count++;
//            }
//        }
//
//        System.out.println(count);
//
//
//    }
//}
