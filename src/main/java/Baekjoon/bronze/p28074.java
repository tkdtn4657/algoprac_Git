package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p28074 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Map<Character, Boolean> mobis = new HashMap<>(Map.of('M', false, 'O', false, 'B', false, 'I', false, 'S', false));
        for(int i = 0; i < s.length();i++){
            if(mobis.containsKey(s.charAt(i))){
                mobis.put(s.charAt(i), true);
            }
        }
        int count = 0;
        for(char c : mobis.keySet()){

            if(mobis.get(c)){
                count++;
            }
        }

        if(count == 5){
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }
}
