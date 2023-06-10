package Baekjoon.silver;

import org.example.Main;

import java.util.*;
import java.io.*;

public class p1418 {
    static boolean[] check = new boolean[(int) Math.sqrt(1000000) + 1];
    static ArrayList<Integer> sosu = new ArrayList<>();
    //static ArrayList<Integer> result = new ArrayList<>();
    static int count = 0;

    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        //범위가 10만이니까 10만의 루트까지만 에라스토를 구해놔

        //1000까지의 에라스토를 다 구해
        for (int i = 2; i <= (int) Math.sqrt(1000000); i++) {
            if (!check[i]) {
                sosu.add(i);
            }
            for (int j = i; j <= (int) Math.sqrt(1000000); j += i) {
                if (!check[j]) {
                    check[j] = true;
                }
            }
        }
//소수에라스토 만들어짐

        int[] b = new int[n];
        //소수의 집합이 소인수분해
        //약수를 먼저 구하고
        //약수를 소인수분해 해서
        //그 소수를 판별한다.
        //1과 2를 생각하긴해야함
        //약수 : divisor
        for (int i = 2; i <= n; i++) {
            div(i, k);
        }
        System.out.println(count + 1);
    }
    //약수가 소수가 아니야?
    //더 약분해

    //소수로 2부터 계속 나눠 안돼? 3으로 넘어가 안돼? 4로 넘어가 반복 나누기가1이 될때까지
    public static void div(int n, int k) {
        int index = 0;
        while (n != 1) {
            if (sosu.size() > index) {
                if (n % sosu.get(index) == 0) {
                    n /= sosu.get(index);
                } else {
                    index++;
                }
            }
            else{
                return;
            }
        }
        if (sosu.get(index) <= k) {
            count++;
        }
    }
}


//public class p1418 {
//    public static void main() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int k = Integer.parseInt(br.readLine());
//        int[] a = new int[n + 1];
//        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>(n+1);
//
//
//        for(int i = 0; i <= n; i++) {
//            a[i] = i;
//            hs.put(i, 0);
//        } // 1 2 3 4 5 6 7 8 9 10
//        //1은 무조건 됨
//        for(int i = 2; i <= n; i++){
//            int soinsu = a[i];
//            for(int j = 2; j <= soinsu; j++) {//sqrt(soinsu)?
//                while(soinsu % j == 0) {
//                    soinsu /= j;
//                    hs.put(i, j);//하다보면 맥스
//                }
//            }
//        }
//        int count = 0;
//        for(int i = 1; i < a.length; i++) {
//            if(hs.get(i) <= k){
//                count++;
//            }
//        }
//        System.out.println(count);
//    }
//}