package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p26069 {
    static int i;
    static HashMap <String, Boolean> rainbow = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int countRainbow = 0;
    public static void main(String[] args) throws IOException {
        i = Integer.valueOf(br.readLine());
        rainbow.put("ChongChong", true);
        String[] s = new String[2];
        while (i-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[0] = st.nextToken();
            s[1] = st.nextToken();


            if (s[0].equals("ChongChong")) rainbow.put(s[1], true);
            if (s[1].equals("ChongChong")) rainbow.put(s[0], true);
            if(rainbow.containsKey(s[0])){
                if(rainbow.get(s[0])){
                    rainbow.put(s[1],true);
                }
            }
            if(rainbow.containsKey(s[1])){
                if(rainbow.get(s[1])){
                    rainbow.put(s[0],true);
                }
            }

        }

        System.out.println(rainbow.size());
    }

}
