package Baekjoon.silver;

import java.util.*;
import java.io.*;
public class p1340 {
    public static void main()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] cArray = br.readLine().toCharArray();
        boolean[] check = new boolean[n];

        //*S*LL*S*
        //*S*S*S*
        //*S*LL*LL*S*S*LL*
        //*S*LL*S*

        StringBuilder sb = new StringBuilder();

        int count = 0;
        for(int i = 0; i < cArray.length; i++){
            sb.append('*');
            if(cArray[i] == 'L') {
                sb.append(cArray[i]);
                i++;
                sb.append(cArray[i]);
                count++;
            }
            else {
                sb.append(cArray[i]);
                count++;
            }
        }
        sb.append('*');
        count++;

        if(count > n){
            count = n;
        }
        System.out.println(sb.toString());
        System.out.println(count);
    }
}
