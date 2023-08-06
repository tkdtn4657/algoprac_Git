package Baekjoon.Compatition;

import java.io.*;
import java.util.*;

public class p1065_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> a = new HashSet<>();
        String s = "";
        String lastString = "";
        char lastAlpha = '1';
        //물음표기준으로
        String firstString = "";
        char firstAlpha = '1';
        boolean flag = false;
        int flagIndex[] = new int[2];
        String prevString = "";
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            if (s.equals("?")) {
                flag = true;
                flagIndex[0] = i - 1;
                flagIndex[1] = i + 1;
                a.add(s);
                if(i != 0) {
                    lastString = prevString;
                    lastAlpha = lastString.charAt(lastString.length() - 1);
                }
                continue;
            }
            prevString = s;
            a.add(s);
            if (flag) {
                flag = false;
                if (flagIndex[1] == i) {
                    firstString = s;
                    firstAlpha = firstString.charAt(0);
                }
            }


        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            s = br.readLine();

            if (a.contains(s)) {
                continue;
            }
            if(lastAlpha == '1' && s.charAt(s.length()-1) == firstAlpha){//제일첫번째일때?
                System.out.println(s);
                break;
            }
            if(firstAlpha == '1' && s.charAt(0) == lastAlpha){
                System.out.println(s);
                break;
            }
            if (s.charAt(0) == lastAlpha && s.charAt(s.length() - 1) == firstAlpha) {
                System.out.println(s);
                break;
            }
            if(firstAlpha == '1' && lastAlpha == '1'){
                System.out.println(s);
                break;
            }
        }
    }
}
