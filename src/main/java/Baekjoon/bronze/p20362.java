package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p20362 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> hs = new HashMap();
        ArrayList<String[]> al = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        int n = Integer.parseInt(st.nextToken());
        String answer = st.nextToken();

        for(int i = 0; i < n; i++){
            al.add(br.readLine().split(" "));
        }

        int findIndex = 0;
        String findString = "";
        for(int i = 0; i < n ; i++){
            if(al.get(i)[0].equals(answer)) {
                findIndex = i;
                findString = al.get(i)[1];
            }
        }

        for(int i = findIndex-1; i >= 0; i--){
            if(findIndex != 0) {
                if (al.get(i)[1].equals(findString)) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}
