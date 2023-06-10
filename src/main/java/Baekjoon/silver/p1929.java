package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1929 {
    //쉽게가면 그냥 구해놓고 출력하면 되는데
    //안에서 구현하면서 바로바로 구해보자
    public static void main() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[n+1];

        //1000000 은
        for(int i = 2; i <= n; i++){
            if(!check[i] && i >= m){
                bw.write(i + "\n");
            }
            for(int j = i; j <= n; j += i ){
                if(!check[j]){
                    check[j] = true;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
