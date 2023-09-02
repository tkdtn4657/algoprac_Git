package Baekjoon.bronze;

import java.io.*;
import java.util.*;
public class p4493 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int p1Win = 0;
        int p2Win = 0;
        for(int i = 0; i < n; i++){
            int t = Integer.parseInt(br.readLine());
            p1Win = 0;
            p2Win = 0;
            for(int j = 0; j < t; j++){
                st = new StringTokenizer(br.readLine());
                String p1 = st.nextToken();
                String p2 = st.nextToken();

                if(p1.equals(p2)){
                    continue;
                }else{
                    if(p1.equals("R")){
                        if(p2.equals("P")){
                            p2Win++;
                            //sb.append("Player 2").append("\n");
                        }else{
                            p1Win++;
                            //sb.append("Player 1").append("\n");
                        }
                    }else if(p1.equals("P")){
                        if(p2.equals("R")){
                            p1Win++;
                            //sb.append("Player 1").append("\n");
                        }else{
                            p2Win++;
                            //sb.append("Player 2").append("\n");
                        }
                    }else if(p1.equals("S")){
                        if(p2.equals("R")){
                            p2Win++;
                            //sb.append("Player 2").append("\n");
                        }else{
                            p1Win++;
                            //sb.append("Player 1").append("\n");
                        }
                    }
                }

            }
            if(p1Win > p2Win){
                sb.append("Player 1").append("\n");
            }else if(p2Win > p1Win){
                sb.append("Player 2").append("\n");
            }else{
                sb.append("TIE").append("\n");
            }
        }
        System.out.println(sb);
    }
}
