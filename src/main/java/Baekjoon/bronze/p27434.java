package Baekjoon.bronze;

import java.io.*;
import java.math.BigInteger;

class p27434{
    static BigInteger bigIntegerMinus = new BigInteger("-1");
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if(n == 0 || n == 1){
            System.out.println(1);
            return;
        }
        BigInteger result = new BigInteger(String.valueOf(1));
        for(int i = 2; i <= n; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
    }
}
