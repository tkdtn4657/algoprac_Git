package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
public class p5568_3 {
    //범위가 99개니까 일단 100이야 k는 4까지니까 범위를 구하는 식이 100 * Math.pow(100,k-1); 100^k를 하면 1억!
    //범위가 10,000,000,000 100조로 불린배열 불가..
//    static boolean[] check = new boolean[100000000];
    static boolean[] checkIndex;
    //그래서 결국 그냥 셋

    static StringBuilder sb = new StringBuilder();;
    static String[] al;
    static int n;

    static Set<String> is = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        checkIndex = new boolean[n];
        al = new String[n];
        int tempInt = 0;

        int k = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++) {
            al[i] = br.readLine();
        }

        for(int i = 0; i < n; i++){
            checkIndex[i] = true;
            kAdd(al[i], k);
            checkIndex = new boolean[n];
        }

        System.out.println(is.size());

    }

    static void kAdd(String s, int k){
        if(k == 1){
            is.add(s);
            return;
        }
        for(int i = 0; i < n; i++){
            if(!checkIndex[i]){
                checkIndex[i] = true;
                kAdd(s + al[i], k-1);
                checkIndex[i] = false;
            }
        }
    }
}
