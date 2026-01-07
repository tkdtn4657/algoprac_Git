package Baekjoon.silver;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class p16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Map<Character, ArrayList<Integer>> map = new HashMap<>();

        //소문자 입력
        for(int i = 0; i <= (int)'z' - (int)'a'; i++){
            map.put((char)('a' + i), new ArrayList<>());
        }

        //40,000,000,000
        //or
        //200,000 * 27

        //배열로 각 알파벳인덱스에 데이터 저장,

        for(int i = 0; i < s.length(); i++){
            map.get(s.charAt(i)).add(i);
        }

        int[][] alphaIndexArray = new int[26][s.length()];
        for(int i = 0; i <= (int)'z' - (int)'a'; i++){
            ArrayList<Integer> alphaIndexList = map.get((char) ('a' + i));
            int finalI = i;
            alphaIndexList.forEach(index -> {
                alphaIndexArray[finalI][index] = 1;
            });
        }

        for(int i = 0; i < 26; i++) {
            for (int j = 1; j < s.length(); j++) {
                alphaIndexArray[i][j] += alphaIndexArray[i][j-1];
            }
        }

        while(q-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char alpha = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int count = 0;
            if(l == 0){
                count = alphaIndexArray[(int)alpha - (int)'a'][r];
            } else {
                count = alphaIndexArray[(int)alpha - (int)'a'][r] - alphaIndexArray[(int)alpha - (int)'a'][l-1];
            }

            sb.append(count).append(System.lineSeparator());
        }

        System.out.println(sb);

    }
}
