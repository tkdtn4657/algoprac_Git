package Baekjoon.bronze;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class p30087 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, String> hs = new HashMap<>();
        hs.put("Algorithm","204");
        hs.put("DataAnalysis","207");
        hs.put("ArtificialIntelligence","302");
        hs.put("CyberSecurity","B101");
        hs.put("Network","303");
        hs.put("Startup","501");
        hs.put("TestStrategy","105");

//        Stream<Map<String, String>> a = Stream.of(hs);
//        a.filter()

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(hs.get(br.readLine())).append("\n");
        }

        System.out.println(sb);

    }
}
