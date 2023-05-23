package Baekjoon.silver;

import java.io.*;
import java.util.*;

//4마리면
//        4개의 해시에
//        각각 키 밸류로 값이 들어감
//
//        첫번째 줄에는 포켓몬의 종류 수를
//        나타내는 N
//
//        2N에는 데이터세트
//        String 포켓몬[]
//        i번째 포켓몬이 진화에 필요한 사탕의 수와
//        해당 포켓몬에 가지고 있는 총 사탕의 수
//
//        진화가 된 후에 2개의 사탕을 돌려받아.
public class p13717 {
    public static void main()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        String[] pokemon = new String[n];
        int[] levelUpCandy = new int[n];
        int[] haveCandy = new int[n];

        for(int i = 0; i < n; i++) {
            pokemon[i] = br.readLine();
            st = new StringTokenizer(br.readLine());
            levelUpCandy[i] = Integer.parseInt(st.nextToken());
            haveCandy[i] = Integer.parseInt(st.nextToken());
        }

        // pokemon[0] = Caterpie
        // levelUpCandy[0] = 12
        // haveCandy[0] = 42
        int count = 0;
        int maxCount = 0;
        int tempCount = 0;
        int index = 0;
        for(int i = 0; i < n; i++){
            while(haveCandy[i] >= levelUpCandy[i]) {
                haveCandy[i] -= levelUpCandy[i]-2;
                tempCount++;
            }
            if(maxCount < tempCount) {
                maxCount = tempCount;
                index = i;
            }
            count += tempCount;
            tempCount = 0;
        }
        System.out.println(count);
        System.out.println(pokemon[index]);
    }
}
