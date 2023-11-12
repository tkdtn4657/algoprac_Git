package Baekjoon.bronze;

import java.io.*;

public class p28239 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        long m;

        while(n-- > 0){
            m = Long.parseLong(br.readLine());

            boolean check = false;

            for(int i=0;i<=63;i++){
                for(int j=63;j>=0;j--){
                    if((long)Math.pow(2,i) +(long)Math.pow(2,j) == m){
                        check = true;
                        sb.append(i).append(" ").append(j).append("\n");
                        break;
                    }
                }

                if(check) {
                    break;
                }

            }
        }
        System.out.print(sb);
    }
}
