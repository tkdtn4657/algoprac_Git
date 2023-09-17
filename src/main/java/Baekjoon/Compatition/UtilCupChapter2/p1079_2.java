package Baekjoon.Compatition.UtilCupChapter2;

import java.io.*;
import java.util.*;

public class p1079_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Character> cN = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cN.add(st.nextToken().charAt(0));
        }

        int m = Integer.parseInt(br.readLine());

        ArrayList<Character> nM = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            nM.add(st.nextToken().charAt(0));
        }

        int k = Integer.parseInt(br.readLine());
        char[] cK = br.readLine().toCharArray();

        int sLength = Integer.parseInt(br.readLine());
        String s = br.readLine();

//        StringBuilder sb = new StringBuilder();
//
//        sb.append(s);
        ArrayList<Character> al = new ArrayList<>();
        for (int i = 0; i < cK.length; i++) {
            if (cN.contains(cK[i])) {
                cN.remove((Object) cK[i]);
            }
        }

        for (int i = 0; i < cN.size(); i++) {
            s = s.replace(cN.get(i), ' ');
        }

        for (int i = 0; i < nM.size(); i++) {
            if (nM.contains(cK[i])) {
                nM.remove((Object) cK[i]);
            }
        }
        for (int i = 0; i < nM.size(); i++) {
            s = s.replace(nM.get(i), ' ');
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(s);
        while(st.hasMoreTokens()){
            sb.append(st.nextToken()).append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
