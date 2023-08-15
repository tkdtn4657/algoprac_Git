package Baekjoon.Compatition;

import java.io.*;
import java.util.*;

public class p1084_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        String[] a = new String[n];
        String[] F;
        ArrayList<String> s = new ArrayList<>();
        s.add("bowling");
        s.add("swimming");
        s.add("soccer");

        Random rnd = new Random();

        for(int i = 0; i < n; i++){
            int randomNum = rnd.nextInt(3);
            a[i] = s.get(randomNum);
            if(i == n-1) {
                System.out.print(a[i] + "\n");
            }else {
                System.out.print(a[i] + " ");
            }
        }

        System.out.flush();
        //입력받기
        F = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < s.size(); j++) {
                if (!s.get(j).equals(a[i]) && !s.get(j).equals(F[i])) {
                    if (i == n - 1) {
                        System.out.print(s.get(j) + "\n");
                    } else {
                        System.out.print(s.get(j) + " ");
                    }
                }
            }
        }
        System.out.flush();
    }
}
