package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p26004 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] a = new int[5];
        //h : 0 | i : 1 | a : 2 | r : 3 | c : 4 |

        int min = 100001;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'H'){
                a[0]++;
            }else if(s.charAt(i) == 'I'){
                a[1]++;
            }else if(s.charAt(i) == 'A'){
                a[2]++;
            }else if(s.charAt(i) == 'R'){
                a[3]++;
            }else if(s.charAt(i) == 'C'){
                a[4]++;
            }
        }

        for(int num : a){
            min = Integer.min(min, num);
        }

        System.out.println(min);

    }
}
