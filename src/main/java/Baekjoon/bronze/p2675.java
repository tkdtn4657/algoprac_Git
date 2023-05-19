package Baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p2675 {
    public static void main() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<String> repeatCharString = new ArrayList<>(n);
        int repeatCount = 0;
        String s = "";
        String result = "";

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            repeatCount = Integer.parseInt(st.nextToken());
            s = st.nextToken();

            for(int j = 0; j < s.length(); j++) {
                for (int g = 0; g < repeatCount; g++){
                    result += s.charAt(j);
                }
            }
            repeatCharString.add(result);
            result = ""; // 값 초기화
        }
        for( String repeatString : repeatCharString){
            System.out.println(repeatString);
        }
    }
}
