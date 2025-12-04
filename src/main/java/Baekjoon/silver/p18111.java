package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int maxHeight = 0;
        int[][] a = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Integer.max(maxHeight, a[i][j]);
            }
        }

        int i = 0;
        //높은 땅부터 하나씩 깎아가며 만들어보기?
        //일단 maxHeight를 만들 수 있는 블록 수가 되는지 확인
        //이후에 직접 구현
        int count = 0;
        int minCount = Integer.MAX_VALUE;
        int resultHeight = 0;
        for(i = maxHeight; i >= 0; i--){
            count = 0;
            int block = b;
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    if(i > a[j][k]){
                        count += (i - a[j][k]);
                        block -= (i - a[j][k]);
                    } else if(i < a[j][k]){
                        count += (a[j][k] - i) * 2;
                        block += (a[j][k] - i);
                    }
                }
            }
            if(block < 0){
                continue;
            }
            if(minCount > count){
                minCount = count;
                resultHeight = i;
            }
        }

        System.out.println(minCount + " " + (resultHeight));

    }

}
