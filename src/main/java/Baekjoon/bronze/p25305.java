package Baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class p25305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        insert_sort(a);

//        for(int num : a){
//            System.out.println(num);
//        }
        System.out.println(a[k-1]);
    }

    //첫 키는 그대로 두고 그 다음 값부터 시작
    static void insert_sort(int[] a){
        int temp;
        for(int i = 1; i < a.length; i++){
            temp = a[i];
            for(int j = i-1; j >= 0; j--){
                if(temp > a[j]){
                    a[j+1] = a[j];
                    a[j]=temp;
                }
            }
        }
    }
}
