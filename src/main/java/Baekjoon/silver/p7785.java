package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p7785 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> al = new TreeSet<>(Collections.reverseOrder());
        Map<String, String> hs = new HashMap<>();


        while(n--> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String user = st.nextToken();
            String ioCheck = st.nextToken();

            hs.put(user, ioCheck);
            al.add(user);
        }

        StringBuilder sb = new StringBuilder();

        for(String name : al){
            if(hs.get(name).equals("enter")){
                sb.append(name).append("\n");
            }
        }

        System.out.println(sb);

    }
}
