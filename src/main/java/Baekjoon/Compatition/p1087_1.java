package Baekjoon.Compatition;

import java.io.*;
import java.util.*;
public class p1087_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, String> map = new HashMap<>();
        map.put('M', "MatKor");
        map.put('W', "WiCys");
        map.put('C', "CyKor");
        map.put('A', "AlKor");
        map.put('$', "$clear");

        char[] a = br.readLine().toCharArray();

        System.out.println(map.get(a[0]));
    }
}
