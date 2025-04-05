package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p22988 {
    public static void main(String[] args) throws IOException{
        /**
         * 인기 상품 총 용량 Xml 헤어에센스를 팔고있음
         * 
         * 재활용 이벤트
         * min( A + B + x/2, x) 로 새 병을 만들어주고 있음
         * 
         * 히나
         * 헤어에센스 용기 N개를 갖고있고, 각 용기는 Cml 담겨있음
         * 히나는 무조건 재활용 이벤트로 Xml에 맞는 용기로 받고싶음
         * 
         * 1. 꽉찬거 제거
         * 2. 꽉 차지 않았을 때 두개를 합쳐서 용량 a + b + x/2로 만듦
         * 2-1. 합친 용량이 초과했을 때 좌, 우측 포인터 이동
         * 2-2. 초과가 아닐 때 remain++ 좌측 포인터 이동
         * 3. 리메인은 어떻게 남았던 3병을 합치면 반드시 꽉찬 한병이 됨
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        long[] a = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(a);

        int i = 0;
        int j = a.length-1;
        int remain = 0;
        int correctCount = 0;
        long ijSum;
        while(i <= j){
            if(a[j] == x){
                j--;
                correctCount++;
                continue;
            }

            if(i == j){
                remain++;
                break;
            }

            ijSum = a[i] + a[j] + x/2;

            if(ijSum >= x) {
                i++;
                j--;
                correctCount++;
            } else if(ijSum < x){
                remain++;
                i++;
            }
        }

        System.out.println(correctCount + remain / 3);
    }
}
