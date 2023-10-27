package Baekjoon.bronze;

import java.io.*;

class p18409{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();
        int count = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
                count++;
            }
        }

        System.out.println(count);

    }
}