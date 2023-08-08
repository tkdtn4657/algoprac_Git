package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2751 {

    public static int[] a, tmp;
    public static long result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        a = new int[n+1];
        tmp = new int[n+1];

        for(int i = 1; i < n+1; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(1,n);
        //이후출력
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n+1; i++){
            sb.append(a[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void merge_sort(int s, int e){
        if(e - s < 1){
            return;
        }

        int m = s +(e - s) / 2;
        //이 재귀를 통해서 잘게 다 자름.
        merge_sort(s, m);
        merge_sort(m+1, e);
        //자른 것 기준으로 칸 단위로 하나하나 합쳐지는데, 새로운 배열에 집어넣어줌
        for(int i = s; i <= e; i++){
            tmp[i] = a[i];
        }

        int k = s;
        int index1 = s; // 앞배열
        int index2 = m+1; // 뒷배열

        //정렬된 두개의 배열에서 서로 비교를 해서 값을 집어넣어주는 모습
        //각각의 포인터가 집어넣어졌을 때 이동함
        while(index1 <= m && index2 <= e) {
            if (tmp[index1] > tmp[index2]) {
                a[k] = tmp[index2];
                k++;
                index2++;
            } else {
                a[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        //한쪽이 끝났을 때 남은 다른 쪽 배열을 전부 추가
        while(index1 <= m){
            a[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2 <= e){
            a[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
