package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<String> as = new ArrayList<>();

//        String[] nohear = new String[n];
        HashMap<String, String> hs = new HashMap<>();

        String s;
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            hs.put(s, s);
        }
        for(int i = 0; i < m; i++) {
            s = br.readLine();
            if(hs.containsKey(s)){
                as.add(hs.get(s));
            }
        }
        StringBuilder print = new StringBuilder();
        print.append(as.size()).append("\n");
        Collections.sort(as);
        for(String result : as){
            print.append(result).append("\n");
        }
        System.out.println(print.toString());
    }

}
