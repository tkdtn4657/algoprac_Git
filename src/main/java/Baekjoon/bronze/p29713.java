package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p29713 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        int[] a = new int[10];

        for(int i = 0; i < n; i++){
            switch (s[i]){
                case 'B' :
                    a[0]++;
                    break;
                case 'R' :
                    a[1]++;
                    break;
                case 'O' :
                    a[2]++;
                    break;
                case 'N' :
                    a[3]++;
                    break;
                case 'Z' :
                    a[4]++;
                    break;
                case 'E' :
                    a[5]++;
                    break;
                case 'S' :
                    a[6]++;
                    break;
                case 'I' :
                    a[7]++;
                    break;
                case 'L' :
                    a[8]++;
                    break;
                case 'V' :
                    a[9]++;
                    break;
                default:
                    break;
            }
        }

        //E R 은 중복
        //B R O N Z E S I L V
        int count = 0;
        boolean flag = true;
        while(flag) {
            for (int i = 0; i < 10; i++) {
                if (i == 1 || i == 5) {
                    if (a[i] <= 1) {
                        flag = false;
                        break;
                    }
                } else {
                    if (a[i] <= 0) {
                        flag = false;
                        break;
                    }
                }

                if (i == 1 || i == 5) {
                    a[i] -= 2;
                } else {
                    a[i]--;
                }
                if(i == 9) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
