package Baekjoon.bronze;

import java.io.*;

public class p11721 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        int sCount = s.length()/10;
        int range = 0;
        for(int i = 0; i <= sCount; i++){
            if(sCount == i){
                sb.append(s.substring(range, range+s.length()%10));
                continue;
            }
            sb.append(s.substring(range, range+10)).append("\n");
            range = range+10;
        }

        System.out.println(sb);
    }
}
